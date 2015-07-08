package bwt;

import java.util.Arrays;
import java.util.Comparator;

public class Encoder {

    public String encode(CharSequence chars) {
        char eof = chars.charAt(chars.length() - 1);
        final StringBuilder result = new StringBuilder(chars.length());

        for (Integer i : generateSuffixArray(chars)) {
            int ii = i.intValue();
            result.append(ii == 0 ? eof : chars.charAt(ii - 1));
        }

        return result.toString();
    }

    /**
     * Wish I could sort an int[] with a comparator - alas....
     */
    private Integer[] generateSuffixArray(CharSequence chars) {
        Integer[] suffixArray = new Integer[chars.length()];
        Arrays.setAll(suffixArray, Integer::valueOf);
        Arrays.sort(suffixArray, new SuffixComparator(chars));
        return suffixArray;
    }

    /**
     * Compare rotated version of a string using the offset to the corresponding initial index
     */
    private final static class SuffixComparator implements Comparator<Integer> {
        private final CharSequence chars;
        private final int lim;

        public SuffixComparator(CharSequence chars) {
            this.chars = chars;
            this.lim = chars.length();
        }

        @Override
        public int compare(Integer i, Integer j) {
            for (int k = 0; k < lim; k++) {
                char c1 = chars.charAt((i + k) % lim);
                char c2 = chars.charAt((j + k) % lim);
                if (c1 != c2) {
                    return c1 - c2;
                }
            }
            return 0;
        }
    }
}
