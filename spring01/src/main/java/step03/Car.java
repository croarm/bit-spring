package step03;

import java.util.Date;

public class Car {
  String  model;
  int     capacity;
  Date    outDate;
  Engine  engine;
 
  public Car(){
    System.out.println("Car()");
    
  }
  
  @Override
  public String toString() {
    return "Car [model=" + model + ", capacity=" + capacity + ", outDate="
        + outDate + ", engine=" + engine + "]";
  }
  
  public Engine getEngine() {
    return engine;
  }
  public void setEngine(Engine engine) {
    System.out.println("Car.setEngine()");
    this.engine = engine;
  }
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    System.out.println("Car.setModel()");
    this.model = model;
  }
  public int getCapacity() {
    return capacity;
  }
  public void setCapacity(int capacity) {
    System.out.println("Car.setCapacity()");
    this.capacity = capacity;
  }
  public Date getOutDate() {
    return outDate;
  }
  public void setOutDate(Date outDate) {
    System.out.println("Car.setOutDate()");
    this.outDate = outDate;
  }
  
  
  
  
  
}
