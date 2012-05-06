package db;

/*
 * Created on Nov 24, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 *  Description of the Class
 *
 *@author     mikhelmg
 *@created    October 25, 2007
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author mikhelmg
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DBUtil {
	private static Properties props = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	private static String OUTPUTDIR = null;
	private static String ERROR = null;
	
	public DBUtil(String relPath, String schema) {
		props = new Properties();
		String propFileName = relPath +  "/db.properties";
		System.out.println("props "+ propFileName);
		try {
			FileInputStream in = new FileInputStream(propFileName);
			props.load(in);
			url = props.getProperty(schema + ".jdbc.url");
			username = props.getProperty(schema + ".jdbc.username");
			password = props.getProperty(schema + ".jdbc.password");
			OUTPUTDIR = props.getProperty(schema + ".dir");
			ERROR=props.getProperty(schema + ".error");
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("DBUtil:FileNotFoundException");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("DBUtil:IOException");
			e.printStackTrace();
		}
	}
	
	
	public Connection getConnection() throws SQLException{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		System.out.println("url " + url);
		Connection conn = DriverManager.getConnection(url,username,password);
		System.out.println("DBUtil getConnection " + !conn.isClosed());
		return conn;
	}
	/**
	 * @return the oUTPUTDIR
	 */
	public static String getOUTPUTDIR() {
		return OUTPUTDIR;
	}
	/**
	 * @return the eRROR
	 */
	public static String getErrorLogFile() {
		return ERROR;
	}

	public static int save(){
		return 0;
	}

}
