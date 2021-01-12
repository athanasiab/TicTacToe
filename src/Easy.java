import java.util.Random;

public class Easy extends Mode{
    Random random = new Random();

    public Easy(){
    }

    public void move(){ //returns the index of the array that corresponds to the box
        if(!b.full() && b.state() != -1) {
            int box;
            box = random.nextInt(9) + 1;
            while (b.filled(box)) {
                box = random.nextInt(9) + 1;
            }
            b.insert(box, 2);
        }else{
            System.out.println("All boxes are filled.");
            if(b.state() == 1) {
                System.out.print("You won!");
                end = true;
            }else if(b.state() == 2){
                System.out.print("You lost...");
                end = true;
            }else{
                System.out.print("It's a tie.");
                end = true;
            }
        }
    }
}
