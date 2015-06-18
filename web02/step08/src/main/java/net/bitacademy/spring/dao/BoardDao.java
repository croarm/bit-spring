package net.bitacademy.spring.dao;

import java.util.List;

import net.bitacademy.spring.vo.Board;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*mybatis의 MapperScannerConfigurer 에서 사용할 인터페이스
 * => sql 문을 찾을 때, 인터페이스 이름과 메서드 이름을 사용하여 찾는다.
 * => sql 파일에서 namespace 이름과 sql 문의 id 값이 위의 이름과 일치해야 한다.
 * => 메서드의 파라미터 개수는 반드시 한개여야 한다.
 *  */
public interface BoardDao {
  
  List<Board> selectList() throws Exception;
  Board selectOne(int no) throws Exception;
  int insert(Board board) throws Exception;
  int update(Board board) throws Exception;
  int delete(int no) throws Exception;
  
}











