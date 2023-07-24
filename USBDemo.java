/*
 USB接口
*/
interface USB{
	public void work(String str);
}

/**
 风扇类
*/
class Fan implements USB{
	public void work(String str){
		System.out.println("吹风"+str);
	}
}

/**
 相机类
*/
class Camera implements USB{
	public void work(String str){
		System.out.println("拍照"+str);
	}
}

/**
 MP3类
*/
class Mp3 implements USB{
	public void work(String str){
		System.out.println("播放"+str);
	}
}

/*
 个人电脑
*/
class PC{
	public void comm(USB usb,String str){
		System.out.println("传递了"+usb+"设备");
		usb.work(str);
	}
}

class USBDemo{
	public static void main(String[] args){
		// 创建pc对象
		PC pc = new PC();
		
		Fan fan = new Fan();
		Mp3 mp3 = new Mp3();
	    Camera c = new Camera();
		
		pc.comm(fan,"cool");
		pc.comm(mp3,"中国");
		pc.comm(c,"beauty");
	}
}