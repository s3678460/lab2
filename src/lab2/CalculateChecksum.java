package lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Checksum;




public class CalculateChecksum {
	

	public static void main(String[] args) {
		System.out.println("Enter your input");
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(input);
		
		try {
			String path = new File("").getAbsolutePath();
			File file = new File( path + "/text.txt");
			FileOutputStream outputStream = new FileOutputStream(file);
			StringBuffer stringBuffer = new StringBuffer();
			String lineString = bufferedReader.readLine();
			while(!lineString.matches("x")) {
				String lineWrite = lineString + "\n";
				byte[] bytes = lineWrite.getBytes();
				stringBuffer.append(lineWrite);
				outputStream.write(bytes);
				lineString = bufferedReader.readLine();



			}
			File file1 = new File( path + "/checksum.txt");
			FileOutputStream outputStreamChecksum = new FileOutputStream(file1);
			Checksum checksum = new CRC32();
			byte bytes[] = stringBuffer.toString().getBytes();
			checksum.update(bytes, 0, bytes.length);
			CheckedOutputStream checkedOutputStream = new CheckedOutputStream(outputStreamChecksum,(Checksum) checksum);
			
			String value = String.valueOf(checkedOutputStream.getChecksum().getValue());

			outputStreamChecksum.write(value.getBytes());
			outputStream.close();
			checkedOutputStream.close();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("No File Available");
		}
		
		

	}

}
