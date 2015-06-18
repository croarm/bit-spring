package net.bitacademy.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.spring.dao.BoardDao;
import net.bitacademy.spring.vo.Board;


public class BoardDetailController {
  
  public String execute(HttpServletRequest req, HttpServletResponse resp)
      throws Exception {
      
      BoardDao boardDao = new BoardDao();
      
      Board board = boardDao.selectOne(Integer.parseInt(req.getParameter("no")));
      req.setAttribute("board", board);
      
      return "/board/detail.jsp";
      
    
  }
}
