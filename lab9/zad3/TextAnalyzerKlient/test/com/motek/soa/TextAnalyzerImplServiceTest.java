/**
 * TextAnalyzerImplServiceTest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.7  Built on : Nov 20, 2017 (11:41:20 GMT)
 */
package com.motek.soa;


/*
 *  TextAnalyzerImplServiceTest Junit test case
 */
public class TextAnalyzerImplServiceTest extends junit.framework.TestCase {
    /**
     * Auto generated test method
     */
    public void testcountSpaces() throws java.lang.Exception {
        com.motek.soa.TextAnalyzerImplServiceStub stub = new com.motek.soa.TextAnalyzerImplServiceStub(); //the default implementation should point to the right endpoint

        com.motek.soa.TextAnalyzerImplServiceStub.CountSpacesE countSpaces4 = (com.motek.soa.TextAnalyzerImplServiceStub.CountSpacesE) getTestObject(com.motek.soa.TextAnalyzerImplServiceStub.CountSpacesE.class);
        // TODO : Fill in the countSpaces4 here
        assertNotNull(stub.countSpaces(countSpaces4));
    }

    /**
     * Auto generated test method
     */
    public void testStartcountSpaces() throws java.lang.Exception {
        com.motek.soa.TextAnalyzerImplServiceStub stub = new com.motek.soa.TextAnalyzerImplServiceStub();
        com.motek.soa.TextAnalyzerImplServiceStub.CountSpacesE countSpaces4 = (com.motek.soa.TextAnalyzerImplServiceStub.CountSpacesE) getTestObject(com.motek.soa.TextAnalyzerImplServiceStub.CountSpacesE.class);
        // TODO : Fill in the countSpaces4 here
        stub.startcountSpaces(countSpaces4, new tempCallbackN1000C());
    }

    //Create an ADBBean and provide it as the test object
    public org.apache.axis2.databinding.ADBBean getTestObject(
        java.lang.Class type) throws java.lang.Exception {
        return (org.apache.axis2.databinding.ADBBean) type.newInstance();
    }

    private class tempCallbackN1000C extends com.motek.soa.TextAnalyzerImplServiceCallbackHandler {
        public tempCallbackN1000C() {
            super(null);
        }

        public void receiveResultcountSpaces(
            com.motek.soa.TextAnalyzerImplServiceStub.CountSpacesResponseE result) {
        }

        public void receiveErrorcountSpaces(java.lang.Exception e) {
            fail();
        }
    }
}
