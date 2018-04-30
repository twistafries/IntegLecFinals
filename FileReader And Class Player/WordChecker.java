import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @(#)WordChecker.java
 *
 *
 * @author Brendon Bruce Viloria
 * @version 1.00 2018/4/24
 */

public class WordChecker {
        
    /**
     * Creates a new instance of <code>WordChecker</code>.
     */
    public WordChecker() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        // TODO code application logic here
        
        //Container of words
        List <String> words = new ArrayList<>();
        	
        //Scanner for the user input	
        Scanner input = new Scanner(System.in);
        
        //Scanner for the file to be read
        Scanner reader = new Scanner(new File("words.txt"));
        
        int ctr = 0;
        
        //Copy the word from words.txt to words TreeSet
        while(reader.hasNext()){
        	String word = reader.nextLine();
        	words.add(word);
        	ctr++;
        }
        
        System.out.println("Words : "+ctr);
        
        
//        System.out.print("Enter a word : ");
//        String inWord = input.nextLine();
//        
//        if(words.contains(inWord)){
//        	System.out.println("Contained");	
//        }else{
//        	System.out.println("Not Contained");
//      }
		int randomWord = new Random().nextInt(ctr);
		
		String word = words.get(randomWord);
		for(int i = 0; word.length() > i; i++){
			if(word.charAt(i).toString()){
				System.out.print("");
			} else System.out.print("_");
		}
    }
}
