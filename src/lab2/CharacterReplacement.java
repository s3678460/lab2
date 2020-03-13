package lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class CharacterReplacement {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter your input: ");
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);
		String line = in.readLine();
		String replacementString = line.replace(" ", "_");
		byte [] bytes = replacementString.getBytes();
		OutputStream output = null;
		try {
			output = System.out;
			output.write(bytes);
			output.flush();
			output.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Can not print output");
		}
		
		
	}

}
