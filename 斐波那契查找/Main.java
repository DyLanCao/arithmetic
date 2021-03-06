package 斐波那契查找;

//操作数组为有序数组
/*
 * 思路：先找到最接近当前数组长度的斐波那契数，这个数是等于数组长度减一的。如果不符合这个条件则填充上一些虚数
 * 进行补位，这里选择的补位数字是当前数组的最后一位数值，之后初始化一个新的数组copy过来原有数组并对数组进行补位
 * 之后在新数组中进行查找元素，这里面还是取中间元素进行比较但是这种中间元素就不是原来的那种（left+right）/2的形式了
 * 而是根据斐波那契数列的形式来进行选取，初始为mid = low + fibo[k-1];之后进行大小比较判断，如果比待查元素大
 * 则向前查找high = mid -1; k -= 1 斐波那契的数组向前取一位，如果小于待查元素说明当前查找范围在后面则让low=mid+1
 * 之后让fibo的范围向前缩小两位，因为要是缩小一位的话就直接是当前元素数组的末尾值了，缩小两位还是一个黄金比例的中间位置
 * 这样不断进行判断，当相同的时候会出现两种情况，1种是大于小于数组长度则直接范围，如果大于当前长度则是数组的最后一位元素
 * 如果left>right说明当前元素并不在我们的取值范围当中。
 * 优点就是平均查找时间要优化与折半查找，但是在最坏的情况之下要怀于折半查找，并且在找mid的时候使用的是加减的方式而不是
 * 乘除的方式这一点也是一种优化
 */

public class Main {
	
	private static final int max_size = 20;  
	
	//第一步：初始化斐波那契数组用作查找的第一步查找的位数
	public int[] Fibon(){
		int[] result = new int[max_size];
		result[0] = 0;
		result[1] = 1;
		for(int i=2;i<max_size;i++){
			result[i] = result[i-1]+result[i-2];
		}
		return result;
	}
	public int search(int[] array,int number){
		if(array == null || array.length == 0){
			return -1;
		}
		//保证当前数组的范围在这两个指针之间
		//左指针
		int low = 0;
		//右指针
		int high = array.length-1;
		int[] fibon = this.Fibon();
		int k = 0;
		//找到了当前比数组长度大一级的斐波那契数给了k
		for(int i=0;i<fibon.length;i++){
			k++;
			if(fibon[i] > array.length){
			     break;	
			}
		}
		//如果数组长度不正好小于斐波那契数的数值减一的话对其进行虚数的补齐
		int[] operator = new int[fibon[k]];
		for(int i=0;i<array.length;i++){
			operator[i] = array[i];
		}
		for(int i= array.length;i<fibon[k];i++){
			operator[i] = array[array.length-1];
		}
		while(low <= high){
			//待比较的中间值 low的值在这里可以理解成是一个增量的概念起始增量为0之后会根据当前数据的
			//大小来进行调整
			int mid = low + fibon[k-1];
			//如果中间元素大于待查元素则调整high的范围，并与前一位斐波那契数进行比较
			if(number < operator[mid]){
				high = mid-1;
				k-= 1;
			}else if(number > operator[mid]){   //比中间元素大的时候，调整低指针使得地址针为中间值+1
				low = mid+1;
				k-=2;
			}
			else{
				if(mid < array.length){
					return mid;
				}else{
					return array.length-1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args){
		int a[] = {0,16,24,35,47,59,62,73,88,99};
		Main m = new Main();
		int index = m.search(a,59);
		System.out.println(index);
	}
}
