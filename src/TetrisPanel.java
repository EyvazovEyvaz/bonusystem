import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;
import java.util.List;

public class TetrisPanel extends JPanel {
    public static final int FRAME_WIGHT = 400;
    public static final int FRAME_HEIGHT = 550;
    public static final int UNIC = 25;
    public static final int col = FRAME_WIGHT / UNIC;
    public static final int row = FRAME_HEIGHT / UNIC;

    public static final int[][][][] T = {//TTTT
            {{{1, 0, 0}, {1, 1, 0}, {1, 0, 0}}, {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}, {{0, 0, 1}, {0, 1, 1}, {0, 0, 1}}, {{1, 1, 1}, {0, 1, 0}, {0, 0, 0}},},
            //LLLL
            {{{1, 1, 1}, {0, 0, 1}, {0, 0, 0}}, {{0, 0, 1}, {0, 0, 1}, {0, 1, 1}}, {{0, 0, 0}, {1, 0, 0}, {1, 1, 1}}, {{0, 1, 1}, {0, 0, 1}, {0, 0, 1}},},
            //ZZZZ
            {{{1, 0, 0}, {1, 1, 0}, {0, 1, 0}}, {{0, 0, 0}, {0, 1, 1}, {1, 1, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}},
            ///SSSS
            {{{0, 1, 0}, {1, 1, 0}, {1, 0, 0}}, {{1, 1, 0}, {0, 1, 1}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}},
            //OOOO
            {{{1, 1, 0}, {1, 1, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}},
            //IIII
            {{{1, 1, 1}, {0, 0, 0}, {0, 0, 0}}, {{1, 0, 0}, {1, 0, 0}, {1, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}},

    };
    String str0 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (5_0).png";
    String str1 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (5_1).png";
    String str2 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (5_2).png";
    String str3 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (5_3).png";
    String str4 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (5_4).png";
    String str5 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (5_5).png";
    static int y = -25;
    static int x = 0;
    public static boolean rotateCheck = false;
    public static int rotate = 0;
    static int rnd = 0;
    static boolean check = false;
    static boolean pause_cont = true;
    static boolean pause_cont2 = false;
    static int getX = 0;
    static int getY = 0;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    ArrayList<Integer> arrayListChild;
    static int rand;

    TetrisPanel() {
        this.setBounds(55, 50, FRAME_WIGHT, FRAME_HEIGHT);
        this.setVisible(true);
        this.setLayout(null);

    }

    public static void thrEad() {
        try {
            Thread.sleep(5);
            Y();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void Y() {
        if (pause_cont) return;
        if (y == 300) {
            pause_cont2 = true;
            y = -25;
            rotate = 0;
            rnd = rand;
            x = 0;
        } else {
            if (y == -25) {
                randommm();
            }
            pause_cont2 = false;
            check = true;
            y += 25;
        }
    }

    public static int randommm() {
        Random random = new Random();
        rand = random.nextInt(0, 6);
        return rand;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        /// Goruntu şəkil
        BufferedImage image0;

        try {
            image0 = ImageIO.read(new File("C:\\Users\\eyvaz\\OneDrive\\Desktop\\images\\x.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image img0 = image0.getScaledInstance(getWidth(), getHeight(), 5);
        g.drawImage(img0, 0, 0, this);


        new TetrisScorePanel(rand);

        if (rotateCheck) {
            rotateCheck = false;
        }
        if (rnd == 4) {
            rotate = 0;
        } else if (rnd == 5 && rotate == 2) {
            rotate = 0;
        } else if (rnd == 3 && rotate == 2) {
            rotate = 0;
        } else if (rnd == 2 && rotate == 2) {
            rotate = 0;
        } else if (rnd == 0 && rotate == 4) {
            rotate = 0;
        } else if (rnd == 5 && rotate == 3) {
            rotate = 0;
        }

        if (rotate == 4 || rotate == 5 || rotate == 6 || rotate == 7) {
            rotate = 0;
        }

        if (y == 300) {
            arrayListChild = new ArrayList<>();
            arrayListChild.add(rnd);
            arrayListChild.add(rotate);
        }

        for (int i = 0; i < T[4].length - 1; i++) {
            for (int j = 0; j < T[4][0][0].length; j++) {
                if (T[rnd][rotate][i][j] != 0) {
                    BufferedImage imagef = null;
                    switch (rnd) {
                        case 0 -> {
                            try {
                                imagef = ImageIO.read(new File(str0));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        case 1 -> {
                            try {
                                imagef = ImageIO.read(new File(str1));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        case 2 -> {
                            try {
                                imagef = ImageIO.read(new File(str2));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        case 3 -> {
                            try {
                                imagef = ImageIO.read(new File(str3));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        case 4 -> {
                            try {
                                imagef = ImageIO.read(new File(str4));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        case 5 -> {
                            try {
                                imagef = ImageIO.read(new File(str5));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    getX = i * UNIC + 6 * UNIC + x;
                    getY = j * UNIC + y;
                    g.drawImage(imagef, getX, getY, UNIC, UNIC, this);

                    if (y == 300) {
                        if (rnd == 1 && rotate == 0 || rotate == 1 || rotate == 2 || rotate == 3) {
                            getY -= 25;
                        }
                        if (rnd == 5 && rotate == 1) {
                            getY += 50;
                        }
                        if (rnd == 5 && rotate == 0) {
                            getY -= 25;
                        }
                        if (rnd == 0 && rotate == 3 /*||rotate==2*/) {
                            getY -= 25;
                        }
                        if (rnd == 2 && rotate == 0) {
                            //getY -=25;
                        }
                        if (rnd == 3 && rotate == 1) {
                            getY += 25;
                        }
                        if (rnd == 2 && rotate == 1) {
                            //getY -=25;
                        }
                        if (rnd == 3 && rotate == 1) {
                            getY -= 25;
                        }
                        arrayListChild.add(getX);
                        arrayListChild.add(getY);
                    }
                }
            }
        }

       /* for (int i = -1; i <= col; i++) {
            for (int j = -1; j <= row; j++) {
                g.drawRect(i * UNIC, j * UNIC, UNIC, UNIC);
                g.setColor(Color.cyan);
            }
        }*/

        if (pause_cont && TetrisScorePanel.v != 0) {
            g.setColor(Color.RED);
            g.drawString("PAUSA", 200, 200);
            g.setFont(new Font("Bold", Font.PLAIN, 5));
        }

        if (y == 300) {
            arrayList.add(arrayListChild);
        }

        try {
            musicPanel();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }

        paint2(g);
        thrEad();
        repaint();


    }

    public void musicPanel() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File file = new File("C:\\Users\\eyvaz\\Downloads\\f68c40b3-1185-46a3-82ff-4dc4ffb04942.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        FloatControl floatControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        if (y == 300) {
            floatControl.setValue(6.0f);
            clip.start();
        } else {
            clip.stop();
        }

    }

    public void paint2(Graphics g) {
        for (ArrayList<Integer> rr : arrayList) {
            BufferedImage imagef = null;
            int tX = 0;
            int tY = 0;
            for (int i = 0; i < T[4].length - 1; i++) {
                for (int j = 0; j < T[4][0][0].length; j++) {
                    if (T[rr.get(0)][rr.get(1)][i][j] != 0) {
                        switch (rr.get(0)) {
                            case 0 -> {
                                try {
                                    imagef = ImageIO.read(new File(str0));
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            case 1 -> {
                                try {
                                    imagef = ImageIO.read(new File(str1));
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            case 2 -> {
                                try {
                                    imagef = ImageIO.read(new File(str2));
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            case 3 -> {
                                try {
                                    imagef = ImageIO.read(new File(str3));
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            case 4 -> {
                                try {
                                    imagef = ImageIO.read(new File(str4));
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            case 5 -> {
                                try {
                                    imagef = ImageIO.read(new File(str5));
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                        tX += 2;
                        tY += 2;

                        g.drawImage(imagef, rr.get(tX), rr.get(tY + 1), UNIC, UNIC, this);

                    }
                }
            }
        }
    }

    /*public static boolean test() {

        for (ArrayList<Integer> tt : arrayList) {
            for (int i=0; i<tt.size(); i++){
                if (i%2==0 && tt.get(i) == getX && tt.get(i+1) == getY+25){
                    System.out.println("yes");
                    return true;
                }
            }
        }
        return false;
    }*/
    /*public static int test2() {

        int p = 0;
        p = y;
        for (ArrayList<Integer> tt : arrayList) {
            for (int i=0; i<tt.size(); i++){
                if (i!=0 && i%2==0 && tt.get(i) == getX && tt.get(i+1) == getY+50){
                    System.out.println("ttX: "+tt.get(i)+"--ttY: "+tt.get(i+1));
                    System.out.println("getX: "+getX+"--getY: "+getY);
                    p = getY;
                }
            }
        }
        return p;
    }*/
}
