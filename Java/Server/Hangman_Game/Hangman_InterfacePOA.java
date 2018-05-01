package Hangman_Game;


/**
* Hangman_Game/Hangman_InterfacePOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../Hangman_Game.idl
* Tuesday, May 1, 2018 3:13:45 PM CST
*/

public abstract class Hangman_InterfacePOA extends org.omg.PortableServer.Servant
 implements Hangman_Game.Hangman_InterfaceOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("getUserName", new java.lang.Integer (0));
    _methods.put ("guess", new java.lang.Integer (1));
    _methods.put ("continue", new java.lang.Integer (2));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // Hangman_Game/Hangman_Interface/getUserName
       {
         String name = in.read_string ();
         this.getUserName (name);
         out = $rh.createReply();
         break;
       }

       case 1:  // Hangman_Game/Hangman_Interface/guess
       {
         String guess = in.read_string ();
         boolean $result = false;
         $result = this.guess (guess);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // Hangman_Game/Hangman_Interface/_continue
       {
         String confirm = in.read_string ();
         this._continue (confirm);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Hangman_Game/Hangman_Interface:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Hangman_Interface _this() 
  {
    return Hangman_InterfaceHelper.narrow(
    super._this_object());
  }

  public Hangman_Interface _this(org.omg.CORBA.ORB orb) 
  {
    return Hangman_InterfaceHelper.narrow(
    super._this_object(orb));
  }


} // class Hangman_InterfacePOA