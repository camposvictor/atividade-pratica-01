package priorityQueueRepository;

import java.util.ArrayList;
import java.util.List;

public class priorityQueue{
	ArrayList<personInQueue> person = new ArrayList<>();
	private int priorityCounter;
	private int noPriorityCounter;
	private int total;
	private int inQueue;
	
	public priorityQueue(){
	    this.noPriorityCounter = 0;
	    this.priorityCounter = 0;
	    this.total = 0;
	    this.inQueue = 0;
	}
	
	public void add(personInQueue data) {
		if(data.getPriority()==true){
			int cont = 0;
			for(personInQueue person : person){
				if(!person.getPriority()){
					this.person.add(cont, data);
					this.priorityCounter++;
				}
				cont++;
			}
		}
		else{
			this.person.add(data);
			this.noPriorityCounter++;
		}
		this.inQueue++;
	}
	
	public personInQueue remove(){
		if(this.person.isEmpty()){
			return null;
		}
		else{
			this.total++;
			return this.person.remove(0);
		}
	}
	
	public boolean isEmpty(){
		return person.isEmpty();
	}
	
	public int size() {
	    return this.person.size();
	}
	

	
	public int getNoPriorityCounter() {
	    return this.noPriorityCounter;
	}

	public int getPriorityCounter() {
	    return this.priorityCounter;
	}
	  
	public int getinQueue() {
		return this.inQueue;
	}
	  
	public int getTotal() {
		return this.total;
	}
	
	public List<personInQueue> findAll() {
		List<personInQueue> queue = new ArrayList<personInQueue>();
	    int i=1;
		for (personInQueue data : this.person) {
	    	System.out.println(i + ". "+ person.getName);
	    }
	    return queue;
	}
}
