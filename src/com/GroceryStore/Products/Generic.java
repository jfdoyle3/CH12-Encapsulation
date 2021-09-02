package com.GroceryStore.Products;

public class Generic extends Product {
    private Integer intMeta = null;
    private String intMetaDesc = null;
    private String strMeta = null;
    private Object objMeta = null;

    public Generic(String name, int price, String id, String description) {
        super(name, price, id, description);
    }
}
