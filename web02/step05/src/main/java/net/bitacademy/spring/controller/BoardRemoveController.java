package net.bitacademy.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.spring.dao.BoardDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/remove.do")
public class BoardRemoveController {

  @Autowired
  BoardDao boardDao;
  
  @RequestMapping
  public String remove(HttpServletRequest req, HttpServletResponse resp)
      throws Exception{

    int no = Integer.parseInt(req.getParameter("no"));

    boardDao.delete(no);

    return "redirect:list.do";
  }
}
