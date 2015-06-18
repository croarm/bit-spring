package net.bitacademy.spring.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.spring.vo.Board;

@WebServlet("/board/list.do")
public class BoardListServlet extends HttpServlet {
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
      rs = stmt.executeQuery("select bno, title, cre_dt, views"
          + " from board"
          + " order by bno desc");
      
      ArrayList<Board> boards = new ArrayList<Board>();
      Board board = null;
      
      while (rs.next()) {
        board = new Board();
        board.setNo(rs.getInt("bno"));
        board.setTitle(rs.getString("title"));
        board.setCreateDate(rs.getDate("cre_dt"));
        board.setViews(rs.getInt("views"));
        boards.add(board);
      }
      
      req.setAttribute("list", boards);
      
      RequestDispatcher rd = req.getRequestDispatcher("/board/list.jsp");
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
