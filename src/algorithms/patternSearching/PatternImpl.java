package algorithms.patternSearching;

/**
 * @author rams0516
 *         Date: 7/10/2017
 *         Time: 1:55 PM
 */
public class PatternImpl {

    /**
     *
     * @param text
     * @param pattern
     * Search for the pattern in brute force manner
     */
    public void naiveSearch(String text, String pattern) {
        int count = 0;
        for(int i = 0 ; i <= text.length()-pattern.length() ; i++) {
            int j;
            for(j = 0 ; j < pattern.length() ; j++) {
                if(text.charAt(i+j) != pattern.charAt(j))
                    break;
            }
            if(j == pattern.length()) {
                count++;
                System.out.println("Pattern found at position = "+i);
            }
        }
        if(count == 0)
            System.out.println("Pattern not found");
    }
}