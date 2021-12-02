package oodesign.store.product;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * provides the services such as:
 * - search by id
 * - search by name
 * - search by color
 * - search by range of dates
 * (from 1/2020 to 8/2021)
 * */
public class Services {

    public static Map<Integer, Product> idAndProduct;

    /**
     * create a map with id as key and all information of the product as value
     * */
    public Map<Integer, Product> buildMapIDandProduct(List<Product> products){
        idAndProduct = new HashMap<>();
        for (Product aProduct : products) {
            idAndProduct.put(aProduct.getId(), aProduct);
        }
        return idAndProduct;
    }

    /**
     * search by id
     * */
    public Product searchById(int id){
        if (idAndProduct.containsKey(id)) {
         return idAndProduct.get(id);
        }
        return null;
    }

    /**
     * search by name
     * */
    public Product searchByName(String name){
        Iterator<Map.Entry<Integer, Product>> iterator = idAndProduct.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Product> entry = iterator.next();
            int id = entry.getKey();
            String nameInfo = entry.getValue().getName();
            if (nameInfo.equals(name)) {
                return idAndProduct.get(id);
            }
        }
        return null;
    }

    /**
     * search by color
     * */
    public Product searchByColor(String color){
        Iterator<Map.Entry<Integer, Product>> iterator = idAndProduct.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Product> entry = iterator.next();
            int id = entry.getKey();
            String colorInfo = entry.getValue().getColor();
            if (colorInfo.equals(color)) {
                return idAndProduct.get(id);
            }
        }
        return null;
    }
    /**
     * search by date range
     * */
    public List<Product> searchByDateRange(int startingMonth, int startingYear, int endingMonth, int endingYear) {
        List<Product> listProducts = new ArrayList<>();
        Iterator<Map.Entry<Integer, Product>> iterator = idAndProduct.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Product> entry = iterator.next();
            int id = entry.getKey();
            int month = entry.getValue().getMonth();
            int year = entry.getValue().getYear();

            //if the item production date is within the range of date, we return it
            if (month >= startingMonth && month <= endingMonth && year >= startingYear && year <= endingYear) {
                listProducts.add(idAndProduct.get(id));
            }
        }
        return listProducts;
    }

    public void printMap(Map<Integer, Product> map) {
        System.out.println(map.entrySet());
    }

    public void print(List<Product> products) {
        for (Product aProduct : products) {
            System.out.println(aProduct);
        }
    }
    public static void main(String[] args) throws IOException {
        MyFileReader fr = new MyFileReader();
        File file = new File("/Users/serenapang/Development/Algorithms/src/oodesign/store/product/products.csv");
        List<Product> products = fr.extractInfo(file);
        //fr.print(products);

        Services services = new Services();
        Map<Integer, Product> idWithProduct = services.buildMapIDandProduct(products);
        services.printMap(idWithProduct);

        Product product = services.searchById(1);
        System.out.println("Searching " + product.getId() + " " + product.getName());

        System.out.println("Search products from Jan 2020 to Aug 2021: ");
        List<Product> result = services.searchByDateRange(1,2020, 8,2021);
        services.print(result);
    }
}
