package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test03 {
  public static void main(String[] args) {
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext("step01/application-context03.xml");
    
    Car car1 = (Car) ctx.getBean("step01.Car#0");
    Car car2 = (Car) ctx.getBean("step01.Car");
    if(car1 == car2){
      System.out.println("car1 == car2");
    }
    
    //Car car = (Car) ctx.getBean("Car"); // 에러!!!
    
    Car carx = (Car) ctx.getBean("step01.Car#1");
    Car cary = (Car) ctx.getBean("step01.Car#2");
    
  }
}
