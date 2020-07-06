package leetcode;

public class TwoNums {
	public int[] twos(int[] a,int target){
		for(int i=0;i<a.length-1;i++)
			for(int j=i+1;j<a.length;j++)
				if(a[i]+a[j]==target)
					return new int[]{i,j};
		return null;
	}

	public static void main(String[] args) {
		TwoNums t=new TwoNums();
		int[] a={1,4,5,8,2,5,0};
		int target=1;
		
		int[] b=t.twos(a, target);
		System.out.println(b);

	}

}
