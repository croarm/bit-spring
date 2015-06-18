package net.bitacademy.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.bitacademy.spring.dao.BoardDao;
import net.bitacademy.spring.vo.Board;

@Component("/board/change.do")
public class BoardChangeController implements PageController {

  @Autowired
  BoardDao boardDao;
  
  public String execute(HttpServletRequest req, HttpServletResponse resp)
      throws Exception{

    Board board = new Board();

    board.setNo(Integer.parseInt(req.getParameter("no")));
    board.setTitle(req.getParameter("title"));
    board.setContent(req.getParameter("content"));

    boardDao.update(board);

    return "redirect:list.do";


  }

}
