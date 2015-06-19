package net.bitacademy.spring.controller;

import javax.servlet.http.HttpServletRequest;

import net.bitacademy.spring.service.BoardService;
import net.bitacademy.spring.vo.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")
public class BoardController {
  
  @Autowired BoardService boardService;
  
  @RequestMapping("/list") // web.xml에 설정한 확장자명 (.do)는 생략해도 된다
  public String list(Model model) throws Exception{
    
      model.addAttribute("list", boardService.list());
      
      return "board/list";
  }
  
  @RequestMapping(value="/add",method=RequestMethod.POST)
  public String add(Board board, HttpServletRequest request) throws Exception{

    boardService.add(board, request.getRemoteAddr());

    return "redirect:list.do";
  }
  
  @RequestMapping(value="/change",method=RequestMethod.POST)
  public String change(Board board, HttpServletRequest request) throws Exception{

    boardService.change(board, request.getRemoteAddr());
    
    return "redirect:list.do";
  }
  
  @RequestMapping("/remove")
  public String remove(int no, HttpServletRequest request) throws Exception{
    
    boardService.remove(no, request.getRemoteAddr());
    
    return "redirect:list.do";
  }
  
  @RequestMapping("/detail")
  public String detail(int no, Model model, HttpServletRequest request) throws Exception {
      
      Board board = boardService.get(no, request.getRemoteAddr());
      model.addAttribute("board", board);
      
      return "board/detail";
    
  }
}
