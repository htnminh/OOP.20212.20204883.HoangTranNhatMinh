package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GarbageCreator {
	public static void main(String[] args) throws IOException {
		String fileName = "data.txt";
		Path currentPath = Paths.get(
				System.getProperty("user.dir"));
		Path filePath = Paths.get(
				currentPath.toString(),
				"src", "hust", "soict", "dsai", "garbage",
				fileName); 
		
		byte[] inputBytes = {0};
		long startTime, endTime;
		
		inputBytes = Files.readAllBytes(filePath);
		startTime = System.currentTimeMillis();
		String outputString = "";
		for (byte b: inputBytes) 
			outputString += (char) b;
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
			// around 4246
		
	}
}
