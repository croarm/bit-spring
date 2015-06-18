package net.bitacademy.spring.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.spring.controller.BoardAddController;
import net.bitacademy.spring.controller.BoardChangeController;
import net.bitacademy.spring.controller.BoardDetailController;
import net.bitacademy.spring.controller.BoardListController;
import net.bitacademy.spring.controller.BoardRemoveController;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    req.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html;charset=UTF-8");

    //ex) http://localhost:9999/web02/board/list.do?pageNo=2&size=5 
    // getServletPath()=> /board/list.do //뒤부터 ? 전까지 

    try{

      String servletPath = req.getServletPath();
      String viewUrl = null;
      if(servletPath.equals("/board/list.do")){
        BoardListController controller = new BoardListController();
        viewUrl = controller.execute(req, resp);
      } else if(servletPath.equals("/board/detail.do")){
        BoardDetailController controller = new BoardDetailController();
        viewUrl = controller.execute(req, resp);
      } else if(servletPath.equals("/board/add.do")){
        BoardAddController controller = new BoardAddController();
        viewUrl = controller.execute(req, resp);
      } else if(servletPath.equals("/board/change.do")){
        BoardChangeController controller = new BoardChangeController();
        viewUrl = controller.execute(req, resp);
      } else if(servletPath.equals("/board/remove.do")){
        BoardRemoveController controller = new BoardRemoveController();
        viewUrl = controller.execute(req, resp);
      } else {
        throw new Exception("해당 URL을 처리할 수 없습니다.");
      }

      if(viewUrl.startsWith("redirect:")){
        resp.sendRedirect(viewUrl.substring(9));//redirect: 뒤부터가 주소니까..
      } else{
        RequestDispatcher rd = req.getRequestDispatcher(viewUrl);
        rd.include(req, resp);
      }
    } catch (Exception e) {
      req.setAttribute("error", e);
      RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
      rd.include(req, resp);

    }
  }

}
