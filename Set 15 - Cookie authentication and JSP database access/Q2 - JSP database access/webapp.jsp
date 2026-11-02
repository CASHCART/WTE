<%@ page import="java.sql.*" %>
<%
try {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con = DriverManager.getConnection(
        "jdbc:oracle:thin:@localhost:1521/XE", "system", "manager");
    String q = "select * from books";
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery(q);
    out.println("<table cellspacing='1' border='2' align='center'>");
    out.println("<tr><th>Title</th><th>Author</th><th>Edition</th><th>Price</th></tr>");
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
    out.println(e);
}
%>
