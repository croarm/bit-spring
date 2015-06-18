package net.bitacademy.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.spring.dao.BoardDao;
import net.bitacademy.spring.vo.Board;


public class BoardChangeController {

  public String execute(HttpServletRequest req, HttpServletResponse resp)
      throws Exception{

    Board board = new Board();

    board.setNo(Integer.parseInt(req.getParameter("no")));
    board.setTitle(req.getParameter("title"));
    board.setContent(req.getParameter("content"));

    BoardDao boardDao = new BoardDao();
    boardDao.update(board);

    return "redirect:list.do";


  }

}
