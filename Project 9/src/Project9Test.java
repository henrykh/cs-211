public class Project9Test {
	public static void main(String[] args){
		LinkedIntList test = new LinkedIntList();
		test.add(5);
		test.add(2);
		test.add(1);
		
		test.stretch(0);
		System.out.println(test);
		
		test.add(5);
		test.add(2);
		test.add(1);
		
		test.stretch(5);
		System.out.println(test);
		
		test.add(5);
		test.add(2);
		test.add(1);
		
		test.stretch(-5);
		System.out.println(test);
		
		test.add(5);
		test.add(2);
		test.add(1);
		
		test.stretch(10);
		System.out.println(test);
	}
}