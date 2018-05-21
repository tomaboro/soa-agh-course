
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

    private final static QName _Zamien_QNAME = new QName("http://soa.motek.com/", "zamien");
    private final static QName _UnsupportedCurrencyException_QNAME = new QName("http://soa.motek.com/", "UnsupportedCurrencyException");
    private final static QName _ZamienResponse_QNAME = new QName("http://soa.motek.com/", "zamienResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.motek.soa
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UnsupportedCurrencyException }
     * 
     */
    public UnsupportedCurrencyException createUnsupportedCurrencyException() {
        return new UnsupportedCurrencyException();
    }

    /**
     * Create an instance of {@link Zamien }
     * 
     */
    public Zamien createZamien() {
        return new Zamien();
    }

    /**
     * Create an instance of {@link ZamienResponse }
     * 
     */
    public ZamienResponse createZamienResponse() {
        return new ZamienResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Zamien }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soa.motek.com/", name = "zamien")
    public JAXBElement<Zamien> createZamien(Zamien value) {
        return new JAXBElement<Zamien>(_Zamien_QNAME, Zamien.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnsupportedCurrencyException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soa.motek.com/", name = "UnsupportedCurrencyException")
    public JAXBElement<UnsupportedCurrencyException> createUnsupportedCurrencyException(UnsupportedCurrencyException value) {
        return new JAXBElement<UnsupportedCurrencyException>(_UnsupportedCurrencyException_QNAME, UnsupportedCurrencyException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZamienResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soa.motek.com/", name = "zamienResponse")
    public JAXBElement<ZamienResponse> createZamienResponse(ZamienResponse value) {
        return new JAXBElement<ZamienResponse>(_ZamienResponse_QNAME, ZamienResponse.class, null, value);
    }

}
