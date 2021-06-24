# Product-SoapWebServiceClient-SAAJ-JAX-WS
This is an small demonstration of using SAAJ in webService Client which helps to generate soap request and parse Soap response.

1). Use the attached web service project (http://localhost:8080/BaseWebService/ProductsServiceService?Tester). This testing page allows you to see the SOAP message you need to create for the getproducts() method.

2). Create a valid SOAP message based on the SOAP message requirements of the web service to call getproducts(). You may need to add/remove namespaces or prefixes to the envelope.

3). Create a SOAP connection and pass your SOAP message to the web service, receiving the SOAP response in return.

4). Create a Product class and populate an instance of that class by reading the product details from the SOAP response message.

5). Write the response SOAPMessage content to a file called response.xml.
