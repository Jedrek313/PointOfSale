import java.util.Iterator;
import java.util.LinkedList;

public class PointOfSale {

    private BarCodeScanner barCodeScanner;
    private Printer printer;
    private LcdDisplay lcdDisplay;
    private boolean running;

    private LinkedList<Product> products = new LinkedList<>();
    private Database database = new Database();
    private double sum = 0.0;

    public PointOfSale(){
        barCodeScanner = new BarCodeScanner();
        printer = new Printer();
        lcdDisplay = new LcdDisplay();
        running = true;
    }

    public void run(){
        while(running){
            String barCode = barCodeScanner.scan();
            if(barCode=="exit"){
                exit();
                running = false;
            }else if(barCode =="" || barCode==null){
                lcdDisplay.print("Invalid bar-code");
            }else{
                processBarCode(barCode);
            }
        }
    }


    public void processBarCode(String barCode){
        Product product = database.found(barCode);
        if(product==null){
            lcdDisplay.print("Product not found");
        }else{
            addProduct(product);
            lcdDisplay.print(product);
        }
    }

    private void exit(){
        printAllOnPrinter();
        lcdDisplay.print("Total sum: "+sum);
        clear();
    }

    private void clear(){
        sum = 0.0;
        products.clear();
    }

    private void addProduct(Product product){
        products.add(product);
        sum = sum + product.getPrice();
    }

    private void printAllOnPrinter(){
        Iterator<Product> iterator = products.iterator();
        while(iterator.hasNext()){
            lcdDisplay.print(iterator.next());
        }
        printer.print("Total sum: "+sum);
    }
}
