/*Rules:	  
There	  were	  certain	  rules	  that	  the	  numerals	  followed	  which	  should	  be	  observed:	  

• The	symbols	'I',	'X',	'C',	and	'M'	can	be	repeated	at	most	3	times	in	a	row.	
• The	symbols	'V',	'L',	and	'D'	can	never	be	repeated.	
• The	'1'	symbols	('I',	'X',	and	'C')	can	only	be	subtracted	from	the	2	next	highest	values	('IV'	and	
	'IX',	  'XL'	  and	  'XC',	  'CD'	  and	  'CM').	  
• Only	one	subtraction	can	be	made	per	numeral	('XC'	is	allowed,	'XXC'	is not).

• The	'5'	symbols	('V',	'L',	and	'D')	can	never	be	subtracted.	*/

public class RomanNumerals {
	public int convertToInteger(String romanNum) {
		
		// To be Implemented
		return 0;
		
	}
	
	public int getValueOfsimpleSymbol(char romanNum) throws RomanNumeralsException {
		int value =0;
		switch (romanNum)
			{
			case 'I':
				value = 1;
				break;
			case 'V':
				value = 5;
				break;
			case 'X': 
				value = 10;
				break;
			case 'L':
				value = 50;
				break;
			case 'C':
				value = 100;
				break;
			case 'D':
				value = 500;
				break;
			case 'M':
				value = 1000;
				break;
			default:
				throw new RomanNumeralsException();
				
			}
		
		return value;				
	}
	
	public int getValueOfCombinedSymbol(String romanNum) throws RomanNumeralsException {
		String str = romanNum; 
		char[] charArray = str.toCharArray();
		boolean subtracted;
		boolean sameSymbols;
		int value =0;
		int count =1;
		for (int i = 0;i<charArray.length; i++) {
			subtracted = false;
			sameSymbols = false;
			if (i+2 <= (charArray.length)) {
				if (subtractable(charArray[i],charArray[i+1],count)&& !sameSymbols) {
					
					value = value +getValueOfsimpleSymbol(charArray[i+1])-getValueOfsimpleSymbol(charArray[i]);
					subtracted = true;
					i++;
									
				}
			
			
				if (!subtracted) {
					if (charArray[i]==charArray[i+1] ) {
						if (repeatableSymbol(charArray[i])) {
							count ++;		
							sameSymbols = true;
						} else {
							count =4;
						}
					} else {
						count = 1;
					}
					
					
					
					if (count <= 3) {
						value = (value + getValueOfsimpleSymbol(charArray[i])+getValueOfsimpleSymbol(charArray[i+1]));
						i++;
					} else {
						throw new RomanNumeralsException();
					}
				}
			} else {
				value = value + getValueOfsimpleSymbol(charArray[i]);
			}
		}
		return value;	
		
	}
	
	private boolean repeatableSymbol(char romanChar) {
		switch(romanChar) 
			{
			case 'I':
				return true;
			case 'X':
			 	return true;
			case 'C':
				return true;
			case 'M':
				return true;
			default:
				return false;
			}	
		
	}
	
	private boolean subtractable(char romanChar1, char romanChar2, int count) throws RomanNumeralsException {
		
		if (subtractableSymbol(romanChar1)&& !subtractableSymbol(romanChar2)&&count==1) {
			if (romanChar2>romanChar1&&romanChar2<=(romanChar1*100)) {
				return true;
			} else {
				return false;
			}
			
		}else if (count>1){
			throw new RomanNumeralsException();
			
		}else {
			return false;
		}
		
	}
	
	private boolean subtractableSymbol(char romanChar) {
		switch(romanChar)
		{
		case 'V':
			return false;
		case 'L':
			return false;
		case 'D':
			return false;
		default:
			return true;
				
		}
	}
}
