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

            //if the item production date is within the range of date, we return it

            //be mindful about the year difference and the months it should be added
            /**
             * if starting year is less than ending year
             * such as from 1/2020 - 4/2022
             *
             * we need to print all year of 2020 and 2021
             * which means 1/2020 - 12/2020 and 1/2021 - 12/2021
             * and then 1/2022 to 4/2022
             * */
            int yearDifference = endingYear - startingYear;
            //we have to add all the products from the starting month of the starting year
            //also the whole year product of the other years
            /**
             * we are going to decrement the year difference until it reaches 0
             * when difference is 0, we only need to add the products from that ending year
             * first we add all the products produced from the starting mon to December for the starting year
             * if there are more years need to be added()
             * */
            if (yearDifference > 0) {
                    //if it's the same as starting year, add >= starting month to December
                    //if year is greater than starting year

            } //year difference is 0, which means its the same year, but might have difference in months
            else { //as long as the product is produced in that year, print all products within the months frame
                if (month >= startingMonth && month <= endingMonth && year == startingYear) {
                    listProducts.add(idAndProduct.get(id));
                }
            }
//            if (month >= startingMonth && month <= endingMonth && year >= startingYear && year <= endingYear) {
//                listProducts.add(idAndProduct.get(id));
//            }
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

        Product product = services.searchById(1);
        services.printResult(product);

    //    System.out.println("Search products from Jan 2020 to Aug 2021: ");
     //   List<Product> result = services.searchByDateRange(1,2020, 8,2021);
    //    services.printListOfResults(result);
    }
}
