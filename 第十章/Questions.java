package µÚÊ®ÕÂ;

// Introduced in Chapter 10
import java.util.Scanner;

/** The game of Questions. */
public class Questions {

  /** For reading from the console. */
  public static final Scanner INPUT = new Scanner(System.in);

  /** Root of the tree of knowledge. */
  private BinaryNode<String> root;

  /**
   * Initially, the program guesses that the player is thinking of
   * a giraffe.
   */
  public Questions() {
    root = new BinaryNode<String>("a giraffe");
  }

  /**
   * Node is a leaf corresponding to an incorrect guess.  Gather
   * information from the user and add two children to node.
   */
  protected void learn(BinaryNode<String> node) {
    System.out.print("What is it? ");
    String correct = INPUT.nextLine();
    System.out.println("I need a question to distinguish that from "
                       + node.getItem() + ".");
    System.out.println("The answer for " + correct
			          + " should be yes.");
    System.out.print("Enter the question: ");
    String question = INPUT.nextLine();
    node.setLeft(new BinaryNode<String>(correct));
    node.setRight(new BinaryNode<String>(node.getItem()));
    node.setItem(question);
  }

  /** Play until the program wins or gives up. */
  public void play() {
    BinaryNode<String> node = root;
    while (!(node.isLeaf())) {
      System.out.print(node.getItem() + " ");
      if (INPUT.nextLine().equals("yes")) {
        node = node.getLeft();
      } else {
        node = node.getRight();
      }
    }
    System.out.print("It is ... " + node.getItem() + "? ");
    if (INPUT.nextLine().equals("yes")) {
      System.out.println("I win!");
    } else {
      System.out.println("I give up.");
      learn(node);
    }
    System.out.println(root.toString("  "));
  }

/** Create and repeatedly play the game. */
  public static void main(String[] args) {
    Questions game = new Questions();
    System.out.println("Welcome to Questions.");
    do {
      System.out.println();
      game.play();
      System.out.print("Play again (yes or no)? ");
    } while (INPUT.nextLine().equals("yes"));
  }
}
