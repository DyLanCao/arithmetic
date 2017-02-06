package �۰����;

public class Test02 {
	
	public static int halfSort(int[] data,int key){
		int left = 0;//����
		int right = data.length-1;//�ұ��
		int result = -1;
		while(left<=right){	//�����м��ж�
			int half = (left+right)/2;
			if(data[half] == key){
				result = half;
				break;
			}else if(data[half] < key){
				left = half;
			}else{
				right = half;
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		int[] number = {1,2,3,4,5,6,7,8,9,10};
		int key = 6;
		int result = Test02.halfSort(number, key);
		if(result == -1){
			System.out.println("��ǰ���ݲ�����");
		}else{
			System.out.println(result);
		}
	}
}
