import java.util.Scanner;

public class Menu {

  private Scanner scanner;
  private PriorityQueueRepository<String> queueRepository;

  public Menu(PriorityQueueRepository<String> repo, Scanner s) {
    this.queueRepository = repo;
    this.scanner = s;
  }

  private void showMenu() {
    System.out.println("\n1 - Adicionar pessoa para atendimento normal");
    System.out.println("2 - Adicionar pessoa para atendimento prioritário");
    System.out.println("3 - Atender pessoa");
    System.out.println("4 - Listar pessoas");
    System.out.println("5 - Gerar estatísticas de atendimentos");
    System.out.println("6 - Sair");
    System.out.print("\n-> ");
  }

  private void waitForEnter() {
    System.out.println("\nPressione ENTER para continuar...");
    scanner.nextLine();
  }

  private void addNormalService() {
    System.out.print("Nome: ");
    String name = scanner.nextLine();
    queueRepository.add(name, false);
  }

  private void addPriorityService() {
    System.out.print("Nome: ");
    String name = scanner.nextLine();
    queueRepository.add(name, true);
  }

  private void attend() {
    if (!queueRepository.isEmpty()) {
      System.out.println("Atendido: " + queueRepository.remove());
      return;
    }
    System.out.println("Fila vazia!");
  }

  private void list() {
    int queuePosition = 1;
    for (String name : queueRepository.findAll()) {
      System.out.println((queuePosition++) + " - " + name);
    }
  }

  private void statistics() {
    final int total = queueRepository.getNoPriorityCounter() + queueRepository.getPriorityCounter();
    System.out.println("Pessoas atendidas: " + total);
    System.out
        .println(
            "Porcentagem de atendimentos prioritários: " + (queueRepository.getPriorityCounter() * 100 / total) + "%");
    System.out
        .println(
            "Porcentagem de atendimentos normais: " + (queueRepository.getNoPriorityCounter() * 100 / total) + "%");
  }

  public void run() {
    int option;
    do {
      showMenu();
      option = scanner.nextInt();
      scanner.nextLine();
      System.out.println();
      switch (option) {
        case 1:
          addNormalService();
          break;
        case 2:
          addPriorityService();
          break;
        case 3:
          attend();
          waitForEnter();
          break;
        case 4:
          list();
          waitForEnter();
          break;
        case 5:
          statistics();
          waitForEnter();
          break;
        case 6:
          if (!queueRepository.isEmpty()) {
            System.out.println("Fila não vazia, Nao foi possivel sair!");
            waitForEnter();
          } else
            System.exit(0);

          break;
        default:
          System.out.println("Opção inválida!");
          waitForEnter();
      }
    } while (true);
  }
}
