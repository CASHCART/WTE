import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class InitParamServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
		throws IOException,ServletException{

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ServletContext cont = getServletContext();
		String c = cont.getInitParameter("collegename");
		out.println("<h1> Context Parameters:</h1>");
		out.println("<h2> College Name:"+c+"</h2>");	
	
		ServletConfig conf = getServletConfig();
		String s = conf.getInitParameter("studentname");
		out.println("<h1> Context Parameters:</h1>");
		out.println("<h2> Student Name:"+s+"</h2>");
		

	}
}
