package com.java;

public class Student {
	private int s_id;
	private String s_gender;
	private String s_email;
	private double s_score;
	public Student(int s_id, String s_gender, String s_email, double s_score) {
		super();
		this.s_id = s_id;
		this.s_gender = s_gender;
		this.s_email = s_email;
		this.s_score = s_score;
	}
	public Student() {
		super();
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_gender() {
		return s_gender;
	}
	public void setS_gender(String s_gender) {
		this.s_gender = s_gender;
	}
	public String getS_email() {
		return s_email;
	}
	public void setS_email(String s_email) {
		this.s_email = s_email;
	}
	public double getS_score() {
		return s_score;
	}
	public void setS_score(double s_score) {
		this.s_score = s_score;
	}
	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", s_gender=" + s_gender + ", s_email=" + s_email + ", s_score=" + s_score
				+ "]";
	}
	
}
