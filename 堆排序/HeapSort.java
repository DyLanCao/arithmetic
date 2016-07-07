package ������;

public class HeapSort {
	
	//������ķ���
	public static void heapSort(int[] array){
		//�Դ�����������һ���ѽṹ�ĳ�ʼ��
		buildMaxHeap(array);
		//������ѽ��ж����򣬰Ѹ�Ԫ�������һ��Ԫ�ؽ��н��� 
		//֮���ڶԳ���Ԫ���������Ԫ�ؽ��ж����ݽṹ�ĵ���
		for(int i = array.length-1;i>=1;i--){
			array[i] = array[i]^array[0];
			array[0] = array[i]^array[0];
			array[i] = array[i]^array[0];
			maxHeap(array,i,0);
		}
		
	}
	
	public static void buildMaxHeap(int[] array){
		//�Ӷ������м���н���
		int half = array.length/2;
		for(int i=half;i>=0;i--){
			//���ý����ѽṹ�ķ���������жѽṹ�Ľ���
			maxHeap(array,array.length,i);
		}
	}
	//���������
	public static  void maxHeap(int[] array,int heapSize,int index){
		//���Һ��� �����Ԫ������
		int left = index*2+1;
		int right = index*2+2;
		int largest = index;
		//������Ӵ��ڸ��ڵ� ��������С�ڶѳ��� ��ʹ���������������
		if(left<heapSize && array[left]>array[index]){
			largest = left;
		}
		//����Һ��Ӵ�����������ڵ� �����Һ���С�ڶѳ��� ��ʹ������������Һ���
		if(right<heapSize && array[right]>array[largest]){
			largest = right;
		}
		//���統ǰ���ڵ㲻���������� 
		if(index != largest){
			//���ø��ڵ�����������Ԫ�ؽ��н���
			array[largest] = array[largest]^array[index];
			array[index] = array[largest]^array[index];
			array[largest] = array[largest]^array[index];
			//Ȼ���ڶ���������� �������ݹ���й��������
			maxHeap(array,heapSize,largest);
		}
	}
	
	public static void main(String[] args) {
		int[] array = {87,65,67,85,26,41,16,73,438,95,73,51,0};
		
		HeapSort.heapSort(array);
		
		for(int i =0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
}
