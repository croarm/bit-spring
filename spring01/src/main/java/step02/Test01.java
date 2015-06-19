package step02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test01 {
  public static void main(String[] args) {
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext("step02/application-context01.xml");
    
    Car p1 = (Car)ctx.getBean("c7");
    Car p2 = (Car)ctx.getBean("c8");
    Car p3 = (Car)ctx.getBean("c9");
    
    System.out.println(p1);
    System.out.println(p2);
    System.out.println(p3);
    
    
  }
}
