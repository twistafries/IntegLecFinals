package Hangman_Game;


/**
* Hangman_Game/Hangman_InterfaceOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../Hangman_Game.idl
* Tuesday, May 1, 2018 3:13:46 PM CST
*/

public interface Hangman_InterfaceOperations 
{
  void getUserName (String name);
  boolean guess (String guess);
  void _continue (String confirm);
} // interface Hangman_InterfaceOperations