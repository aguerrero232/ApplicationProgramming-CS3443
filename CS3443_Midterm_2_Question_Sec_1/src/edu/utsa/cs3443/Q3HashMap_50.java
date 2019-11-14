package edu.utsa.cs3443;

import java.util.HashMap;
import java.util.Map;

public class Q3HashMap_50 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String book = "This paper investigates how experiencing Virtual Reality VR Disability "
				+ "Simulation DS affects information recall and participants implicit association "
				+ "towards people with disabilities participants implicit association "
				+ "towards people with disabilities";

		print(generateWordFrequency(book));
		print(generateCharacterFrequency(book));
	}

	//////////////////////////////////////////////////////////////////////////

	// THIS FUNCTION WORTH 20 POINTS
	/**
	 * This function takes an String argument and generates the frequencies 
	 * 0f words in the String.
	 * 
	 * Input: "This is a midterm test which is a test".
	 * Output: 
	 * 			which = 1
				a = 2
				test = 2
				this = 1
				is = 2
				midterm = 1
	 * NOTE: You do not need to worry about the order of the print.
	 * 
	 * @param book
	 * @return
	 */
	public static Map<String, Integer> generateWordFrequency(String book) {
		// TODO WRITE YOUR CODE HERE
		HashMap<String,Integer> map = new HashMap<>();
		for(String word : book.split(" ")){
			if(!map.containsKey(word))
				map.put(word,1);
			else
				map.replace(word,map.get(word).intValue()+1);
		}
		return map;
	}

	// THIS FUNCTION WORTH 10 POINTS
	/**
	 * This function takes a Map<String, Integer> and prints its contents.
	 * @param frequencies
	 */
	public static void print(Map<String, Integer> frequencies) {
		// TODO WRITE YOUR CODE HERE
		for(Map.Entry<String, Integer> freq : frequencies.entrySet())
			System.out.println("WORD: "+ freq.getKey() + " FREQUENCY: " + freq.getValue());
	}

	// THIS FUNCTION WORTH 20 POINTS
	/**
	 * This function takes an String argument and generates the frequencies 
	 * 0f words in the String.
	 * 
	 * Input: "This is a midterm test which is a test".
	 * Output:
	 * 			a = 2
				r = 1
				s = 5
				c = 1
				t = 6
				d = 1
				e = 3
				w = 1
				h = 3
				i = 5
				m = 2
	 * NOTE: You do not need to worry about the order of the print.
	 *
	 * @param book
	 * @return
	 */
	public static Map<String, Integer> generateCharacterFrequency(String book) {
		// TODO WRITE YOUR CODE HERE
		HashMap<String,Integer> map = new HashMap<>();
		char[] charsInBook = book.toCharArray();
		for(char c : charsInBook){
			if(!map.containsKey(""+c))
				map.put(""+c,1);
			else
				map.replace(""+c,map.get(""+c).intValue()+1);
		}
		return map;
	}
}
