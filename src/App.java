import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        PersonPriorityQueueRepository repo = new PersonPriorityQueueRepository();

        repo.add(new Person("P1", true));
        repo.add(new Person("n1", false));
        repo.add(new Person("p2", true));
        repo.add(new Person("p3", true));

        Menu menu = new Menu(repo, scanner);

        menu.run();
        scanner.close();
    }
}
