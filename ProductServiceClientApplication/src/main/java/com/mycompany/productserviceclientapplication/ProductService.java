/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productserviceclientapplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import my.model.Product;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author macbookair
 */
public class ProductService {

    public static void main(String[] args) throws SOAPException, IOException, TransformerConfigurationException, TransformerException {

        // 1). Create a valid SOAP message based on the SOAP message requirements of the web service to call getproducts(). 
        MessageFactory mf = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
        SOAPMessage soapMessage = mf.createMessage();

        SOAPPart soapPart = soapMessage.getSOAPPart();

        SOAPEnvelope soapEnvelope = soapPart.getEnvelope();

        soapEnvelope.addNamespaceDeclaration("S", "http://schemas.xmlsoap.org/soap/envelope/");

        soapEnvelope.setPrefix("S");

        SOAPHeader soapHeader = soapMessage.getSOAPHeader();
        soapHeader.detachNode();

        SOAPBody soapBody = soapMessage.getSOAPBody();
        soapBody.addNamespaceDeclaration("ns2", "http://Services/");
        soapBody.setPrefix("S");
        QName qname = new QName("", "GetProduct", "ns2");
        soapBody.addChildElement(qname);

        soapMessage.writeTo(System.out);

        System.out.println("");

        //2). Create a SOAP connection and pass your SOAP message to the web service, receiving the SOAP response in return.
        SOAPConnectionFactory scFactory = SOAPConnectionFactory.newInstance();

        SOAPConnection soapConnection = scFactory.createConnection();

        URL endpoint = new URL("http://localhost:8080/BaseWebService/ProductsServiceService");

        //3). Call to service and getting response
        SOAPMessage response = soapConnection.call(soapMessage, endpoint);

        //4). Reading response body.
        SOAPBody responseBody = response.getSOAPBody();

        System.out.println("----------------- Response -----------------");
        response.writeTo(System.out);
        
        
        System.out.println("\n----------------- Read XML response and populating into POJO class -----------------");
        NodeList list = responseBody.getElementsByTagName("SelectedProduct");

        //5). Create a Product List and populating instances of Product class by reading the product details from the SOAP response message.
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < list.getLength(); i++) {
            
            String id = list.item(i).getChildNodes().item(0).getTextContent();
            String name = list.item(i).getChildNodes().item(1).getTextContent();
            double price = Double.parseDouble(list.item(i).getChildNodes().item(2).getTextContent());

            Product p = new Product();
            p.setId(id);
            p.setName(name);
            p.setPrice(price);
            
            products.add(p);

        }
        
        for(Product p : products)
        {
            System.out.println(p.getId()+" "+p.getName()+" "+p.getPrice());
        }

        //6).Write the response SOAPMessage content to a file called response.xml.
        Document doc = response.getSOAPBody().extractContentAsDocument();
        StringWriter sw = new StringWriter();
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.transform(new DOMSource(doc), new StreamResult(sw));
        FileOutputStream fos = new FileOutputStream(new File("response.xml"));
        fos.write(sw.toString().getBytes());
        fos.close();

    }

}
