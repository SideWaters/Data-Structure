import java.util.LinkedList;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class E12_30 {
	public static void bucketSort(double[] data) {
		int n = data.length;
		List<LinkedList<Double>> buckets = new ArrayList<LinkedList<Double>>(n);
		for (int i = 0; i < n; i++) {
			buckets.add(new LinkedList<Double>());
		}
		for (int i = 0; i < n; i++) {
			buckets.get((int) (data[i] * n)).add(data[i]);
		}
		int i = 0;
		for (LinkedList<Double> bucket : buckets) {
			Collections.sort(bucket);
			for (Double d : bucket) {
				data[i] = d;
				i++;
			}
		}
	}

}
