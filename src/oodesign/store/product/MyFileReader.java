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
            String color = productArray[5];

            Product aProduct = new Product(id);
            aProduct.setDate(date);
            aProduct.setName(name);
            aProduct.setColor(color);
            listOfProducts.add(aProduct);
        }
        return listOfProducts;
    }

    public void print(List<Product> products) {
        for (Product aProduct : products) {
            System.out.println("id:[" + aProduct.getId() + "] name:[" + aProduct.getName() +
                    "] date:[" + aProduct.getDate()+"]");
        }
    }

    public static void main(String[] args) throws IOException {
        MyFileReader fr = new MyFileReader();
        File file = new File("/Users/serenapang/Development/Algorithms/src/oodesign/store/product/products.csv");
        List<Product> products = fr.extractInfo(file);
        fr.print(products);
    }
}
