package net.bitacademy.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.bitacademy.spring.dao.BoardDao;
import net.bitacademy.spring.vo.Board;

@Component("/board/detail.do")
public class BoardDetailController implements PageController {
  
  @Autowired
  BoardDao boardDao;
  
  public String execute(HttpServletRequest req, HttpServletResponse resp)
      throws Exception {
      
      
      Board board = boardDao.selectOne(Integer.parseInt(req.getParameter("no")));
      req.setAttribute("board", board);
      
      return "/board/detail.jsp";
      
    
  }
}
