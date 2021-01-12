public class Hard extends Mode{
    Board b = new Board();
    boolean end = false; //indicates whether the game has ended or not

    public Hard(){
    }

    public void insert(int box){ //inserts the input of the player
        b.insert(box, 1);
    }

    public void move(){ //returns the index of the array in that corresponds to the box
        int box;
        box = choose();
        while (b.filled(box)){
            box = choose();
        }
        b.insert(box, 2);
    }

    private int choose(){ //picks the box that is better strategically
        int box;

        if(!b.full() && b.state() != -1) {


            //ΣΥΝΘΗΚΕΣ
            //ΧΡΗΣΗ ΤΩΝ GETS


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
        return box;
    }

    public boolean hasMoves(){ //the game hasn't ended
        return end;
    }

    public void show(){ //calls Show from Board
        b.Show();
    }
}

