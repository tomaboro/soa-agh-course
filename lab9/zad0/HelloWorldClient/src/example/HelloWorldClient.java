package example;

public class HelloWorldClient {
  public static void main(String[] args) {
    HelloWorldService helloWorldService = new HelloWorldService();
    HelloWorld helloWorld = helloWorldService.getHelloWorldPort();
    System.out.println(helloWorld.sayHelloWorldFrom("Tomasz"));
  }
}