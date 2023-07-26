//按钮监听器
interface ButtonListener{
	public void onClick(); // 单击事件
	public void onDbClick(); // 双击事件
	public void onKeyDown(); // 按键按下
	public void onKeyUp(); // 按键释放
}

// 按钮
class Button{

	// 按钮监听器
	private ButtonListener listener;
	
	// 添加监听器
	public void addListener(ButtonListener lst){
		this.listener = lst;
	}
	
	// 模拟单击事件
	public void click(){
		listener.onClick();
	}

	// 模拟双击事件
	public void dbClick(){
		listener.onDbClick();
	}
}

// 单击事件适配器
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
			// 实现
			public void onClick(){
				System.out.println("I Click");
			}
		});

		btn1.click();

		Button btn2 = new Button();
		btn2.addListener(new ButtonListenerAdapter(){
			// 实现
			public void onClick(){
				System.out.println("You Click");
			}
			// 重写
			public void onDbClick(){
				System.out.println("You Click twice");
			}
		});
		btn2.click();
		btn2.dbClick();
		
		// 多态，使用适配器引用子类
		ButtonListener l = new ButtonListenerAdapter(){
			// 实现
			public void onClick(){
				System.out.println("He Click");
			}
			// 重写
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