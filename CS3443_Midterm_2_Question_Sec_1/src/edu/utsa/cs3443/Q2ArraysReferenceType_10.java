package edu.utsa.cs3443;

/*

	For and array with #row = 5 and #col = 6
	Your code should produce an output like below:
	
	Populating Row Wise
	625	26	27	28	29	30	
	19	400	21	22	23	24	
	13	14	225	16	17	18	
	7	8	9	100	11	12	
	1	2	3	4	25	6
		
	Populating Column Wise
	1	6	11	16	21	26	
	2	7	12	17	22	27	
	3	8	13	18	23	28	
	4	9	14	19	24	29	
	5	10	15	20	25	30	

*/

public class Q2ArraysReferenceType_10 {

	static class Counter {
		int count;

		Counter(int count) {
			this.count = count;
		}

		@Override
		public String toString() {
			return this.count + "";
		}
	}

	public static void main(String[] args) {

		int row, col;
		Counter array[][];

		row = 5;
		col = 6;

		array = new Counter[row][col];
		populateArrayRowWise(array);
		printArray(array);

		array = new Counter[row][col];
		populateArrayColumnWise(array);
		printArray(array);
	}

	//////////////////////////////////////////////////////////////////////////

	public static void printArray(Counter[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
	}

	// THIS FUNCTION WORTH 5 POINTS
	public static void populateArrayRowWise(Counter[][] array) {
		System.out.println("Populating Row Wise");
		// TODO WRITE YOUR CODE HERE
		int count = 1;
		for (int i = array.length-1; i >=0; i--) {
			for (int j = 0; j < array[0].length; j++) {
				if(i == j) {
					array[i][j] = new Counter(count*count++);
				}
				else {
					array[i][j] = new Counter(count++);
				}
			}
			System.out.println();
		}
	}

	// THIS FUNCTION WORTH 5 POINTS
	public static void populateArrayColumnWise(Counter[][] array) {
		System.out.println("Populating Column Wise");
		// TODO WRITE YOUR CODE HERE
		int count=1;
		for (int i = 0; i < array[0].length; i++) {
			for (int j = 0; j < array.length; j++) {
				array[j][i] = new Counter(count++);
			}
			System.out.println();
		}
	}

}
