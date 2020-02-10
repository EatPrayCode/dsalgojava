// https://www.geeksforgeeks.org/print-all-permutations-of-a-string-in-java/

package Recursion;

import java.util.ArrayList;

class PermutationsString {

    static ArrayList<String> list = new ArrayList<>();

    public static void printPermutn(String str, String prefix) {
        if (str.length() == 0) {
            list.add(prefix);
            return;
        }
        boolean alpha[] = new boolean[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            if (alpha[ch - 'a'] == false) {
                printPermutn(ros, prefix + ch);
            }
            alpha[ch - 'a'] = true;
        }
    }

    public static void main(String[] args) {

        String str = "geek";

        printPermutn(str, "");
        System.out.println(list);

    }

}
