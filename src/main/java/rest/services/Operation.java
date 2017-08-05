package rest.services;

public class Operation {

	private String name;
	private String operation;
	

	public Operation(String name,String operation) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.operation=operation;
	}
	public String getOperation() {
		return operation;
	}

	public String getName() {
		return name;
	}
}
