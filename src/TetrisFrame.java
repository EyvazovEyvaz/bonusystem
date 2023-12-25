import javax.swing.*;
import java.awt.*;
import java.awt.font.TextHitInfo;

public class TetrisFrame extends JFrame {

    public static final int FRAME_WIGHT = 700;
    public static final int FRAME_HEIGHT = 600;

    TetrisFrame(){
        this.pack();
        this.setSize(FRAME_WIGHT,FRAME_HEIGHT);
        this.setTitle("EYVAZ_TETRIS_GAME");
        this.add(new TetrisPanel());
        this.add(new TetrisScorePanel(0));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
