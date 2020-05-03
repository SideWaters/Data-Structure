import java.util.HashMap;
import java.util.Scanner;

public class Squre {
	HashMap<Double, Double> table = new HashMap<Double, Double>();

	public Double getSqure(Double target) {
		if (table.containsKey(target)) {
			return table.get((Double) target);
		} else {
			Double result = Math.sqrt(target);
			table.put(target, result);
			return result;
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("input an number");
		Double num;
		Squre project = new Squre();
		String ifOver;
		do {
			num = input.nextDouble();
			System.out.println(project.getSqure(num));// ¿É¶à´Î
			System.out.println("again?(yes/no)");
			ifOver = input.next();

		} while (ifOver.equals("yes"));
		input.close();
	}
}
