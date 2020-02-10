// https://www.geeksforgeeks.org/word-break-problem-dp-32/

package DynamicProgramming;

import java.util.Arrays;
import java.util.List;


class WordBreakProblem
{

    public static boolean wordBreakBool(List<String> dict, String str)
	{
		// return true if we have reached the end of the String, 
		if (str.length() == 0) {
			return true;
		}

		for (int i = 1; i <= str.length(); i++)
		{
			// consider all prefixes of current String
			String prefix = str.substring(0, i);

			// return true if prefix is present in the dictionary and
			// remaining string also forms space-separated sequence of
			// one or more dictionary words

			if (dict.contains(prefix) && wordBreakBool(dict, str.substring(i))) {
				return true;
			}
		}

		// return false if the String can't be segmented
		return false;
	}

    
    
	// Function to segment given String into a space-separated
	// sequence of one or more dictionary words

	public static void wordBreak(List<String> dict, String str, String out)
	{
		// if we have reached the end of the String,
		// print the output String

		if (str.length() == 0)
		{
			System.out.println(out);
			return;
		}

		for (int i = 1; i <= str.length(); i++)
		{
			// consider all prefixes of current String
			String prefix = str.substring(0, i);

			// if the prefix is present in the dictionary, add prefix to the
			// output String and recur for remaining String
		
			if (dict.contains(prefix)) {
				wordBreak(dict, str.substring(i), out + " " + prefix);
			}
		}
	}

	// main function
	public static void main(String[] args)
	{
		// List of Strings to represent dictionary
		// List<String> dict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");

		// // input String
		// String str = "pineapplepenapple";

        // wordBreak(dict, str, "");
        
        List<String> dict = Arrays.asList("this", "th", "is", "famous",
									"Word", "break", "b", "r", "e", "a", "k",
									"br", "bre", "brea", "ak", "problem");

		// input String
		String str = "Wordbreakproblem";

		if (wordBreakBool(dict, str)) {
			System.out.print("String can be segmented");
		} else {
			System.out.print("String can't be segmented");
        }
        
	}
}
