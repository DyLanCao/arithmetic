package Լɪ��;

public class MyLinkedList {
	//�ڲ��� place���ڰ�������Ľڵ���Ϣ ������ǰλ����Ϣ ǰһ���ڵ�ͺ�һ���ڵ�
	public class Place{
		private String place;
		private Place before;
		private Place after;
		public Place(){
			
		}
		
		public Place(String place,Place before,Place after){
			this.place = place;
			this.before = before;
			this.after = after;
		}

		public String getPlace() {
			return place;
		}

		public void setPlace(String place) {
			this.place = place;
		}

		public Place getBefore() {
			return before;
		}

		public void setBefore(Place before) {
			this.before = before;
		}

		public Place getAfter() {
			return after;
		}

		public void setAfter(Place after) {
			this.after = after;
		}
	}
	public Place header = new Place(null,null,null);
	public MyLinkedList(){
		header.setBefore(header);
		header.setAfter(header);
	}
	//���Ԫ�صķ���
	public void add(String value){
		Place p = new Place(value,null,null);
		p.setAfter(header);
		p.setBefore(header.getBefore());
		p.getBefore().setAfter(p);
		p.getAfter().setBefore(p);
	}
	//�������Ż��Ԫ��
	public Place get(int index){
		Place result = header;
		while(index>0){
			if(result.getAfter()!=header){
				result = result.getAfter();
				index--;
			}else{
				System.out.println("�����������������Ȼ�ǰ����Ϊ��");
				System.exit(0);
			}
		}
		return result;
	}
	//�ж�Ԫ�صĳ���
	public int size(){
		int length =0 ;
		Place result = header;
		while(result.getAfter()!=header){
			result = result.getAfter();
			length++;
		}
		return length;
	}
	//�Ƴ���ǰ�Ľڵ�
	public void remove(Place p){
		Place before = p.getBefore();
		Place after = p.getAfter();
		before.setAfter(after);
		after.setBefore(before);
		p = null;
		System.gc();
	}
}
