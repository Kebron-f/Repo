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
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class TwoDimRaggedArrayUtility{
	
	
	public  TwoDimRaggedArrayUtility() {
		
	}
	
	public static double[][] readFile(File file) throws FileNotFoundException{
	    Scanner filein = new Scanner(file);
	    int rowcount =0;
	    int row =0;
		
		while(filein.hasNextLine()) {
			rowcount++;
			 filein.nextLine(); 
			
		}
		System.out.println(rowcount +" "+ row);
		filein.close();
		
		 filein = new Scanner(file);
		
		double[][] TwoDArr= new double[rowcount][];
		
		while(filein.hasNextLine() && row < rowcount ) {
			String line = filein.nextLine();
			String[] values = line.trim().split("\\s+");
			
			TwoDArr[row] = new double[values.length];
			
			for(int j =0; j< values.length; j++) {
			
				TwoDArr[row][j] =  Double.parseDouble(values[j]);
			}
			row++;
		}
			
		 
		filein.close();
		return TwoDArr;
}

	public static void writeToFile(double[][] data,File outputFile)throws FileNotFoundException{
		
		PrintWriter fw = new PrintWriter(outputFile);
	
		for (int i = 0 ; i < data.length ; i++) {
			for(int j = 0 ; j<data[i].length ; j++) {
				fw.print(data[i][j] + " ");
			}
			fw.println();
		}
		fw.close();
	}
	

    public static double getTotal(double[][] data) {
    	double sum = 0;
    	for (int i = 0 ; i < data.length ; i++) {
			for(int j = 0 ; j<data[i].length ; j++) {
				sum+= data[i][j];
			}
		}
    	return sum;
    }
    
    public static double getAverage(double[][] data) {
    	double sum = 0;
    	double count = 0;
    	double average = 0;
    	for (int i = 0 ; i < data.length ; i++) {
			for(int j = 0 ; j<data[i].length ; j++) {
				sum+= data[i][j];
				count++;
			}
		}
    	average = sum/count;
    	return average;
    }
	
    
    public static double getRowTotal(double[][] data,int row) {
    	double rowSum = 0;
    	
			for(int j = 0 ; j<data[row].length ; j++) {
				rowSum+= data[row][j];
			
		}
			return rowSum;
    }
    

    public static double getColumnTotal(double[][] data,int col) {
    	double colSum=0;
    	
    	for (int i = 0 ; i < data.length ; i++) {
    		if( col < data[i].length)
				 colSum+= data[i][col];
					
		}
    	return colSum;
    }
    
    public static double getHighestInRow(double[][] data,int row) {
    	double highestInRow = data[row][0];
    	
    	for(int i = 1; i< data[row].length ; i++) {
    		highestInRow = highestInRow > data[row][i] ? highestInRow : data[row][i] ;
    	}
    	return highestInRow;
    }
    
    public static int getHighestInRowIndex(double[][] data,int row) {
    	int highestInRowIndex = 0;
    	double highestInRow = data[row][highestInRowIndex];
    	
    	for(int i = 1; i< data[row].length ; i++) {
    		highestInRowIndex = highestInRow > data[row][i] ? highestInRowIndex : i ;
    	}
    	return highestInRowIndex;
    }
    
    public static double getLowestInRow(double[][] data,int row) {
    	double lowestInRow = data[row][0];
    	
    	for(int i = 1; i< data[row].length ; i++) {
    		lowestInRow = lowestInRow < data[row][i] ? lowestInRow : data[row][i] ;
    	}
    	return lowestInRow;
    }
    
    public static int getLowestInRowIndex(double[][] data,int row) {
    	int lowestInRowIndex = 0;
    	double highestInRow = data[row][lowestInRowIndex];
    	
    	for(int i = 1; i< data[row].length ; i++) {
    		lowestInRowIndex = highestInRow < data[row][i] ? lowestInRowIndex : i ;
    	}
    	return lowestInRowIndex;
    }
    
    public static double getHighestInColumn(double[][] data,int col) {
    	double highestInCol = data[0][col];
    	
    	for(int i = 1; i< data.length ; i++) {
    		if( col < data[i].length)
    			highestInCol = highestInCol > data[i][col] ? highestInCol : data[i][col] ;
    	}
    	return highestInCol;
    }
    
    public static int getHighestInColIndex(double[][] data,int col) {
    	int index = 0;
    	double highestInCol = data[index][col];
    	
    	for(int i = 1; i< data.length ; i++) {
    		if( col < data[i].length)
    			index= highestInCol > data[i][col] ? index : i ;
    	}
    	return index;
    }
    
    public static double getLowestInColumn(double[][] data,int col) {
    	double lowestInCol = data[0][col];
    	
    	for(int i = 1; i< data.length ; i++) {
    		if( col < data[i].length)
    		lowestInCol = lowestInCol < data[i][col] ? lowestInCol : data[i][col] ;
    	}
    	return lowestInCol;
    }
    
    public static int getLowestestInColIndex(double[][] data,int col) {
    	int index = 0;
    	double lowestInCol = data[index][col];
    	
    	for(int i = 1; i< data.length ; i++) {
    		if( col < data[i].length)
    		index= lowestInCol < data[i][col] ? index : i ;
    	}
    	return index;
    }

    public static double getHighestInArray(double[][] data) {
    	double highest = data[0][0];
    	for (int i = 0 ; i < data.length ; i++) {
			for(int j = 0 ; j<data[i].length ; j++) {
				highest = highest > data[i][j] ? highest : data[i][j] ;
			}
		}
    	return highest;
    }
	
    public static double getLowestInArray(double[][] data) {
    	double lowest = data[0][0];
    	for (int i = 0 ; i < data.length ; i++) {
			for(int j = 0 ; j<data[i].length ; j++) {
				lowest = lowest < data[i][j] ? lowest : data[i][j] ;
			}
		}
    	return lowest;
    }
}
	
	
	
	
	
	
	
	
	
	
	
	
	
