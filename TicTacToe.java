// package src;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {


    public static void main(String[] args) {
     char[][] board = 
     {
        {'1','2','3'},
        {'4','5','6'},
        {'7','8','9'}
     };
    

   char player_1='O';
   char player_2='X';
   boolean gameOver = false;
   Scanner scanner = new Scanner(System.in);
   System.out.println("\n\t\t\u001b[32m=== TIC TAC TOE ===\n");

    System.out.println("\t----------------------------------------");
    System.out.println( "\t\u001b[32m|\u001b[34m       SELECT A MODE TO PLAY:         \u001b[32m|");
    System.out.println( "\t\u001b[32m|\u001b[34m  Enter 1 for Playing with friend     \u001b[32m|");
    System.out.println( "\t\u001b[32m|\u001b[34m  Enter 2 for Playing with Computer   \u001b[32m|");
    System.out.println("\t\u001b[32m----------------------------------------\n");
    System.out.println("\t\u001b[36mSelect an option (1 or 2): \n");
    System.out.print("\tEnter option no. ==>");
    int option=scanner.nextInt();
    while(option != 1 && option != 2){
        System.out.print("\t\u001b[31mEnter valid option for mode of game\n");
        System.out.print("\t\u001b[36mEnter option no. ==>");
        option=scanner.nextInt();
    }

   printBoard(board);

   if(option==1){
        
        int switch_player=0;
        int movecount=1;
        while(!gameOver){

            if(movecount>9){

                System.out.println("\t\t\u001b[35mGame ends in a TIE!");
                printBoard(board);
                break;
            }
            
            if(switch_player%2==0){
            System.out.print("\u001b[31m Player "+player_1+" enter: ");
            }else{
            System.out.print("\u001b[34m Player "+player_2+" enter: ");
            }
            
            int move=scanner.nextInt();
            int row= getrow(move);
            int col=getcol(move); 

            

            if(move>0 &&move<10 && board[row][col] != 'O' && board[row][col] != 'X'){
            gameOver=haveWon(board,row,col,switch_player);   
            }else{
                System.out.println("\u001b[45;1mEnter a valid move!!--Status:Invalid");
            }

            if(gameOver){
                if(switch_player%2==0){
                    System.out.println("\t\t\u001b[32mPlayer O has won");
                }else{
                    System.out.println("\t\t\u001b[32mPlayer X has won");
                }
            }

            switch_player++;
            movecount++;
            printBoard(board);
        }
   }else if(option==2){
    
        int switch_player=0;
        int movecount=1;
        
        int move;
        while (!gameOver) {

           if(movecount>9){
                System.out.println("\t\t\u001b[35mGame ends in a TIE!");
                printBoard(board);
                break;
            }  

          if(switch_player%2==0){
            System.out.print("\u001b[31m Player "+player_1+" enter: ");
               move=scanner.nextInt();
            }else{
               move=getComputermove(board);
               System.out.println("\u001b[34m Player "+player_2+" enter: "+move);
            }
            
            int row= getrow(move);
            int col=getcol(move);   
          
            if(move>0 &&move<10 && board[row][col] != 'O' && board[row][col] != 'X'){
            gameOver=haveWon(board,row,col,switch_player);   
            }else{
                System.out.println("\u001b[45;1mEnter a valid move!!--Status:Invalid");
            }

            if(gameOver){
                if(switch_player%2==0){
                    System.out.println("\t\t\u001b[32mPlayer O has won");
                }else{
                    System.out.println("\t\t\u001b[32mComputer has won");
                }
            }

            switch_player++;
            movecount++;
            printBoard(board);
        }
   }
   
}


   public static void printBoard(char[][] board){
    for(int row=0; row< board.length;row++){
        System.out.println("\t" +"\u001b[33m------------------------------------");
        for(int col=0; col<board[row].length;col++){
            
            if(board[row][col]=='X'){
                 System.out.print("\t"+" \u001b[34m"+board[row][col]);
            }else if(board[row][col]=='O'){
                 System.out.print("\t"+" \u001b[31m"+board[row][col]);
            }else{
                System.out.print("\t"+" \u001b[33m"+board[row][col]);
                
            }
             if(col==1 || col==0){
                System.out.print("\t"+" \u001b[33m"+"|");
            }
           
            
        }
        
        System.out.println("");
     }
     System.out.println("\t" +"\u001b[33m------------------------------------");
   }


   public static int getrow(int move){
       switch (move) {
        case 1:case 2:case 3: return 0;
        case 4:case 5:case 6: return 1;
        default:
            return 2;
    
       }
   }

   public static int getcol(int move){
          switch (move) {
            case 1:case 4: case 7: return 0;
            case 2: case 5: case 8: return 1;
            default:
                return 2;
       }
   }


   public static boolean haveWon(char[][] board,int row,int col,int switch_p){
    if(switch_p%2==0){
        board[row][col]='O';
    }else{
        board[row][col]='X';
    }
     
    // rows for x
    for(int i=0;i<3;i++){
      if(board[i][0]=='X' && board[i][1]=='X' && board[i][2]=='X'){
        return true;
      }
    }

     // rows for O
    for(int i=0;i<3;i++){
      if(board[i][0]=='O' && board[i][1]=='O' && board[i][2]=='O'){
        return true;
      }
    }


    // diagonal for x

      if(board[0][0]=='X' && board[1][1]=='X' && board[2][2]=='X'){
        return true;
      }
      if(board[0][2]=='X' && board[1][1]=='X' && board[2][0]=='X'){
        return true;
      }

       // diagonal for O
       if(board[0][0]=='O' && board[1][1]=='O' && board[2][2]=='O'){
        return true;
      }
      if(board[0][2]=='O' && board[1][1]=='O' && board[2][0]=='O'){
        return true;
      }

    // col for x
    for(int i=0;i<3;i++){
      if(board[0][i]=='X' && board[1][i]=='X' && board[2][i]=='X'){
        return true;
      }
    }

    // col for O
     for(int i=0;i<3;i++){
      if(board[0][i]=='O' && board[1][i]=='O' && board[2][i]=='O'){
        return true;
      }
    }

    return false; 
   }


   public static int getComputermove(char[][] board){
    Random rand = new Random();
     int move;
    while(true){
        move=rand.nextInt(9)+1;
        int row=getrow(move);
        int col=getcol(move);
        if(board[row][row]!='O' && board[row][col]!='X'){
            return move;   
        }
    }
   }

}