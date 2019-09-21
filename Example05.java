class Animal {
	public Animal(){
		System.out.println("我是一只动物");
	}
	public Animal(String name) {
		System.out.println("我是一只"+name);
	}
}
class Dog extends Animal {
	public Dog() {
	}
}
public class Example05 {
	public static void main(String[] args) {
		Dog dog=new Dog();
	}
}