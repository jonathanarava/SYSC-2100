import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.*;
import java.util.ArrayList;

public class CountSubstrings {
      List<String> list = new ArrayList<String>(); 
    
	 public static void main(String[] args) throws IOException {
	  
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Please enter the path for the input file: ");
		 String filename = sc.nextLine();
		 File inputFile = new File(filename);
		 Scanner reader = new Scanner(inputFile);
		 
		 Scanner pat = new Scanner(System.in);
		 System.out.println("Enter the pattern to look for:");
		 String pattern = sc.nextLine();
		 
		 //System.out.println("Using ArrayLists: " +   + "matches, derived in" +  + "milliseconds.");
		 //System.out.println("Using LinkedLists: " +   + "matches, derived in" +  + "milliseconds.");
	 }
	 
	 /*
	     * Returns the lowest index at which substring pattern begins in text (or
	     * else -1).
	     */
	    private static int findBrute(List<Character> text, List<Character> pattern) {
	        int n = text.size();
	        int m = pattern.size();
	        for (int i = 0; i <= n - m; i++) { // try every starting index
	                                        // within text
	        int k = 0; // k is index into pattern
	        while (k < m && text.get(i + k) == pattern.get(k))
	            // kth character of pattern matches
	            k++;
	        if (k == m) // if we reach the end of the pattern,
	            return i; // substring text[i..i+m-1] is a match
	        }
	        return -1; // search failed
	    }
	    
}

