import java.util.Iterator;
import java.util.LinkedList;

public class PointOfSale {

    private BarCodeScanner barCodeScanner;
    private Printer printer;
    private LcdDisplay lcdDisplay;
    private boolean running;

    private LinkedList<Product> products = new LinkedList<>();
    private ProductsDatabase database = new ProductsDatabase();
    private double sum = 0.0;

    public PointOfSale(){
        barCodeScanner = new BarCodeScanner();
        printer = new Printer();
        lcdDisplay = new LcdDisplay();
        running = true;
    }

    public void startTransaction(){
        running=true;
        while(running){
            String barCode = barCodeScanner.scan();
            if(barCode.equals("exit")){
                running = false;
                exit();
            }else if(barCode.equals("")){
                lcdDisplay.print("Invalid bar-code");
            }else{
                processBarCode(barCode);
            }
        }
    }


    private void processBarCode(String barCode){
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
            printer.print(iterator.next());
        }
        printer.print("Total sum: "+sum);
    }
}
