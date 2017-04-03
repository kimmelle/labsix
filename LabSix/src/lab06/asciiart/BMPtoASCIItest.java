package lab06.asciiart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BMPtoASCIItest {
	BMPtoASCII bta;

	@Before
	public void setUp() throws Exception {
		BMPtoASCII bta = new BMPtoASCII("/Users/elliskimmell/git/labsix-kimmelle/LabSix/src/lab06/asciiart/images/monalisa");
	}
	 @Test
	 public void testWidth(){
		 assertEquals(516,bta.getWidth());
	 }
	 @Test
	 public void testHeight(){
		 assertEquals(547,bta.getHeight());
	 }

}
