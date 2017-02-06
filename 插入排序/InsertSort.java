package ��������;

public class InsertSort {
	
	public static void sort(int[] data){
		for(int i = 1;i<data.length;i++){
			//����һ���м�ı����������ǰ�����ֵ������
			int temp = data[i];
			//���������Ƚϱ�ʾ����
			int index = i;
			while(index>=1 && temp<data[index-1]){
				//�����ֵ����ǰ��һ��
				data[index] = data[index-1];
				index--;
			}
			data[index] = temp; 
		}
	}
	//���
	public static void print(int[] data){
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+" ");
		}
	}
	public static void main(String[] args){
		int[] data = {24,53,64,7535,7,68746,35,24,0,1,1,2,3};
		InsertSort.sort(data);
		InsertSort.print(data);
	}
}
