import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PointOfSale {

    private BarCodeScanner barCodeScanner;
    private Printer printer;
    private LcdDisplay lcdDisplay;
    private boolean running;

    private List<Product> products = new LinkedList<>();
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
                exit();
            }else if(barCode.equals("")){
                lcdDisplay.print("Invalid bar-code");
            }else{
                processBarCode(barCode);
            }
        }
    }

    public void deactivate(){
        barCodeScanner.endScanning();
    }
    private void processBarCode(String barCode){
        Product product = database.found(barCode);
        if(product==null){
            lcdDisplay.print("Product not found");
        }else{
            addProduct(product);
            lcdDisplay.print(product.toString());
        }
    }

    private void exit(){
        running = false;
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
            printer.print(iterator.next().toString());
        }
        printer.print("Total sum: "+sum);
    }
}
