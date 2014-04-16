package businessLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.DataBeans;

/**
 * @author Jack Young
 * @date April 01, 2014
 * SWE 642
 * 
 * Class Purpose:  The purpose of the DataProcessor class is to 
 * calculate the mean and standard deviation for the 10 inputed
 * raffle numbers.    
 * 
 */
public class DataProcessor {
	
	/**
	 * The computeMetrics method accepts a string of 10 numbers,
	 * which are separated by a comma.  It first parses the string
	 * then computes the mean and standard deviation of those 10
	 * numbers and return those values in the DataBean wrapper
	 * class. 
	 * 
	 * @param raffleString
	 * @return  DataBean object (mean & stdv)
	 */
	public static DataBeans computeMetrics(String raffleString) {
		List<String> e = Arrays.asList(raffleString.trim().split("\\s*,\\s*"));
		List<Double> d = new ArrayList<Double>();
		for (int i = 0; i < e.size(); i++) {
			d.add(Double.parseDouble(e.get(i)));
		}
		double mean = 0.00;
		for (int i = 0; i < d.size(); i++) {
			mean += d.get(i);
		}
		mean = (float) mean / d.size();

		double variance = 0.00;
		double temp = 0.00;
		for (int i = 0; i < d.size(); i++) {
			temp += (mean - d.get(i)) * (mean - d.get(i));
		}
		variance = (float) temp / d.size();
		double stdv = Math.sqrt(variance);

		DataBeans DB = new DataBeans(mean, stdv);
		return DB;
	}

}
