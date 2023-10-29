import java.io.File;  // Library to deal with file
import java.io.FileWriter; // Library to wrap a file
import java.io.FileNotFoundException;  // Exception
import java.io.PrintWriter; // Library to write to a file
import java.io.IOException;				       // IOException
import java.util.Scanner; // Import the Scanner class to read data
public class FileUtils {
	public static File createFile(String filename)
	{
		File file = new File(filename);
		try {
			if (file.createNewFile()) {
				System.out.println("File created successfully.");
				return file;
			}
			else {
				System.out.println("File exists already");
				return null;
			}
		}
		catch (IOException e){
			System.err.println("Error occurred: " + e.getMessage());
			return null;
		}
	}
	public static File openFile(String filename)
	{
		File file = new File(filename);

		// Check if the file exists
		if (file.exists()) {
		    System.out.println("File opens successfully.");
		    return file;
		} else {
		    System.out.println("File does not exist");
		    return null;
		}
	}

	// Function to read input
	public static Scanner getInputFromFile(File file) throws FileNotFoundException {
		return new Scanner(file);
   	}

	public static PrintWriter writeToFile(File file) throws IOException, FileNotFoundException {
		return new PrintWriter(new FileWriter(file));
	}
}

