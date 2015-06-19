package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test02 {
  public static void main(String[] args) {
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext("step01/application-context02.xml");
    
    Car car1 = (Car) ctx.getBean("car1");
    
    System.out.println("- - - - - - - - - - - - - ");
    
    Car car2 = (Car) ctx.getBean("car2");
    Car car3 = (Car) ctx.getBean("car3");
    if(car2 == car3){
      System.out.println("car2 == car3");
    }
    
    System.out.println("- - - - - - - - - - - - - ");
    
    Car car4 = (Car) ctx.getBean("car4");
    Car car5 = (Car) ctx.getBean("car5");
    Car car6 = (Car) ctx.getBean("car6");
    if(car4 == car5){
      System.out.println("car4 == car5");
    }
    if(car4 == car6){
      System.out.println("car4 == car6");
    }
    
    
    
  }
}
