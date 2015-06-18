package net.bitacademy.spring.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/list.do")
public class BoardListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>Insert title here</title>");
    out.println("</head>");
    out.println("<body>");
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb","study","study");
      stmt = con.createStatement();
      rs = stmt.executeQuery("select bno, title, cre_dt, views"
          + " from board"
          + " order by bno desc");
      
      out.println("<h1>게시물 목록</h1>");
      out.println("<a href='form.html'>새 글</a><br>");
      out.println("<table border='1'>");
      out.println("<tr>");
      out.println(" <th>번호</th>");
      out.println(" <th>제목</th>");
      out.println(" <th>등록일</th>");
      out.println(" <th>조회수</th>");
      out.println("</tr>");
      
      while (rs.next()) {
        out.println("<tr>");
        out.println(" <td>" + rs.getInt("bno") + "</td>");
        out.println(" <td><a href='detail.do?no=" + rs.getInt("bno")
            + "'>" + rs.getString("title") + "</a></td>");
        out.println(" <td>" + rs.getString("cre_dt") + "</td>");
        out.println(" <td>" + rs.getInt("views") + "</td>");
        out.println("</tr>");
      }
      out.println("</table>");
      
    } catch (Exception e) {
      out.println("예외 발생!");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
      
    } finally {
      try { rs.close(); } catch (Exception ex) {}
      try { stmt.close(); } catch (Exception ex) {}
      try { con.close(); } catch (Exception ex) {}
    }
    
    out.println("</body>");
    out.println("</html>");
  }
}
