//��ť������
interface ButtonListener{
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

class InnerClassDemo3{
	public static void main(String[] args){
		Button btn1 = new Button();
		btn1.addListener(new ButtonListenerAdapter(){
			// ʵ��
			public void onClick(){
				System.out.println("I Click");
			}
		});

		btn1.click();

		Button btn2 = new Button();
		btn2.addListener(new ButtonListenerAdapter(){
			// ʵ��
			public void onClick(){
				System.out.println("You Click");
			}
			// ��д
			public void onDbClick(){
				System.out.println("You Click twice");
			}
		});
		btn2.click();
		btn2.dbClick();
		
		// ��̬��ʹ����������������
		ButtonListener l = new ButtonListenerAdapter(){
			// ʵ��
			public void onClick(){
				System.out.println("He Click");
			}
			// ��д
			public void onDbClick(){
				System.out.println("He Click twice");
			}
		};
		
		Button btn3 = new Button();
		btn3.addListener(l);
		btn3.click();

		Button btn4 = new Button();
		btn4.addListener(new ButtonListener(){
			public void onClick(){
				
			}
			public void onDbClick(){
				
			} 
			public void onKeyDown(){
				
			}
			public void onKeyUp(){
				
			}
		});
	}
}