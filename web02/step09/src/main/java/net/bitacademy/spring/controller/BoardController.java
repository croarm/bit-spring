package net.bitacademy.spring.controller;

import java.util.List;

import net.bitacademy.spring.dao.BoardDao;
import net.bitacademy.spring.vo.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")
public class BoardController {
  @Autowired
  BoardDao boardDao;
  
  @RequestMapping("/list") // web.xml에 설정한 확장자명(.do)은 생략해도 된다.
  public String list(Model model) throws Exception {
    List<Board> boards = boardDao.selectList();
    model.addAttribute("list", boards);
    return "board/list";
  }
  
  @RequestMapping(value="/add", method=RequestMethod.POST)
  public String add(Board board) throws Exception {
    boardDao.insert(board);
    return "redirect:list.do";
  }
  
  @RequestMapping(value="/change", method=RequestMethod.POST)
  public String change(Board board) throws Exception {
    boardDao.update(board);
    return "redirect:list.do";
  }
  
  @RequestMapping("/remove")
  public String remove(int no) throws Exception {
    boardDao.delete(no);
    return "redirect:list.do";
  }
  
  @RequestMapping("/detail")
  public String detail(int no, Model model) throws Exception {
    Board board = boardDao.selectOne(no);
    model.addAttribute("board", board);
    return "board/detail";
  }
}









