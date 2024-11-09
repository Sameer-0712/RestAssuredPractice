package pojoconcepts;

public class Employees {

	private String name;
	private String id;
	private String dept;
	private String designation;
	private FinData finData;
		
	public FinData getFinData() {
		return finData;
	}
	public void setFinData(FinData finData) {
		this.finData = finData;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
