/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naborBeauty.business;

import java.text.NumberFormat;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
/**
 *
 * @author hyejeongkim
 */
@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productID;
    private String productCode;
    private String productDescription;
    private double productPrice;
    private int productQty;

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }


    public Product() {
        productCode = "";
        productDescription = "";
        productPrice = 0;
        productQty = 0;
    }
    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }
    public void setCode(String code) {
        this.productCode = code;
    }

    public String getCode() {
        return productCode;
    }

    public void setDescription(String description) {
        this.productDescription = description;
    }

    public String getDescription() {
        return productDescription;
    }

    public void setPrice(double price) {
        this.productPrice = price;
    }

    public double getPrice() {
        return productPrice;
    }

    public String getPriceNumberFormat() {
        NumberFormat number = NumberFormat.getNumberInstance();
        number.setMinimumFractionDigits(2);
        if (productPrice == 0) {
            return "";
        } else {
            return number.format(productPrice);
        }
    }

    public String getPriceCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(productPrice);
    }
}