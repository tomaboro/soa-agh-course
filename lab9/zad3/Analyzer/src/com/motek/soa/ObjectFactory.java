
package com.motek.soa;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.motek.soa package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CountSpacesResponse_QNAME = new QName("http://soa.motek.com/", "countSpacesResponse");
    private final static QName _CountSpaces_QNAME = new QName("http://soa.motek.com/", "countSpaces");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.motek.soa
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CountSpaces }
     * 
     */
    public CountSpaces createCountSpaces() {
        return new CountSpaces();
    }

    /**
     * Create an instance of {@link CountSpacesResponse }
     * 
     */
    public CountSpacesResponse createCountSpacesResponse() {
        return new CountSpacesResponse();
    }

    /**
     * Create an instance of {@link Report }
     * 
     */
    public Report createReport() {
        return new Report();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountSpacesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soa.motek.com/", name = "countSpacesResponse")
    public JAXBElement<CountSpacesResponse> createCountSpacesResponse(CountSpacesResponse value) {
        return new JAXBElement<CountSpacesResponse>(_CountSpacesResponse_QNAME, CountSpacesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountSpaces }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soa.motek.com/", name = "countSpaces")
    public JAXBElement<CountSpaces> createCountSpaces(CountSpaces value) {
        return new JAXBElement<CountSpaces>(_CountSpaces_QNAME, CountSpaces.class, null, value);
    }

}
