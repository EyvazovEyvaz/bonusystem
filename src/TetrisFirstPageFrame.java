import javax.swing.*;

public class TetrisFirstPageFrame extends JFrame {

    public static final int FRAME_WIGHT = 700;
    public static final int FRAME_HEIGHT = 600;

    TetrisFirstPageFrame(){
        this.pack();
        this.setSize(FRAME_WIGHT,FRAME_HEIGHT);
        this.setTitle("EYVAZ_TETRIS_GAME");
        this.add(new TetrsiFirstPagePanel());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
    }
}
