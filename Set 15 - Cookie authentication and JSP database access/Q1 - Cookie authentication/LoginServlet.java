
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
                       throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie c1 = new Cookie("user1", "pwd1");
        Cookie c2 = new Cookie("user2", "pwd2");

        response.addCookie(c1);
        response.addCookie(c2);

        String u = request.getParameter("uname");
        String p = request.getParameter("pwd");

        Cookie c[] = request.getCookies();
        boolean flag = false;

        if (c != null) {
            for (int i = 0; i < c.length; i++) {
                if (c[i].getName().equals(u) &&
                    c[i].getValue().equals(p)) {
                    flag = true;
                    break;
                }
            }
        }

        if (flag) {
            out.println("Welcome " + u);
        } else {
            out.println("You are not an authenticated user");
        }
    }
}
