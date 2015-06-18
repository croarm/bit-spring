package net.bitacademy.spring.service;

import java.util.List;

import net.bitacademy.spring.dao.BoardDao;
import net.bitacademy.spring.dao.BoardLogDao;
import net.bitacademy.spring.vo.Board;
import net.bitacademy.spring.vo.BoardLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class BoardService {
  
  @Autowired BoardDao boardDao;
  @Autowired BoardLogDao boardLogDao;
  @Autowired PlatformTransactionManager txManager;
  
  
  public int add(Board board, String ip) throws Exception{
    //트랜젝션 정의 => 트랜젝션을 다루는 정책을 지정한다.
    // 트랜젝션 전파 유형
    //   기존 트렌젝션 여부 :   있다.(tx1)       없다.
    // 1) REQUIRED      :     tx1           새로 생성
    // 2) REQUIRES_NEW  :   새로 생성(tx2)    새로 생성(tx1)
    // 3) SUPPORTS      :     tx1           트랜젝션 없이 실행
    // 4) NOT_SUPPORTED :   트랜젝션 없이 실행  트랜젝션 없이 실행
    // 5) MANDATORY     :     tx1           오류 발생!
    // 6) NEVER         :   오류 발생!        트랜젝션 없이 실행
    //트랜젝션 상태를 얻어냄
    TransactionDefinition txDef = new DefaultTransactionDefinition(
        TransactionDefinition.PROPAGATION_REQUIRED);
    TransactionStatus txStatus = txManager.getTransaction(txDef);
    
    try{
      int count = boardDao.insert(board);
      logAction(board.getNo(), ip, BoardLog.CMD_INSERT);
      txManager.commit(txStatus);
      return count;

    }catch(Exception e){
      txManager.rollback(txStatus);
      throw e;
    
    }
  }
  
  public Board get(int no, String ip) throws Exception{
    
    Board board = boardDao.selectOne(no);
    logAction(no, ip, BoardLog.CMD_SELECT);
    return board;
    
  }
  
  public List<Board> list() throws Exception{
   
    return boardDao.selectList();
    
  }
  
  public int change(Board board, String ip) throws Exception{
    TransactionDefinition txDef = new DefaultTransactionDefinition(
        TransactionDefinition.PROPAGATION_REQUIRED);
    TransactionStatus txStatus = txManager.getTransaction(txDef);
    
    try{
    int count = boardDao.update(board);
    logAction(board.getNo(), ip, BoardLog.CMD_UPDATE);
    txManager.commit(txStatus);
    return count;
    }catch(Exception e){
      txManager.rollback(txStatus);
      throw e;
    
    }
  }
  
  public int remove(int no, String ip) throws Exception{
    TransactionDefinition txDef = new DefaultTransactionDefinition(
        TransactionDefinition.PROPAGATION_REQUIRED);
    TransactionStatus txStatus = txManager.getTransaction(txDef);
    
    try{
    int count = boardDao.delete(no);
    logAction(no, ip, BoardLog.CMD_DELETE);
    txManager.commit(txStatus);
    return count;
    }catch(Exception e){
      txManager.rollback(txStatus);
      throw e;
    
    }
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
