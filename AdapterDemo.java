//��ť������
interface ButtonListener
{
	public void onClick(); // �����¼�
	public void onDbClick(); // ˫���¼�
	public void onKeyDown(); // ��������
	public void onKeyUp(); // �����ͷ�
}

// ��ť
class Button{

	// ��ť������
	private ButtonListener listener;
	
	// ��Ӽ�����
	public void addListener(ButtonListener lst){
		this.listener = lst;
	}
	
	// ģ�ⵥ���¼�
	public void click(){
		listener.onClick();
	}
	// ģ��˫���¼�
	public void dbClick(){
		listener.onDbClick();
	}
}

// ����ʵ����
class MyListener implements ButtonListener{
	public void onClick(){
		System.out.println("one click");
	}
	public void onDbClick(){
		System.out.println("two click");
	}
	public void onKeyDown(){
		System.out.println("Key Down");
	}
	public void onKeyUp(){
		System.out.println("Key Up");
	}
} 


class AdapterDemo{
	public static void main(String[] args){
		Button btn1 = new Button();
		MyListener l = new MyListener();
		btn1.addListener(l);

		btn1.click();
	}
}