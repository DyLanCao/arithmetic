package �鲢����;
//�鲢����
public class MergeSort {
										// 0   3
	public static void sort(int[] array,int i,int j){ // 1 2 3 4
		//�������������
		if(i<j){
			//������зֽ⴦��ײ��ֳɵ���Ԫ�ص��������������鲢
			int middle = (i+j)/2;
			sort(array,i,middle-1);
			sort(array,middle+1,j);
			merge(array,i,middle,j);
		}
	}

	public static void merge(int[] array,int i,int middle,int j){
		//����������ʼ����
		int left = i;
		//����������ʼ����
		int right = middle+1;
		//��ʱ�洢���������
		int index = i;
		//��ʱ�洢����
		int[] temp = new int[array.length];
		//��������������������У�������Ȳ�ͬ�򳤶������Ԫ����ʣ��
		while(left<=middle && right<=j){
			
			if(array[left]<=array[right]){
				temp[index++] = array[left++];
			}else{
				temp[index++] = array[right++];
			}
		}
		//���������Ԫ����ʣ���ʱ����븳ֵ
		while(left<=middle){
			temp[index++] = array[left++];
		}
		//���������Ԫ����ʣ���ʱ����븳ֵ
		while(right<=j){
			temp[index++] = array[right++];
		}
		//����ʱ������Ԫ�ظ���������仯������
        while(i<=j)
        {
            array[i]=temp[i++];
        }
	}
	
	public static void main(String[] args){
		int[] array = {13,42,52,25,63,1,2,35,7,9};
		
		System.out.println("�鲢����ǰ��");
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
		System.out.println("�鲢�����");
		sort(array, 0, array.length-1);		
		
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
}
