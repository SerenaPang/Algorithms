package oodesign.store.product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader {
    /**
     * split the line into array and use integer parse int
     */
    public List<Product> extractInfo(File inputFile) throws IOException {
        List<Product> listOfProducts = new ArrayList<>();
        FileReader in = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(in);

        System.out.println("Reading " + inputFile.getName().toString() + "... ...");
        String line;
        while ((line = br.readLine()) != null) {
            //for each line, we extract the id, date
            String[] productArray = line.split(":");
            String idStr = productArray[0];
            int id = Integer.parseInt(idStr);
            String date = productArray[1];
            String name = productArray[2];
            String description = productArray[3];
            String price = productArray[4];
            String color = productArray[5];
            //process date info
            String[] dateInfo = date.split(",");
            String monthStr = dateInfo[0];
            int month = determineMonth(monthStr);
            int year = Integer.parseInt(dateInfo[1]);

            Product aProduct = new Product(id);
            aProduct.setDate(date);
            aProduct.setName(name);
            aProduct.setDescription(description);
            aProduct.setPrice(price);
            aProduct.setColor(color);
            aProduct.setMonth(month);
            aProduct.setYear(year);

            listOfProducts.add(aProduct);
        }
        return listOfProducts;
    }

    /**
     * helper method to determine the month of production
     * */
    public int determineMonth(String monthStr) {
        int month = 0;
        switch (monthStr) {
            case "January":
                month = 1;
                break;
            case "February":
                month = 2;
                break;
            case "March":
                month = 3;
                break;
            case "April":
                month = 4;
                break;
            case "May":
                month = 5;
                break;
            case "June":
                month = 6;
                break;
            case "July":
                month = 7;
                break;
            case "August":
                month = 8;
                break;
            case "September":
                month = 9;
                break;
            case "October":
                month = 10;
                break;
            case "November":
                month = 11;
                break;
            case "December":
                month = 12;
                break;
        }
        return month;
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
        fr.print(products);
    }
}
