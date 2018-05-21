package example;public class HelloWorldClient {
  public static void main(String[] argv) {
    MyService service = new PortLocator().getPort();
    //invoke business method
    service.businessMethod();  
  }
}
