import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        PriorityQueueRepository<String> repo = new PriorityQueueRepository<String>();
        Menu menu = new Menu(repo, scanner);

        menu.run();
        scanner.close();
    }
}
