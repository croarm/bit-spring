package net.bitacademy.spring.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.spring.dao.BoardDao;
import net.bitacademy.spring.vo.Board;

@WebServlet("/board/add.do")
public class BoardAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
   
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    req.setCharacterEncoding("UTF-8");
    
    Board board = new Board();
    board.setTitle(req.getParameter("title"));
    board.setContent(req.getParameter("content"));
    
    resp.setContentType("text/html;charset=UTF-8");
    try {
      BoardDao boardDao = new BoardDao();
      boardDao.insert(board);
      
      resp.sendRedirect("list.do");
      return;
      
    } catch (Exception e) {
      req.setAttribute("error", e);
      RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
      rd.include(req, resp);
    }
  }
}
