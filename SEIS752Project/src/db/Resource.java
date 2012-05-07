package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Resource {
	private static final String insertStatement = "insert into  Ressource(ID,TITLE,DESCRIPTION,DATE_CREATED,LOCATION,ICON) values (?,?,?,?,?,?)";
	private static final String insertGradeStatement = "insert into  applies(RESSOURCE_ID,GRADE_ID) values (?,?)";
	private static final String insertSubjectStatement = "insert into  relates(RESSOURCE_ID,SUBJECT_ID) values (?,?)";
	String location = null;
	String subject = null;
	String grade = null;
	String title = null;
	String description = null;
	Date date_created = null;
	String icon = null;
	int id = 0;
	String resource_type = null;
	private static final int ID = 1;
	private static final int TITLE = 2;
	private static final int DESCRIPTION = 3;
	private static final int DATE_CREATED = 4;
	private static final int LOCATION = 5;
	private static final int ICON = 6;
	private static final int GRADE = 2;
	private static final int SUBJECT = 2;


	public Date getDate_created() {
		return date_created;
	}
	public void setDate_created() {
		java.util.Date utilDate = new java.util.Date();
		this.date_created = new java.sql.Date(utilDate.getTime());
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResource_type() {
		return resource_type;
	}
	public void setResource_type(String resource_type) {
		this.resource_type = resource_type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String loc) {
		this.location = loc;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int save(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet idVal = stmt.executeQuery("select S_RESSOURCE.nextVal from dual" );
		if(idVal.next()) {
			setId(idVal.getInt(1));
		} else {
			throw new SQLException("Error getting ID for Resources");
		}
		idVal.close();
//  "insert into  Ressource(ID,TITLE,DESCRIPTION,DATE_CREATED,LOCATION,ICON) values (?,?,?,?,?,?,?,?,?)";
/*
  	private static final int ID = 1;
	private static final int TITLE = 2;
	private static final int DESCRIPTION = 3;
	private static final int DATE_CREATED = 4;
	private static final int LOCATION = 5;
	private static final int ICON = 6;
	private static final int GRADE = 7;
	private static final int SUBJECT = 8;
 */
		PreparedStatement insertResourceStmt = conn.prepareStatement(insertStatement);
		PreparedStatement insertGradeStmt = conn.prepareStatement(insertGradeStatement);
		PreparedStatement insertSubjectStmt = conn.prepareStatement(insertSubjectStatement);
		insertResourceStmt.setInt(ID, getId());
		insertSubjectStmt.setInt(ID, getId());
		insertGradeStmt.setInt(ID, getId());
		insertResourceStmt.setDate(DATE_CREATED, getDate_created());
		insertResourceStmt.setString(DESCRIPTION, getDescription());
		insertResourceStmt.setString(ICON, getIcon());
		System.out.println("statement icon " + getIcon());
		insertResourceStmt.setString(TITLE, getTitle());
		insertResourceStmt.setString(LOCATION, getLocation());
		System.out.println("statement LOCATION " + getLocation());
		insertGradeStmt.setString(GRADE, getGrade());
		insertSubjectStmt.setString(SUBJECT, getSubject());
		insertResourceStmt.executeUpdate();
		insertGradeStmt.executeUpdate();
		insertSubjectStmt.executeUpdate();

		
//		PreparedStatement insertContentStmt = conn.prepareStatement(insertContentStatement);
//		ResultSet idContent = stmt.executeQuery("select S_CONTENT.nextVal from dual" );
//		if(idContent.next()){
//			insertContentStmt.setInt(1, idContent.getInt(1));
//			idContent.close();
//		} else {
//			idContent.close();
//			throw new SQLException("Error getting ID for Content");
//		}
		// ID,FILE_TYPE,FILE_NAME,RESOURCE_ID
//		insertContentStmt.setString(2,"");
//		insertContentStmt.setString(3, getFile());
//		insertContentStmt.setInt(4, id);
//		insertContentStmt.executeUpdate();
//		insertContentStmt.close();
		
		return id;
		
	}
}
