package �����㷨.��ά�����в���;

public class Solution {
	//˼·���Ӷ�ά��������½ǽ��в��ң�����ʱ�������ƶ���С��ʱ�������ƶ�
    public boolean Find(int [][] array,int target) {
       int length = array.length-1;//�������ֵ
       int index = 0;//�������ֵ
       boolean flag = false;
       while(length>=0 && index<=array[length].length-1){
    	   int temp = array[length][index];//���½ǵ�ֵ
    	   //���½ǵ�ֵ���ڴ���ֵ��ʱ��
    	   if(temp > target){
    		   length--;//���������
    	   //���½ǵ�ֵС�ڴ���ֵ��ʱ��
    	   }else if(temp <target){
    	       index++;//������Ӽ�   
    	   }else{
    		   flag = true;
    		   break;
    	   }
       }
       return flag;
    }
    public static void main(String[] args){
    	int i = 5;
    	int[][] re = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
    	Solution s = new Solution();
    	System.out.println(s.Find(re, i));
    }
}