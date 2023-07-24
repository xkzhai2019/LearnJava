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

// 监听实现类
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