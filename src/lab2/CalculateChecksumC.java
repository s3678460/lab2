package lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;

public class CalculateChecksumC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Print content in text.txt and calculate its value
		try  {
			String path = new File("").getAbsolutePath();
			File file = new File( path + "/text.txt");
			FileInputStream inputStream = new FileInputStream(file);
			Checksum checksum = new CRC32();

			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line = bufferedReader.readLine();
			
			while(line!=null) {
				
				System.out.println(line);
				stringBuffer.append(line+"\n");
				line = bufferedReader.readLine();
				
			}
			
			byte bytes[] = stringBuffer.toString().getBytes();
			checksum.update(bytes, 0, bytes.length);
			
			CheckedInputStream checkedInputStream = new CheckedInputStream(inputStream, (Checksum) checksum);

			System.out.println("Checksum: "+checkedInputStream.getChecksum().getValue());
			
			
		
			bufferedReader.close();

		} catch (Exception e) {
			System.err.println("Text File Not Found");
		}
		
		// Read value from checksum text file
		try {
			String path = new File("").getAbsolutePath();
			File file = new File( path + "/checksum.txt");
			FileInputStream inputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader reader = new BufferedReader(inputStreamReader);
			
			String line = reader.readLine();
			while(line != null) {
				System.out.println("Calculated checksum: "+line);
				line=reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			System.err.println("Check File Not Found");
		}
	}

}
