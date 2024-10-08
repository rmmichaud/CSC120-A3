/** Rachel Michaud
 * I did not collaborate with anyone on this assignment. 
 * I did not utilize any outside sources on this assignment.
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
class Conversation {
  public static void main(String[] arguments) {
    // You will start the conversation here.
    //declare transcript list and initialize scanner and random 
    List<String> transcript = new ArrayList<>();
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);
    String[] response = {
      "Mhmm.",
      "Sounds interesting.",
      "Wow!",
      "Interesting! Tell me more.",
      "How are you feeling about this?",
      "I see.",
      "It makes you think, doesn't it?",
      "I've never thought about it like that.",
      "Now that's a thought!",
      "It's one of those things, you know?"
    };
    String output1 = "How many rounds? ";
    // add output1 to transcript list, print first interaction and read input  
    transcript.add(output1);
    System.out.print(output1);
    int numRounds = scanner.nextInt();
    scanner.nextLine();
    String str = Integer.toString(numRounds);
    // add str to transcript list 
    transcript.add(str);
    String output2 = "Hello, what would you like to discuss?";
    transcript.add(output2);
    System.out.println(output2);
    String round = scanner.nextLine();
    String roundOriginal = round;
    transcript.add(round);
    int counter = 1;
    while (counter <= numRounds) {
      /** replace various personal pronounds with correct mirrored terms **/
      String[] parts = round.split(" ");
      for (int i = 0; i < parts.length; i++) {
        if (parts[i].equals("your")) {
          parts[i] = parts[i].replace("your", "my");
          continue;
        }
        if (parts[i].equals("Your")) {
          parts[i] = parts[i].replace ("Your", "My");
          continue;
        }
        if (parts[i].equals("I")) {
          if (i == 0) {
            parts[i] = parts[i].replace ("I", "You");
          } else {
            parts[i] = parts[i].replace ("I", "you");
          }
          continue;
        }
        if (parts[i].equals("me")) {
          parts[i] = parts[i].replace ("me", "you");
          continue;
        }
        if (parts[i].equals("Me")) {
          parts[i] = parts[i].replace ("Me", "You");
          continue;
        }
        if (parts[i].equals("you") || parts[i].equals("You")) {
          parts[i] = parts[i].replace ("you", "I");
          parts[i] = parts[i].replace ("You", "I");
          continue;
        }
        if (parts[i].equals("my")) {
          parts[i] = parts[i].replace ("my", "your");
          continue;
        }
        if (parts[i].equals("My")) {
          parts[i] = parts[i].replace ("My", "Your");
          continue;
        }
        if (parts[i].equals("am")) {
          parts[i] = parts[i].replace ("am", "are");
          continue;
        }
      }
      round = String.join(" ", parts);
      // fixing grammar inconsistencies created by replacing the personal pronouns*
      round = round.replace("I are", "I am");
      round = round.replace("are I", "am I");
      round = round.replace("Are I", "Am I");

      if (roundOriginal.contains(round) == false) {
        // replaces punctuation, turns mirrored input into a question
        round = round.replace (".", "?");
        round = round.replace ("!", "?");
        if (round.contains("?") == false){
          round = round + "?";
        }
        // add mirrored input to transcript, prints it out, gets new input
        transcript.add(round);
        System.out.println(round);
        round = scanner.nextLine();
        roundOriginal = round;
        transcript.add(round);
      } else {
          // if no mirrored input, return a random response
          int rand_int = rand.nextInt(10);
          // add response to transcript, get new input, add to transcript
          String finalResponse = response[rand_int];
          transcript.add(finalResponse);
          System.out.println(finalResponse);
          round = scanner.nextLine();
          roundOriginal = round;
          transcript.add(round);
        }
      // if number of rounds of conversation has been reached, print out goodbye and transcript, end loop
      if (counter == numRounds-1) {
        String goodbye = "It was great talking with you!";
        System.out.println(goodbye);
        transcript.add(goodbye);
        System.out.println();
        System.out.println("Transcript:");
        for(int i = 0; i < transcript.size(); i++) {
          System.out.println(transcript.get(i));
          
      }
        break;
      } 
      counter += 1;
    }
    scanner.close();  
  }
}
