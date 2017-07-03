package sortingalgorithms;

public class BubbleSort {
	
	public static void main(String args[]){
		BubbleSort b = new BubbleSort();
		System.out.println(b.xyz(100));
		
	}
	public int xyz(int num){
		
		if(num==1) return 1;
		
		else return (xyz(num-1)+num);
		
		
	}

}
