class Animal {
	String name;
	void shout(){
		System.out.println("���﷢������");
		}
}
class Dog extends Animal {
	public void printName(){
		System.out.println("name="+name);
	}
}
public class Example01{
	public static void main(String[] args) {
		Dog dog=new Dog();
		dog.name="ɳƤ��";
		dog.printName();
		dog.shout();
	}
}