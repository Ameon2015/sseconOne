package edu.wiu;
/*
   CS351, Spring 2020
   Western Illinois University
   Covert
   Provided StoryNode Class
   For use with Homework 1
*/

/**
   StoryNode class used for optional CYOA homework <br><br>
   StoryNode stores: 
   <br>description - used to print traversal of tree and in visualizer,
   <br>storyText - the story for this location
   <br>leftChoice - the word or phrase used to indicated taking the left choice
   <br>rightChoice - the word or phrase used to indicated taking the right choice
   @author Jason Covert
*/
public final class StoryNode{
   private final String desc;
   private final String storyText;
   private final String leftChoice;
   private final String rightChoice;
   
   /**
      Create a StoryNode based on the data supplied.
      @param d brief description of location; preferably one word
      @param text the descriptive story text. Use of formatting can aid readability in console based settings. Use %n to separate text per line in the text.
      @param cL the keyword used to select the left choice. Should be clearly included in the story text.
      @param cR the keyword used to select the right choice. Should be clearly included in the story text.
   */
   public StoryNode(String d, String text, String cL, String cR){
      if( d == null ) throw new IllegalArgumentException( "StoryNode description can't be null.");
      desc = d;      
      if( text == null ) throw new IllegalArgumentException( "StoryNode text can't be null.");      
      storyText = text;
      
      // disallow use of "null" as keyword in choices; helps to prevent some debugging issues with CYOA stories
      // null will throw an exception, "null" won't
      if( cL!= null && cL.equals("null")) cL = null;
      if( cR!= null && cR.equals("null")) cR = null;
            
      leftChoice = cL;
      rightChoice = cR;
   }
 
   /**
      Retrieve the story text. Automatically fomatted when returned.
      @return story text formatted using String.format
   */  
   public String getStory(){
      return String.format(storyText);
   }

   /**
      Retrieve the description for this node. 
      @return node description
   */ 
   public String getDescription(){
      return desc;
   }

   /**
      Retrieve the left choice keyword/phrase for this node. 
      @return left choice
   */    
   public String getLeftChoice(){
      return leftChoice;
   }
   
   /**
      Retrieve the right choice keyword/phrase for this node. 
      @return right choice
   */    
   public String getRightChoice(){
      return rightChoice;
   }
   
   @Override
   public String toString(){
      return desc;
   }     
}