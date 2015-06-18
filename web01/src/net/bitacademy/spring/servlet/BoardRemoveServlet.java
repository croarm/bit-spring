package net.bitacademy.spring.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.spring.dao.BoardDao;

@WebServlet("/board/remove.do")
public class BoardRemoveServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    int no = Integer.parseInt(req.getParameter("no"));
    
    resp.setContentType("text/html;charset=UTF-8");
    
    try {
      BoardDao boardDao = new BoardDao();
      boardDao.delete(no);
      
      resp.sendRedirect("list.do");
      return;//
      
    } catch (Exception e) {
      req.setAttribute("error", e);
      RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
      rd.include(req, resp);
      
      
    }
  }
}
