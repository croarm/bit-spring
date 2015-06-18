package net.bitacademy.spring.controller;

import net.bitacademy.spring.dao.BoardDao;
import net.bitacademy.spring.vo.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/board/add.do")
public class BoardAddController {

  @Autowired
  BoardDao boardDao;
  /*
  @RequestMapping(method=RequestMethod.POST) //요청이 들어올때 실행. post 일때만
  public String add(HttpServletRequest req, HttpServletResponse resp)
      throws Exception{

    Board board = new Board();
    board.setTitle(req.getParameter("title"));
    board.setContent(req.getParameter("content"));

      boardDao.insert(board);

      return "redirect:list.do";
  }
   */
/*원하는 요청 파라미터 값이 있으면, 메서드의 파라미터로 선언하라!
 * 단, 파라미터 이름과 같은 이름으로 변수를 선언해야 한다.*/
  /*
  @RequestMapping(method=RequestMethod.POST)
  public String add(String title, String content, HttpServletResponse resp)
      throws Exception{

    Board board = new Board();
    board.setTitle(title);
    board.setContent(content);

    boardDao.insert(board);

    return "redirect:list.do";
  }
  */
  /*요청 파라미터를 vo 객체에 담아달라고 요청할 수 있다.*/
  @RequestMapping(method=RequestMethod.POST)
  public String add(Board board)
      throws Exception{

    boardDao.insert(board);

    return "redirect:list.do";
  }
  
}
