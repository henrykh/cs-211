import java.util.Arrays;

public class MergeSort{
	public static void main(String[] args){
		int[] test = {2,3,6,4,234,75,123,1,23,757,12,34,35};
		mergeSort(test);
			
	}
	
	public static void mergeSort(int[] a){
		System.out.println("sorting "+Arrays.toString(a));
		if(a.length>1){
			int [] left = Arrays.copyOfRange(a, 0, a.length/2);
			int [] right = Arrays.copyOfRange(a, a.length/2, a.length);
			
			mergeSort(left);
			mergeSort(right);
			
			merge(a,left,right);
		}
	}
		
	
	public static void merge(int[] result, int[] left, int[] right){
		System.out.println("merging "+Arrays.toString(left)+" and "+Arrays.toString(right));
		int i1 = 0;
		int i2 = 0;
		for(int i = 0; i<result.length; i++){
			if(i2>=right.length || (i1<left.length && left[i1]<=right[i2])){
				result[i] = left[i1];
				i1++;
			}
			else {
				result[i] = right [i2];
				i2++;
			}
		}
	}
}