package net.bitacademy.spring.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.spring.vo.Board;

@WebServlet("/board/detail.do")
public class BoardDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    resp.setContentType("text/html;charset=UTF-8");

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb","study","study");
      stmt = con.createStatement();
      rs = stmt.executeQuery("select bno, title, content, cre_dt, views"
          + " from board"
          + " where bno="+req.getParameter("no"));
      
      if(!rs.next()) {
        throw new Exception("해당 번호의 게시물을 찾을 수 없습니다.");
      }

      Board board = new Board();
      board.setNo(rs.getInt("bno"));
      board.setTitle(rs.getString("title"));
      board.setContent(rs.getString("content"));
      board.setCreateDate(rs.getDate("cre_dt"));
      board.setViews(rs.getInt("views"));
      
      req.setAttribute("board", board);
      
      RequestDispatcher rd = req.getRequestDispatcher("/board/detail.jsp");
      rd.include(req, resp);
      
      
    } catch (Exception e) {
      req.setAttribute("error", e);
      RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
      rd.include(req, resp);
      
    } finally {
      try { rs.close(); } catch (Exception ex) {}
      try { stmt.close(); } catch (Exception ex) {}
      try { con.close(); } catch (Exception ex) {}
    }
    
  }
}
