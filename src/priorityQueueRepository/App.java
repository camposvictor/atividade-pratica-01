package priorityQueueRepository;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu(sc);
        menu.run();
        sc.close();
    }
}
