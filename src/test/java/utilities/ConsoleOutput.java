package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import org.testng.asserts.SoftAssert;

import base.BaseTest;

public class ConsoleOutput extends BaseTest {
	
	static SoftAssert softassert = new SoftAssert();
	
	public static void assertAll() {
		softassert.assertAll();
	}

	public static void consoleOutputParse() throws IOException {
		{
			BufferedReader reader1 = new BufferedReader(new FileReader("consoleOutputNEW.txt"));

			BufferedReader reader2 = new BufferedReader(new FileReader("consoleOutputOLD.txt"));

			String line1 = reader1.readLine();

			String line2 = reader2.readLine();

			boolean areEqual = true;

			//int lineNum = 1;

			while (line1 != null || line2 != null) {
				if (line1 == null || line2 == null) {
					areEqual = false;

					break;
				} else if (!line1.equalsIgnoreCase(line2)) {
					areEqual = false;

					break;
				}

				line1 = reader1.readLine();

				line2 = reader2.readLine();

				//lineNum++;
			}

			if (areEqual) {
				softassert.assertTrue(false);
				//System.out.println("Two files have same content.");
			} else {
				//System.out.println("Two files have different content. They differ at line " + lineNum);
				//System.out.println("File1 has " + line1 + " and File2 has " + line2 + " at line " + lineNum);
			}

			reader1.close();

			reader2.close();

		}
	}
	

	public static void consoleOutputNEW() throws FileNotFoundException {

		File file = new File("consoleOutputNEW.txt");
		PrintStream printStreamToFile = new PrintStream(file);
		System.setOut(printStreamToFile);
	}

	public static void consoleOutputCopy() throws IOException {
		// Creating two stream
		// one input and other output
		FileInputStream consoleOutputNEW = null;
		FileOutputStream consoleOutputOLD = null;

		// Try block to check for exceptions
		try {

			// Initializing both the streams with
			// respective file directory on local machine

			// Custom directory path on local machine
			consoleOutputNEW = new FileInputStream("consoleOutputNEW.txt");

			// Custom directory path on local machine
			consoleOutputOLD = new FileOutputStream("consoleOutputOLD.txt");

			int c;

			// Condition check
			// Reading the input file till there is input
			// present
			while ((c = consoleOutputNEW.read()) != -1) {

				// Writing to output file of the specified
				// directory
				consoleOutputOLD.write(c);
			}

		}

		// Optional finally keyword but is good practice to
		// empty the occupied space is recommended whenever
		// closing files,connections,streams
		finally {

			// Closing the streams

			if (consoleOutputNEW != null) {

				// Closing the fileInputStream
				consoleOutputNEW.close();
			}
			if (consoleOutputOLD != null) {

				// Closing the fileOutputStream
				consoleOutputOLD.close();
			}
		}
	}
}
