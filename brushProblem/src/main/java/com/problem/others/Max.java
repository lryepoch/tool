package others;

public class Max {
	int i=0;
	int max;
	public void diGuiMax(int[] a){
		
		if(a[i]>a[i+1]){
			max=a[i];
		}
		
		diGuiMax(a);
		
	}

	public static void main(String[] args) {
		

	}

}
