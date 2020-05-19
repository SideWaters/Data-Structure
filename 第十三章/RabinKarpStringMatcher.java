// Introduced in Chapter 13
/** String matcher using the Rabin-Karp fingerprinting algorithm. */
public class RabinKarpStringMatcher extends AbstractStringMatcher {

	/** All arithmetic is done modulo this number to avoid overflow. */
	public static final int MODULUS = 65521;

	/** Strings are treated as numbers in this base. */
	public static final int RADIX = (Character.MAX_VALUE + 1) % MODULUS;

	/** Fingerprint of the pattern. */
	private int patternPrint;

	/** Value of a 1 in the highest place in the pattern. */
	private int highPlace;

	/** Pattern is the pattern being sought. */
	public RabinKarpStringMatcher(String pattern) {
		super(pattern);
		patternPrint = initialFingerprint(pattern, pattern.length());
		highPlace = 1;
		for (int i = 1; i < pattern.length(); i++) {
			highPlace = (highPlace * RADIX) % MODULUS;
		}
	}

	/** Return a fingerprint for the first length characters of str. */
	protected int initialFingerprint(String str, int length) {
		int result = 0;
		for (int i = 0; i < length; i++) {
			result = (result * RADIX) % MODULUS;
			result = (result + str.charAt(i)) % MODULUS;
		}
		return result;
	}

	public int match(String text) {
		int textPrint = initialFingerprint(text, getPattern().length());
		for (int position = 0; position + getPattern().length() <= text.length(); position++) {
			if ((textPrint == patternPrint) && (matchAt(text, position))) {
				return position;
			}
			// Remove left character
			textPrint -= (highPlace * text.charAt(position)) % MODULUS;
			if (textPrint < 0) {
				textPrint += MODULUS * (1 + (-textPrint / MODULUS));
			}
			// Shift over
			textPrint = (textPrint * RADIX) % MODULUS;
			// Add right character
			if (position + getPattern().length() != text.length()) {
				textPrint += text.charAt(position + getPattern().length());
				textPrint %= MODULUS;
			}
		}
		return -1;
	}

	public ArrayList<Integer> allMatches(String text) {
		int textPrint = initialFingerprint(text, getPattern().length());
		ArrayList<Integer> dir = new ArrayList<Integer>();
		for (int position = 0; position + getPattern().length() <= text.length(); position++) {
			if ((textPrint == patternPrint) && (matchAt(text, position))) {
				dir.add(position);
			}
			// Remove left character
			textPrint -= (highPlace * text.charAt(position)) % MODULUS;
			if (textPrint < 0) {
				textPrint += MODULUS * (1 + (-textPrint / MODULUS));
			}
			// Shift over
			textPrint = (textPrint * RADIX) % MODULUS;
			// Add right character
			if (position + getPattern().length() != text.length()) {
				textPrint += text.charAt(position + getPattern().length());
				textPrint %= MODULUS;
			}
		}
		return dir;
	}

	public static void main(String[] args) {
		System.out.println(new RabinKarpStringMatcher("plany").match("amanaplanyacanalplanamaplany"));
		System.out.println(new RabinKarpStringMatcher("plan").allMatches("amanaplanacanalplanamaplanplan"));
		System.out.println("RESULT: " + new RabinKarpStringMatcher("algor").match("rabinkarpstringmatchingalgorithm"));
		System.out.println(
				"RESULT: " + new RabinKarpStringMatcher("algor").allMatches("rabinkarpstringmatchingalgorithmalgor"));
	}

}
