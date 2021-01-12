import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Mode game;
        int input;
        Scanner sc=new Scanner(System.in);
        System.out.println("Choose level. Enter 1 for easy level 2 for hard level: ");
        do {
            input = sc.nextInt();
            if(input != 1 && input != 2){
                System.out.println("Number must be 1 or 2. Try again.");
            }
        }while (input != 1 && input != 2);
        //shows the current board
        //checks whether the game has ended or not
        //PC's turn
        //shows the current board
        //shows the current board
        if(input == 1){ //Easy mode
            game = new Easy();
            System.out.println("You entered the easy mode");
        }else{ //Hard mode
            game = new Hard();
            System.out.println("You entered the hard mode");
        }
        game.show(); //shows the current board
        while(game.hasMoves()) {
            input = inputCheck(game);
            game.insert(input);
            game.show(); //shows the current board
            game.move(); //PC's turn
            game.show(); //shows the current board
        }

    }

    static int inputCheck(Mode game){ //code for checking users input
        Scanner sc=new Scanner(System.in);
        int input;
        System.out.println("Your turn:");
        do {
            input = sc.nextInt();
            if(input < 1 || input >9){
                System.out.println("Enter a number from 1-9");
            }else if (game.filled(input)){
                System.out.println("Box is full, please enter another number");
            }
        }while(input < 1 || input >9 || game.filled(input));
        return input;
    }
}
