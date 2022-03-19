package priorityQueueRepository;

import java.util.List;
import java.util.Scanner;

public class Menu {

private Scanner scanner;
private priorityQueue priority = new priorityQueue();
private personInQueue personInQueue;

public Menu(Scanner s) {
	this.scanner = s;
}


private void showMenu() {
	System.out.println("----------------------------------------------------");
	System.out.println("|                   --> MENU <--                   |");
	System.out.println("|--------------------------------------------------|");
	System.out.println("| 1. Adicionar pessoa para atendimento normal      |");
	System.out.println("| 2. Adicionar pessoa para atendimento prioritario |");
	System.out.println("| 3. Atender pessoa                                |");
	System.out.println("| 4. Listar pessoas na fila                        |");
	System.out.println("| 5. Gerar estatisticas de atendimentos            |");
	System.out.println("| 6. Sair                                          |");
	System.out.println("----------------------------------------------------");
	System.out.print("\n-> ");
}
  
  private void waitForEnter() {
	    System.out.println("\nPressione ENTER para continuar...");
	    scanner.nextLine();
  }

  private void addNormalService(){
	  	System.out.print("Nome: ");
	    String name = scanner.nextLine();
	    personInQueue = new personInQueue(name, true);
  }
  
  private void addPriorityService(){
	  	System.out.print("Nome: ");
	    String name = scanner.nextLine();
	    personInQueue = new personInQueue(name, true);
  }
  
  private void attend(){
	  if (!priority.isEmpty()) {
	      System.out.println("Atendido: " + priority.remove());
	  }
	  System.out.println("Fila vazia!");
  }
  
private void list(){
	int queuePosition = 1;
    for (priorityQueueRepository.personInQueue name : priority.findAll()) {
      System.out.println((queuePosition++) + " - " + name);
    }
  }
  
  private void statistics() {
	  final int total = priority.getNoPriorityCounter() + priority.getPriorityCounter();
	  if(priority.getNoPriorityCounter() == 0 && priority.getPriorityCounter() == 0) {
		  	System.out.println("Pessoas atendidas: 0");
		    System.out.println("Pessoas na fila: 0");
		    System.out.println("\nTotal de pessoas: 0"); 
	    	System.out.println("Porcentagem de atendimentos prioritarios: 0%");
	    	System.out.println("Porcentagem de atendimentos normais: 0%");
		}
	  else {
		    System.out.println("Pessoas atendidas: " +priority.getTotal());
		    System.out.println("Pessoas na fila: " +priority.getinQueue());
		    System.out.println("\nTotal de pessoas: " +total);
		    System.out.println("Porcentagem de atendimentos prioritarios: " + (priority.getPriorityCounter() * 100 / total) + "%");
		    System.out.println("Porcentagem de atendimentos normais: " + (priority.getNoPriorityCounter() * 100 / total) + "%");
	  }
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
          priority.person.add(personInQueue);
          break;
        case 2:
          addPriorityService();
          priority.person.add(personInQueue);
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
          if (!priority.isEmpty()) {
        	System.out.println("Fila não esta vazia, não foi possivel sair!");
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
