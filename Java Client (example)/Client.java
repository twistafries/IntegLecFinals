import Hangman_Game.*;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

import java.util.Scanner;
import java.util.ArrayList;

public class Client{
	static Hangman_Interface hImp;
	
	public static void main(String args[]){
		boolean loop=false;
		String username="";
		Scanner kbd = new Scanner(System.in);
		ArrayList<String> wordArray = new ArrayList<>();
		
		try{
			ORB orb = ORB.init(args, null);
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			String name = "Hangman";
			
			hImp = Hangman_InterfaceHelper.narrow(ncRef.resolve_str(name));
			System.out.println("Welcome to the Java Hangman Game client.");
			while(loop==false){
				System.out.println("Enter your name: ");
				username = kbd.nextLine();
				loop = hImp.login(username);
				if(loop==false){
					System.out.println("Name already exists!");
				}
			}
			
			//and whatever the rest you need
			
			System.out.println(hImp.wordToGuess(username));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}