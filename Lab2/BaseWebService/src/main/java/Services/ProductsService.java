/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Product;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author Owner
 */
@WebService(name="ProductsService")
public class ProductsService {
    
    @WebMethod(operationName="GetProduct")
    @WebResult(name="SelectedProduct")
    public List<Product> GetProducts(){
        
        List<Product> products = new ArrayList<Product>();
        
        products.add(new Product("P1", "Notebook", 10.00));
        products.add(new Product("P2", "Blue Pen", 5.00));
        products.add(new Product("P3", "Red Pen", 5.00));
        products.add(new Product("P4", "Macbook", 1500.00));
        products.add(new Product("P5", "Table", 100.00));
        products.add(new Product("P6", "Chair", 150.00));
        products.add(new Product("P7", "Lamp", 20.00));
        products.add(new Product("P8", "Charger", 30.00));
        
        return products;
    }
}
