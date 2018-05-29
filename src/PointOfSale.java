import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PointOfSale {

    private BarCodeScanner barCodeScanner;
    private Printer printer;
    private LcdDisplay lcdDisplay;
    private boolean running;

    private List<Product> products = new LinkedList<>();
    private DatabaseManager database = new DatabaseManager();
    private double totalPrice = 0.0;

    public PointOfSale(){
        barCodeScanner = new BarCodeScanner();
        printer = new Printer();
        lcdDisplay = new LcdDisplay();
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

    public void deactivateScanner(){
        barCodeScanner.deactivate();
    }

    public boolean isRunning() {
        return running;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void addProduct(Product product){
        products.add(product);
        totalPrice = totalPrice + product.getPrice();
    }

    public List<Product> getProducts() {
        return products;
    }

    private void processBarCode(String barCode){
        Product product = database.find(barCode);
        if(product==null){
            lcdDisplay.print("Product not found");
        }else{
            addProduct(product);
            lcdDisplay.print(product.toString());
        }
    }


    public void exit(){
        running = false;
        printAllOnPrinter();
        lcdDisplay.print("Total price: "+totalPrice);
        clear();
    }

    private void clear(){
        totalPrice = 0.0;
        products.clear();
    }


    private void printAllOnPrinter(){
        Iterator<Product> iterator = products.iterator();
        while(iterator.hasNext()){
            printer.print(iterator.next().toString());
        }
        printer.print("Total price: "+totalPrice);
    }
}
