import java.io.*;

//Here is the test program I used for my CommonWords class
public class test{
	public static void main(String[] args)
	throws FileNotFoundException{
		CommonWords common = new CommonWords();
		
		common.determineCommonWord("Hamlet.txt", "KingLear.txt");
		
		System.out.print(common);
	}
}