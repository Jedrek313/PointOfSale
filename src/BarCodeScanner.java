import java.util.Scanner;

public class BarCodeScanner {

    private Scanner scanner;

    public String scan(){
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void deactivate(){
        scanner.close();
    }
}
