// https://leetcode.com/problems/shortest-palindrome/

public class shortestpalindrome {

    boolean isPalin(char str[], int st, int end) {
        while (st < end) {
            if (str[st] != str[end])
                return false;
            st++;
            end--;
        }
        return true;
    }

    // Returns count of insertions on left side to make
    // str[] a palindrome
    public int findMinInsert(char str[], int n) {
        // Find the largest prefix of given string
        // that is palindrome.
        for (int i = n - 1; i >= 0; i--) {
            // Characters after the palindromic prefix
            // must be added at the beginning also to make
            // the complete string palindrome
            if (isPalin(str, 0, i))
                return (n - i - 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        shortestpalindrome lcs = new shortestpalindrome();
        String s1 = "JAVA";
        System.out.println(lcs.findMinInsert(s1.toCharArray(), s1.length()));
    }

}
