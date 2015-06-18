package net.bitacademy.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.bitacademy.spring.dao.BoardDao;
import net.bitacademy.spring.vo.Board;

@Component("/board/list.do")
public class BoardListController implements PageController {
  
  @Autowired
  BoardDao boardDao;
  
  public String execute(HttpServletRequest req, HttpServletResponse resp)
      throws Exception{
    
      List<Board> boards = boardDao.selectList();
      
      req.setAttribute("list", boards);
      return "/board/list.jsp";
  }
}
