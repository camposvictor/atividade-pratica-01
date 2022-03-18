import java.util.ArrayList;
import java.util.List;

public class PriorityQueueRepository<T> {
  private ArrayList<T> queue;
  private int priorityCounter;
  private int noPriorityCounter;

  public PriorityQueueRepository() {
    this.queue = new ArrayList<T>();
    this.noPriorityCounter = 0;
    this.priorityCounter = 0;
  }

  public void add(T data, boolean priority) {
    if (priority) {
      this.priorityCounter++;
      this.queue.add(0, data);
      return;
    }

    this.queue.add(data);
    this.noPriorityCounter++;
  }

  public T remove() {
    if (this.queue.isEmpty())
      return null;

    return this.queue.remove(0);
  }

  public int size() {
    return this.queue.size();
  }

  public boolean isEmpty() {
    return this.queue.isEmpty();
  }

  public List<T> findAll() {
    List<T> list = new ArrayList<T>();
    for (T item : this.queue) {
      list.add(item);
    }

    return list;
  }

  public int getNoPriorityCounter() {
    return this.noPriorityCounter;
  }

  public int getPriorityCounter() {
    return this.priorityCounter;
  }
}
