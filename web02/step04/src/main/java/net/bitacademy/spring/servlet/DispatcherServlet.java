package net.bitacademy.spring.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.spring.controller.PageController;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

@WebServlet(urlPatterns="*.do",loadOnStartup=1)
public class DispatcherServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  ApplicationContext beanContainer;
  
  @Override
  public void init() throws ServletException {
    // servlet.init(servletconfig)에 의해 호출된다. 
    // => 서블릿 컨테이너는 서블릿 객체를 생성한 후 init() 메서드를 호출한다.
    // => init() 메서드는 서블릿이 작업하는데 필요한 객체를 준비하는 일을 한다.
    beanContainer = new FileSystemXmlApplicationContext(
            this.getServletContext().getRealPath("/")//현재 웹어플의 진짜 경로
            + "/WEB-INF/config/application-context.xml");
  }
  
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
      PageController controller = 
          (PageController)beanContainer.getBean(servletPath);
      
      if(controller != null){
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
