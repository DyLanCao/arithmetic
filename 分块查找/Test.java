package �ֿ����;

//˼·���ȶԵ�ǰ�����ݽ��зֿ鴦����һ��������ÿһ���е�����
//�������а����˵�ǰ���е����ֵ���ڲ���ȷ��Ԫ�ص�ʱ�����ҵ�ȷ���Ŀ�
//֮���ٶԿ���в��ҵĹ���
public class Test {
	private static int[] indexTable = new int[3];
	
	public static void initIndexTable(int[] data){
		int length = data.length/indexTable.length;
		int temp = data[0];
		int j = 0;
		for(int i=0;i<data.length-1;i++){
			if(i == length){
				indexTable[j] = temp;
				j++;
				temp = 0;
				length *= 2;
			}
			if(temp < data[i+1]){
				temp = data[i+1];
			}
		}
		indexTable[j] = temp;
		for(int i=0;i<indexTable.length;i++){
			System.out.print(indexTable[i]+" ");
		}
	}
	
	public void search(int[] data,int key){
		for(int i=0;i<indexTable.length;i++){
			
		}
	}
	public static void main(String[] args){
		int[] data = {12,42,53,64,72,1,53,63,2,63,41,63,41,653,777};
		Test.initIndexTable(data);
	}
}
