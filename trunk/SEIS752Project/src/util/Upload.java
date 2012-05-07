package util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import db.DBUtil;
import db.Resource;

/**
 * Servlet implementation class Upload
 */
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection conn = null;
    private String root = null;   
    private static final String TMP_DIR_PATH = "c:\\TEMP";
    private static final String DESTINATION_DIR_PATH ="C:\\apps\\seis752\\vault\\folder1";   
    private File destinationDir;
    private PreparedStatement insertResources = null;
    private Map gradeMap = null;
    private Map subjectMap = null;
    private File tmpDir;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("upload init");
		gradeMap = new HashMap();
		subjectMap = new HashMap();
		tmpDir = new File(TMP_DIR_PATH);
		if(!tmpDir.isDirectory()) {
			throw new ServletException(TMP_DIR_PATH + " is not a directory");
		}

		//		String realPath = getServletContext().getRealPath(DESTINATION_DIR_PATH);
		String realPath = config.getInitParameter("data");
		destinationDir = new File(realPath);
		if(!destinationDir.isDirectory()) {
			throw new ServletException(DESTINATION_DIR_PATH+" is not a directory");
		}

		String root = config.getInitParameter("root") + config.getServletContext().getContextPath();
		System.out.println(root);
		try {
			conn = new DBUtil(root, "seis752").getConnection();
			this.root = root;
			Statement gradeStmt = conn.createStatement();
			ResultSet grade_rs = gradeStmt.executeQuery("select id, grade from grade" );
			while(grade_rs.next()) {
				String id = new Integer(grade_rs.getInt(1)).toString();
				gradeMap.put(id, grade_rs.getString(2));
			}

			
			Statement subjectStmt =  conn.createStatement();
			ResultSet subject_rs = gradeStmt.executeQuery("select id, name from subject" );
			while(subject_rs.next()) {
				String id = new Integer(subject_rs.getInt(1)).toString();
				subjectMap.put(id, subject_rs.getString(2));
			}
			subject_rs.close();
			subjectStmt.close();			
			grade_rs.close();
			gradeStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Resource resource = new Resource();
		resource.setTitle(request.getParameter("title"));
		resource.setSubject(request.getParameter("subject"));
		resource.setGrade(request.getParameter("grade"));
		resource.setDescription(request.getParameter("description"));
		
		resource.setLocation(new File(request.getParameter("file")).getName());
		resource.setIcon(new File(request.getParameter("icon")).getName());
		resource.setDate_created();
//		System.out.println("doGet BasicSearch called ");
//		System.out.println("title " + resource.getTitle());
//		System.out.println("subject " + resource.getSubject() + ":" + subjectMap.get(resource.getSubject()));
//		System.out.println("grade " + resource.getGrade() + ":" + gradeMap.get(resource.getGrade()));
//		System.out.println("description " + resource.getDescription());
//		System.out.println("location " + resource.getLocation());
//		System.out.println("icon " + resource.getIcon());
		request.getSession().setAttribute ("title",resource.getTitle());
		request.getSession().setAttribute ("subject",subjectMap.get(resource.getSubject()));
		request.getSession().setAttribute ("grade",gradeMap.get(resource.getGrade()));
		request.getSession().setAttribute ("description",resource.getDescription());
		request.getSession().setAttribute ("location", resource.getLocation());
		request.getSession().setAttribute ("icon",resource.getIcon());
		Set id = new HashSet();
		try {

			id.add(new Integer( resource.save(conn)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("upload-result.jsp").forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("upload post");

		}


	

}
