import java.util.ArrayList;
import java.util.Random;

public class Hard extends Mode{
    Random random = new Random();

    public Hard(){
    }

    public void move(){ //returns the index of the array in that corresponds to the box
        int box;
        box = choose();
        if(!b.full() && b.state() != -1) {
            while (b.filled(box)) {
                box = choose();
            }
            b.insert(box, 2);
        }else{
            System.out.println("All boxes are filled.");
            if(b.state() == 1) {
                System.out.print("You won!");
            }else if(b.state() == 2){
                System.out.print("You lost...");
            }else{
                System.out.print("It's a tie.");
            }
        }
    }

    private int choose(){ //picks the box that is better strategically
        int box;
        ArrayList<Integer> moves1 = b.getMoves1();
        ArrayList<Integer> moves2 = b.getMoves2();
        //code to check if the player will win on the next move
        box = nextMove(moves1);
        if (box != -1){
            moves1.remove(moves1.size() - 1);
            return box;
        }else{
            moves1.remove(moves1.size() - 1);
        }
        //code to check if it will win on the next move
        box = nextMove(moves2);
        if (box != -1){
            moves2.remove(moves2.size() - 1);
            return box;
        }else{
            moves2.remove(moves2.size() - 1);
        }
        //else will fill the center box or a corner on
        if (!b.filled(5)){
            return 5;
        } else if(!b.filled(1)){
            return 1;
        } else if(!b.filled(3)){
            return 3;
        }else if(!b.filled(7)){
            return 7;
        }else if(!b.filled(9)){
            return 9;
        }
        box = random.nextInt(9) + 1;
        while (b.filled(box)) {
            box = random.nextInt(9) + 1;
        }
        return box;
    }

    private int nextMove(ArrayList<Integer> moves){
        int box = -1;
        boolean stop = false;

        for(int i = 0; i < 9 && !stop; i++) {
            moves.add(i + 1);
            if(!b.filled(moves.get(moves.size() - 1))){ //box is not already filled
                if(b.win(moves)){
                    stop = true;
                    box = i + 1;
                }
            }
            moves.remove(moves.size() - 1);
        }
        return box;
    }
}

