/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import Hangman_Game.Hangman_Interface;
import Hangman_Game.Hangman_InterfaceHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

/**
 *
 * @author asus
 */
public class ClientConnection {
    private Hangman_Interface hangmanInterface;
    
    public Hangman_Interface getHangmanInterface() {
        connect();
        return hangmanInterface;
    }
    
    public boolean connect() {
        try {
            String[] args = {"-ORBInitialPort","1055", "-ORBInitialHost", "localhost"};
            ORB orb = ORB.init(args, null);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "Hangman";
            hangmanInterface = Hangman_InterfaceHelper.narrow(ncRef.resolve_str(name));
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }    
}
