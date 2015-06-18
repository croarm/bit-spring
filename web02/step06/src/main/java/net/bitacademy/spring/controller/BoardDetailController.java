package net.bitacademy.spring.controller;

import net.bitacademy.spring.dao.BoardDao;
import net.bitacademy.spring.vo.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board/detail.do")
public class BoardDetailController {
  
  @Autowired
  BoardDao boardDao;
  
  /*뷰 컴포넌트에게 전달할 데이터를 담을 바구니를 요청한다. => Model*/
  /*
  @RequestMapping
  public String detail(int no, Model model)
      throws Exception {
      
      Board board = boardDao.selectOne(no);
      model.addAttribute("board", board);
      
      return "/board/detail.jsp";
    
  }
  */
  
  /* @RequestParam 을 사용하여 요청 파라미터를 제어할 수 있다.*/
  @RequestMapping
  public String detail(
      @RequestParam(value="bno",required=true, defaultValue="13") int no, Model model)
      throws Exception {
      
      Board board = boardDao.selectOne(no);
      model.addAttribute("board", board);
      
      return "/board/detail.jsp";
    
  }
}
