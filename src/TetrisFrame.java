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
        this.getContentPane().setBackground(new Color(11,3,37));
       /* BufferedImage image0;
        try {
            image0 = ImageIO.read(new File("C:\\Users\\eyvaz\\Downloads\\space4.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image img0 = image0.getScaledInstance(getWidth(), getHeight(), 5);
        this.add(new JLabel(new ImageIcon(img0)));*/
        this.add(new TetrisPanel());
        this.add(new TetrisScorePanel(0));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
