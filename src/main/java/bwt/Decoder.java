package bwt;

import java.util.*;

public class Decoder {

    /**
     * Decode BW encoded characters using the terminator '$'
     */
    public String decode(CharSequence bwChars) {
        return decode(bwChars, '\u0000');
    }

    /**
     * Decode BW encoded characters using the provided terminator
     */
    public String decode(CharSequence bwChars, char terminator) {
        DecodeMetadata metadata = new DecodeMetadata(bwChars);

        int row = 0;
        char[] resultArray = new char[bwChars.length()];
        resultArray[bwChars.length() - 1] = terminator;

        for (int k = bwChars.length() - 2; k >= 0; k--) {
            resultArray[k] = bwChars.charAt(row);
            char c = bwChars.charAt(row);
            row = metadata.getFirstCol().get(c) + metadata.getRanks().get(row);
        }

        return new String(resultArray);
    }

    // ########################################
    private final static class DecodeMetadata {
        List<Integer> ranks;
        Map<Character, Integer> firstCol;

        public DecodeMetadata(CharSequence chars) {
            Map<Character, Integer> totals = new TreeMap<>();
            ranks = new ArrayList<>();
            firstCol = new HashMap<>();

            for (int i = 0; i < chars.length(); i++) {
                int value = totals.merge(chars.charAt(i), 1, (k, kk) -> ++k);
                ranks.add(value - 1);
            }

            int total = 0;
            for (Map.Entry<Character, Integer> entry : totals.entrySet()) {
                firstCol.put(entry.getKey(), total);
                total += entry.getValue();
            }
        }

        public Map<Character, Integer> getFirstCol() {
            return firstCol;
        }

        public List<Integer> getRanks() {
            return ranks;
        }
    }
}
