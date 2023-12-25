import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;

public class TetrisPanel extends JPanel {
    public static final int FRAME_WIGHT = 400;
    public static final int FRAME_HEIGHT = 550;
    public static final int UNIC = 25;
    public static final int col = FRAME_WIGHT/UNIC;
    public static final int row = FRAME_HEIGHT/UNIC;

    public static final int[][][][] T = {//TTTT
                                        { {{1,0,0},{1,1,0},{1,0,0}}, {{0,0,0},{0,1,0},{1,1,1}}, {{0,0,1},{0,1,1},{0,0,1}}, {{1,1,1},{0,1,0},{0,0,0}},},
                                        //LLLL
                                        { {{1,1,1},{0,0,1},{0,0,0}}, {{0,0,1},{0,0,1},{0,1,1}}, {{0,0,0},{1,0,0},{1,1,1}}, {{0,1,1},{0,0,1},{0,0,1}},},
                                        //ZZZZ
                                        { {{1,0,0},{1,1,0},{0,1,0}}, {{0,0,0},{0,1,1},{1,1,0}}, {{0,0,0},{0,0,0},{0,0,0}}, {{0,0,0},{0,0,0},{0,0,0}}},
                                        ///SSSS
                                        { {{0,1,0},{1,1,0},{1,0,0}}, {{1,1,0},{0,1,1},{0,0,0}}, {{0,0,0},{0,0,0},{0,0,0}}, {{0,0,0},{0,0,0},{0,0,0}}},
                                        //OOOO
                                        { {{1,1,0},{1,1,0},{0,0,0}}, {{0,0,0},{0,0,0},{0,0,0}}, {{0,0,0},{0,0,0},{0,0,0}}, {{0,0,0},{0,0,0},{0,0,0}}},
                                        //IIII
                                        { {{1,1,1},{0,0,0},{0,0,0}}, {{1,0,0},{1,0,0},{1,0,0}}, {{0,0,0},{0,0,0},{0,0,0}}, {{0,0,0},{0,0,0},{0,0,0}}},

                                        };
    static int y=-25;
    static int x=0;
    public static boolean rotateCheck = false;
    public static int rotate = 0;
    static int rnd = 0;
    static boolean check = false;
    static boolean pause_cont = true;
    static boolean pause_cont2 = false;
    static int getX = 0;
    static int getY = 0;

    int count = 0;
   static int rand;
    ArrayList<Integer> all = new ArrayList<>();
    ArrayList<Integer> coordXY = new ArrayList<>();
    TetrisPanel(){
        this.setBounds(0,0,FRAME_WIGHT,FRAME_HEIGHT);
        this.setVisible(true);
        this.setLayout(null);
       // thrEad();

    }
    public static void thrEad(){
            try {
                Thread.sleep(10);
                Y();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

    }
    public static void Y() {
        if (pause_cont) return;
        if (y == 500) {
            pause_cont2=true;
            y = -25;
            rotate = 0;
            rnd = rand;
        } else {
            if (y==-25){
                randommm();
            }
            pause_cont2=false;
            check = true;
            y += 25;
        }
    }
    public static int randommm(){
        Random random = new Random();
        rand = random.nextInt(0,6);
        return rand;
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        /// Goruntu şəkil
        BufferedImage image0;

        try {
            image0 = ImageIO.read(new File("C:\\Users\\eyvaz\\OneDrive\\Desktop\\images\\x.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image img0 = image0.getScaledInstance(getWidth(),getHeight(),5);
        g.drawImage(img0,0,0,this);


        //// Goruntu setka

        /// Goruntu tetris elemnti və hərəkət

        // Rotasiya yoxlanisi
        new TetrisScorePanel(rand);

        if (rotateCheck){
            rotateCheck = false;
        }
        if (rnd==4){
            rotate=0;
        } else if (rnd==5 && rotate==2){
            rotate=0;
        } else if (rnd==3 && rotate==2 ){
            rotate=0;
        } else if (rnd==2 && rotate==2 ){
            rotate=0;
        } else if (rnd==0 && rotate==4){
            rotate=0;
        }else if (rnd==5 && rotate==3) {
            rotate = 0;
        }

        if (rotate==4 ||rotate==5||rotate==6||rotate==7){
            rotate = 0;
        }
        /// elementlərin aşağı və sağa sola hərəkəti üçün hər bir dasi hərəkət etməlidir.
        /// burda koordinatlar dəyişdikcə (Thread ilə) repaint() metodu çox önəmlidir.
        if (y==475){
            count++;
            all.add(rnd);
            all.add(rotate);
        }
        for(int i=0; i<T[4].length-1; i++){
            for (int j=0; j<T[4][0][0].length; j++){
                if (T[rnd][rotate][i][j] !=0){
                    switch (rnd) {
                        case 0 -> g.setColor(new Color(31, 82, 5));
                        case 1 -> g.setColor(new Color(255, 109, 1));
                        case 2 -> g.setColor(new Color(0, 255, 255));
                        case 3 -> g.setColor(new Color(0, 255, 0));
                        case 4 -> g.setColor(new Color(0, 0, 255));
                        case 5 -> g.setColor(new Color(255, 0, 0));
                    }
                    getX = i*UNIC+6*UNIC+x;
                    getY = j*UNIC+y;
                    if (y==475) {
                        all.add(getX);
                        all.add(getY);
                    }
                    g.fill3DRect(getX,getY, UNIC,UNIC,true);

                }
            }
        }

        /*for(int i=-1; i<=col; i++){
            for(int j=-1; j<=row; j++){
                g.drawRect(i*UNIC, j*UNIC, UNIC,UNIC);
                g.setColor(Color.cyan);
            }
        }*/

        if (pause_cont && TetrisScorePanel.v!=0){
            g.setColor(Color.RED);
            g.drawString("PAUSA",200,200);
            g.setFont(new Font("Bold",Font.PLAIN,5));
        }

        thrEad();
        repaint();


        /// hər dəfə elementlər sərhədə və ya digər element sərhədinə çatdıqda stop edliməlidir burda
        /// və növbəti başlamalıdır.
        /// random tipini arrayda saxla
        /// rotate hansi formadir arrayde saxla
        /// formanin her bir dasi ucun getX ve getY koordinatlari hansi olub son halinda onu saxla arrayda
        /// bu koordinatlarda, bu tip və forma ucun yenidən stabil rəngləmə etsin
        /// hər dəfə thread işləyəndə (artım edəndə y) bu rəngləmə bu arraylar ucun davam etsinki, daimi gorunurluluk olsun


    }

}
