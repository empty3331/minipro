package com.javaex.ex02;

public class Person {
	// 필드
	private String name;
	private String hp;
	private String company;

	// 생성자
	public Person() {
	}

	public Person(String name, String hp, String company) {
		this.name = name;
		this.hp = hp;
		this.company = company;

	}

	// g/s

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void showInfo() {
		System.out.println(name + " " + hp + " " + company);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", hp=" + hp + ", company=" + company + "]";
	}

}
