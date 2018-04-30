import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman_Game{
	public static void main(String[] args){
		int limit = 5;
		String guess = "";
		Scanner kbd = new Scanner(System.in);
		int ranNum;
		
		//make a list
		List<String> words = new ArrayList<>();
		
		//load and read words.txt and put them in the list
		try{
			BufferedReader br = new BufferedReader(new FileReader("words.txt"));
			String lines="";
			while((lines = br.readLine())!=null){
				words.add(lines);
			}
		}catch(Exception e){
		}
		
		//picks a random word
		int rWord = new Random().nextInt(words.size());
		String genWord = words.get(rWord);
		
		//Put the letters in the word into an ArrayList
		//another list for what is to be displayed
		//and another list for the guesses. Only the first two are really necessary
		ArrayList<String> wordArr = new ArrayList<>();
		ArrayList<String> displayWord = new ArrayList<>();
		ArrayList<String> guesses = new ArrayList<>();
		
		for(int i = 0; i < genWord.length(); i++){
			wordArr.add((Character.toString(genWord.charAt(i))));
			displayWord.add("_");
		}
		
		//count down errors - normal exit
		while(limit > 0){
			System.out.println("Wrong guesses: " + guesses);
			System.out.println(limit + " tries remaining.");
			
			//print out underscores
			for(String item: displayWord){
				System.out.print(item + " ");
			}
			System.out.println("\n\n");
			System.out.print("Take a guess: ");
			
			guess = kbd.nextLine();
			
			//if the guess matches any letter on the wordArr array, 
			//replace the underscore in displayWord array to 
			//the same index as the wordArr guess position.
			
			if(wordArr.contains(guess)){
				for(int j = 0; j < wordArr.size(); j++){
					if(wordArr.get(j).equals(guess)){
						displayWord.set(j, guess);
					}
				}
			} else {
				 limit--;
				 guesses.add(guess);
			}
			
			//win condition
			if(!displayWord.contains("_")){
				System.out.println("Well done!");
				break;
			}
		}
		
		System.out.println("The correct word was: " + genWord);
		System.out.println("Game over! Thanks for playing.");
	}
}