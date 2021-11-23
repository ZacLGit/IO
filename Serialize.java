package IO;

/**
 * 
 */

import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;



/**
 * @author main
 *
 */
public class Serialize {
	static final String FileName = "binaryObjectfile";

	/**
	 * @throws Something
	 * 
	 */
	public Serialize() throws IOException {


		SomeCoolClass original=new SomeCoolClass();
		SomeCoolClass readIn=null;

		ObjectOutputStream binaryOutput = null ;

		try {
			binaryOutput = new ObjectOutputStream(new FileOutputStream(FileName));
			binaryOutput.writeObject(original);

			original.setValue(9999);

		} catch (IOException ex) {
			System.err.println(ex);
		} finally {
			binaryOutput.close();
		}


		ObjectInputStream binaryInput = null;

		try {
			binaryInput = new ObjectInputStream(new FileInputStream(FileName));
			
			readIn = (SomeCoolClass) binaryInput.readObject();
			System.out.println(readIn);
			System.out.println(original);
		} catch (IOException ex) {
			System.err.println(ex);
		} catch (ClassNotFoundException ex)  {
			System.err.println(ex);			
		}finally {
			binaryInput.close();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		new Serialize();

	}

}


class SomeCoolClass implements Serializable{
	int value = 3;
	String stringyStuff = "strings strings everywhere";


	public String toString() {
		return "Object is "+value+stringyStuff;
	}

	public void setValue(int newValue) {
		value = newValue;
	}

}

