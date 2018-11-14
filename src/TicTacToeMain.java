import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by iang_lu on 11/16/17.
 */

//TODO: rewrite the win methods to actually say who wins or ties
public class TicTacToeMain extends JPanel{
    Game game;
    int turn;

//    private JFrame window
    private JButton re = new JButton("Restart");

    public TicTacToeMain(int w, int h){
        turn = 1;
        game = new Game();
        re.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game = new Game();
                repaint();
            }
        });

        add(re);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                int w = getWidth()/3;
                int h = getHeight()/3;

                int r = y / h;
                int c = x / w;

//                String p = "Player wins!";
//                String t = "It's a tie!";


                //1 x 2 O  0 blank
                if(game.getGr()[r][c] == 0) {
                    if (turn == 1) {
                        game.getGr()[r][c] = 1;
                    } else if (turn == 2) {
                        game.getGr()[r][c] = 2;
                    }
                    turnCounter();
                }
                repaint();

//                else if(false){
//                    if(game.checkIfWin() == false && game.checkIfTie() == false){
//                        if(game.getGr()[r][c] == 0) {
//                            if (turn == 1) {
//                                game.getGr()[r][c] = 1;
//                            } else if (turn == 2) {
//                                game.getGr()[r][c] = 2;
//                            }
//                            turnCounter();
//                        }
//                        repaint();
//                    }
//                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });



    } //NOT FINISHED!!!


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        game.draw(g2, getWidth(), getHeight());

        int w = getWidth()/3;
        int h = getHeight()/3;
        for (int r = 0; r < game.getGr().length; r++) {
            for (int c = 0; c < game.getGr()[0].length; c++) {
                if (game.getGr()[r][c] == 1){
                    g2.setStroke(new BasicStroke(3));
                    g2.setColor(new Color(99, 119, 159));
                    g2.drawLine(c*w, r*h, c*w+w, r*h+h);
                    g2.drawLine(c*w+w, r*h, c*w, r*h+h);
                }else if(game.getGr()[r][c] == 2){
                    g2.setStroke(new BasicStroke(3));
                    g2.setColor(new Color(185, 111, 82));
                    g2.drawOval(c*w, r*h, w, h);
                }
            }
        }


        if(game.checkIfWin() == true){
            g2.setColor(new Color(29, 9, 90));
            g2.setStroke(new BasicStroke(4));
            Font font = new Font("Verdana", Font.BOLD, 60);
            g2.setFont(font);
            g2.drawString("Player Whoever wins!", 35, 100);
        }else if(game.checkIfTie() == true){
            g2.setColor(new Color(82, 25,0));
            Font font = new Font("Verdana", Font.BOLD, 50);
            g2.setFont(font);
            g2.setStroke(new BasicStroke(4));
            g2.drawString("You are tied with whoever", 15, 100);
            g2.drawString("else you are playing with!", 15, 150);

        }

    }

    public void turnCounter(){
//        for (int r = 0; r < game.getGr().length; r++) {
//            for (int c = 0; c < game.getGr()[0].length; c++) {
//                if(turn == 1){
//                    game.getGr()[r][c] = 1;
//                    turn++;
//                }
//                else{
//                    game.getGr()[r][c] = 2;
//                    turn--;
//                }
//            }
//        }
        if(turn == 1)
            turn ++;
        else
            turn --;
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic Tac Toe Liang Lu");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        int width = 800;
        int height = 800;
        frame.setPreferredSize(new Dimension(width, height + 24));


        JPanel panel = new TicTacToeMain(width, height);
//        JButton restart = new JButton("Start a New Game");
        panel.setFocusable(true);
        panel.grabFocus();

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
