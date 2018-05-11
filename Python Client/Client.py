import sys
import CORBA
import CosNaming
import Hangman_Game

orb = CORBA.ORB_init(sys.argv, CORBA.ORB_ID)

obj = orb.resolve_initial_references("NameService")
ncRef = obj._narrow(CosNaming.NamingContext)

name = [CosNaming.NameComponent("hangman", "")]
hangmanObj = ncRef.resolve(name)
hangman = hangmanObj._narrow(Hangman_Game.Hangman_Interface)

print ("Welcome to the python hangman game client.")
guess = ''
loop = False
retry = True
guessList = []

while (loop == False):
	username = input("Enter a username: ")
	loop = hangman.login(username)
	if loop == False:
		print ("Name already exists!")
		
	while retry==True:
		word = hangman.wordToGuess(username)
		errors = 5
		print ("Word Generated!")
		print ("Health Remaining: ", errors)
		wordToGuess = ["_ "] * len(word)
		while errors > 0:
			print ("Guess the word: ", ''.join(wordToGuess))
			guess = input("Guess a letter: ").lower()
			guessList.append(guess)
			print ("Current guesses: ", guessList)
			if guess in word:
				for pos, char in enumerate(word):
					if char == guess:
						wordToGuess[pos] = guess
			else:
				errors=errors-1
				print("Health remaining: ",errors)
			if("_ " not in wordToGuess):
				print ("You've guessed correctly!")
				break
		print ("The correct word was ", word,"!")
		retr = input("Play again (y/n)?")
		if retr == "y":
			retry==True
		else:
			retry==False
			hangman.logout(username)
			break