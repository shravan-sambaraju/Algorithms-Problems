package problems.random;

/* Add spaces to sentence */

import java.util.HashSet;

import static common.utils.UtilMethods.getListOfWords;

class AddSpacesToSentence {

    private static String bestSplit(HashSet<String> dictionary, String sentence) {
        ParseResult[] memo = new ParseResult[sentence.length()];
        ParseResult r = split(dictionary, sentence, 0, memo);
        return r == null ? null : r.parsed;
    }

    private static ParseResult split(
        HashSet<String> dictionary, String sentence, int start, ParseResult[] memo) {
        if (start >= sentence.length()) {
            return new ParseResult(0, "");
        }
        if (memo[start] != null) {
            return memo[start];
        }

        int bestInvalid = Integer.MAX_VALUE;
        String bestParsing = null;

        String partial = "";
        int index = start;
        while (index < sentence.length()) {
            char c = sentence.charAt(index);
            partial += c;
            int invalid = dictionary.contains(partial) ? 0 : partial.length();
            if (invalid < bestInvalid) {
                ParseResult result = split(dictionary, sentence, index + 1, memo);
                if (invalid + result.invalid < bestInvalid) {
                    bestInvalid = invalid + result.invalid;
                    bestParsing = partial + " " + result.parsed;
                    if (bestInvalid == 0) {
                        break;
                    }
                }
            }
            index++;
        }
        memo[start] = new ParseResult(bestInvalid, bestParsing);
        return memo[start];
    }

    private static String clean(String str) {
        char[] punctuation = {',', '"', '!', '.', '\'', '?', ','};
        for (char c : punctuation) {
            str = str.replace(c, ' ');
        }
        return str.replace(" ", "").toLowerCase();
    }

    public static void main(String[] args) {
        HashSet<String> dictionary = getWordListAsHashSet();
        String sentence =
            "As one of the topk companies in the world, Google will surely attract the attention of computer gurus. This does not, however, mean the company is for everyone.";
        sentence = clean(sentence);
        System.out.println(sentence);
        // Result v = parse(0, 0, new HashMap<Integer, Result>());
        // System.out.println(v.parsed);
        System.out.println(bestSplit(dictionary, sentence));
    }

    private static HashSet<String> getWordListAsHashSet() {
        String[] wordList = getListOfWords();
        HashSet<String> wordSet = new HashSet<String>();
        for (String s : wordList) {
            wordSet.add(s);
        }
        return wordSet;
    }

    private static class ParseResult {
        private int invalid = Integer.MAX_VALUE;
        private String parsed = "";

        public ParseResult(int inv, String p) {
            invalid = inv;
            parsed = p;
        }

        private static ParseResult min(ParseResult r1, ParseResult r2) {
            if (r1 == null) {
                return r2;
            } else if (r2 == null) {
                return r1;
            }
            return r2.invalid < r1.invalid ? r2 : r1;
        }

        public ParseResult clone() {
            return new ParseResult(this.invalid, this.parsed);
        }
    }
}
