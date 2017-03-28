package lab06.asciiart;

/**
 * A class that can read pixel data for Windows Bitmap (BMP) image files and
 * write out a text file containing an ASCII art rendering of the image.
 * 
 * @author Grant Braught
 * @version Oct 26, 2016
 * 
 * @author yourNameHere
 * @version theDateHere
 */
public class BMPtoASCII {

	/**
	 * Create a new BMPtoASCII converter for the specified filename.
	 * 
	 * @param filename
	 *            the path to a file, but not containing the extension (i.e.
	 *            dir1/dir2/cat not dir1/dir2/cat.bmp).
	 */
	public BMPtoASCII(String filename) {

	}

	/**
	 * Read the file specified in the constructor (adding a .bmp extension) into
	 * an array of intensity values (i.e. average the RGB values and store them
	 * into a 2d array of ints.)
	 */
	public void readFile() {

	}

	/**
	 * Get the width of the image, or -1 if the file has not yet been read.
	 * 
	 * @return the width of the image or -1.
	 */
	public int getWidth() {
		return 0;
	}

	/**
	 * Get the height of the image or -1 if the file has not yet been read.
	 * 
	 * @return the height of the image or -1.
	 */
	public int getHeight() {
		return 0;
	}

	/**
	 * Get the intensity (average of the RGB values) of the pixel at row, col in
	 * the .bmp file.
	 * 
	 * @param row
	 *            the row of the pixel
	 * @param col
	 *            the column of the pixel
	 * @return the intensity of the pixel at row, col, or -1 if the file has not
	 *         been read.
	 */
	public int getIntensity(int row, int col) {
		return 0;
	}

	/**
	 * Write the ASCII art rendering of the .bmp file into a text file using the
	 * name specified in the constructor (adding a .txt extension).
	 */
	public void writeFile() {

	}
}
