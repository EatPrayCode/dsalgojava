package DynamicProgramming;

import java.util.ArrayList;
import java.util.Set;

public class test {

    public static void printPerm(String str, String prefix) {

        if (str.length() == 0) {
            System.out.println(prefix);
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);;
            printPerm(ros, prefix + ch);
        }

    }

    public static void main(String args[]) {
        printPerm("geek", "");
    }

}
