package �����㷨;

public class Test {
	
	public void quick_sort(int[] t,int l,int r){
		if(l<r){
			int i = l;//����         			
			int j = r;//�ұ��          			
			int x = t[i];//Ŀ��Ԫ��			
			while(i < j){					
				while(i<j && t[j]>=x){
					j--;
				}
				if(i<j){
					t[i] = t[j];
					i++;
				}
				while(i<j && t[i]<x){
					i++;
				}
				if(i<j){
					t[j] = t[i];
					j--;
				}
			}
			t[i] = x;
			quick_sort(t,l,i-1);
			quick_sort(t,i+1,r);
		}
	}
	
	public static void main(String[] args){
		int[] a = {10,8,21,32,16,54,7};
		Test t = new Test();
		t.quick_sort(a, 0, a.length-1);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
}
