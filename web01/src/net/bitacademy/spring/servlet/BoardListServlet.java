package net.bitacademy.spring.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.spring.dao.BoardDao;
import net.bitacademy.spring.vo.Board;

@WebServlet("/board/list.do")
public class BoardListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    resp.setContentType("text/html;charset=UTF-8");
    
    try {
      BoardDao boardDao = new BoardDao();
      List<Board> boards = boardDao.selectList();
      
      req.setAttribute("list", boards);
      RequestDispatcher rd = req.getRequestDispatcher("/board/list.jsp");
      rd.include(req, resp);
      
      
    } catch (Exception e) {
      req.setAttribute("error", e);
      RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
      rd.include(req, resp);
      
    } 
  }
}
