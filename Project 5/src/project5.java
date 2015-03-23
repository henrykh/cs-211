import java.util.*;

public class project5 {
	public static void main(String[] args){
		writeSquares(9);
	}
	public static void writeSquares(int number){
		if(number<1){
			throw new IllegalArgumentException("Number must be greater than 0");
		}
		else{
			int[] list = new int[number];
			writeSquares(number, list, 0,0);
		}
	}
	private static void writeSquares(int number,int [] list, int oddIndex, int evenIndex){
		if(number==0){
			System.out.println(Arrays.toString(list));
		}
		else if(number%2==0){
			list[(list.length-1)-evenIndex]=(int) Math.pow(number,2);
			writeSquares(number-1, list, oddIndex, evenIndex+1);
		}
		else if(number%2!=0){
			list[0+oddIndex]=(int) Math.pow(number,2);
			writeSquares(number-1, list, oddIndex+1, evenIndex);
		}
	}
}