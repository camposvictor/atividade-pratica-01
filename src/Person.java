public class Person {
	private String name;
	private boolean hasPriority;

	public Person(String name, boolean priority) {
		this.name = name;
		this.hasPriority = priority;
	}

	public String getName() {
		return name;
	}

	public boolean getHasPriority() {
		return hasPriority;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPriority(boolean priority) {
		this.hasPriority = priority;
	}
}
