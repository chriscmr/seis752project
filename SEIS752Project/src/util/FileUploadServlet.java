package util;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * This is a File Upload Servlet that is used with AJAX
 * to monitor the progress of the uploaded file. It will
 * return an XML object containing the meta information
 * as well as the percent complete.
 * 
 */
public class FileUploadServlet 
	extends HttpServlet 
	implements Servlet 
{
	private static final long serialVersionUID = 2740693677625051632L;

	public FileUploadServlet()
	{
		super();
	}
	
    protected void doGet(HttpServletRequest aRequest, HttpServletResponse response) 
    	throws ServletException, IOException 
    {}
 
 
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    	throws ServletException, IOException 
    {
    	doGet(request,response);
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List uploadedItems = null;
		FileItem fileItem = null;
		String filePath = "c:\\Users\\Chris\\workspaceGlassFish\\SEIS752Project\\WebContent\\images";	// Path to store file on local system
 		try 
		{
			// iterate over all uploaded files
			uploadedItems = upload.parseRequest(request);
			Iterator i = uploadedItems.iterator();
			while (i.hasNext()) 
			{
				fileItem = (FileItem) i.next();
				request.getSession().setAttribute (fileItem.getFieldName(), fileItem.getName());
//				System.out.println("Field Name = "+fileItem.getFieldName()+
//						", File Name = "+fileItem.getName()+
//						", Content type = "+fileItem.getContentType()+
//						", File Size = "+fileItem.getSize());
				if (fileItem.isFormField() == false) 
				{
					if (fileItem.getSize() > 0) 
					{
						File 
							uploadedFile = null; 
						String
							myFullFileName = fileItem.getName(),
							myFileName = "",
							slashType = (myFullFileName.lastIndexOf("\\") > 0) ? "\\" : "/"; // Windows or UNIX
						int
							startIndex = myFullFileName.lastIndexOf(slashType);

						// Ignore the path and get the filename
						myFileName = myFullFileName.substring(startIndex + 1, myFullFileName.length());

						// Create new File object
						uploadedFile = new File(filePath, myFileName);
						
						// Write the uploaded file to the system
						fileItem.write(uploadedFile);
					}
				}
			}
		} 
		catch (FileUploadException e) 
		{
			e.printStackTrace();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
	}       
}
