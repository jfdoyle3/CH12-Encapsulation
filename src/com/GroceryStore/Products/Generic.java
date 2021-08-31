package com.GroceryStore.Products;

public class Generic extends Product {
    private Integer intMeta;
    private String intMetaDesc;
    private String strMeta;
    private Object objMeta;


    public Generic(String name, int price, String id, String description) {
        super(name, price, id, description);
        this.intMeta = null;
        this.intMetaDesc = null;
        this.strMeta = null;
        this.objMeta = null;
    }
}
