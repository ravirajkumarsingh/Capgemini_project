package com.cpg.sprint1.entities;

public class Test {
	
	public Test() {
		this("","");
	}
	
	public Test(String testId, String testName) {
		// TODO Auto-generated constructor stub
		this.testId=testId;
		this.testName=testName;
	}

	private String testId;
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	private String testName;
}
