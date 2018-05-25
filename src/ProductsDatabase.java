import java.io.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductsDatabase {

    private Map<String, Product> products;

    public ProductsDatabase(){
        products = new TreeMap<>();
        fillList();
    }

    public Product found(String barCode){
        return products.get(barCode);
    }

    private void fillList(){
        try {
            Scanner scanner = new Scanner(new File("Products.csv"));
            String line;
            while ((scanner.hasNextLine())) {
                line = scanner.nextLine();
                String[] columns = line.split(";");
                String barCode = columns[0];
                Product product = new Product(columns[1],Double.parseDouble(columns[2]));
                products.put(barCode,product);
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
