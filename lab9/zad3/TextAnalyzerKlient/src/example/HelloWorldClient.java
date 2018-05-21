package example;

import com.motek.soa.TextAnalyzerImplServiceStub;
import org.apache.axis2.AxisFault;

public class HelloWorldClient {
  public static void main(String[] argv) {
    TextAnalyzerImplServiceStub service = null;
    try {
      service = new TextAnalyzerImplServiceStub();
      TextAnalyzerImplServiceStub.CountSpacesE cse = new TextAnalyzerImplServiceStub.CountSpacesE();
      TextAnalyzerImplServiceStub.CountSpaces cs = new TextAnalyzerImplServiceStub.CountSpaces();
      cs.setArg0("Jestem Tomasz Borowicz");
      cse.setCountSpaces(cs);
      System.out.println(service.countSpaces(cse).getCountSpacesResponse().get_return());
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
