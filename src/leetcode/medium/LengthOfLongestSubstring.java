package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int inIdx = 0;
        int outIdx = 0;
        int max = 0;
        while (outIdx < s.length()) {
            if (set.contains(s.charAt(outIdx))) {
                set.remove(s.charAt(inIdx));
                inIdx++;
            } else {
                set.add(s.charAt(outIdx));
                max = Math.max(set.size(), max);
                outIdx++;
            }
        }
        return max;
    }
}
