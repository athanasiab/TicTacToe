import java.util.ArrayList;

public class Board {    //class that designs the board
    private final char[] b= new char[9];
    private final ArrayList<Integer> moves1 = new ArrayList<>(); //holds the
    private final ArrayList<Integer> moves2 = new ArrayList<>();

    public Board(){ //initialises the array so that it doesn't cause any issues
        for(int i = 0; i < 9; i++){
            b[i] = '0';
        }
    }

    public void Show(){ //Creates the visualisation of the board

        //ΠΩΣ ΝΑ ΦΤΙΑΧΝΕΙ ΤΟΝ ΠΙΝΑΚΑ

    }


    //Getters for Array Lists "moves" are used in "Hard" in order to PC choose the best move
    public ArrayList<Integer> getMoves1(){
        return moves1;
    }
    public ArrayList<Integer> getMoves2(){
        return moves2;
    }

    public void insert(int box, int player){ //fills a box
        if(box <= 9 && box >= 1) {
            if (player == 1) { //player = 1: user
                b[box-1] = 'X';
                moves1.add(box-1);
            }else{ //player = 2: PC
                b[box-1] = 'O';
                moves2.add(box-1);
            }
        }else{
            System.out.println("Wrong inputs. The box should be a number from 1 to 9");
        }
    }

    public boolean filled(int box){
        if (b[box-1] != '0'){
            return moves1.contains(box - 1) || (moves2.contains(box - 1));
        }
        return false;
    }

    public int state(){ //returns an integer that indicates the current state of the game
        int s = -1; //the game has not ended
        if (moves1.size() >= 3 || moves2.size() >= 3) {
            if (win(moves1)) {
                s = 1; //the player won
            } else if (win(moves2)) {
                s = 2; //the player lost
            } else if (tie()){
                s = 0; //the game is tied
            }
        }


        return s;
    }

    private boolean win(ArrayList<Integer> moves){ //checks if the player whose moves we add as a parameter has won
        if(moves.contains(1) && moves.contains(5) && moves.contains(9)){ //main diagonal
            return true;
        } else if(moves.contains(3) && moves.contains(5) && moves.contains(7)){ //secondary diagonal
            return true;
        } else if(moves.contains(1) && moves.contains(2) && moves.contains(3)){ //first row
            return true;
        } else if(moves.contains(4) && moves.contains(5) && moves.contains(6)){ //second row
            return true;
        } else if(moves.contains(7) && moves.contains(8) && moves.contains(9)){ //third row
            return true;
        } else if(moves.contains(1) && moves.contains(4) && moves.contains(7)){ //first column
            return true;
        } else //third column
            if(moves.contains(2) && moves.contains(5) && moves.contains(8)){ //second column
            return true;
        } else return moves.contains(3) && moves.contains(6) && moves.contains(9);
    }

    private boolean tie() { //checks for tie
        if (full()) { //all boxes have been filled
            return !win(moves1) && !win(moves2); //tie
        }
        return false; //there isn't a tie
    }

    public boolean full(){ //checks if the board is full
        return moves1.size() + moves2.size() == 9;
    }
}
