package net.bitacademy.spring.service;

import java.util.List;

import net.bitacademy.spring.dao.BoardDao;
import net.bitacademy.spring.dao.BoardLogDao;
import net.bitacademy.spring.vo.Board;
import net.bitacademy.spring.vo.BoardLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

@Service
public class BoardService {
  @Autowired BoardDao boardDao;
  @Autowired BoardLogDao boardLogDao;
  @Autowired PlatformTransactionManager txManager;
  
  public int add(Board board, String ip) throws Exception {
    int count = boardDao.insert(board);
    logAction(board.getNo(), ip, BoardLog.CMD_INSERT);
    return count;
  }
  
  public Board get(int no, String ip) throws Exception {
    Board board = boardDao.selectOne(no);
    logAction(no, ip, BoardLog.CMD_SELECT);
    return board;
  }
  
  public List<Board> list() throws Exception {
    return boardDao.selectList();
  }
  
  public int change(Board board, String ip) throws Exception {
    int count = boardDao.update(board);
    logAction(board.getNo(), ip, BoardLog.CMD_UPDATE);
    return count;
  }
  
  public int remove(int no, String ip) throws Exception {
    int count = boardDao.delete(no);
    logAction(no, ip, BoardLog.CMD_DELETE);
    return count;
  }
  
  private void logAction(int no, String ip, String command)
      throws Exception {
    BoardLog boardLog = new BoardLog();
    boardLog.setBoardNo(no);
    boardLog.setIpAddress(ip);
    boardLog.setCommand(command);
    boardLogDao.insert(boardLog);
  }
}








