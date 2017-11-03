package helper;

import com.google.common.base.Strings;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import errorMessages.ErrorMessages;
import morseCodeException.MorseCodeException;

public abstract class MorseCodeHelper {

	/**
	 * Translate Morse Code to Text.
	 * @param morseCode
	 * @return String
	 * @throws Exception 
	 */
	public static String translate2Text(String morseCode) throws Exception {

		String[] stringArray = morseCode.replaceAll("     ", " | ").split(" ");

		String textResult = "";
		for (String code : stringArray) {
			
			String morse = MORSE_CODE_MAPPING.inverse().get(code);
			
			if(Strings.isNullOrEmpty(morse)) {
				throw new MorseCodeException(ErrorMessages.INVALID_MORSE);
			}
			
			textResult = textResult.concat(morse);
		}
		
		return textResult;
	}
	
	/**
	 * Translate Morse Code to Text.
	 * @param text
	 * @return String
	 * @throws Exception 
	 */
	public static String translate2Morse(String text) throws Exception {

		String[] stringArray = text.replaceAll(" ", "|").split("");
		
		String morseCodeResult = "";
		for (String c : stringArray) {
			String morse = MORSE_CODE_MAPPING.get(c);
			
			if(Strings.isNullOrEmpty(morse)) {
				throw new MorseCodeException(ErrorMessages.INVALID_MORSE);
			}
			
			morseCodeResult = morseCodeResult.concat(morse).concat(" ");
		}
		
		return morseCodeResult.replaceAll("\\s+$", "");
	}
	
//	/**
//	 * Validate bit sequence (Only 0 or 1).
//	 * @param bitSequence
//	 * @throws Exception 
//	 */
//	public static void validateBitSequence(String bitSequence) throws Exception {
//		
//		if (!bitSequence.matches("[0-1]+")) {
//			throw new MorseCodeException(ErrorMessages.INVALID_INPUT);
//		}
//	}
	
	// One to one relationship between character and morse code
	static BiMap<String, String> MORSE_CODE_MAPPING = HashBiMap.create();

	// Build the BiMap
	static {
		MORSE_CODE_MAPPING.put("|", "   ");
		MORSE_CODE_MAPPING.put(",", "--..--");
		MORSE_CODE_MAPPING.put(".", ".-.-.-");
		MORSE_CODE_MAPPING.put("?", "..--..");
		MORSE_CODE_MAPPING.put("0", "-----");
		MORSE_CODE_MAPPING.put("1", ".----");
		MORSE_CODE_MAPPING.put("2", "..---");
		MORSE_CODE_MAPPING.put("3", "...--");
		MORSE_CODE_MAPPING.put("4", "....-");
		MORSE_CODE_MAPPING.put("5", ".....");
		MORSE_CODE_MAPPING.put("6", "-....");
		MORSE_CODE_MAPPING.put("7", "--...");
		MORSE_CODE_MAPPING.put("8", "---..");
		MORSE_CODE_MAPPING.put("9", "----.");
		MORSE_CODE_MAPPING.put("A", ".-");
		MORSE_CODE_MAPPING.put("B", "-...");
		MORSE_CODE_MAPPING.put("C", "-.-.");
		MORSE_CODE_MAPPING.put("D", "-..");
		MORSE_CODE_MAPPING.put("E", ".");
		MORSE_CODE_MAPPING.put("F", "..-.");
		MORSE_CODE_MAPPING.put("G", "--.");
		MORSE_CODE_MAPPING.put("H", "....");
		MORSE_CODE_MAPPING.put("I", "..");
		MORSE_CODE_MAPPING.put("J", ".---");
		MORSE_CODE_MAPPING.put("K", "-.-");
		MORSE_CODE_MAPPING.put("L", ".-..");
		MORSE_CODE_MAPPING.put("M", "--");
		MORSE_CODE_MAPPING.put("N", "-.");
		MORSE_CODE_MAPPING.put("O", "---");
		MORSE_CODE_MAPPING.put("P", ".--.");
		MORSE_CODE_MAPPING.put("Q", "--.-");
		MORSE_CODE_MAPPING.put("R", ".-.");
		MORSE_CODE_MAPPING.put("S", "...");
		MORSE_CODE_MAPPING.put("T", "-");
		MORSE_CODE_MAPPING.put("U", "..-");
		MORSE_CODE_MAPPING.put("V", "...-");
		MORSE_CODE_MAPPING.put("W", ".--");
		MORSE_CODE_MAPPING.put("X", "-..-");
		MORSE_CODE_MAPPING.put("Y", "-.--");
		MORSE_CODE_MAPPING.put("Z", "--..");
		MORSE_CODE_MAPPING.put(" ", "|");
	}
}
