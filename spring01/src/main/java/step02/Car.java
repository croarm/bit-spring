package step02;

import java.util.Date;

public class Car {
  String  model;
  int     capacity;
  Date    outDate;
  
  
  public Car(){
    System.out.println("Car() 호출");
  }
  
  public Car(String model){
    System.out.println("Car(model)");
    this.model = model;
  }
  public Car(int capacity){
    System.out.println("Car(capacity)");
    this.capacity = capacity;
  }
  public Car(String model, int capacity){
    System.out.println("Car(model,capacity)");
    this.model = model;
    this.capacity = capacity;
  }
  public Car(int capacity, String model){
    System.out.println("Car(capacity,model)");
    this.model = model;
    this.capacity = capacity;
  }
  
  @Override
  public String toString() {
    return "Car [model=" + model + ", capacity=" + capacity + ", outDate="
        + outDate + "]";
  }


  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }
  public int getCapacity() {
    return capacity;
  }
  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }
  public Date getOutDate() {
    return outDate;
  }
  public void setOutDate(Date outDate) {
    this.outDate = outDate;
  }
  
  
  
  
  
}
