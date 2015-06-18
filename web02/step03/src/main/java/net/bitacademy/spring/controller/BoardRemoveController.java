package net.bitacademy.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.spring.dao.BoardDao;


public class BoardRemoveController  {

  public String execute(HttpServletRequest req, HttpServletResponse resp)
      throws Exception{

    int no = Integer.parseInt(req.getParameter("no"));

    BoardDao boardDao = new BoardDao();
    boardDao.delete(no);

    return "redirect:list.do";
  }
}
