package net.bitacademy.spring.vo;

import java.io.Serializable;
import java.sql.Date;

public class BoardLog implements Serializable {
  private static final long serialVersionUID = 1L;
 
  public static final String CMD_INSERT = "I";
  public static final String CMD_SELECT = "S";
  public static final String CMD_UPDATE = "U";
  public static final String CMD_DELETE = "D";
  
  protected int     no;
  protected int     boardNo;
  protected String  ipAddress;
  protected String  command;
  protected Date    createDate;
  
  @Override
  public String toString() {
    return "BoardLog [no=" + no + ", boardNo=" + boardNo + ", ipAddress="
        + ipAddress + ", command=" + command + ", createDate=" + createDate
        + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getBoardNo() {
    return boardNo;
  }
  public void setBoardNo(int boardNo) {
    this.boardNo = boardNo;
  }
  public String getIpAddress() {
    return ipAddress;
  }
  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }
  public String getCommand() {
    return command;
  }
  public void setCommand(String command) {
    this.command = command;
  }
  public Date getCreateDate() {
    return createDate;
  }
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
  
  
}
