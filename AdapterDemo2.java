//按钮监听器
interface ButtonListener
{
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