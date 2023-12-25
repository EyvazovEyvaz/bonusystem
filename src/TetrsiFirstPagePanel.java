import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TetrsiFirstPagePanel extends JPanel {

    public static final int FRAME_WIGHT = 700;
    public static final int FRAME_HEIGHT = 600;

    int f1x1 = 100;
    int f1x2 = 125;
    int f1y1 = 0;
    int f1y2 = 25;
    int f1y3 = 50;

    int f2x1 =180;
    int f2x2 =205;
    int f2x3 =230;
    int f2y1 =0;
    int f2y2 =25;

    int f3x1 = 290;
    int f3y1 = 0;
    int f3y2 = 25;
    int f3y3 = 50;

    int f4x1 = 350;
    int f4x2 = 375;
    int f4y1 = 0;
    int f4y2 = 25;
    int f4y3 = 50;

    int f5x1 = 440;
    int f5x2 = 465;
    int f5y1 = 0;
    int f5y2 = 25;

    int f6x1 = 530;
    int f6x2 = 555;
    int f6x3 = 505;
    int f6y1 = 0;
    int f6y2 = 25;
    TetrsiFirstPagePanel(){
        this.setBounds(0,0,FRAME_WIGHT,FRAME_HEIGHT);
        this.setVisible(true);
        this.setBackground(Color.white);
        this.setLayout(null);
    }

    public void firstPageStyle(){

        JLabel jLabel2 = new JLabel("TETRIS GAME");
        jLabel2.setBounds(100,0,500,100);
        jLabel2.setFont(new Font("BOLD",Font.BOLD,70));
        jLabel2.setForeground(Color.white);
        this.add(jLabel2);
        this.setLayout(null);


    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        BufferedImage image;
        try {
            image = ImageIO.read(new File("C:\\Users\\eyvaz\\Downloads\\12c0eeefc4fee15918d79b034d0e068a.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(image, -10, 100, this);

         f1x1 +=50;
         f1x2 +=50;
         f1y1 +=50;
         f1y2 +=50;
         f1y3 +=50;
        g.fillRect(f1x1,f1y1,25,25);
        g.fillRect(f1x1,f1y2,25,25);
        g.fillRect(f1x1,f1y3,25,25);
        g.fillRect(f1x2,f1y3,25,25);
        g.setColor(new Color(234,67,53));

         f2x1 +=50;
         f2x2 +=50;
         f2x3 +=50;
         f2y1 +=50;
         f2y2 +=50;
        g.fillRect(f2x1,f2y1,25,25);
        g.fillRect(f2x2,f2y1,25,25);
        g.fillRect(f2x3,f2y1,25,25);
        g.fillRect(f2x2,f2y2,25,25);
        g.setColor(new Color(52,168,83));

         f3x1 +=50;
         f3y1 +=50;
         f3y2 +=50;
         f3y3 +=50;
        g.fillRect(f3x1,f3y1,25,25);
        g.fillRect(f3x1,f3y2,25,25);
        g.fillRect(f3x1,f3y3,25,25);
        g.setColor(new Color(255,109,1));

         f4x1 -=50;
         f4x2 -=50;
         f4y1 +=50;
         f4y2 +=50;
         f4y3 +=50;
        g.fillRect(f4x1,f4y1,25,25);
        g.fillRect(f4x1,f4y2,25,25);
        g.fillRect(f4x2,f4y2,25,25);
        g.fillRect(f4x2,f4y3,25,25);
        g.setColor(new Color(70,189,198));

         f5x1 -=50;
         f5x2 -=50;
         f5y1 +=50;
         f5y2 +=50;
        g.fillRect(f5x1,f5y1,25,25);
        g.fillRect(f5x2,f5y1,25,25);
        g.fillRect(f5x1,f5y2,25,25);
        g.fillRect(f5x2,f5y2,25,25);
        g.setColor(new Color(0,255,0));

         f6x1 -=50;
         f6x2 -=50;
         f6x3 -=50;
         f6y1 +=50;
         f6y2 +=50;
        g.fillRect(f6x1,f6y1,25,25);
        g.fillRect(f6x2,f6y1,25,25);
        g.fillRect(f6x3,f6y2,25,25);
        g.fillRect(f6x1,f6y2,25,25);
        g.setColor(new Color(0,0,255));
        g.setColor(Color.gray);


        try {
            Thread.sleep(200);
            this.setBackground(Color.blue);
            firstPageStyle();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        repaint();
    }
}
