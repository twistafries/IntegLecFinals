package Hangman_Game;


/**
* Hangman_Game/Hangman_InterfaceHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../Hangman_Game.idl
* Saturday, May 12, 2018 5:43:56 AM CST
*/

abstract public class Hangman_InterfaceHelper
{
  private static String  _id = "IDL:Hangman_Game/Hangman_Interface:1.0";

  public static void insert (org.omg.CORBA.Any a, Hangman_Game.Hangman_Interface that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Hangman_Game.Hangman_Interface extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (Hangman_Game.Hangman_InterfaceHelper.id (), "Hangman_Interface");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Hangman_Game.Hangman_Interface read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_Hangman_InterfaceStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Hangman_Game.Hangman_Interface value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static Hangman_Game.Hangman_Interface narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Hangman_Game.Hangman_Interface)
      return (Hangman_Game.Hangman_Interface)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Hangman_Game._Hangman_InterfaceStub stub = new Hangman_Game._Hangman_InterfaceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static Hangman_Game.Hangman_Interface unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Hangman_Game.Hangman_Interface)
      return (Hangman_Game.Hangman_Interface)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Hangman_Game._Hangman_InterfaceStub stub = new Hangman_Game._Hangman_InterfaceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
