/*
 USB�ӿ�
*/
interface USB{
	public void work(String str);
}

/**
 ������
*/
class Fan implements USB{
	public void work(String str){
		System.out.println("����"+str);
	}
}

/**
 �����
*/
class Camera implements USB{
	public void work(String str){
		System.out.println("����"+str);
	}
}

/**
 MP3��
*/
class Mp3 implements USB{
	public void work(String str){
		System.out.println("����"+str);
	}
}

/*
 ���˵���
*/
class PC{
	public void comm(USB usb,String str){
		System.out.println("������"+usb+"�豸");
		usb.work(str);
	}
}

class USBDemo{
	public static void main(String[] args){
		// ����pc����
		PC pc = new PC();
		
		Fan fan = new Fan();
		Mp3 mp3 = new Mp3();
	    Camera c = new Camera();
		
		pc.comm(fan,"cool");
		pc.comm(mp3,"�й�");
		pc.comm(c,"beauty");
	}
}