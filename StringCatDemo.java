/*
	�ַ�������
*/
class StringCatDemo{
	public static void main(String[] args){

		// ʹ��+
		int[] no = new int[]{1001,1002,1003,1004,1005};
		String[] names = new String[]{"����","����","����","����","����"};
		String[] classes = new String[]{"��ѧ","����","Ӣ��","��ѧ","��ѧ",};

		System.out.println("���ο���ѧ����Ϣ���£�");
		for (int i=0;i<no.length ;i++ ){
			System.out.println("ѧ�ţ�"+no[i]+"|������"+names[i]+"|�γ̣�"+classes[i]+"|�༶��"+"������������");
		}

		// �ַ������ȹ���ʱ�ɷ�Ϊ����
		String str = "Welcome to" + " Beijing "
		+"��ӭ����"+"����";
		System.out.println(str);

		// ʹ��concat(),��������String
		String info = "������";
		info = info.concat("ˮ䰡�");
		info = info.concat("��¥��");
		info = info.concat("����");
		System.out.println(info);

		String cn = "�й�";
		System.out.println(cn.concat("����").concat("����"));

	}
}
