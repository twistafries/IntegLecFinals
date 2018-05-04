import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import Hangman_Game.*;

public class Server {

    public static void main(String args[]) {
       try {
          ORB orb = ORB.init(args, null);

          POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
          rootpoa.the_POAManager().activate();
          
	        HangmanGameImpl hangmanGameImpl = new HangmanGameImpl();
	
	        org.omg.CORBA.Object ref = rootpoa.servant_to_reference(hangmanGameImpl);
	        Hangman_Interface href = Hangman_InterfaceHelper.narrow(ref);
	
	        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

          NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

          String name = "Hangman";
          NameComponent path[] = ncRef.to_name(name);
          ncRef.rebind(path, href);

          System.out.println("Hangman Server running ...");

          orb.run();

      } catch (Exception e) {
           System.err.println("ERROR: " + e);
           e.printStackTrace(System.out);
      }
      	  
        System.out.println("Hangman Server Exiting...");
   }
}


