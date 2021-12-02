package oodesign.store.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Base on the list of product, we build a map for all products for fast access
 * */
public class MapBuilder {
    List<Product> products;
    public  MapBuilder (List<Product> products) {
        this.products = products;
    }

    /**
     * It is very important to build a map for search services
     * all our search are base on this map
     * a map with id as key and all information of the product as value
     * */
    public Map<Integer, Product> buildMapIDandProduct(){
        Map<Integer, Product> idAndProduct = new HashMap<>();
        for (Product aProduct : products) {
            idAndProduct.put(aProduct.getId(), aProduct);
        }
        return idAndProduct;
    }
}
