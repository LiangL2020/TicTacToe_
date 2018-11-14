import java.awt.*;

/**
 * Created by student on 11/16/17.
 */
public class Game {

    private int[][] gr;

    public Game(){
        gr = new int[3][3];
    }

    public void draw(Graphics2D g2, int w, int h){
        for (int r = 0; r < gr.length; r++) {
            for (int c = 0; c < gr[0].length; c++) {
                g2.drawRect(w/3*r, h/3*c, w/3, h/3);
//                gr[r][c] = 0;
            }
        }
    }

    public int[][] getGr() {
        return gr;
    }

    public boolean checkIfWin(){ //DID NOT FINISH!!!!
//        for (int r = 0; r < gr.length; r++) {
//            for (int c = 0; c < gr[0].length; c++) {
//                if(gr[r][c] == gr[r][c+1] && gr[r][c+1] == gr[r][c+2] && gr[r][c] != 0){
////                    return gr[r][c];
//                    return true;
//                }else if(gr[r][c] == gr[r+1][c] && gr[r+1][c] == gr[r+2][c] && gr[r][c] != 0){
//                    return true;
//
//            }
//        }

        for (int r = 0; r < gr.length; r++) {
            if (gr[r][0] == gr[r][1] && gr[r][1] == gr[r][2] && gr[r][0] != 0) {
//                    return gr[r][c];
                return true;
            }
        }
        for (int c = 0; c < gr[0].length; c++) {
            if (gr[0][c] == gr[1][c] && gr[1][c] == gr[2][c] && gr[0][c] != 0) {
                return true;
            }
        }

        if(gr[0][0] == gr[1][1] && gr[1][1] == gr[2][2] && gr[0][0] != 0){
            return true;
        }
        if(gr[0][2] == gr[1][1] && gr[1][1] == gr[2][0] && gr[0][2] != 0){
            return true;
        }
        return false;
    }

    public boolean checkIfTie(){
        for (int r = 0; r < gr.length; r++) {
            for (int c = 0; c < gr[0].length; c++) {
                if(gr[r][c] == 0){
                    return false;
                }
            }
        }
        return true;
    }
}

