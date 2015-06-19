package step04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test01 {
  public static void main(String[] args) {
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext("step04/application-context01.xml");
    /*@Component 애노테이션으로 객체를 생성할 때는 객체 아이디 값으로 클래스 이름을 사용. 첫 알파벳 소문자*/
    Car p1 = (Car)ctx.getBean("car");
    Engine p2 = (Engine)ctx.getBean("engine");
    
    System.out.println(p1);
    System.out.println(p2);
    
    //git ~ 마지막 기수 ~ spring01 부분을 참고할 것.
  }
}
