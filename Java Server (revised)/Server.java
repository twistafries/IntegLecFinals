import Hangman_Game.*;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Hashtable;
import java.util.Random;

//Implementation of Hangman_Game 
class Hman_Imp extends Hangman_InterfacePOA{
	private ORB orb;
	private Map<String, List> users = new Hashtable<>();
	private List<String> words = new ArrayList<>();
	private ArrayList<String> usedWords;

	private int pickWord;
	
	public Hman_Imp(){
		try{
			BufferedReader br = new BufferedReader(new FileReader("words.txt"));
			String lines="";
			while((lines = br.readLine())!=null){
				words.add(lines);
			}
		}catch(Exception e){
		}
	}
	
	public void setORB(ORB orb){
		this.orb = orb;
	}
	
	public boolean login(String username){
		if(users.containsKey(username)){
			return false;
		} else {
			users.put(username, usedWords = new ArrayList<>());
			System.out.println("New User: " + username);
			return true;
		}
	}
	
	public String wordToGuess(String username){
		String genWord = "";
		while(!(users.get(username)).contains(genWord)){
			pickWord = new Random().nextInt(words.size());
			genWord = words.get(pickWord);
			(users.get(username)).add(genWord);
		}
		return genWord;
	}
	
	public void logout(String username){
		if(users.containsKey(username)){
			users.remove(username);
		}
	}
}

//server class
public class Server{
	public static void main(String args[]){
		try{
			ORB orb = ORB.init(args, null);
			
			//set up server skeleton
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();
			
			//servant ref
			Hman_Imp hman_Imp = new Hman_Imp();
			hman_Imp.setORB(orb);
			
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(hman_Imp);
			Hangman_Interface href = Hangman_InterfaceHelper.narrow(ref);
			
			//naming service
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			String name_service = "hangman";
			NameComponent nc = new NameComponent(name_service, "");
			NameComponent path[] = {nc};
			ncRef.rebind(path, href);
			
			System.out.println("Server up. Would you like to play a game?");
			
			orb.run();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
