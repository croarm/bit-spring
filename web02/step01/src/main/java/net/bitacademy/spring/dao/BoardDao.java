package net.bitacademy.spring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.bitacademy.spring.vo.Board;

public class BoardDao {
  public List<Board> selectList() throws Exception{
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb","study","study");
      stmt = con.createStatement();
      rs = stmt.executeQuery("select bno, title, cre_dt, views"
          + " from board"
          + " order by bno desc");
      
      ArrayList<Board> boards = new ArrayList<Board>();
      Board board = null;
      
      while (rs.next()) {
        board = new Board();
        board.setNo(rs.getInt("bno"));
        board.setTitle(rs.getString("title"));
        board.setCreateDate(rs.getDate("cre_dt"));
        board.setViews(rs.getInt("views"));
        boards.add(board);
      }
      
      return boards;
    
    } finally {
      try { rs.close(); } catch (Exception ex) {}
      try { stmt.close(); } catch (Exception ex) {}
      try { con.close(); } catch (Exception ex) {}
    }
  }
  
  public Board selectOne(int no) throws Exception{

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb","study","study");
      stmt = con.createStatement();
      rs = stmt.executeQuery("select bno, title, content, cre_dt, views"
          + " from board"
          + " where bno="+ no);
      
      if(!rs.next()) {
        throw new Exception("해당 번호의 게시물을 찾을 수 없습니다.");
      }

      Board board = new Board();
      board.setNo(rs.getInt("bno"));
      board.setTitle(rs.getString("title"));
      board.setContent(rs.getString("content"));
      board.setCreateDate(rs.getDate("cre_dt"));
      board.setViews(rs.getInt("views"));
      
      return board;
      
    } finally {
      try { rs.close(); } catch (Exception ex) {}
      try { stmt.close(); } catch (Exception ex) {}
      try { con.close(); } catch (Exception ex) {}
    }
  }
  
  public int insert(Board board) throws Exception{

    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb","study","study");
      stmt = con.prepareStatement(
          "insert into board(title,content,cre_dt) values(?,?,now())");
      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());
      return stmt.executeUpdate();
      
    } finally {
      try { stmt.close(); } catch (Exception ex) {}
      try { con.close(); } catch (Exception ex) {}
    }
    
  }
  
  public int update(Board board) throws Exception{
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studydb","study","study");
      stmt = con.prepareStatement(
          "update board set title=?, content=? where bno=?"
          );
      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());
      stmt.setInt(3, board.getNo());
      
      return stmt.executeUpdate();//
      
    } finally {
      try { stmt.close(); } catch (Exception ex) {}
      try { con.close(); } catch (Exception ex) {}
    }
  }

  public int delete(int no) throws Exception {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studydb","study","study");
      
      stmt = con.prepareStatement(
          "delete from board where bno=?");
      stmt.setInt(1, no);
      
      return stmt.executeUpdate();//
      
    
    } finally {
      try { stmt.close(); } catch (Exception ex) {}
      try { con.close(); } catch (Exception ex) {}
    }
  }
}

