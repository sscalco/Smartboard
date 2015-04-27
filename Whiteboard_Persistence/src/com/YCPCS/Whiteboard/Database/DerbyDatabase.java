package com.YCPCS.Whiteboard.Database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.YCPCS.Whiteboard.Model.Assignment;
import com.YCPCS.Whiteboard.Model.Grade;
import com.YCPCS.Whiteboard.Model.Lecture;
import com.YCPCS.Whiteboard.Model.Relationship;
import com.YCPCS.Whiteboard.Model.User;

import dbUtils.DBUtil;
import dbUtils.PersistenceException;


public class DerbyDatabase implements DatabaseLayer{
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby JDBC driver");
		}
	}
	
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}
	
	private static final int MAX_ATTEMPTS = 10;
	
	@Override
	public int getUserIDByLogin(String username, String password) {
		return executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement("select id from users " +
							"where users.username = ? AND users.password = ?"
					);
					stmt.setString(1, username);		
					stmt.setString(2, password);
					
					int result = 0;
					
					resultSet = stmt.executeQuery();
					
					while (resultSet.next()){
						return resultSet.getInt(1);
					}
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
		//return 0;
	}

	@Override
	public String getFirstNameFromId(int id) {
		// TODO: fix the sql query
		return executeTransaction(new Transaction<String>() {
			@Override
			public String execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
//				"select id from users " +
//				"where users.username = ? AND users.password = ?"
				try {
					stmt = conn.prepareStatement("select firstname from users " +
							"where id = ?"
					);
					stmt.setInt(1, id);
					
					String result = "";
					
					resultSet = stmt.executeQuery();
					
					while (resultSet.next()){
						return resultSet.getString(1);
					}
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
		
	}

	@Override
	public String getLastNameFromId(int id) {
		// TODO Auto-generated method stub
		return executeTransaction(new Transaction<String>() {
			@Override
			public String execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement("select lastname " +
							"from users " +
							"where id = ? "
					);
					stmt.setInt(1, id);		
					
					
					String lastname = "";
					
					resultSet = stmt.executeQuery();
					
					while (resultSet.next()){
						return resultSet.getString(1);
						
					}
					return lastname;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
		
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		
		return executeTransaction(new Transaction<User>() {
			@Override
			public User execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement("select users.* " +
							"from users where username = ? and password = ?"
					);
					stmt.setString(1, username);		
					stmt.setString(2, password);
					
					resultSet = stmt.executeQuery();
					
					if (resultSet.next()){
						// User was found
						User user = new User();
						loadUser(user, resultSet, 1);
						return user;
					} else {
						// No such username/password combination
						return null;
					}
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
		
	}

	@Override
	public void addUserToDatabase(User user) {
		Connection conn = null;
		try{
			conn = connect();
			PreparedStatement statement = conn.prepareStatement("INSERT INTO users (username, password, firstname, lastname, email)" + "VALUES (?, ?, ?, ?, ?)");
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFirstname());
			statement.setString(4, user.getLastname());
			statement.setString(5, user.getEmail());
			statement.execute();
			conn.commit();
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeQuietly(conn);
		}
	}

	// needs the corrected SQL statement
	@Override
	public Lecture getClassById(int id) {
		// TODO Auto-generated method stub
		return executeTransaction(new Transaction<Lecture>() {
			@Override
			public Lecture execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement("select class" +
							"from X where id = ? "      //TODO: get lecture from SQL
					);
					stmt.setInt(1, id);		
					
					
					Lecture lecture = new Lecture();
					
					resultSet = stmt.executeQuery();
					
					while (resultSet.next()){
						loadLecture(lecture, resultSet, 1);
						
					}
					return lecture;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
		
	}

	@Override
	public List<Relationship> getRelationshipsByRootAndTarget(String root,
			String target) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
	
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();
		
		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;
			
			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}
			
			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}
			
			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}

	private Connection connect() throws SQLException {
		String homeDir = System.getProperty("user.home");
		Connection conn = DriverManager.getConnection("jdbc:derby:" + homeDir + "/whiteboard.db;create=true");
		
		// Set autocommit to false to allow multiple the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	private void loadUser(User user, ResultSet resultSet, int index) throws SQLException {
		user.setId(resultSet.getInt(index++));
		user.setUsername(resultSet.getString(index++));
		user.setPassword(resultSet.getString(index++));
		user.setLastname(resultSet.getString(index++));
		user.setFirstname(resultSet.getString(index++));
		user.setEmail(resultSet.getString(index++));
	}
	
	private void loadRelationship(Relationship relationship, ResultSet resultSet, int index) throws SQLException {
		relationship.setId(resultSet.getInt(index++));
		relationship.setRootId(resultSet.getInt(index++));
		relationship.setTargetId(resultSet.getInt(index++));
		relationship.setRoot(resultSet.getString(index++));
		relationship.setTarget(resultSet.getString(index++));
	}
	
	private void loadLecture(Lecture lecture, ResultSet resultSet, int index) throws SQLException {
		lecture.setClassId(resultSet.getInt(index++));
		lecture.setClassName(resultSet.getString(index++));
		lecture.setTeacher(resultSet.getString(index++));
		lecture.setClassDescription(resultSet.getString(index++));
		lecture.setClassSize(resultSet.getInt(index++));
	}
	
	private void loadAssignment(Assignment assignment, ResultSet resultSet, int index) throws SQLException {
		assignment.setId(resultSet.getInt(index++));
		assignment.setPointValue(resultSet.getInt(index++));
		assignment.setName(resultSet.getString(index++));
		assignment.setDescription(resultSet.getString(index++));
	}
	
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement userStmt = null;
				PreparedStatement lectureStmt = null;
				PreparedStatement relationshipStmt = null;
				PreparedStatement assignmentStmt = null;
				
				
				try {
					userStmt = conn.prepareStatement(
							"create table users (" +
							"    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY," +
							"    username varchar(20)," +
							"    password varchar(30)," +
							"    lastname varchar(40)," +
							"    firstname varchar(40)," +
							"    email varchar(40)" +
							")");
					userStmt.executeUpdate();
					
					lectureStmt = conn.prepareStatement(
							"create table lectures (" +
							"    id integer primary key," +
							"    name varchar(40)," +
							"    teacher varchar(30)," +
							"    description varchar(500)," +
							"    size integer" +
							")");
					lectureStmt.executeUpdate();
					
					relationshipStmt = conn.prepareStatement(
							"create table relationships (" +
							"    id integer primary key," +
							"    root_id integer," +
							"    target_id integer," +
							"    root varchar(30)," +
							"    target varchar(30)" +
							")");
					relationshipStmt.executeUpdate();
					
					assignmentStmt = conn.prepareStatement(
							"create table assignments (" +
							"    id integer primary key," +
							"    point_value integer," +
							"    name varchar(50)," +
							"    description varchar(500)," +
							"    grade integer" +
							")");
					assignmentStmt.executeUpdate();
					return true;
				} finally {
					DBUtil.closeQuietly(userStmt);
					DBUtil.closeQuietly(lectureStmt);
					DBUtil.closeQuietly(relationshipStmt);
					DBUtil.closeQuietly(assignmentStmt);
				}
			}
		});
	}
	
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<Lecture> lectureList;
				List<Relationship> relationshipList;
				List<User> userList;
				List<Assignment> assignmentList;
				
				try {
					lectureList = InitialData.getClasses();
					relationshipList = InitialData.getRelationships();
					userList = InitialData.getUsers();
					assignmentList = InitialData.getAssignments();
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertLecture = null;
				PreparedStatement insertRelationship = null;
				PreparedStatement insertUser = null;
				PreparedStatement insertAssignment = null;

				try {
					insertLecture = conn.prepareStatement("insert into lectures values (?, ?, ?, ?, ?)");
					for (Lecture lecture : lectureList) {
						insertLecture.setInt(1, lecture.getClassId());
						insertLecture.setString(2, lecture.getClassName());
						insertLecture.setString(3, lecture.getTeacher());
						insertLecture.setString(4, lecture.getClassDescription());
						insertLecture.setInt(5, lecture.getClassSize());
						insertLecture.addBatch();

					}
					insertLecture.executeBatch();
					
					insertRelationship = conn.prepareStatement("insert into relationships values (?, ?, ?, ?, ?)");
					for (Relationship relationship : relationshipList) {
						insertRelationship.setInt(1, relationship.getId());
						insertRelationship.setInt(2, relationship.getRootId());
						insertRelationship.setInt(3, relationship.getTargetId());
						insertRelationship.setString(4, relationship.getRoot());
						insertRelationship.setString(5, relationship.getTarget());
						insertRelationship.addBatch();
					}
					insertRelationship.executeBatch();
					
					insertUser = conn.prepareStatement("insert into users (username, password, lastname, firstname, email) values (?, ?, ?, ?, ?)");
					for (User user : userList) {
						insertUser.setString(1, user.getUsername());
						insertUser.setString(2, user.getPassword());
						insertUser.setString(3, user.getLastname());
						insertUser.setString(4, user.getFirstname());
						insertUser.setString(5, user.getEmail());
						insertUser.addBatch();

					}
					insertUser.executeBatch();
					
					insertAssignment = conn.prepareStatement("insert into assignments values (?, ?, ?, ?, ?)");
					for (Assignment assignment : assignmentList) {
						insertAssignment.setInt(1, assignment.getId());
						insertAssignment.setInt(2, assignment.getPointValue());
						insertAssignment.setString(3, assignment.getName());
						insertAssignment.setString(4, assignment.getDescription());
						insertAssignment.addBatch();

					}
					insertAssignment.executeBatch();
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertRelationship);
					DBUtil.closeQuietly(insertLecture);
					DBUtil.closeQuietly(insertUser);
					DBUtil.closeQuietly(insertAssignment);
				}
			}
		});
	}
	
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Starting Database");
		DerbyDatabase db = new DerbyDatabase();
		System.out.println("Creating tables...");
		db.createTables();
		
		System.out.println("Loading initial data...");
		db.loadInitialData();
		
		System.out.println("Testing Getting User from username and password");
		System.out.println("User id = "+db.getUserIDByLogin("bfwalton", "apple"));
		System.out.println("Testing Getting First Name from ID");
		System.out.println("First Name = " + db.getFirstNameFromId(4));
		
		System.out.println("Testing add user");
		User testUser = new User();
		testUser.setUsername("I AM A TEST");
		testUser.setPassword("banana");
		testUser.setFirstname("BOB");
		testUser.setLastname("Testuser");
		db.addUserToDatabase(testUser);
		
		System.out.println("User added");
		
		System.out.println("Tring to check user");
		System.out.println("Test user id: "+db.getUserIDByLogin("TEST_USER", "banana"));
		System.out.println("Testing Getting Last Name from ID");
		System.out.println("Last Name = " + db.getLastNameFromId(4));
		System.out.println("Success!");
	}

	@Override
	public Grade getGradeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
