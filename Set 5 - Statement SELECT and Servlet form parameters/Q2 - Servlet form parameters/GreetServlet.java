import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class GreetServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
		throws IOException,ServletException{

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String n = request.getParameter("t1");
		out.println("<h1>Hello,Welcome:"+n+"</h1>");
		

	}
}
