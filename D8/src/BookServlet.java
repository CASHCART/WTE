
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class BookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Book Details</h2>");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/XE",
                "system",
                "cashcart"
            );

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM books");

            out.println("<table border='1' cellpadding='10'>");
            out.println("<tr>");
            out.println("<th>Title</th>");
            out.println("<th>Author</th>");
            out.println("<th>Edition</th>");
            out.println("<th>Price</th>");
            out.println("</tr>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString(1) + "</td>");
                out.println("<td>" + rs.getString(2) + "</td>");
                out.println("<td>" + rs.getInt(3) + "</td>");
                out.println("<td>" + rs.getFloat(4) + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }

        out.println("</body></html>");
    }
}
