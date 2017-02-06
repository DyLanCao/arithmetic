package Ͱ����;

public class BucketSort {
	
	public static void main(String[] args){
		
		int[] data = {5,999,6,42,1,1,1,8};
		int[] data1 = {5,999,6,42,1,1,1,8};
		System.out.println("����ǰ");
		print(data);
		bestBucketsSort(data, 1000);
		System.out.println("�����������");
		print(data);
		System.out.println("һ����������");
		normalBucketSort(data1,1000);
		print(data1);
	}
	
	//����һ��Ͱ��
	public static class Bucket{
		private int data;//��ǰͰ�е�����
		private Bucket next;//Ͱ�е�ǰ���ݵ���һ��
		
		public Bucket(){
			
		}
		public Bucket(int data, Bucket next){
			this.data = data;
			this.next = next;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Bucket getNext() {
			return next;
		}
		public void setNext(Bucket next) {
			this.next = next;
		}
	}
	
	//Ͱ������������ģ�� ��Ͱ�ĸ���M�������������ͬ
	public static void bestBucketsSort(int[] data,int max){
		//Ͱ�ĸ�����Χ����ǰ������ֵ�ֵ
		Bucket[] buckets = new Bucket[max];
		for(int i=0;i<max;i++){
			buckets[i] = new Bucket(0,null);
		}
		//Ϊÿһ��ֵ���и�ֵ����ӦͰ�У��ŵ���Ӧ������λ����
		for(int i=0;i<data.length;i++){
			if(buckets[data[i]].getData() == 0){
				buckets[data[i]].setData(1);
			}else{
				//���統ǰ����һ����ʱ��
				Bucket temp = buckets[data[i]];
				//�ж�ʲôʱ����һ��Ϊ�գ��ѵ�ǰ��ֵ�������ȥ
				while(temp.getNext()!=null){
					temp = temp.getNext();
				}
				Bucket b = new Bucket();
				b.setData(1);
				temp.setNext(b);
			}
		}
		//���ڹ滮data������λ��
		int temp = 0;
		for(int i=0;i<buckets.length;i++){
			//���統ǰͰ��ֵ���Ͱ�е�ֵ�����ȥ
			if(buckets[i].getData() == 1){
				data[temp++] = i;
				//�����ж����ͬԪ����������
				while(buckets[i].getNext() != null){
					data[temp++] = buckets[i].getNext().getData();
					buckets[i].setNext(buckets[i].getNext().getNext());
				}
			}
		}
	}
	//Ͱ����һ�������ģ��
	public static void normalBucketSort(int[]data,int max){
		//����Ͱ�ĸ���Ϊ�������ʮ��֮һ
		Bucket[] buckets = new Bucket[max/10];
		for(int i=0;i<buckets.length;i++){
			buckets[i] = new Bucket(0,null);
		}
		//�ѵ�ǰ������ӽ�Ͱ�Ĺ���
		for(int i=0;i<data.length;i++){
			//���統ǰͰû������
			if(buckets[data[i]/10].getData() == 0){
				buckets[data[i]/10].setData(data[i]);
			//���������Ѱ����ӽ�ȥ
			}else{
				Bucket temp = buckets[data[i]/10];
				//���統ǰͰ����һ���ڵ���ֵ����Ѱ��
				while(temp.getNext()!=null){
					temp = temp.getNext();
				}
				//��ӽ�ȥ
				Bucket b = new Bucket(data[i],null);
				temp.setNext(b);
			}
		}
		//����������λ��
		int temp = 0;
		//��ֵ��ȥ�Ĺ���
		for(int i=0;i<buckets.length;i++){
			if(buckets[i].getData() != 0){
				data[temp++] = buckets[i].getData();
				//���統ǰ������ֵ��Ϊ�յĻ�
				if(buckets[i].getNext()!=null){
					int[] result = bubbleSort(buckets[i].getNext());
					for(int j=0;i<result.length;i++){
						data[temp++] = result[j];
					}
				}
				
			}
		}
	}
	//ð��������������ͬһ��Ͱ�е�����
	public static int[] bubbleSort(Bucket b){
		//�ѵ�ǰͰ��������ֵ�洢��һ��������
		int[] data = new int[1024];
		int index = 0;
		while(b!=null){
			data[index++] = b.getData();
			b = b.getNext();
		}
		//ð������
		for(int i=0;i<index;i++){
			for(int j = index-1;j>i;j--){
				int temp = data[j];
				if(temp < data[j-1]){
					data[j] = data[j-1];
					data[j-1] = temp;
				}
			}
		}
		int[] result = new int[index];
		for(int i=0;i<index;i++){
			result[i] = data[i];
		}
		return result;
	}
	//���
	public static void print(int[] data){
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
}
