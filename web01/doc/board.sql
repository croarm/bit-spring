CREATE TABLE board (
  bno int(11) NOT NULL AUTO_INCREMENT,
  title varchar(255) NOT NULL,
  content mediumtext NOT NULL,
  cre_dt datetime DEFAULT NULL,
  views int(11) DEFAULT '0',
  PRIMARY KEY (bno)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

insert into board(title, content) values('aaaa', 'aaaaaaaaa');
insert into board(title, content) values('bbbbb', 'bbbbbbbbb');
insert into board(title, content) values('ccccc', 'ddcccccccc');
insert into board(title, content) values('dddddd', 'ddddddddd');
insert into board(title, content) values('eeeeee', 'eeeeeeee');

update board set
  cre_dt=now()
where bno > 0;



CREATE TABLE board_log (
  blno int(11) NOT NULL AUTO_INCREMENT,
  bno int NOT NULL,
  ipaddr varchar(255) NOT NULL,
  command char(1) DEFAULT NULL,
  cre_dt datetime NOT NULL,
  PRIMARY KEY (blno)
)
