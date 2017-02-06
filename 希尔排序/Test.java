package ϣ������;

public class Test {
	
	public static void shell_Sort(int[] array){
		//��������Ϊ��ֱ�ӷ��ز������ж�
		if(array == null || array.length == 0){
			return ;
		}else{
			//ȷ����������С��Χ
			for(int i = array.length>>1;i>0;i>>=1){
				for(int j = i;j<array.length;j += i){
					int temp  = array[j];
					int flag = j;
					while(flag >= i && temp<array[flag-i]){
						array[flag] = array[flag-i];
						flag -= i;
					}
					array[flag] = temp;
				}
			}
		}
	}
	
	
	public static void main(String[] args){
		int[] array = {41,532632,62,1,14,52,53,63,63,63,52,414,0,653,3,1,2};
		Test.shell_Sort(array);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
	
}
