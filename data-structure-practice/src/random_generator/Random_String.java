package random_generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Random_String {

	private final String myCharset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private final String myAlphaset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final String myNumberset = "1234567890";

	public enum generateType {
		ALPHANUMERIC, ALPHABETIC, NUMERIC, PHONE, EMAIL
	};

	public Random_String(int numOfStrings, int length, generateType genType, String fileName) throws IOException {

		File f = new File(fileName);
		f.createNewFile();
		FileWriter w = new FileWriter(f);

		switch (genType) {
		case ALPHANUMERIC:
			System.out.println("generating alphanumeric strings to " + fileName);
			generateRandomStrings(numOfStrings, length, w, myCharset);
			System.out.println("done.");
			break;
		case ALPHABETIC:
			System.out.println("generating alphabetic strings to " + fileName);
			generateRandomStrings(numOfStrings, length, w, myAlphaset);
			System.out.println("done.");
			break;
		case NUMERIC:
			System.out.println("generating numeric strings to " + fileName);
			generateRandomStrings(numOfStrings, length, w, myNumberset);
			System.out.println("done.");
			break;
		default:
			System.out.println("Nothing is generated");
			break;
		}
	}

	public void generateRandomStrings(int num, int len, FileWriter w, String mySet) throws IOException {
		Random r = new Random();
		char buf[] = new char[len];
		int index;
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < len; j++) {
				index = r.nextInt(mySet.length());
				buf[j] = mySet.charAt(index);
			}
			w.write(buf);
			w.write('\n');
		}
		w.close();
	}

}
