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

@WebServlet("/board/detail.do")
public class BoardDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    resp.setContentType("text/html;charset=UTF-8");

    try {
      
      BoardDao boardDao = new BoardDao();
      
      Board board = boardDao.selectOne(Integer.parseInt(req.getParameter("no")));
      req.setAttribute("board", board);
      
      RequestDispatcher rd = req.getRequestDispatcher("/board/detail.jsp");
      rd.include(req, resp);
      
      
    } catch (Exception e) {
      req.setAttribute("error", e);
      RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
      rd.include(req, resp);
      
    } 
    
  }
}
