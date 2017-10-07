
package it.mibact.bonus.verificavoucher;

import com.sun.xml.internal.ws.developer.JAXWSProperties;

import javax.jws.HandlerChain;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyStore;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "VerificaVoucher", targetNamespace = "http://bonus.mibact.it/VerificaVoucher/", wsdlLocation = "https://s3.eu-central-1.amazonaws.com/sklivvz-misc/VerificaVoucher.wsdl")
public class VerificaVoucher_Service
    extends Service
{

    private final static URL VERIFICAVOUCHER_WSDL_LOCATION;
    private final static WebServiceException VERIFICAVOUCHER_EXCEPTION;
    private final static QName VERIFICAVOUCHER_QNAME = new QName("http://bonus.mibact.it/VerificaVoucher/", "VerificaVoucher");

    // Path to keystore and password for client side authentication using a certificate.
    private String keystorePath;
    private String password;

    static {
        URL url = null;
        WebServiceException e = null;
        try {
           url = new URL("https://s3.eu-central-1.amazonaws.com/sklivvz-misc/VerificaVoucher.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        VERIFICAVOUCHER_WSDL_LOCATION = url;
        VERIFICAVOUCHER_EXCEPTION = e;

    }

    public VerificaVoucher_Service(String keystorePath, String password) {
        super(__getWsdlLocation(), VERIFICAVOUCHER_QNAME);
        this.keystorePath = keystorePath;
        this.password = password;
    }
    /**
     * 
     * @return
     *     returns VerificaVoucher
     */
    @WebEndpoint(name = "VerificaVoucherSOAP")
    public VerificaVoucher getVerificaVoucherSOAP() {

        try {
           SSLContext sc = SSLContext.getInstance("SSLv3");
            KeyManagerFactory factory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(new FileInputStream(keystorePath), password.toCharArray());
            factory.init(keyStore, password.toCharArray());
            sc.init(factory.getKeyManagers(), null, null);

            VerificaVoucher service = super.getPort(new QName("http://bonus.mibact.it/VerificaVoucher/", "VerificaVoucherSOAP"), VerificaVoucher.class);
            ((BindingProvider) service).getRequestContext()
                    .put(JAXWSProperties.SSL_SOCKET_FACTORY, sc.getSocketFactory());

            return service;

        } catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns VerificaVoucher
     */
    @WebEndpoint(name = "VerificaVoucherSOAP")
    public VerificaVoucher getVerificaVoucherSOAP(WebServiceFeature... features) {
        return super.getPort(new QName("http://bonus.mibact.it/VerificaVoucher/", "VerificaVoucherSOAP"), VerificaVoucher.class, features);
    }

    private static URL __getWsdlLocation() {
        if (VERIFICAVOUCHER_EXCEPTION!= null) {
            throw VERIFICAVOUCHER_EXCEPTION;
        }
        return VERIFICAVOUCHER_WSDL_LOCATION;
    }

}
