package net.bitacademy.spring.dao;

import net.bitacademy.spring.vo.BoardLog;

public interface BoardLogDao {
  int insert(BoardLog boardLog) throws Exception;
}
