import static org.junit.Assert.*;

import org.junit.Test;

public class TestRomanNumerals {

	
	@Test
	public void valueOfI () throws RomanNumeralsException {
		RomanNumerals number = new RomanNumerals();
		int numeral = number.getValueOfsimpleSymbol('I');
		assertEquals(1,numeral); 				
	}
	
	@Test (expected = RomanNumeralsException.class)
	public void valueOfT() throws RomanNumeralsException {
		RomanNumerals number = new RomanNumerals();
		int numeral = number.getValueOfsimpleSymbol('T');	
		
	}
	
	@Test
	public void valueOfXI() throws RomanNumeralsException {
		RomanNumerals number = new RomanNumerals();
		int numeral = number.getValueOfCombinedSymbol("XI");	
		assertEquals(11,numeral);
	}
	
	@Test
	public void valueOfXXX() throws RomanNumeralsException {
		RomanNumerals number = new RomanNumerals();
		int numeral = number.getValueOfCombinedSymbol("XXX");	
		assertEquals(30,numeral);
	}
	
	
	@Test (expected = RomanNumeralsException.class)
	public void valueOfXXXX() throws RomanNumeralsException {
		RomanNumerals number = new RomanNumerals();
		int numeral = number.getValueOfCombinedSymbol("XXXX");	
		assertEquals(30,numeral);
		
	}
	
	@Test (expected = RomanNumeralsException.class)
	public void valueOfVV() throws RomanNumeralsException {
		RomanNumerals number = new RomanNumerals();
		int numeral = number.getValueOfCombinedSymbol("VV");
		
	}
	
	@Test
	public void valueOfXXI() throws RomanNumeralsException {
		RomanNumerals number = new RomanNumerals();
		int numeral = number.getValueOfCombinedSymbol("XXI");	
		assertEquals(21,numeral);
	}
	
	@Test
	public void valueOfSubtractIV() throws RomanNumeralsException {
		RomanNumerals number = new RomanNumerals();
		int numeral = number.getValueOfCombinedSymbol("IV");	
		assertEquals(4,numeral);
	}
	
	@Test (expected = RomanNumeralsException.class)
	public void valueOfSubtractIIV() throws RomanNumeralsException {
		RomanNumerals number = new RomanNumerals();
		int numeral = number.getValueOfCombinedSymbol("IIV");		
	}
	
	@Test 
	public void combinationXXIV() throws RomanNumeralsException {
		RomanNumerals number = new RomanNumerals();
		int numeral = number.getValueOfCombinedSymbol("XXIV");	
		assertEquals(24,numeral);
	}
	
	@Test 
	public void combinationMCM() throws RomanNumeralsException {
		RomanNumerals number = new RomanNumerals();
		int numeral = number.getValueOfCombinedSymbol("CM");	
		assertEquals(900,numeral);
	}
	
	
	@Test
	public void combinationMCMLXXXIV() throws RomanNumeralsException {
	RomanNumerals number = new RomanNumerals();
	int numeral = number.getValueOfCombinedSymbol("MCMLXXXIV");	
	assertEquals(1984,numeral);
	}
	
	@Test
	public void combinationMMXIV() throws RomanNumeralsException {
	RomanNumerals number = new RomanNumerals();
	int numeral = number.getValueOfCombinedSymbol("MMXIV");	
	assertEquals(2014,numeral);
    } 
	
	@Test
	public void combinationMMXIV2() throws RomanNumeralsException {
	RomanNumerals number =new RomanNumerals() ;
	int numeral = number.convertToInteger("MMXIV");
	assertEquals(2014,numeral);
	}
	
	
	
	
	
	
	


}
