package ioandFile;

import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * 类的版本号 用于对象的序列化 具体用于读取对象时相比硬盘的版本
	 */
	private static final long serialVersionUID = 1L;
	private String Name;
	private int age;
	private Address adress;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person(String name, int age) {
		super();
		Name = name;
		this.age = age;
	}
	
	public Address getAdress() {
		return adress;
	}
	public void setAdress(Address adress) {
		this.adress = adress;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("无参数的构造器");
	}
	@Override
	public String toString() {
		return "Person [Name=" + Name + ", age=" + age + ", adress=" + adress
				+ "]";
	}
	
}
