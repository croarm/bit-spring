package net.bitacademy.spring.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/add.do")
public class BoardAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    req.setCharacterEncoding("UTF-8");//getParameter() 호출전에 지정해야된다.
    String title = req.getParameter("title");
    String content = req.getParameter("content");
    
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
    PreparedStatement stmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb","study","study");
      stmt = con.prepareStatement(
          "insert into board(title,content,cre_dt) values(?,?,now())");
      stmt.setString(1, title);
      stmt.setString(2, content);
      stmt.executeUpdate();
      
      resp.sendRedirect("list.do");
      return;//
      
    } catch (Exception e) {
      out.println("예외 발생!");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
      
    } finally {
      try { stmt.close(); } catch (Exception ex) {}
      try { con.close(); } catch (Exception ex) {}
    }
    
    out.println("</body>");
    out.println("</html>");
  }
}
