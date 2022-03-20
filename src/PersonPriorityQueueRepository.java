import java.util.List;

 public class PersonPriorityQueueRepository {
  private PersonPriorityQueue queue;
  private int priorityCounter;
  private int noPriorityCounter;
  private int priorityCounterInQueue;
  private int noPriorityCounterInQueue;

  public PersonPriorityQueueRepository() {
    this.queue = new PersonPriorityQueue();
    this.noPriorityCounter = 0;
    this.priorityCounter = 0;
    this.priorityCounterInQueue = 0; 
    this.noPriorityCounterInQueue = 0;
  }

  public void add(Person person) {
    this.queue.add(person);
    if(person.getHasPriority()) {
    	this.priorityCounterInQueue++;
    	
    }
    else {
    	this.noPriorityCounterInQueue++;
    }
  }

  public Person remove() {
    if (this.queue.isEmpty())
      return null;

    Person personRemoved = this.queue.remove();

    if (personRemoved.getHasPriority()) {
      this.priorityCounter++;
      this.priorityCounterInQueue--;
    }
    else {
      this.noPriorityCounter++;
	  this.noPriorityCounterInQueue--;
	}

    return personRemoved;
  }

  public int size() {
    return this.queue.size();
  }

  public boolean isEmpty() {
    return this.queue.isEmpty();
  }

  public List<Person> findAll() {
    return this.queue.findAll();
  }
  
  public int getNoPriorityCounterInQueue() {
	 return this.noPriorityCounterInQueue;
  }

  public int getPriorityCounterInQueue() {
	 return this.priorityCounterInQueue;
  }
  
  public int getNoPriorityCounter() {
    return this.noPriorityCounter;
  }

  public int getPriorityCounter() {
    return this.priorityCounter;
  }
}