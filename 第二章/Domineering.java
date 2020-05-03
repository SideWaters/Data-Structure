package 第二章;

import java.util.Scanner;

// Introduced in Chapter 2
/** The game of Domineering. */
public class Domineering {
	int row;
	int column;
  /** For reading from the console. */
  public static final java.util.Scanner INPUT
    = new java.util.Scanner(System.in);

  /** The player who plays their dominoes horizontally. */
  public static final boolean HORIZONTAL = false;

  /** The player who plays their dominoes vertically. */
  public static final boolean VERTICAL = true;
  
  /** Array of board squares, true if occupied. */
  private boolean[][] squares;
  public Domineering() {
	  super();
  }
  /** The board is initially empty. */
  public Domineering(int a) {
    squares = new boolean[a][a];
    // Java initializes all array elements to false
  }

  /**
   * Return true if there is a legal move for the specified player.
   */
  public boolean hasLegalMoveFor(boolean player) {
    int rowOffset = 0;
    int columnOffset = 0;
    if (player == HORIZONTAL) {
      columnOffset = 1;
    } else {
      rowOffset = 1;
    }
    for (int row = 0; row < (squares.length - rowOffset); row++) {
      for (int column = 0; column < (squares.length - columnOffset); column++) {
        if (!(squares[row][column]
              || squares[row + rowOffset][column + columnOffset])) {
          return true;
        }
      }
    }
    return false;
  }
  boolean player = HORIZONTAL;
  /** Play until someone wins. */
  public void play() {
    
    while (true) {
      System.out.println("\n" + this);
      if (player == HORIZONTAL) {
        System.out.println("Horizontal to play");
      } else {
        System.out.println("Vertical to play");
      }
      if (!(hasLegalMoveFor(player))) {
        System.out.println("No legal moves -- you lose!");
        return;
      }
      this.setChess();
      /**1.18判断是是否覆盖棋子*/
      if(player) {//垂直
    	  if(!(squares[row][column])&&!(squares[row+1][column]))
    	  {
    		  playAt(row, column, player);
    		  player = !player;
    	  }
    	  else {
    		  System.out.println("覆盖棋子，请重新输入");
    		  this.play();
    	  }
      }
      else {//水平
	      if(!(squares[row][column])&&!(squares[row][column+1])) {
	    	  playAt(row, column, player);
	    	  player = !player;
	      }
	      else {
	    	  System.out.println("覆盖棋子，请重新输入");
	    	  this.play();
	      }
      }
    }
  }
  /**2.18判断是否越界*/
  public void setChess() {
	  System.out.print("Row: ");
      row = INPUT.nextInt();
      System.out.print("Column: ");
      column = INPUT.nextInt();
      if(player) {//垂直
    	  if(row<0||row>squares.length-2||column<0) {
    		  System.out.println("超出棋盘界限，请重新输入");
    		  this.setChess();
          }
      }
      else {//水平
    	  if(row<0||column<0||column>squares.length-2) {
    		  System.out.println("超出棋盘界限，请重新输入");
    	  this.setChess();
    	  }
      }
  }
  /**
   * Play a domino with its upper left corner at row, column.
   */
  public void playAt(int row, int column, boolean player) {
    squares[row][column] = true;
    if (player == HORIZONTAL) {
      squares[row][column + 1] = true;
    } else {
      squares[row + 1][column] = true;
    }
  }

  public String toString() {
	  String result=" ";
	  for(int a=0;a<squares.length;a++) {
		  result+=" ";
		  result+=a;
	  }
//    String result = "  0 1 2 3 4 5 6 7";
    for (int row = 0; row < squares.length; row++) {
      result += "\n" + row;
      for (int column = 0; column < squares.length; column++) {
        if (squares[row][column]) {
          result += " #";
        } else {
          result += " .";
        }
      }
    }
    return result;
  }
  
  /** Create and play the game. */
  public static void main(String[] args) {
    System.out.println("Welcome to Domineering.\nHow big board do you want?");
    Scanner in=new Scanner(System.in);
    int a=in.nextInt();
    Domineering game = new Domineering(a);
    game.play();
    in.close();
  }

}
