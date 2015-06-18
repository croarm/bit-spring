package net.bitacademy.spring.dao;

import java.io.InputStream;
import java.util.List;

import net.bitacademy.spring.vo.Board;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDao {
  static SqlSessionFactory sqlSessionFactory;
  
  static {
    try {
      // Resources는 클래스 경로에서 주어진 파일을 찾는다.
      InputStream inputStream = Resources.getResourceAsStream(
          "net/bitacademy/spring/dao/mybatis-config.xml");
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  
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











