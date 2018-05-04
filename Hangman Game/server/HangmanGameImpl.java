import org.omg.CORBA.*;
import Hangman_Game.*; 
import java.util.*;
import java.io.*;

public class HangmanGameImpl extends Hangman_InterfacePOA {
	private ArrayList<Player> players = new ArrayList<>();
	private ArrayList<String> words = new ArrayList<>();

	public HangmanGameImpl() {
        try{
            Scanner scan = new Scanner(new FileReader("words.txt"));
            while(scan.hasNextLine()){
                words.add(scan.nextLine());
            }
        } catch(IOException e) {
            System.out.println("File does not exist.");
        }
	}

	public boolean login(String username) {
		try {
			if(players.isEmpty()) {
				players.add(new Player(username, words));
			} else {
				for(int i = 0; i < players.size(); i++) {
					if(players.get(i).getUsername().equalsIgnoreCase(username)) {
						return false;
					}
				}
			}
			players.add(new Player(username, words));
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String wordToGuess(String username) {
		String wordToGuess = "";
		for(int i = 0; i < players.size(); i++) {
			if(players.get(i).getUsername().equalsIgnoreCase(username)) {
				wordToGuess = players.get(i).getWordToGuess();
			}
		}
		return wordToGuess;
	}

	public boolean guessTheLetter(String username, String letter) {
		for(int i = 0; i < players.size(); i++) {
			if(players.get(i).getUsername().equalsIgnoreCase(username)) {
				if(gameOver(username)) {
					players.get(i).play();
				}
				if(players.get(i).getWordToGuess().contains(letter)) {
					players.get(i).correctGuess(letter);
				} else {
					players.get(i).wrongGuess();
				}
			}
		}
		return false;
	}

	public int getLife(String username) {
		int life = 0;
		for(int i = 0; i < players.size(); i++) {
			if(players.get(i).getUsername().equalsIgnoreCase(username)) {
				life = players.get(i).getLife();
			}
		}
		return life;
	}

	public boolean gameOver(String username) {
		for(int i = 0; i < players.size(); i++) {
			if(players.get(i).getUsername().equalsIgnoreCase(username)) {
				if(players.get(i).getLife() == 0 || players.get(i).getNumberOfRemainingLetters() == 0) {
					return true;
				}
			}
		}
		return false;
	}

	public void logout(String username) {
		if(!players.isEmpty()) {
			for(int i = 0; i < players.size(); i++) {
				if(players.get(i).getUsername().equalsIgnoreCase(username)) {
					players.remove(i);
				}
			}
		}
	}
}
