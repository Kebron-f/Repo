/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: an application that calculates bonus earned per based on the file provided
 * Due: 04/09/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: ____Kebron Ghile_____
*/
public class HolidayBonus  {

	public HolidayBonus() {
		
	}
	
	public static double[] calculateHolidayBonus(double[][] data) {
		double [] bonusArr = new double[data.length];
		
		
		
		for (int i = 0 ;i<data.length ;i++) {
			for (int j = 0 ;j< data[i].length;j++) {
				if(data[i][j] < 0) 
					bonusArr[i]+=0;
				
				else if(data[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(data, j)) 
					bonusArr[i]+=5000;
				
				else if(data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data, j)) 
					bonusArr[i]+=1000;
				
				else 
					bonusArr[i]+=2000;
			}
			
	}
		return bonusArr;
	}
	public static double calculateTotalHolidayBonus(double[][] data) {
		double x = 0;
		double [] arr = calculateHolidayBonus(data);
		
		for(int i = 0; i< arr.length ; i++) {
			x+= arr[i];
		}
		return x;
		
	}
	
}

