package leetcode_arrays_strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import random_generator.Random_String;

/**
 * Question 566: Reshape the Matrix -- In MATLAB, there is a very useful
 * function called 'reshape', which can reshape a matrix into a new one with
 * different size but keep its original data.
 * 
 * You're given a matrix represented by a two-dimensional array, and two
 * positive integers r and c representing the row number and column number of
 * the wanted reshaped matrix, respectively.
 * 
 * The reshaped matrix need to be filled with all the elements of the original
 * matrix in the same row-traversing order as they were.
 * 
 * If the 'reshape' operation with given parameters is possible and legal,
 * output the new reshaped matrix; Otherwise, output the original matrix.
 * 
 * 
 * @author chenfeng
 *
 */
public class ReshapeMatrix_566 {

	public static void main(String[] args) throws IOException {
		int numOfStrings = 36;
		int numLength = 3;
		String randomNumberFileName = "random_numbers.txt";

		// create random matrix
		Random_String rs2 = new Random_String(numOfStrings, numLength, Random_String.generateType.NUMERIC,
				randomNumberFileName);

		Scanner scanNumber = new Scanner(new File(randomNumberFileName));
		int originalRowLength = 6, originalColLength = 6;
		int[][] nums = new int[originalRowLength][originalColLength];

		for(int i = 0; i < originalRowLength; i++){
			for(int j = 0; j < originalColLength; j++){
				nums[i][j] = Integer.parseInt(scanNumber.nextLine());
			}
		}
		scanNumber.close();
		
		//compute result
		int resultRowLength = 4;
		int resultColLength = 9;
		int[][] result = new int[resultRowLength][resultColLength];
		
		result = matrixReshape(nums,resultRowLength,resultColLength);
		System.out.println("result is: ");
		System.out.println(Arrays.deepToString(result));
		

	}
	public static int[][] matrixReshape(int[][] nums, int r, int c){
		int test = r * c - nums.length * nums[0].length;
		
		if(test == 0){
			int[][] result = new int[r][c];
			int l = r * c;
			int n = nums[0].length;
			
			for(int i = 0; i < l; i++){
				result[i/c][i%c] = nums[i/n][i%n];
			}
			
			return result;
		}else{
			return nums;
		}
	}

}
