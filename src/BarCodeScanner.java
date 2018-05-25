import java.util.Scanner;

public class BarCodeScanner {

    private Scanner scanner;

    public BarCodeScanner(){
        scanner = new Scanner(System.in);
    }

    public String scan(){
        return scanner.nextLine();
    }

    public void endScanning(){
        scanner.close();
    }
}
