// List
class ListDemo{
	public static void main(String[] args){
		// �������϶���ʹ���˷���
		java.util.List<Integer> list = new java.util.ArrayList<Integer>();
		list.add(new Integer(1));
		list.add(new Integer(2));
		list.add(new Integer(3));
		list.add(new Integer(4));

		//System.out.println(list.size());
		System.out.println(list.get(2));

		Integer first = list.remove(0);
		System.out.println(first);

		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}