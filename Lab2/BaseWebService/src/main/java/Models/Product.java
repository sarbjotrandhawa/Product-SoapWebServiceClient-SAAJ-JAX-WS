/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Owner
 */
public class Product {

    public Product(String ID, String Name, double Price) {
        this.ID = ID;
        this.Name = Name;
        this.Price = Price;
    }   
    
    private String ID;
    private String Name;
    private double Price;

    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Price
     */
    public double getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(double Price) {
        this.Price = Price;
    }

    @Override
    public String toString() {
        return "Product{" + "ID=" + ID + ", Name=" + Name + ", Price=" + Price + '}';
    }
    
    
}
