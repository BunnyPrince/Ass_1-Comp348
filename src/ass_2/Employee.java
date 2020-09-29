package ass_2;

import java.math.BigDecimal;

 class Employee implements Person{
	private String firstName;
	private String lastName;
	private int id;
	private BigDecimal salary;
	
	public Employee (String fn, String ln,int i ,BigDecimal s ) {
		firstName = fn;
		lastName = ln;
		id = i;
		salary = s;
	}
	
	public String toString() {
		return id +","+ firstName +"," + lastName +","+ salary;
	}
	
	public static Person parse(String emp) {
		String[] employeeInfo = emp.split(",");
		String employeeFirsatName = employeeInfo[1];
		String employeeLastName = employeeInfo[2];
		int employeeId = 0;
		BigDecimal employeeSalary = new BigDecimal(0);
		try{
			employeeId = Integer.parseInt(employeeInfo[0]);
//			double is used to prevent the NumberFormatException
			employeeSalary =BigDecimal.valueOf(Double.parseDouble(employeeInfo[3]));
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		return new Employee(employeeFirsatName, employeeLastName, employeeId, employeeSalary);
	}
	
	public BigDecimal getSalary() {
		return salary;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}
	@Override
	public String getLastName() {
		return lastName;
	}

	
	

}
