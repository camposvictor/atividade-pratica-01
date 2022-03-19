import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        PersonPriorityQueueRepository repo = new PersonPriorityQueueRepository();

        Menu menu = new Menu(repo, scanner);

        menu.run();
        scanner.close();
    }
}
