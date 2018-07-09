//package cn.thxy.test01;
//
//interface Fruit {
//	public void eat();					
//}
//class Apple implements Fruit {
//	public void eat() {
//		System.out.println("*****吃苹果");
//	}
//}
//class Banana implements Fruit {
//	public void eat() {
//		System.out.println("****吃香蕉");
//	}
//}
//class GetFactory {
//	public static Fruit GetInstance(String className) {
//		if("Apple".equals(className)) {
//			return new Apple();
//		}
//		else if("Banana".equals(className)) {
//			return new Banana();
//		} else {
//			return null;
//		}
//	}
//}
//
//public class Factory {
//	public static void main(String args[]) {
//		Fruit f = GetFactory.GetInstance("Apple");
//		f.eat();
//	}
//}
