package IO;

/**
 * 
 */

import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.IOException;



/**
 * @author main
 *
 */
public class BinaryIO {


	static final String FileName = "binaryfile";

	/**
	 * 
	 */
	public BinaryIO() throws IOException {

		int valueToWrite=3;
		int valueToRead=0;

		ObjectOutputStream binaryOutput = null ;

		try {
			binaryOutput = new ObjectOutputStream(new FileOutputStream(FileName));
			binaryOutput.writeInt(valueToWrite);
		} catch (IOException ex) {
			System.err.println(ex);
		} finally {
			binaryOutput.close();
		}


		ObjectInputStream binaryInput = null;

		try {
			binaryInput = new ObjectInputStream(new FileInputStream(FileName));
			valueToRead = binaryInput.readInt();
			System.out.println(valueToRead);
		} catch (IOException ex) {
			System.err.println(ex);
		} finally {
			binaryInput.close();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		new BinaryIO();

	}

}

