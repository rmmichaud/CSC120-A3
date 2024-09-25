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
      /** replace various personal pronounds with a temporary variable, then replace those temp variables with the final word
       * not all words needed temporary variables, some could be directly replaced
       */
      round = round.replace ("your", "TEMP1");
      round = round.replace ("Your", "TEMP2");
      round = round.replace (" I ", " TEMP3 ");
      round = round.replace ("me", "TEMP4");
      round = round.replace ("Me", "TEMP5");
      round = round.replace ("you", "TEMP6");
      round = round.replace ("You", "TEMP6");
      round = round.replace("I ", "TEMP7 ");
      round = round.replace(" you", " TEMP8");
      round = round.replace ("my", "TEMP9");
      round = round.replace ("My", "TEMP10");
      round = round.replace (" am ", " TEMP11 ");
      round = round.replace(" am", " TEMP11");

      round = round.replace ("TEMP1", "my");
      round = round.replace ("TEMP2", "My");
      round = round.replace ("TEMP3", "you");
      round = round.replace ("TEMP4", "you");
      round = round.replace ("TEMP5", "You");
      round = round.replace ("TEMP6", "I");
      round = round.replace("TEMP7", "You ");
      round = round.replace("TEMP8", " me");
      round = round.replace ("TEMP9", "your");
      round = round.replace ("TEMP10", "Your");
      round = round.replace("TEMP11", "are");

      // fixing grammar inconsistencies created by replacing the personal pronouns*
      round = round.replace("I are", "I am");
      round = round.replace("are I", "am I");
      round = round.replace("Are I", "Am I");

      if (round != roundOriginal) {
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
      }

        else {
          // if no mirrored input, return a random response
          int rand_int = rand.nextInt(10);
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
