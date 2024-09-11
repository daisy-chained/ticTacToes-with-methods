import nl.saxion.app.SaxionApp;

import java.awt.*;

public class Application implements Runnable {
    public static void main(String[] args) {
        SaxionApp.start(new Application(), 1024, 768);
    }

    public void run() {
        int move;
        int ticker = 0;
        int player = 1;
        int[] storage = new int[10];
        boolean gameOver = false;

        while (!gameOver && ticker<9) {
            SaxionApp.print("where");
            move = SaxionApp.readInt();
            //valid move check
            if (move < 1 || move > 9) {
                SaxionApp.printLine("invalid answer");}
            else if (storage[move] == 1 || storage[move] == 2)
                {SaxionApp.printLine("spot taken");}
            else{
                storage[move] = player;
                draw(storage);
                gameOver= winCon(storage,player);
                ticker++;
                if (player == 1) {player = 2;} else{player = 1;}
            }
            //doing conversion to accurate player selection
            // TODO figure out when player conversion can happen.
        }

        if (player == 1) {player = 2;} else{player = 1;}
        if(ticker == 9){SaxionApp.printLine("out of moves");}
        else{ SaxionApp.printLine("Player " + player + " won"); }

        SaxionApp.print("game over");

    }
    static void draw(int[] storage){
        int size = 100;
        SaxionApp.clear();
        SaxionApp.drawLine(150, 50, 150, 350);
        SaxionApp.drawLine(250, 50, 250, 350);
        SaxionApp.drawLine(50, 150, 350, 150);
        SaxionApp.drawLine(50, 250, 350, 250);
        SaxionApp.setTextDrawingColor(Color.black);
        SaxionApp.drawText("1",80,50,size);
        SaxionApp.drawText("2",180,50,size);
        SaxionApp.drawText("3",280,50,size);
        SaxionApp.drawText("4",80,150,size);
        SaxionApp.drawText("5",180,150,size);
        SaxionApp.drawText("6",280,150,size);
        SaxionApp.drawText("7",80,250,size);
        SaxionApp.drawText("8",180,250,size);
        SaxionApp.drawText("9",280,250,size);
        SaxionApp.setTextDrawingColor(Color.BLUE);
        SaxionApp.setFill(Color.BLUE);
        //todo refactor all of these if  statements to less lines

        if (storage[1] == 1) {SaxionApp.drawCircle(100, 100, 50);}
        if (storage[1] == 2) {SaxionApp.drawText("x", 80, 50, size);}

        if (storage[2] == 1) {SaxionApp.drawCircle(200, 100, 50);}
        if (storage[2] == 2) {SaxionApp.drawText("x", 180, 50, size);}

        if (storage[3] == 1) {SaxionApp.drawCircle(300, 100, 50);}
        if (storage[3] == 2) {SaxionApp.drawText("x", 280, 50, size);}

        if (storage[4] == 1) {SaxionApp.drawCircle(100, 200, 50);}
        if (storage[4] == 2) {SaxionApp.drawText("x", 80, 150, size);}

        if (storage[5] == 1) {SaxionApp.drawCircle(200, 200, 50);}
        if (storage[5] == 2) {SaxionApp.drawText("x", 180, 150, size);}

        if (storage[6] == 1) {SaxionApp.drawCircle(300, 200, 50);}
        if (storage[6] == 2) {SaxionApp.drawText("x", 280, 150, size);}

        if (storage[7] == 1) {SaxionApp.drawCircle(100, 300, 50);}
        if (storage[7] == 2) {SaxionApp.drawText("x", 80, 250, size);}

        if (storage[8] == 1) {SaxionApp.drawCircle(200, 300, 50);}
        if (storage[8] == 2) {SaxionApp.drawText("x", 180, 250, size);}

        if (storage[9] == 1) {SaxionApp.drawCircle(300, 300, 50);}
        if (storage[9] == 2) {SaxionApp.drawText("x", 280, 250, size);}

    }
    public Boolean winCon(int[] storage, int player){

        //lines
        if (storage[1] == player && storage[2] == player && storage[3] == player) {return true;}
        if (storage[4] == player && storage[5] == player && storage[6] == player) {return true;}
        if (storage[7] == player && storage[8] == player && storage[9] == player) {return true;}
        //diag
        if (storage[1] == player && storage[5] == player && storage[9] == player) {return true;}
        if (storage[3] == player && storage[5] == player && storage[7] == player) {return true;}
        //collumns
        if (storage[1] == player && storage[4] == player && storage[7] == player) {return true;}
        if (storage[2] == player && storage[5] == player && storage[8] == player) {return true;}
        if (storage[3] == player && storage[6] == player && storage[9] == player) {return true;}
            return false;
    }}






