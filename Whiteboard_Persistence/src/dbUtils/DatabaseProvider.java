package dbUtils;

import com.YCPCS.Whiteboard.Database.DatabaseLayer;

public class DatabaseProvider {
	private static DatabaseLayer theInstance;
	
	public static void setInstance(DatabaseLayer db) {
		theInstance = db;
	}
	
	public static DatabaseLayer getInstance() {
		if (theInstance == null) {
			throw new IllegalStateException("IDatabase instance has not been set!");
		}
		return theInstance;
	}
}
