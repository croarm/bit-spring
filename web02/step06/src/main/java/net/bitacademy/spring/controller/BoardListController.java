package net.bitacademy.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.spring.dao.BoardDao;
import net.bitacademy.spring.vo.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/list.do")
public class BoardListController {
  
  @Autowired
  BoardDao boardDao;
  
  /* request handler - 요청을 처리하는 메서드 
   * 리턴 타입 : String => jsp(view 컴포넌트) 주소 */
  @RequestMapping 
  public String list(HttpServletRequest req, HttpServletResponse resp)
      throws Exception{
    
      List<Board> boards = boardDao.selectList();
      
      req.setAttribute("list", boards);
      return "/board/list.jsp";
  }
  
  
  /* 리턴타입 : ModelAndView => 뷰 컴포넌트 url과 뷰 컴포넌트가 사용할 데이터를 함께 리턴한다.  */
  /*
  @RequestMapping //바로 아래 메소드를 부를거니까.. 이름은 그냥 지 멋데로
  public ModelAndView list(HttpServletRequest req, HttpServletResponse resp)
      throws Exception{
    
      List<Board> boards = boardDao.selectList();
      
      ModelAndView mv = new ModelAndView();
      mv.setViewName("/board/list.jsp");
      mv.addObject("list", boards);
      
      return mv;
  }
  */
  
  /* 리턴타입 : String => 클라이언트에게 바로 출력할 내용
   * => jsp를 경유하지 않고 페이지 컨트롤러에서 바로 내용을 보내고 싶을 때 사용한다. 
   * => json 문자열을 클라이언트로 보낼 때. 주로 사용
   * => 한글을 utf-8 로 보낼 수 없다.*/
  /*
  @RequestMapping 
  @ResponseBody //리턴 값은 view URL이 아니라 클라이언트에게 보낼 내용이다.
  public String list(HttpServletRequest req, HttpServletResponse resp)
      throws Exception{
    
      List<Board> boards = boardDao.selectList();
      
      return new Gson().toJson(boards);
  }
  */
  
  /*  리턴타입 : 
  
  */
  /*
  @RequestMapping 
  public ResponseEntity<String> list(HttpServletRequest req, HttpServletResponse resp)
      throws Exception{
    
      List<Board> boards = boardDao.selectList();
      
      String content = new Gson().toJson(boards);
      HttpHeaders headers = new HttpHeaders();
      
      headers.add("Content-Type", "text/plain;charset=UTF-8");
      return new ResponseEntity<String>(content, headers, HttpStatus.OK);
  }
  */
}
