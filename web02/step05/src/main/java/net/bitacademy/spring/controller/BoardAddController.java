package net.bitacademy.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
  
  @RequestMapping(method=RequestMethod.POST) //요청이 들어올때 실행. post 일때만
  public String add(HttpServletRequest req, HttpServletResponse resp)
      throws Exception{
    
    Board board = new Board();
    board.setTitle(req.getParameter("title"));
    board.setContent(req.getParameter("content"));
    
      boardDao.insert(board);
      
      return "redirect:list.do";
  }
}
