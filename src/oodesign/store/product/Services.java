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
    List<Product> products;
    //pass the list of products to map builder
    MapBuilder mapBuilder;
    //use this map for searching services
    Map<Integer, Product> idAndProduct;

    public Services (List<Product> listOfAllProducts) {
        this.products = listOfAllProducts;
        mapBuilder = new MapBuilder(products);
        idAndProduct = mapBuilder.buildMapIDandProduct();
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
    public List<Product> searchByName(String name){
        List<Product> listProducts = new ArrayList<>();
        Iterator<Map.Entry<Integer, Product>> iterator = idAndProduct.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Product> entry = iterator.next();
            int id = entry.getKey();
            String nameInfo = entry.getValue().getName();
            if (nameInfo.equals(name)) {
                listProducts.add(idAndProduct.get(id));
            }
        }
        return listProducts;
    }

    /**
     * search by color
     * */
    public List<Product> searchByColor(String color){
        List<Product> listProducts = new ArrayList<>();
        Iterator<Map.Entry<Integer, Product>> iterator = idAndProduct.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Product> entry = iterator.next();
            int id = entry.getKey();
            String colorInfo = entry.getValue().getColor();
            if (colorInfo.equals(color)) {
                listProducts.add(idAndProduct.get(id));
            }
        }
        return listProducts;
    }
    /**
     * search by date range
     *  if the item production date is within the range of date, we return it
     *   be mindful about the year difference and the months it should be added
     *   we have to add all the products from the starting month of the starting year
     *   also the whole year product of the other years
     * */
    public List<Product> searchByDateRange(int startingMonth, int startingYear, int endingMonth, int endingYear) {
        List<Product> listProducts = new ArrayList<>();
        if (endingYear < startingYear) {
            System.out.println("Ending year should be GREATER or EQUALS to the starting year ");
            return listProducts;
        }
        Iterator<Map.Entry<Integer, Product>> iterator = idAndProduct.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Product> entry = iterator.next();
            int id = entry.getKey();
            int month = entry.getValue().getMonth();
            int year = entry.getValue().getYear();
           // System.out.println("month: " + month + " starting mon: " + startingMonth + " ending mon: " + endingMonth + " year: " + year + " starting: " + startingYear  + " ending year: " + endingYear);
            /**
             * case 1: year, starting year and ending year are equals; we only include the months in range
             * case 2.1: starting year is the same as year, but ending year is not the same as year;
             *          we include starting year month in range, and ending year month in range
             * case 2.2: starting and ending year are not the same; and both are not the same as year
             *  we include all the years in range with all months
             * */
            if (startingYear == endingYear) {
                if (year == endingYear && month >= startingMonth && month <= endingMonth) {
                    listProducts.add(idAndProduct.get(id));
                }
            } else {
                    //case 2.1
                    if (startingYear == year && month >= startingMonth && month <= 12 || endingYear == year && month <= endingMonth) {
                        listProducts.add(idAndProduct.get(id));
                    } else  if (year > startingYear && year < endingYear){
                        //case 2.2
                        //in between the starting and ending year
                        if (year > startingYear && year < endingYear && month >= 1 && month <= 12) {
                            System.out.println("here add " + id);
                            listProducts.add(idAndProduct.get(id));
                        }
                    }
            }
        }
        return listProducts;
    }
    /**
     * print the search result for search for single result
     *  - id
     * */
    public void printResult(Product product) {
        if (product == null) {
            System.out.println("Product NOT FOUND");
            return;
        }
        System.out.println(product);
    }

    /**
     * print the search result for search for multiple result
     *  - name
     *  - color
     *  - date range
     * */
    public void printListOfResults(List<Product> products) {
        if (products == null || products.size() == 0) {
            System.out.println("Product NOT FOUND");
            return;
        }
        for (Product aProduct : products) {
            System.out.println(aProduct);
        }
    }

    public void printMap(Map<Integer, Product> map) {
        System.out.println(map.entrySet());
    }

    public static void main(String[] args) throws IOException {
        MyFileReader fr = new MyFileReader();
        File file = new File("/Users/serenapang/Development/Algorithms/src/oodesign/store/product/products.csv");
        List<Product> products = fr.extractInfo(file);
        //fr.print(products);

        Services services = new Services(products);
       // services.printMap(idWithProduct);

//        Product product = services.searchById(1);
//        services.printResult(product);

        //testing date range: starting year == ending year
        //3/2020 - 8/2020
        //List<Product> result = services.searchByDateRange(2,2020, 6,2020);

        //testing date range: starting year < ending year
        //2/2020 - 1/2022
        List<Product> result = services.searchByDateRange(2,2020, 1,2022);

        //testing date range: starting year < ending year
        //3/2020 - 3/2021
        //List<Product> result = services.searchByDateRange(3,2020, 4,2021);
        services.printListOfResults(result);
    }
}
