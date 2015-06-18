package net.bitacademy.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.spring.dao.BoardDao;
import net.bitacademy.spring.vo.Board;


public class BoardAddController {
   
  public String execute(HttpServletRequest req, HttpServletResponse resp)
      throws Exception{
    
    Board board = new Board();
    board.setTitle(req.getParameter("title"));
    board.setContent(req.getParameter("content"));
    
      BoardDao boardDao = new BoardDao();
      boardDao.insert(board);
      
      return "redirect:list.do";
  }
}
