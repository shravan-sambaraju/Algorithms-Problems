package problems.recursion;

public class HoppSteps123 {
	
	public static int countWays(int n){
		if(n<0){
			return 0;
		}
		else if(n==0){
			return 1;
		}else{
			return countWays(n-3)+countWays(n-2)+countWays(n-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(countWays(10));
	}

}
