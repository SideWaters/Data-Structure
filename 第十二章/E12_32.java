package 第十二章;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class E12_32 {
	public static void bucketSort(double[] data) {
		
		int n = data.length;
		ArrayList<Double> dataNum = new ArrayList<Double>(n);
		for (double num : data) {
			dataNum.add(num);
		}
		double min = Collections.min(dataNum);
		double max = Collections.max(dataNum);
		if(min==max) {
			return;
		}
		for (int i = 0; i < n; i++) {
			data[i] = (data[i] - min) / (max - min);
		}
		List<LinkedList<Double>> buckets = new ArrayList<LinkedList<Double>>(n);
		for (int i = 0; i < n; i++) {
			buckets.add(new LinkedList<Double>());
		}
		for (int i = 0; i < n; i++) {
			buckets.get((int) (data[i] * (n - 1))).add(data[i]);
		}
		int i = 0;
		for (LinkedList<Double> bucket : buckets) {
			Collections.sort(bucket);
			for (Double d : bucket) {
				data[i] = d * (max - min) + min;
				i++;
			}
		}
	}
//ps:this change will increase a little time of algorithm run time
	public static void main(String[] args) {
		double data[] = new double[20];
		for (int i = 0; i < data.length; i++)
			data[i] = Math.random() * 99;
		for (int i = 0; i < data.length; i++) {
			System.out.printf("%6.1f", data[i]);
		}
		System.out.println();
		bucketSort(data);
		for (int i = 0; i < data.length; i++) {
			System.out.printf("%6.1f", data[i]);
		}
	}

}
