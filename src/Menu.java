import java.util.Scanner;

public class Menu {

  private Scanner scanner;
  private PersonPriorityQueueRepository queueRepository;

  public Menu(PersonPriorityQueueRepository repo, Scanner s) {
    this.queueRepository = repo;
    this.scanner = s;
  }

  private void showMenu() {
	  	System.out.println("----------------------------------------------------");
		System.out.println("|                   --> MENU <--                   |");
		System.out.println("|--------------------------------------------------|");
	    System.out.println("| 1. Adicionar pessoa para atendimento normal      |");
	    System.out.println("| 2. Adicionar pessoa para atendimento prioritario |");
	    System.out.println("| 3. Atendimento de uma pessoa                     |");
	    System.out.println("| 4. Listar pessoas na fila                        |");
	    System.out.println("| 5. Gerar estatisticas                            |");
	    System.out.println("| 5. Sair                                          |");
	    System.out.println("----------------------------------------------------");
	    System.out.print("\n-> ");
  }

  private void waitForEnter() {
    System.out.println("\nPressione ENTER para continuar...");
    scanner.nextLine();
  }

  private void addNormalService() {
    System.out.print("Nome: ");
    String name = scanner.nextLine();
    queueRepository.add(new Person(name, false));
  }

  private void addPriorityService() {
    System.out.print("Nome: ");
    String name = scanner.nextLine();
    queueRepository.add(new Person(name, true));
  }

  private void attend() {
    if (!queueRepository.isEmpty()) {
      Person personAttended = queueRepository.remove();
      System.out.println("Atendido: " + personAttended.getName());
      return;
    }
    System.out.println("Fila vazia!");
  }

  private void list() {
    int queuePosition = 0;
    for (Person person : queueRepository.findAll()) {
    	queuePosition++;
    	System.out.println((queuePosition) + ". " + person.getName() + " - " + (person.getHasPriority() ? "Prioritário" : "Normal"));
    }
    if(queuePosition==0) {
    	System.out.println("A fila esta vazia!");  
    }
  }

  private void statistics() {
    final int total = queueRepository.getNoPriorityCounter() + queueRepository.getPriorityCounter();
    System.out.println("Pessoas na fila: " + queueRepository.size());

    if (total == 0) {
      System.out.println("Nenhuma pessoa atendida");
      return;
    }
    System.out.println("Porcentagem de atendimentos prioritários: " + (queueRepository.getPriorityCounter() * 100 / total) + "%");
    System.out.println("Porcentagem de atendimentos normais: " + (queueRepository.getNoPriorityCounter() * 100 / total) + "%");
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
            System.out.println("Fila não esta vazia, não foi possivel sair!");
            waitForEnter();
          } else
            System.exit(0);

          break;
        default:
        	System.out.println("\nOpção inválida!\n");
          waitForEnter();
      }
    } while (true);
  }
}
