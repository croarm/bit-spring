package net.bitacademy.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.bitacademy.spring.dao.BoardDao;
import net.bitacademy.spring.vo.Board;


@Component("/board/add.do")
public class BoardAddController implements PageController {
  
  @Autowired
  BoardDao boardDao;
  
  public String execute(HttpServletRequest req, HttpServletResponse resp)
      throws Exception{
    
    Board board = new Board();
    board.setTitle(req.getParameter("title"));
    board.setContent(req.getParameter("content"));
    
      boardDao.insert(board);
      
      return "redirect:list.do";
  }
}
