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

@WebServlet("/board/change.do")
public class BoardChangeServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    //파라미터 값을 유니코드로 바꿀 때 기본 : iso-8859-1(영어) --> Unicode 
    // utf-8(한글) --> Unicode
    req.setCharacterEncoding("UTF-8");//getParameter() 호출전에 지정해야된다.
    Board board = new Board();
    
    board.setNo(Integer.parseInt(req.getParameter("no")));
    board.setTitle(req.getParameter("title"));
    board.setContent(req.getParameter("content"));
    
    resp.setContentType("text/html;charset=UTF-8");
    
    try {
      BoardDao boardDao = new BoardDao();
      boardDao.update(board);
      
      resp.sendRedirect("list.do");
      return;//
    } catch (Exception e) {
      req.setAttribute("error", e);
      RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
      rd.include(req, resp);
      
    } 
    
  }
  
}
