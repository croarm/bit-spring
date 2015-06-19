package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test04 {
  public static void main(String[] args) {
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext("step01/application-context04.xml");
    
    Car p1 = (Car) ctx.getBean("car1");
    Car p2 = (Car) ctx.getBean("car1");
    
    if(p1 == p2){
      System.out.println("p1 == p2");
    }
    System.out.println("- - - - - - - - - -");
    
    Car p3 = (Car) ctx.getBean("car2");
    Car p4 = (Car) ctx.getBean("car2");
    
    if(p3 != p4){
      System.out.println("p3 != p4");
    }
    
  }
}
