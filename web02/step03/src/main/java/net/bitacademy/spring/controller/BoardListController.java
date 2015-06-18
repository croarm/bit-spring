package net.bitacademy.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.spring.dao.BoardDao;
import net.bitacademy.spring.vo.Board;


public class BoardListController {
  
  public String execute(HttpServletRequest req, HttpServletResponse resp)
      throws Exception{
    
      BoardDao boardDao = new BoardDao();
      List<Board> boards = boardDao.selectList();
      
      req.setAttribute("list", boards);
      return "/board/list.jsp";
  }
}
