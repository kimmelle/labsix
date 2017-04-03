package lab06.asciiart;

import java.io.*;
import java.util.*;

/**
 * A class that can read pixel data for Windows Bitmap (BMP) image files and
 * write out a text file containing an ASCII art rendering of the image.
 * 
 * @author Grant Braught
 * @version Oct 26, 2016
 * 
 * @author Ellis and Matt
 * @version March 29 2017
 */
public class BMPtoASCII {
	
	private int[][] intensity;
	private static String filename;
	private int width;
	private int height;

	/**
	 * Create a new BMPtoASCII converter for the specified filename.
	 * 
	 * @param filename
	 *            the path to a file, but not containing the extension (i.e.
	 *            dir1/dir2/cat not dir1/dir2/cat.bmp).
	 */
	public BMPtoASCII(String filename) {
		this.filename = filename;
		intensity = new int[getWidth()][getHeight()];
		width = 0;
		height = 0;

	}

	/**
	 * Read the file specified in the constructor (adding a .bmp extension) into
	 * an array of intensity values (i.e. average the RGB values and store them
	 * into a 2d array of ints.)
	 */
	public void readFile() {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(filename+".bmp"));
			dis.skip(10);
			int offset = dis.readInt();
			dis.skip(4);
			int pixelWidth = dis.readInt();
			int pixelHeight = dis.readInt();
			width = pixelWidth*3;
			while (width%4 != 0) {
				width++;
			}
			height = pixelHeight*3;
			while(height%4 != 0) {
				height++;
			}
			dis.skip(offset);
			for (int i=0; i<intensity.length; i++){
				for (int j=0; j<pixelWidth*3; j++) {
					intensity[i][j]=dis.readInt()/3;
				}
			}
		} catch (IOException e) {
			System.out.println("File error");
			width = -1;
			height = -1;
		}

	}

	/**
	 * Get the width of the image, or -1 if the file has not yet been read.
	 * 
	 * @return the width of the image or -1.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Get the height of the image or -1 if the file has not yet been read.
	 * 
	 * @return the height of the image or -1.
	 */
	public int getHeight() {
		return height;
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
		return intensity[row][col];
	}

	/**
	 * Write the ASCII art rendering of the .bmp file into a text file using the
	 * name specified in the constructor (adding a .txt extension).
	 */
	public void writeFile() {
		DataOutputStream dos = null;
		try{
			dos = new DataOutputStream(new FileOutputStream(filename+".txt"));
			for (int i=0; i<intensity.length; i++){
				for (int j=0; j<intensity[0].length; j++){
					dos.writeInt(3*intensity[i][j]);
				}
			}
		}catch (IOException e) {
			System.out.println("Error writing file");
		}

	}
	
	public static void main(String args[]){
		Scanner scr = new Scanner(System.in);
		 filename = scr.next();
		//BMPtoASCII bta = new BMPtoASCII();
		
	}
}
