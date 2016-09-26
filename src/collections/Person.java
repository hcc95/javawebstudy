package collections;

public class Person {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
<<<<<<< HEAD
	public Person(){
		
	}
	public Person(String name, int age) {
=======
	public Person(String name, int age) {
		super();
>>>>>>> branch 'master' of https://github.com/hcc95/javawebstudy.git
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
