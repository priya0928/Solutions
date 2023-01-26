
import java.util.Scanner;
import java.util.*;
import java.lang.*;

public class WordSegment
{
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String inputString = in.next();
		
		in = new Scanner(System.in);
		int wordDictSize = in.nextInt();
		
		
		if(wordDictSize >=1 && wordDictSize <=25){
		    in = new Scanner(System.in);
		    String wordDictSpaceSeparated = in.nextLine();
		    
		    String[] wordArray = wordDictSpaceSeparated.split(" ");
		    List<String> wordDict = Arrays.asList(wordArray);
		    
		    if(wordDict.size() == wordDictSize){
		        System.out.println(wordBreak(inputString, wordDict));
		    } else {
		        System.out.println("Word dictionary should contain only " + wordDictSize + " words");
		        System.exit(0);
		    }
		    
		} else {
		    System.out.println("N should be >=1 and <=25");
		    System.exit(0);
		}
		
	}
	
    private static boolean wordBreak(String inputString, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        return wb(inputString, wordDictSet);
    }
    private static boolean wb(String inputString, Set<String> wordDictSet) {
        int len = inputString.length();
        if (len == 0) {
            return true;
        }
        for (int i = 1; i <= len; ++i) {
            if (wordDictSet.contains(inputString.substring(0, i)) && wb(inputString.substring(i), wordDictSet)) {
                return true;
            }
        }
        return false;
    
}
}
