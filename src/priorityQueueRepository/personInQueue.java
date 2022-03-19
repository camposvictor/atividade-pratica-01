package priorityQueueRepository;

public class personInQueue {
	private String name;
	private boolean priority;
	
	public personInQueue(String name, boolean priority){
		this.name = name;
		this.priority = priority;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean getPriority(){
		return priority;
	}
}
