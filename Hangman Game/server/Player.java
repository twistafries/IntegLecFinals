import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;

public class Player {
	private String username;
	private ArrayList<String> words = new ArrayList<>();;
	private int life;
	private int randomNumber;
	private String wordToGuess;
	private ArrayList<String> remainingLetters = new ArrayList<>();
	private Random randomizer = new Random();

	public Player(String username, ArrayList<String> words) throws IOException {
		this.username = username;
		this.words = words;
		Random randomizer = new Random();
		remainingLetters = new ArrayList<>();
		play();
	}

	public String getUsername() {
		return username;
	}

	public int getLife() {
		return life;
	}

	public String getWordToGuess() {
		return wordToGuess;
	}

	public void setRemainingLetters() {
		for(int i = 0; i < wordToGuess.length(); i++) {
			if(!remainingLetters.isEmpty()) {
				if(!remainingLetters.contains(wordToGuess.charAt(i))) {
					remainingLetters.add(String.valueOf(wordToGuess.charAt(i)));
				}
			} else {
					remainingLetters.add(String.valueOf(wordToGuess.charAt(i)));
			}
		}
	}

	public int getNumberOfRemainingLetters() {
		return remainingLetters.size();
	}

	public void correctGuess(String letter) {
		for(int i = 0; i < remainingLetters.size(); i++) {
			if(remainingLetters.contains(letter)) {
				remainingLetters.remove(i);
			}
		}
	}

	public void wrongGuess() {
		life--;
	}

	public void removeWordFromWordsList(int index) {
		words.remove(index);
	}

	public void play() {
		randomNumber = randomizer.nextInt(words.size());
		wordToGuess = words.get(randomNumber);
		setRemainingLetters();
		removeWordFromWordsList(randomNumber);
		life = 5;
	}
}