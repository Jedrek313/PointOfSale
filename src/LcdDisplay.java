public class LcdDisplay {

    public void print(String text){
        System.out.println("LCDDisplay: " + text);
    }

    public void print(Product product){
        print("Product: " + product.getName() + " Price: " + product.getPrice());
    }

}
