package com.ibm.emp;

public class Executive extends Employee {
	private double incentives;

	public Executive() {
	}

	public Executive(String empName, double salary, double incentives) {
		super(empName, salary);
		this.incentives = incentives;
	}

	@Override
	public void paySlip() {
		super.paySlip();
		System.out.println("Incentives: " + incentives);
	}

	@Override
	public double getSalary() {
		return super.getSalary() + incentives;
	}
}
