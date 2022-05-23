package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NoGarbage {
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
		StringBuilder outputStringBuilder = new StringBuilder();
		for (byte b: inputBytes) 
			outputStringBuilder.append((char) b);
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
			// around 15
		
	}
}
