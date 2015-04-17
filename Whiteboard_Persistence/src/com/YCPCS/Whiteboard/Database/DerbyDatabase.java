package com.YCPCS.Whiteboard.Database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.YCPCS.Whiteboard.Model.Grade;
import com.YCPCS.Whiteboard.Model.Lecture;
import com.YCPCS.Whiteboard.Model.Relationship;
import com.YCPCS.Whiteboard.Model.User;
import com.YCPCS.Whiteboard.Model.Assignment;

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
					stmt = conn.prepareStatement("select id" +
							"from users where username = ? and password = ?"
					);
					stmt.setString(1, username);		
					stmt.setString(2, password);
					
					int result = 0;
					
					resultSet = stmt.executeQuery();
					
					while (resultSet.next()){
						
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
		// TODO fix the while loop
		return executeTransaction(new Transaction<String>() {
			@Override
			public String execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement("select firstname" +
							"from users where id = ? "
					);
					stmt.setInt(1, id);		
					
					
					String result = "";
					
					resultSet = stmt.executeQuery();
					
					while (resultSet.next()){
						// 
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
		return null;
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		
		return executeTransaction(new Transaction<User>() {
			@Override
			public User execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement("select user" +
							"from users where username = ? and password = ?"
					);
					stmt.setString(1, username);		
					stmt.setString(2, password);
					
					User user = new User();
					
					resultSet = stmt.executeQuery();
					
					while (resultSet.next()){
						loadUser(user, resultSet, 6);
					}
					return user;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
		
	}

	@Override
	public void addUserToDatabase(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Lecture getClassById(int id) {
		// TODO Auto-generated method stub
		return null;
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


	@Override
	public Grade getGradeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:books.db;create=true");
		
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
		assignment.setAssignmentGrade(resultSet.getFloat(index++));
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
							"    id integer primary key," +
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
				}catch(Exception e){
					System.out.println("Tables have already been created");
					return false;
				}finally {
					DBUtil.closeQuietly(userStmt);
					DBUtil.closeQuietly(lectureStmt);
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
				// relationship
				// user
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
					insertLecture = conn.prepareStatement("insert into users values (?, ?, ?, ?)");
					for (Lecture lecture : lectureList) {
						//insertLecture.setInt(1, lecture.getClassId());
						insertLecture.setString(1, lecture.getClassName());
						insertLecture.setInt(2, lecture.getClassSize());
						insertLecture.setString(3, lecture.getClassDescription());
						insertLecture.setInt(4, lecture.getClassSize());
						insertLecture.addBatch();
					}
					insertLecture.executeBatch();
					
					insertRelationship = conn.prepareStatement("insert into relationships values (?, ?, ?, ?, ?)");
					for (Relationship relationship : relationshipList) {
						insertRelationship.setInt(1, relationship.getId());
						insertRelationship.setInt(2, relationship.getRootId());
						insertRelationship.setInt(3, relationship.getTargetId());
						insertRelationship.setString(4, relationship.getRoot());
						insertRelationship.setString(4, relationship.getTarget());
						insertRelationship.addBatch();
					}
					insertRelationship.executeBatch();
					
					insertUser = conn.prepareStatement("insert into users values (?, ?, ?, ?, ?, ?)");
					for (User user : userList) {
						insertUser.setInt(1, user.getId());
						insertUser.setString(4, user.getUsername());
						insertUser.setString(4, user.getPassword());
						insertUser.setString(4, user.getLastname());
						insertUser.setString(4, user.getFirstname());
						insertUser.setString(4, user.getEmail());
						insertUser.addBatch();
					}
					insertUser.executeBatch();
					
					insertAssignment = conn.prepareStatement("insert into users values (?, ?, ?, ?, ?)");
					for (Assignment assignment : assignmentList) {
						insertAssignment.setInt(1, assignment.getId());
						insertAssignment.setString(2, assignment.getName());
						insertAssignment.setInt(3, assignment.getPointValue());
						insertAssignment.setString(4, assignment.getDescription());
						insertAssignment.setFloat(5, assignment.getAssignmentGrade());
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
		System.out.println("Creating tables...");
		DerbyDatabase db = new DerbyDatabase();
		db.createTables();
		
		System.out.println("Loading initial data...");
		db.loadInitialData();
		
		System.out.println("Success!");
		
		System.out.println(db.getUserByUsernameAndPassword("bfwalton", "apple"));
	}
}
