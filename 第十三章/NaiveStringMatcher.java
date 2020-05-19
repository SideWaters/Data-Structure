// Introduced in Chapter 13
/** Simply checks each position in the text for the pattern. */
public class NaiveStringMatcher extends AbstractStringMatcher {

	/** Pattern is the pattern being sought. */
	public NaiveStringMatcher(String pattern) {
		super(pattern);
	}

	public int match(String text) {
		for (int position = 0; position + getPattern().length() <= text.length(); position++) {
			if (matchAt2(text, position)) {
				return position;
			}
		}
		return -1;
	}

	public ArrayList<Integer> allMatches(String text) {
		ArrayList<Integer> dir = new ArrayList<Integer>();
		for (int position = 0; position + getPattern().length() <= text.length(); position++) {
			if (matchAt2(text, position)) {
				dir.add(position);
			}
		}
		return dir;
	}
	
	private boolean matchAt2(String text, int position) {
	    for (int i = 0; i < getPattern().length(); i++) {
	    	char a=getPattern().charAt(i); char b=text.charAt(i + position);
	        if (a!='?'&&a!=b) {
	          return false;
	        }
	      }
	      return true;
	    }
	public static void main(String[] args) {
		System.out.println(new NaiveStringMatcher("p?a?n").match("amanaplabnacanalplanama"));
		System.out.println(new NaiveStringMatcher("p?a?n").allMatches("amanaplabnacanalpyacnamapxayn"));
	}
}
