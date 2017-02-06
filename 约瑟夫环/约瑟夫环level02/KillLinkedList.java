package Լɪ��.Լɪ��level02;

import Լɪ��.MyLinkedList.Place;

public class KillLinkedList {
	//�ڲ����ʾ��ǰ�ڵ����ڵ�λ��
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
	private Place header = new Place(null,null,null);
	
	public KillLinkedList(){
		header.setBefore(header);
		header.setAfter(header);
	}
	
	public Place getHeader() {
		return header;
	}

	public void setHeader(Place header) {
		this.header = header;
	}

	//��ӽڵ�
	public void add(String index){
		Place p = new Place(index,null,null);
		//����Ϊͷ���
		p.setAfter(header);
		//ǰ��Ϊ��ǰͷ���ĺ�һ��
		p.setBefore(header.getBefore());
		//�ֱ��֪���ߵ���һ���ڵ�����
		p.getBefore().setAfter(p);
		p.getAfter().setBefore(p);
	}
	//��ȡ��ǰĳһԪ��
	public Place get(int index){ //1
		Place result = header;
		while(index>0){
			if(result.getAfter()!=header){
				result = result.getAfter();
				index--;
			}else{
				System.out.println("����������������");
				return null;
			}
		}
		return result;
	}
	//��ȡ��ǰ������
	public int size(){
		int length = 0;
		Place temp = header.getAfter();
		while(temp!=header){
			length++;
			temp = temp.getAfter();
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
