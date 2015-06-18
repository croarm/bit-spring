package net.bitacademy.spring.dao;

import java.util.List;

import net.bitacademy.spring.vo.Board;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 굳이 이름을 지정안하면 class 명의 첫 알파벳을 소문자로 만든 이름을 사용 ex) boardDao
public class BoardDao {
  @Autowired
  SqlSessionFactory sqlSessionFactory;
  
  public List<Board> selectList() throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectList(
          "net.bitacademy.spring.dao.BoardDao.selectList");
    } finally {
      sqlSession.close();
    }
  }
  
  public Board selectOne(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectOne(
          "net.bitacademy.spring.dao.BoardDao.selectOne", no);
    } finally {
      sqlSession.close();
    }
  }
  
  public int insert(Board board) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      int count = sqlSession.insert(
          "net.bitacademy.spring.dao.BoardDao.insert", board);
      sqlSession.commit(); // temp 데이터베이스 ---> 실제 데이터베이스에 적용
      return count;
    } finally {
      sqlSession.close();
    }
  }
  
  public int update(Board board) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      int count = sqlSession.update(
          "net.bitacademy.spring.dao.BoardDao.update", board);
      sqlSession.commit(); // temp 데이터베이스 ---> 실제 데이터베이스에 적용
      return count;
    } finally {
      sqlSession.close();
    }
  }
  
  public int delete(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      int count = sqlSession.delete(
          "net.bitacademy.spring.dao.BoardDao.delete", no);
      sqlSession.commit(); // temp 데이터베이스 ---> 실제 데이터베이스에 적용
      return count;
    } finally {
      sqlSession.close();
    }
  }
  
}











