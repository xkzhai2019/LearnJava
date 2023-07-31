class Mantou{
	private static int Num = 100;
	public int getMantou(){
		if(Num<=0){
			return -1;
		}
		System.out.println("Num:"+Num);
		return Num--;
	}
}

class Worker extends Thread{
	private String name;
	private Mantou mantou;
	private int no;

	public Worker(String name, Mantou mantou){
		this.name = name;
		this.mantou = mantou;
	}
	
	public void run(){
		while(true){
			synchronized(mantou){
				if(no<3){
					int tmp = mantou.getMantou();
					if(tmp==-1){
						//System.out.println("��ͷ�ѳ���");
						return;
					}
					no = no + 1;
					System.out.println(name+"����"+"��"+tmp+"����ͷ,������"+no+"����ͷ");
				}
				else{
					return;
				}
			}
			/*
			try{
				// �ͷ�cpu��ռȨ
				Thread.sleep(100);
			}
			catch(Exception e){
			
			}
			*/
		}
	}
}

class ManTouDemo{
	public static void main(String[] args){
		Mantou mantou = new Mantou();
		for(int i=1;i<=40;i++){
			new Worker("worker"+i,mantou).start();
		}
	}
}