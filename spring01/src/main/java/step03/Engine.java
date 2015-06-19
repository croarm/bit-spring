package step03;

public class Engine {
  String  maker;
  int     valve;
  
  public Engine(){
    System.out.println("Engine()");
  }
  
  
  @Override
  public String toString() {
    return "Engine [maker=" + maker + ", valve=" + valve + "]";
  }
  
  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
    System.out.println("Engine.setMaker()");
    this.maker = maker;
  }
  public int getValve() {
    return valve;
  }
  public void setValve(int valve) {
    System.out.println("Engine.setValve()");
    this.valve = valve;
  }
  
  
  
  
}
