package org.coursera.algo2.w1.q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class GreedySubstractionAlgoW1Q1 {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		File file = new File("D:\\to_delete\\jobs.txt");
		
		ArrayList<String> arr = new ArrayList<String>();
		
		Scanner sc = new Scanner(file);
		
		int no_of_jobs = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < no_of_jobs ; i++)
		{
			String j_w_l = sc.nextLine();
			arr.add(j_w_l);
			
		}
		
		GreedyComparator gc = new GreedyComparator();
		Collections.sort(arr,gc);
		
		long elapsed_time = 0;
		long completion_sum =0;
		for(String x : arr)
		{
			//System.out.println(x);
			int time = Integer.parseInt(x.split(" ")[1]);
			elapsed_time = elapsed_time + time;
			completion_sum = completion_sum + elapsed_time*Integer.parseInt(x.split(" ")[0]);
		}
		
		System.out.println(elapsed_time);
		System.out.println(completion_sum);
		
		
		
	}
	
	static class GreedyComparator implements Comparator<String>
	{

		@Override
		public int compare(String job1, String job2) 
		{
			String[] arrJ1 = job1.split(" ");
			String[] arrJ2 = job2.split(" ");
			
			int diffJ1 = getDiff(arrJ1);
			int diffJ2 = getDiff(arrJ2);
			
			if(diffJ1 == diffJ2)
			{
				return getHigherWeight(arrJ1,arrJ2);
			}
			else 
				return diffJ2 - diffJ1 +1;
		}

		private int getHigherWeight(String[] arrJ1, String[] arrJ2)
		{
			int weight1 = Integer.parseInt(arrJ1[0]);
			int weight2 = Integer.parseInt(arrJ2[0]);
			
			if(weight1 > weight2)
				return -1;
			else
				return 1;
		}

		private int getDiff(String[] arrJ) 
		{
			int weight = Integer.parseInt(arrJ[0]);
			int length = Integer.parseInt(arrJ[1]);
			return weight-length;
		}
		
		
	}

}
