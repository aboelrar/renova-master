package com.example.lenovo.renova.list;

public class productList {
    String producrName,ProductPrice;
    int productImage;

    public productList(String producrName, String productPrice, int productImage) {
        this.producrName = producrName;
        ProductPrice = productPrice;
        this.productImage = productImage;
    }

    public String getProducrName() {
        return producrName;
    }

    public void setProducrName(String producrName) {
        this.producrName = producrName;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }
}
