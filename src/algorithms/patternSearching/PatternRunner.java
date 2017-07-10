package algorithms.patternSearching;

/**
 * @author rams0516
 *         Date: 7/10/2017
 *         Time: 1:56 PM
 */
public class PatternRunner {
    public static void main(String[] args) {
        PatternImpl patternImpl = new PatternImpl();
        String text = "aabaacaadaabaaba";
        String pattern = "aa";
        patternImpl.naiveSearch(text, pattern);
    }
}