package leetcode_arrays_strings;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

import random_generator.Random_String;

public class MyHashTable {

	public static void main(String[] args) {
		int numOfStrings = 1000;
		int strLength = 20;
		int numLength = 10;
		String randomStringFileName = "random_strings.txt";
		String randomNumberFileName = "random_numbers.txt";

		// (optional)create random string and random number files.
//		try {
//			Random_String rs1 = new Random_String(numOfStrings, strLength, Random_String.generateType.ALPHANUMERIC,
//					randomStringFileName);
//			Random_String rs2 = new Random_String(numOfStrings, numLength, Random_String.generateType.NUMERIC,
//					randomNumberFileName);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		// 1.create a hash table from the two files.
		Hashtable<String, String> ht = new Hashtable<String, String>();
		try {
			Scanner scanString = new Scanner(new File(randomStringFileName));
			Scanner scanNumber = new Scanner(new File(randomNumberFileName));

			while (scanString.hasNext()) {
				ht.put(scanString.nextLine(), scanNumber.nextLine());
			}
			scanString.close();
			scanNumber.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 2.show all values in hash table.
		Enumeration<String> myStrings = ht.keys();
		String str;

		while (myStrings.hasMoreElements()) {
			str = (String) myStrings.nextElement();
//			System.out.println(str + ": " + ht.get(str));
		}
		System.out.println();
		
		// 3. access one value
		String mySpecialString = "sN00ZwGokI11JTsImKyL";
		String mySpecialNumber = ht.get(mySpecialString);
		System.out.println("my special value is: " + mySpecialNumber);
		
		// 4. change one value
		BigInteger temp = new BigInteger(mySpecialNumber);
		temp = temp.add(new BigInteger("1"));
		ht.put(mySpecialString, temp.toString());
		System.out.println("my special value plus one is: " + temp);
		
		

	}

}
