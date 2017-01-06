package il.ac.tau.cs.sw1.ex8.bufferedIO;

import java.io.FileReader;
import java.io.IOException;

/**************************************
 *  Add your code to this class !!!   *
 **************************************/

public class MyBufferReader implements IBufferedReader{
	FileReader fReader;
	int bufferSize;
	char[] buffer;
	StringBuilder currentString;


	public MyBufferReader(FileReader fReader, int bufferSize){
		this.fReader = fReader;
		this.bufferSize = bufferSize;
		this.buffer = new char[bufferSize];
		this.currentString = new StringBuilder();
	}
	

	@Override
	public void close() throws IOException {
		fReader.close();
	}


	@Override
	public String getNextLine() throws IOException {
		int numRead;
		int newLineIndex;

		if (currentString.length() > 0) {
			newLineIndex = currentString.indexOf("\n");
		} else {
			newLineIndex = -1;
		}

		while (newLineIndex == -1 && (numRead = fReader.read(buffer)) != -1) {
			currentString.append(buffer);
			newLineIndex = currentString.indexOf("\n");
		}

		String line = currentString.substring(0, newLineIndex);
		currentString.delete(0, newLineIndex);
		if (currentString.substring(0, 1).equals("\n")) {
			currentString.deleteCharAt(0);
		} else {
			currentString.delete(0, currentString.length());
		}

		return line.isEmpty() ? null : line;
	}
}
