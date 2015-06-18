package net.bitacademy.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.spring.dao.BoardDao;
import net.bitacademy.spring.vo.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/detail.do")
public class BoardDetailController {
  
  @Autowired
  BoardDao boardDao;
  
  @RequestMapping
  public String detail(HttpServletRequest req, HttpServletResponse resp)
      throws Exception {
      
      
      Board board = boardDao.selectOne(Integer.parseInt(req.getParameter("no")));
      req.setAttribute("board", board);
      
      return "/board/detail.jsp";
      
    
  }
}
