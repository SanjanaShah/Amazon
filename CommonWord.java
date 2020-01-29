/*
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not
 * case sensitive.  The answer is in lowercase.
 *
 * Example:
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 *
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 *
 * @author Sanjana Shah
 */
import java.util.*;
public class CommonWord {
    private List<String> stringArr(String s) {
        List<String> arr = new ArrayList<String>();
        s = s.toLowerCase().strip();
        char[] sChar = s.toCharArray();
        String holder = "";
        for(char c : sChar) {
            if(c == ' ' && holder != "") {
                arr.add(holder);
                holder = "";
            } else if(checkPuncs(c)) {
                arr.add(holder);
                holder = "";
                continue;
            } else if (c == ' ') {
                continue;
            } else {
                holder += c;
            }
        }
        return arr;
    }

    private boolean checkPuncs(char c) {
        String punctuations = "`~!@#$%^&*()_+{}|:\"<>?-=[]\\;'./,";
        char[] puncs = punctuations.toCharArray();
        for(char punc : puncs) {
            if(c == punc) {
                return true;
            }
        }
        return false;
    }

    private String mostCommon(List<String> splitArr, String[] banned) {
        HashMap<String, Integer> every = new HashMap<String, Integer>();
        for(String str : splitArr) {
            for(String ban : banned) {
                if(str == ban) {
                    break;
                } else if (every.containsKey(str)){
                    every.put(str, every.get(str) + 1);
                } else {
                    every.put(str, 1);
                }
            }
        }

        String key = "";
        int freq = 0;
        for(Map.Entry elem : every.entrySet()) {
            for(String str : banned) {
                if(str.equals(elem.getKey().toString())) {
                    elem.setValue(0);
                }
            }
        }
        for(Map.Entry elem : every.entrySet()) {
            if((int)elem.getValue() > freq) {
                freq = (int) elem.getValue();
                key = elem.getKey().toString();
            }
        }
        return key;
    }


    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        CommonWord cw = new CommonWord();
        List<String> splitArr = cw.stringArr(paragraph);

        String[] banned = new String[]{"hit"};
        System.out.println(cw.mostCommon(splitArr, banned));
    }
}
