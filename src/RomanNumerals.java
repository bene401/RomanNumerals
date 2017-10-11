/*Rules:	  
There	  were	  certain	  rules	  that	  the	  numerals	  followed	  which	  should	  be	  observed:	  

• The	symbols	'I',	'X',	'C',	and	'M'	can	be	repeated	at	most	3	times	in	a	row.	
• The	symbols	'V',	'L',	and	'D'	can	never	be	repeated.	
• The	'1'	symbols	('I',	'X',	and	'C')	can	only	be	subtracted	from	the	2	next	highest	values	('IV'	and	
	'IX',	  'XL'	  and	  'XC',	  'CD'	  and	  'CM').	  
• Only	one	subtraction	can	be	made	per	numeral	('XC'	is	allowed,	'XXC'	is not).

• The	'5'	symbols	('V',	'L',	and	'D')	can	never	be	subtracted.	*/

public class RomanNumerals {
	private boolean subtracted;
	private boolean sameSymbols;
	private boolean mistake;
	int count;
	
	public int convertToInteger(String romanNum) throws RomanNumeralsException {

		return getValueOfCombinedSymbol(romanNum);

	}

	public int getValueOfsimpleSymbol(char romanNum) throws RomanNumeralsException {
		int value = 0;
		switch (romanNum) {
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

		int value = 0;

		for (int i = 0; i < charArray.length; i++) {

			count = 1;
			subtracted = false;
			sameSymbols = false;
			mistake = false;
			System.out.println("Start");

			if (i + 2 <= (charArray.length)) {

				if (charArray[i] == charArray[i + 1]) {
					value = testSameSymbolsInRow(charArray, i, value);
					i = i + count - 1;
				}

				if (!sameSymbols) {
					value = subtractOfSymbols(charArray, i, value);
					if (subtracted) {
						i++;
					}

				}

				if (!subtracted && !sameSymbols && !mistake) {
					value = valueOf(value, getValueOfsimpleSymbol(charArray[i]), 0, 1);
					count = 1;
				} else if (mistake) {
					throw new RomanNumeralsException();
				}

			} else {
				value = value + getValueOfsimpleSymbol(charArray[i]);
			}
		}
		return value;

	}

	private int testSameSymbolsInRow(char[] charArray, int i, int value) throws RomanNumeralsException {

		while (charArray[i] == charArray[i + count]) {
			if (repeatableSymbol(charArray[i])) {
				count++;
				sameSymbols = true;

				if (count > 3) {
					mistake = true;
					break;
				}

				if ((count + i) >= charArray.length) {
					break;
				}
			} else {
				mistake = true;
				break;
			}

		}
		value = valueOf(value, getValueOfsimpleSymbol(charArray[i]), 0, count);
		i = i + count - 1;
		if (i + 1 < charArray.length) {
			if (!subtractableSymbol(charArray[i + 1])) {
				mistake = true;
			}
		}

		return value;

	}

	private int subtractOfSymbols(char[] charArray, int i, int value) throws RomanNumeralsException {
		if (subtractable(charArray[i], charArray[i + 1])) {
			value = valueOf(value, getValueOfsimpleSymbol(charArray[i + 1]), (-getValueOfsimpleSymbol(charArray[i])),
					1);
			subtracted = true;
			return value;

		} else {
			return value;
		}

	}

	private int valueOf(int value, int number1, int number2, int counter) {
		int v = value + ((number1 * counter) + number2);
		return v;

	}

	private boolean repeatableSymbol(char romanChar) {
		switch (romanChar) {
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

	private boolean subtractable(char romanChar1, char romanChar2) throws RomanNumeralsException {

		if (subtractableSymbol(romanChar1)) {
			if (romanChar2 > romanChar1 && romanChar2 <= (romanChar1 * 100)) {
				return true;
			} else {
				return false;
			}
		}

		/*
		 * }else if (count>1){ throw new RomanNumeralsException();
		 * 
		 * }
		 */else {
			return false;
		}

	}

	private boolean subtractableSymbol(char romanChar) {
		switch (romanChar) {
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
