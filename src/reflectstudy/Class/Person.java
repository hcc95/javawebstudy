package reflectstudy.Class;

public class Person {
	private String name;
	int age;
	
	private void test(){
		System.out.println("这是私有的方法");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setName(String name,Integer age ) {
		System.out.println("name:"+name);
		System.out.println("age:"+age);
	}
	public int getAge() {
		return age;
	}
	@AgeValidator(max=80,min=20)
	public void setAge(int age) {
		this.age = age;
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("有参数的构造器");
	}
	public Person(){
		//System.out.println("无参数的构造器");
	}

	private void method2(){
		System.out.println("student父类的方法");
	}
}
