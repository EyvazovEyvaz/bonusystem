import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.font.TextHitInfo;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TetrisFrame extends JFrame {

    public static final int FRAME_WIGHT = 800;
    public static final int FRAME_HEIGHT = 700;

    TetrisFrame(){
        this.pack();
        this.setSize(FRAME_WIGHT,FRAME_HEIGHT);
        this.setTitle("EYVAZ_TETRIS_GAME");
        JLabel jLabel;
        try {
             jLabel = new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\eyvaz\\Downloads\\Emma Howitt Illus_ on X.jpg"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.setContentPane(jLabel);
        this.getContentPane().setBackground(new Color(11,3,37));
        //Image img0 = image0.getScaledInstance(getWidth(), getHeight(), 5);
        this.add(new TetrisPanel());
        this.add(new TetrisScorePanel(0));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
