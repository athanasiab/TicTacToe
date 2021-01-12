import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        int input;
        Scanner sc=new Scanner(System.in);
        System.out.println("Choose level. Enter 1 for easy level 2 for hard level: ");
        do {
            input = sc.nextInt();
            if(input != 1 && input != 2){
                System.out.println("Number must be 1 or 2. Try again.");
            }
        }while (input != 1 && input != 2);
        if(input == 1){ //Easy mode
            Easy game = new Easy();
            System.out.println("You entered the easy mode");
            game.show(); //shows the current board
            while(game.hasMoves()) {
                System.out.println("Your turn:");
                do {
                    input = sc.nextInt();
                    if(input < 1 || input >9){
                        System.out.println("Enter number from 1-9");
                    }
                }while(input < 1 || input >9);

                //ΝΑ ΖΗΤΑΕΙ ΑΛΛΟ ΚΟΥΤΙ ΑΝ ΕΙΝΑΙ ΓΕΜΑΤΟ
                //do while δεν ειναι filled

                game.insert(input);
                game.show(); //shows the current board
                if(game.hasMoves()) { //checks whether the game has ended or not
                    game.move(); //PC's turn
                    game.show(); //shows the current board
                }
            }
        }else{ //Hard mode
            Hard game = new Hard();
            System.out.println("You entered the hard mode");
            game.show(); //shows the current board
            while(game.hasMoves()) {
                System.out.println("Your turn:");
                do {
                    input = sc.nextInt();
                    if(input < 1 || input >9){
                        System.out.println("Enter number from 1-9");
                    }
                }while(input < 1 || input >9);

                game.insert(input);

                //ΝΑ ΖΗΤΑΕΙ ΑΛΛΟ ΚΟΥΤΙ ΑΝ ΕΙΝΑΙ ΓΕΜΑΤΟ
                //do while δεν ειναι filled

                game.insert(input);
                game.show(); //shows the current board
                if(game.hasMoves()) { //checks whether the game has ended or not
                    game.move(); //PC's turn
                    game.show(); //shows the current board
                }
            }
        }

    }
}
