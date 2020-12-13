package com.problem.newcoder;

class NiuNiu{
	public void twoSum(int n,int target){
		for(int i=1;i<n;i++)
			for(int j=1;j<n;j++)
				if(i%j>=target)
					System.out.println(i+" "+j);
	}
	public static void main(String[] args) {
		NiuNiu so = new NiuNiu();
		so.twoSum(10, 7);
	}

}
