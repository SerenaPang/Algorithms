package oodesign.store.product;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Welcome menu for user to select
 * */
public class Menu {
    Services services;

    Menu (List<Product> products) {
        services = new Services(products);
    }

        /**
         * welcome message
         */
        public void welcome() {
            System.out.println("==================================");
            System.out.println("==  Welcome to KittyKi Store! ==");
            System.out.println("==================================");
        }

        /**
         * goodbye message
         */
        public void goodbye() {
            System.out.println("==================================");
            System.out.println("==     Thank You! Good Bye!     ==");
            System.out.println("==================================");
        }

    /**
     * menu message
     */
    public void menu() {
        System.out.println("==  In this store, you will be able to search the products by id, name, color, and by the range of date(year and month) produced  ==");
        System.out.println("==  1. Search By ID   ==");
        System.out.println("==  2. Search By Name ==");
        System.out.println("==  3. Search By Color ==");
        System.out.println("==  4. Search By Date Range ==");
        System.out.println("Please enter the according number 1/2/3/4 stands for ID/NAME/COLOR/DATE RANGE to start your search: ");
    }

    /**
     * take user input; assign task to certain function; print the result
     */
    public void coordinator() {
        Scanner in = new Scanner(System.in);
        Scanner inStr = new Scanner(System.in);
        int userChoice = in.nextInt();
        System.out.println("You Entered: " + userChoice);

        switch (userChoice) {
            case 1:
                System.out.println("Please enter product id: ");
                int id = in.nextInt();
                System.out.println("You Entered: " + id);
                Product targetProduct = services.searchById(id);
                services.printResult(targetProduct);
                break;
            case 2:
                System.out.println("Please enter product name: ");
                String name = inStr.nextLine();
                System.out.println("You Entered: " + name);
                List<Product> productsNames = services.searchByName(name);
                services.printListOfResults(productsNames);
                break;

            case 3:
                System.out.println("Please enter product color: ");
                String color = inStr.nextLine();
                System.out.println("You Entered: " + color);
                List<Product> productsColor = services.searchByColor(color);
                services.printListOfResults(productsColor);
                break;

            case 4:
                System.out.println("Please enter product year range(starting month and year, ending month and year)");
                System.out.println();

                System.out.println("Enter Starting Month(Press ENTER to continue): " );
                String startMonStr = inStr.nextLine();
                int startMon = Integer.parseInt(startMonStr);
                System.out.println("You Entered: " + startMon + " Press ENTER to continue");
                System.out.println();

                System.out.println("Enter Starting Year: ");
                String startYearStr = inStr.nextLine();
                int startYear = Integer.parseInt(startMonStr);
                System.out.println("You Entered: " + startYearStr+ " Press ENTER to continue");
                System.out.println();

                System.out.println("Enter Ending Month: ");
                String endMonStr = inStr.nextLine();
                int endMon = Integer.parseInt(endMonStr);
                System.out.println("You Entered: " + endMonStr+ " Press ENTER to continue");
                System.out.println();

                System.out.println("Enter Ending Year: ");
                String endYearStr = inStr.nextLine();
                int endYear = Integer.parseInt(endYearStr);
                System.out.println("You Entered: " + endYearStr+ " Press ENTER or RETURN to continue");
                System.out.println();

                System.out.println("Searching products produced between " + startMonStr +"/" + startYearStr + " and " + endMonStr + "/" + endYearStr);
                System.out.println();
                List<Product> productsDateRange = services.searchByDateRange(startMon,startYear,endMon,endYear);
                services.printListOfResults(productsDateRange);
                break;
            default:
                System.out.println("Please enter product id: ");
                int idProduct = in.nextInt();
                System.out.println("You Entered: " + idProduct);
                Product productInfo = services.searchById(idProduct);
                services.printResult(productInfo);
        }
        goodbye();
    }
    /**
     * start another search
     */
    public void anotherSearch() {
        System.out.println("Do you want to start another search? enter [yes] or [no] :");
        Scanner in = new Scanner(System.in);
        String userChoice = in.nextLine();
        if (userChoice.equals("yes")) {
            startProgram();
        } else {
            goodbye();
        }
    }
    /**
     * start the program
     */
    public void startProgram() {
        welcome();
        menu();
        coordinator();
        anotherSearch();
    }

        public static void main(String[] args) throws IOException {
        MyFileReader fr = new MyFileReader();
        File file = new File("/Users/serenapang/Development/Algorithms/src/oodesign/store/product/products.csv");
        List<Product> products = fr.extractInfo(file);

        Menu menu = new Menu(products);
        menu.startProgram();
    }
}
