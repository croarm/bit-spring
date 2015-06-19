[step01]
기존 프로젝트를 gradle 빌드 프로젝트로 포팅

[step02]
servlet + jsp + dao + mybatis
*mybatis => persistence(지속성) framework , jdbc 기능을 대행

[step03]
servlet(x) page controller(plain old java object) 
					 + jsp + dao + mybatis + front controller
*front controller
-클라이언트의 모든 요청을 받아서 적절한 컨트롤러에게 위임한다.
-페이지 컨트롤러의 공통 기능을 수행
 1) 예외가 발생했을 때 특정 서블릿으로 포워딩(인클루딩) 시키는 것.
 2) jsp(view 컴포넌트)로 인클루드 하는것. 
 
 *page controller
 -특정 페이지를 위한 작업 수행
 -해당 페이지에서 출력할 데이터를 준비
 -해당 페이지를 위한 요청 데이터를 처리
 
 [step04]
page controller(plain old java object) 
 + jsp(view)
 + dao(model)
 + mybatis
 + front controller(서블릿)
 + bean container(= object manager) => spring bean container
 
 [step05]
 page controller(plain old java object) 
 + jsp(view)
 + dao(model)
 + mybatis
 + front controller(서블릿)
 + bean container(= object manager) => spring bean container
 + Spring mvc 적용
 
 [step06] - 페이지 컨트롤러 상세 정의
- 리턴 가능한 타입
- 파라미터 타입

 [step07] - crud(create,read,update,delete)를 한 클래스로 묶는다
 
 [step08] - Mybatis의 DAO 자동 생성기 투입
 
 [step09] - view resolver 변경하기
 * view resolver(뷰 해결사)
 - 페이지 컨트롤러가 리턴한 값에 대해 뷰 컴포넌트를 실행 하는 일.
 
 * 기존의 jsp를 WEB-INF/views/ 폴더로 옮긴다.
 
 [step10] - service 객체 도입
 * service 객체
 - 업무 관련 로직을 실행
 - transaction 처리
 
 1)BOARD_LOG 테이블 생성
 2) BOARD VO 클래스 생성
 
 [step11] - transaction 처리하는 방법
 1) 코드에서 트랜젝션을 직접 관리하기
 
 [step12] - 
 2) 애노테이션을 이용하여 트랜젝션 선언하기
 => boardService 클래스에 @Transactional 애노테이션 추가
 => /WEB-INF/config/application-context.xml 에 <tx:annotation-driven 
 
 [step13]
 3) AOP 기술을 이용하여 처리 //@ 대신 //특정 메서드 앞뒤로 필터를 
 => application-context.xml 파일에 aop 관련 태그 추가.
 	tx:advice, aop:config 
 => service 클래스에 @Transactional 애노테이션을 제거한다.
 
 [step14]
 => board 테이블에 filepath 컬럼 추가
 => application-context.xml 파일에 multipart 요청 데이터를 ㅊ리하는 객체를 투입
 => BoardController 클래스 변경
 => Board 클래스 변경 sql 변경 ~
 => BoardDao.xml 변경

 [step15] - 프론트 컨트롤러가 공통으로 사용하는 객체를 분리하여 별도로 준비한다.
 => ServletContextListener 구현체를 통해 공용 객체를 준비한다.
 => ContextLoaderListener 를 web.cml 에 등록하낟.
 => ContextLoaderListener 에서 준비할 개체 정보를 application-context.xml 에서 등록한다.
 => 페이지 컨트롤러와 웹 관련 객체들은 dispatcher-servlet.xml에 등록한다.









 