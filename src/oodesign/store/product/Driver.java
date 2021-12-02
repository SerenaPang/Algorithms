package oodesign.store.product;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Driver {
    /**
     * Driver that starts the wohle program
     * */
    public static void main(String[] args) throws IOException {
        MyFileReader fr = new MyFileReader();
        File file = new File("/Users/serenapang/Development/Algorithms/src/oodesign/store/product/products.csv");
        List<Product> products = fr.extractInfo(file);

        Menu menu = new Menu(products);
        menu.startProgram();
    }
}
