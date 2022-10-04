package cv09.danek;

public class MathToolsTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		suite("Test funkce aNaN");
		test(MathTools.aNaN(5, 0), Math.pow(5, 0));
		test(MathTools.aNaN(2, -1), Math.pow(2, -1));
		test(MathTools.aNaN(2, 1), Math.pow(2, 1));
		test(MathTools.aNaN(-5, 3), Math.pow(-5, 3));
		test(MathTools.aNaN(5, 4), Math.pow(5, 4));
		
		suite("Test funkce sinus");
		test(MathTools.sin(0, 1E-10), Math.sin(0));
		test(MathTools.sin(0.5, 1E-10), Math.sin(0.5));
		test(MathTools.sin(1, 1E-10), Math.sin(1));
		test(MathTools.sin(1.5, 1E-10), Math.sin(1.5));
		test(MathTools.sin(2, 1E-10), Math.sin(2));
		
		suite("Test funkce ln");
		test(MathTools.ln(1, 1E-10), Math.log(1));
		test(MathTools.ln(5, 1E-10), Math.log(5));
		test(MathTools.ln(10, 1E-10), Math.log(10));
		test(MathTools.ln(25, 1E-10), Math.log(25));
		test(MathTools.ln(100, 1E-10), Math.log(100));
		
		suite("Test funkce sqrt");
		test(MathTools.sqrt(1, 1E-10), Math.sqrt(1));
		test(MathTools.sqrt(2, 1E-10), Math.sqrt(2));
		test(MathTools.sqrt(4, 1E-10), Math.sqrt(4));
		test(MathTools.sqrt(8, 1E-10), Math.sqrt(8));
		test(MathTools.sqrt(16, 1E-10), Math.sqrt(16));
		
	}
	
	public static void suite(String name) {
		String dividers = "=========================";
		
		System.out.println();
		System.out.println(dividers);
		System.out.println(name);
		System.out.println(dividers);
		System.out.printf("%-25s %-25s%n", "Vlastní implementace", "Třída Math");
	}
	
	public static <T> void test(T nativeImplementation, T customImplementation) {
		System.out.printf("%-25s %-25s%n", nativeImplementation, customImplementation);
	}
}
