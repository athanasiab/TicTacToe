public class Hard extends Mode{
    public Hard(){
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
}

