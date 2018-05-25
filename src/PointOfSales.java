import java.util.Iterator;
import java.util.LinkedList;

public class PointOfSales {

    private BarCodeScanner barCodeScanner = new BarCodeScanner();
    private Printer printer = new Printer();
    private LcdDisplay lcdDisplay = new LcdDisplay();

    private LinkedList<Product> products = new LinkedList<>();
    private Database database = new Database();
    private double sum = 0.0;

    public PointOfSales(){

    }

    public void useScanner(){
        String barCode = barCodeScanner.scan();
        processBarCode(barCode);
    }

    public void processBarCode(String barCode){

        if(barCode=="exit"){
            exit();
        }else if(barCode ==""){

        }else{
            Product product = database.found(barCode);
            if(product==null){
                lcdDisplay.print("Product not found");
            }else{

            }
        }
    }

    private void exit(){
        printAllOnPrinter();

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
        lcdDisplay.print("Total sum: "+sum);
        sum = 0.0;
        products.clear();
    }
}
