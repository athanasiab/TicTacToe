public abstract class Mode {
    Board b = new Board();
    boolean end = false; //indicates whether the game has ended or not

    public Mode() {
    }

    public void insert(int box){ //inserts the input of the player
        b.insert(box, 1);
    }

    public abstract void move();

    public void show(){ //calls Show from Board
        b.Show();
    }

    public boolean filled(int box) {
        return b.filled(box);
    }

    public boolean hasMoves(){ //the game hasn't ended
        return end;
    }
}