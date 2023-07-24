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

// �����¼�������
abstract class ButtonListenerAdapter implements ButtonListener{
	public void onDbClick(){
	}
	public void onKeyDown(){
	}
	public void onKeyUp(){
	}
} 

class MyListener extends ButtonListenerAdapter{
	public void onClick(){
		System.out.println("I click");
	}
}
class YourListener extends ButtonListenerAdapter{
	public void onClick(){
		System.out.println("You click");
	}
}


class AdapterDemo2{
	public static void main(String[] args){
		Button btn1 = new Button();
		MyListener l = new MyListener();
		btn1.addListener(l);
		btn1.click();

		Button btn2 = new Button();
		YourListener y = new YourListener();
		btn2.addListener(y);
		btn2.click();

		
	}
}