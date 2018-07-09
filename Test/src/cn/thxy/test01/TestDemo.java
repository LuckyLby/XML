package cn.thxy.test01;

interface Subject {
	public void make();
}
class RealSubject implements Subject {
	public void make() {
		System.out.println("核心主体工作");
	}
}
class ProxySubject implements Subject {
	private Subject subject;
	public ProxySubject(Subject subject) {
		this.subject = subject;
	}
	public void prepare() {
		System.out.println("核心主题前准备工作");
	}
	public void destroy() {
		System.out.print("核心主题后处理后事");
	}
	public void make() {
		this.prepare();
		this.subject.make();
		this.destroy();
	}
}
public class TestDemo {
	public static void main(String args[]) {
		Subject sub = new ProxySubject(new RealSubject());
		sub.make();
	}
}
