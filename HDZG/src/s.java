interface USB {
	void start();
	void stop();
}
class UFan implements USB {
	public void start() {
		System.out.println("我是USB风扇，获得电流，风扇开始转动");
	}
	public void stop() {
		System.out.println("我是USB风扇，停止转动");
	}
}
class UDisk implements USB {
	public void start() {
		System.out.println("我是U盘，获得电流，开始传输数据");
	}
	public void stop() {
		System.out.println("我是U盘，停止传输数据");
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

