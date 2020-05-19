
// Introduced in Chapter 13
/** String matcher using the Knuth-Morris-Pratt skipping algorithm. */
public class KnuthMorrisPrattStringMatcher extends AbstractStringMatcher {

	/**
	 * Length of longest pattern prefix ending at each position in pattern.
	 */
	private int[] prefixArray;

	/** Pattern is the pattern being sought. */
	public KnuthMorrisPrattStringMatcher(String pattern) {
		super(pattern);
		prefixArray = new int[getPattern().length()]; // All zeroes
		int i = 1;
		int matches = 0;
		while (i < getPattern().length()) {
			if (getPattern().charAt(i)=='?'||getPattern().charAt(i) == getPattern().charAt(matches)) {
				matches++;
				prefixArray[i] = matches;
				i++;
			} else if (matches > 0) {
				matches = prefixArray[matches - 1];
			} else {
				i++;
			}
		}
	}

	public int match(String text) {
		int i = 0;
		int matches = 0;
		while (i < text.length()) {
			if (getPattern().charAt(matches) == '?' || getPattern().charAt(matches) == text.charAt(i)) {
				matches++;
				if (matches == getPattern().length()) {
					return i + 1 - getPattern().length();
				} else {
					i++;
				}
			} else if (matches > 0) {
				matches = prefixArray[matches - 1];
			} else {
				i++;
			}
		}
		return -1;
	}

	public ArrayList<Integer> allMatches(String text) {
		int i = 0;
		int matches = 0;
		ArrayList<Integer> dir = new ArrayList<Integer>();
		while (i < text.length()) {
			if (getPattern().charAt(matches) == '?' || getPattern().charAt(matches) == text.charAt(i)) {
				matches++;
				if (matches == getPattern().length()) {
					dir.add(i + 1 - getPattern().length());
					matches = 0;
					i -= getPattern().length() - 2;
				} else {
					i++;
				}
			} else if (matches > 0) {
				matches = prefixArray[matches - 1];
			} else {
				i++;
			}
		}
		return dir;
	}

	public static void main(String[] args) {
		System.out.println(new KnuthMorrisPrattStringMatcher("p?any").match("amanaplanacanalplanamaplany"));
		System.out.println(new KnuthMorrisPrattStringMatcher("pl?an").allMatches("amanaplxanacanalplyanamaplyan"));

	}
}
