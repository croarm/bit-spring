package net.bitacademy.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.bitacademy.spring.dao.BoardDao;

@Component("/board/remove.do")
public class BoardRemoveController implements PageController {

  @Autowired
  BoardDao boardDao;
  
  public String execute(HttpServletRequest req, HttpServletResponse resp)
      throws Exception{

    int no = Integer.parseInt(req.getParameter("no"));

    boardDao.delete(no);

    return "redirect:list.do";
  }
}
