import java.util.List;

public class PersonPriorityQueueRepository {
  private PersonPriorityQueue queue;
  private int priorityCounter;
  private int noPriorityCounter;

  public PersonPriorityQueueRepository() {
    this.queue = new PersonPriorityQueue();
    this.noPriorityCounter = 0;
    this.priorityCounter = 0;
  }

  public void add(Person person) {
    this.queue.add(person);
  }

  public Person remove() {
    if (this.queue.isEmpty())
      return null;

    Person personRemoved = this.queue.remove();

    if (personRemoved.getHasPriority())
      this.priorityCounter++;
    else
      this.noPriorityCounter++;

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

  public int getNoPriorityCounter() {
    return this.noPriorityCounter;
  }

  public int getPriorityCounter() {
    return this.priorityCounter;
  }
}
