public class Printer {


    public void print(String text){
        System.out.println("Printer: " + text);
    }

    public void print(Product product){
        print("Product: " + product.getName() + " Price: " + product.getPrice());
    }
}
