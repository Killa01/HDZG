interface USB {
	void start();
	void stop();
}
class UFan implements USB {
	public void start() {
		System.out.println("����USB���ȣ���õ��������ȿ�ʼת��");
	}
	public void stop() {
		System.out.println("����USB���ȣ�ֹͣת��");
	}
}
class UDisk implements USB {
	public void start() {
		System.out.println("����U�̣���õ�������ʼ��������");
	}
	public void stop() {
		System.out.println("����U�̣�ֹͣ��������");
	}	
}
public class s {
	public static void main(String[] args) {		
		USB u = new UFan();
		u.start();
		u.stop();
		u = new UDisk();
		u.start();
		u.stop();
	}
}

