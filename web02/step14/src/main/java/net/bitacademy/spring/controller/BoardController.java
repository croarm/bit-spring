package net.bitacademy.spring.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.bitacademy.spring.service.BoardService;
import net.bitacademy.spring.vo.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/board")
public class BoardController {
  @Autowired ServletContext sc;
  @Autowired BoardService boardService;
  
  @RequestMapping("/list") 
  public String list(Model model) throws Exception {
    model.addAttribute("list", boardService.list());
    return "board/list";
  }
  
  @RequestMapping(value="/add", method=RequestMethod.POST)
  public String add(Board board, 
      @RequestParam MultipartFile file, 
      HttpServletRequest request) throws Exception {
    
    String filename = this.generateFilename(file.getOriginalFilename());
    
    // 새로 만든 파일 이름을 사용하여 지정된 디렉토리로 옮긴다. 
    file.transferTo(new File(
        sc.getRealPath("/files")  // 파일을 저장할 경로를 준비한다. 
        + "/" + filename));
    
    board.setFilepath(filename);
    boardService.add(board, request.getRemoteAddr());
    return "redirect:list.do";
  }

  @RequestMapping(value="/change", method=RequestMethod.POST)
  public String change(Board board, 
      @RequestParam(required=false) MultipartFile file, 
      HttpServletRequest request) throws Exception {
    
    if (!file.isEmpty()) {
      String filename = this.generateFilename(file.getOriginalFilename());
      
      // 새로 만든 파일 이름을 사용하여 지정된 디렉토리로 옮긴다. 
      file.transferTo(new File(
          sc.getRealPath("/files")  // 파일을 저장할 경로를 준비한다. 
          + "/" + filename));
      board.setFilepath(filename);
    }
    
    boardService.change(board, request.getRemoteAddr());
    return "redirect:list.do";
  }
  
  @RequestMapping("/remove")
  public String remove(int no, HttpServletRequest request) throws Exception {
    boardService.remove(no, request.getRemoteAddr());
    return "redirect:list.do";
  }
  
  @RequestMapping("/detail")
  public String detail(int no, Model model, HttpServletRequest request) throws Exception {
    Board board = boardService.get(no, request.getRemoteAddr());
    model.addAttribute("board", board);
    return "board/detail";
  }
  
  private String generateFilename(String originFilename) {
    // 원래 파일명을 사용하지 않는다. => 다른 사람이 올린 파일명과 같을 수 있다.
    // 랜덤하게 생성한 파일명을 사용한다.
    int lastIndex = originFilename.lastIndexOf("."); // 파일명에서 마지막 점의 위치
    return System.currentTimeMillis() + originFilename.substring(lastIndex);
  }
}









