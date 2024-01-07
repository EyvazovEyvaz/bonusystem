
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class TetrisScorePanel extends JPanel {
    public static final int FRAME_SCORE_WIGHT = 250;
    public static final int FRAME_SCORE_HEIGHT = 550;
    public static final int UNICS = 25;
    public static final int colS = FRAME_SCORE_WIGHT / 25;
    public static final int rowS = 4;
    public static final int allbuttonsSize = 50;

    public static final int UNIC = 25;
    static int p = 0;
    static int v = 0;
    public static int rnd = 0;
    public int x = 10;
    static int ch = 0;
    static int strt = 0;

    static Clip clip;

    static boolean checkReset = false;
    static int checkSpeed = 0;

    JButton buttonRight, buttonLeft,buttonDown, buttonReset, buttonRotate, buttonResume;

   static int clrs1;
   static int clrs2;
   static int clrs3;

    Random randomColors = new Random();
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

    TetrisScorePanel(int random) {
        this.setBounds(475, 50, FRAME_SCORE_WIGHT, FRAME_SCORE_HEIGHT);
        this.setBackground(Color.white);
        this.setLayout(null);
        scoreLabel();
        score();
        commandbuttonsStartResume();
        this.setFocusable(true);
        this.setVisible(true);
        rnd = random;
    }

    public void scoreLabel() {

        JLabel jLabelScore = new JLabel("SCORE");
        jLabelScore.setBounds(20, 0, 200, 50);
        jLabelScore.setFont(new Font("BOLD", Font.BOLD, 20));
        jLabelScore.setForeground(Color.white);
        this.add(jLabelScore);
        this.setLayout(null);

        JLabel next = new JLabel("NEXT");
        next.setBounds(20, 70, 100, 50);
        next.setFont(new Font("BOLD", Font.BOLD, 20));
        next.setForeground(Color.red);
        this.add(next);
        this.setLayout(null);

    }

    public void score() {

        JLabel scoreL = new JLabel();
        scoreL.setText("0");
        scoreL.setBounds(160, -10, 100, 100);
        scoreL.setFont(new Font("BOLD", Font.BOLD, 60));
        scoreL.setForeground(Color.white);
        this.add(scoreL);
        this.setLayout(null);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        BufferedImage image0;

        try {
            image0 = ImageIO.read(new File("C:\\Users\\eyvaz\\Downloads\\Screenshot_20240105_153643_Gallery.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       // Image img0 = image0.getScaledInstance(getWidth(), getHeight(), 5);
        g.drawImage(image0, 0, 0, this);


        /*ufferedImage image, image2;
        try {
            image = ImageIO.read(new File("C:\\Users\\eyvaz\\OneDrive\\Desktop\\images\\22.png"));
            image2 = ImageIO.read(new File("C:\\Users\\eyvaz\\Downloads\\Solid_white_bordered.svg.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image img = image.getScaledInstance(250,150,5);
        g.drawImage(img,0,75,this);

        Image img2 = image2.getScaledInstance(250,60,5);
        g.drawImage(img2,0,10,this);*/
        /*for(int i=-1; i<=colS; i++){
            for(int j=-1; j<=rowS; j++){
                g.drawRect(i*UNICS, j*UNICS+100, UNICS,UNICS);
                g.setColor(Color.white);
            }
        }*/
        String str0 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (9_5).png";
        String str1 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (9_2).png";
        String str2 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (9_3).png";
        String str3 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (9_6).png";
        String str4 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (9_4).png";
        String str5 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (9_!).png";

        for (int i = 0; i < T[4].length - 1; i++) {
            for (int j = 0; j < T[4][0][0].length; j++) {
                if (T[rnd][0][i][j] != 0) {
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
                    g.drawImage(imagef, i * UNIC + 4 * UNIC + x, j * UNIC + 125, UNIC, UNIC, this);
                }
            }
        }

        if (!TetrisPanel.pause_cont) {
            try {
                x -= 23;
                Thread.sleep(0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (x < -170) {
            x = 100;
        }
        checkIsGameOver(g);

        repaint();
    }

    public void commandbuttonsRights() {
        buttonRight = new JButton();
        buttonRight.setBounds(150, 300, allbuttonsSize, allbuttonsSize);
        buttonRight.setBackground(Color.black);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\eyvaz\\Downloads\\tetris (2).png");
        Image image = imageIcon.getImage();
        Image img = image.getScaledInstance(buttonRight.getWidth(), buttonRight.getHeight(), 5);
        buttonRight.setIcon(new ImageIcon(img));
        this.add(buttonRight);

        buttonRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!TetrisPanel.pause_cont && TetrisScorePanel.v != 0) {
                    int m1 = 175;
                    if (TetrisPanel.rnd == 1 || TetrisPanel.rnd == 4 || TetrisPanel.rotate == 1) {
                        m1 += 25;
                    }
                    if (TetrisPanel.rnd == 5 && TetrisPanel.rotate == 0) {
                        m1 += 50;
                    }
                    if (TetrisPanel.rnd == 5 && TetrisPanel.rotate == 1) {
                        m1 -= 25;
                    }
                    if (TetrisPanel.rnd == 2 && TetrisPanel.rotate == 1) {
                        m1 -= 25;
                    }
                    if (TetrisPanel.x < m1 && !TetrisPanel.testRight())
                        TetrisPanel.x += 25;
                }

            }
        });

    }

    public void commandbuttonsLefts() {
        buttonLeft = new JButton();
        buttonLeft.setBounds(30, 300, allbuttonsSize, allbuttonsSize);
        buttonLeft.setBackground(Color.black);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\eyvaz\\Downloads\\block.png");
        Image image = imageIcon.getImage();
        Image img = image.getScaledInstance(buttonLeft.getWidth(), buttonLeft.getHeight(), 5);
        buttonLeft.setIcon(new ImageIcon(img));
        this.add(buttonLeft);

        buttonLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!TetrisPanel.pause_cont && TetrisScorePanel.v != 0) {

                    int n1 = -150;
                    if (TetrisPanel.rnd == 2 || TetrisPanel.rnd == 0 && TetrisPanel.rotate == 1) {
                        n1 -= 25;
                    }
                    if (TetrisPanel.rnd == 1 && TetrisPanel.rotate == 2) {
                        n1 -= 25;
                    }/*if (TetrisPanel.rnd==5 && TetrisPanel.rotate==1){
                        n1 -=50;*/
                    if (TetrisPanel.rnd == 2 && TetrisPanel.rotate == 0) {
                        n1 += 25;
                    }
                    if (TetrisPanel.x > n1 && !TetrisPanel.testLeft())
                        TetrisPanel.x -= 25;

                }

            }
        });

    }

    public void commandbuttonsDown() {
        buttonDown = new JButton();
        buttonDown.setBounds(90, 360, allbuttonsSize, allbuttonsSize);
        buttonDown.setBackground(Color.black);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\eyvaz\\Downloads\\tetris (3).png");
        Image image = imageIcon.getImage();
        Image img = image.getScaledInstance(buttonDown.getWidth(), buttonDown.getHeight(), 5);
        buttonDown.setIcon(new ImageIcon(img));
        this.add(buttonDown);

        buttonDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /*if (checkSpeed==0){
                    checkSpeed = 1;
                    TetrisPanel.speed = 0;
                } else if (checkSpeed==1) {
                    checkSpeed = 0;
                    TetrisPanel.speed = 80;
                }*/
                TetrisPanel.speed = 0;

            }
        });
    }

    public void commandbuttonsReset() {
        buttonReset = new JButton();
        buttonReset.setBounds(150, 420, allbuttonsSize, allbuttonsSize);
        buttonReset.setBackground(Color.black);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\eyvaz\\Downloads\\tetris (4).png");
        Image image = imageIcon.getImage();
        Image img = image.getScaledInstance(buttonReset.getWidth(), buttonReset.getHeight(), 5);
        buttonReset.setIcon(new ImageIcon(img));
        this.add(buttonReset);

        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!TetrisPanel.pause_cont && TetrisScorePanel.v != 0){
                    TetrisPanel.arrayList = new ArrayList<>();
                    TetrisPanel.rnd = TetrisPanel.randommm();
                    TetrisPanel.y = -25;
                    checkReset = true;
                }
            }
        });

    }

    public void commandbuttonsStartResume() {
        buttonResume = new JButton();
        buttonResume.setBounds(30, 420, allbuttonsSize, allbuttonsSize);
        buttonResume.setBackground(Color.black);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\eyvaz\\Downloads\\tetris.png");
        Image image = imageIcon.getImage();
        Image img = image.getScaledInstance(buttonResume.getWidth(), buttonResume.getHeight(), 5);
        buttonResume.setIcon(new ImageIcon(img));

        buttonResume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                v = 1;
                buttonsAdd();
                if (p == 0) {
                    TetrisScorePanel.p++;
                    TetrisPanel.pause_cont = false;
                    buttonResume.setBackground(Color.white);
                    try {
                        music();
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                        throw new RuntimeException(ex);
                    }
                } else if (p == 1) {
                    TetrisScorePanel.p--;
                    buttonResume.setBackground(Color.blue);
                    TetrisPanel.pause_cont = true;
                    clip.stop();
                }

            }
        });

        this.add(buttonResume);
    }

    public static void music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File file = new File("C:\\Users\\eyvaz\\Downloads\\0386bb84-04b1-4ce2-a2d0-fc5b9dcefa16.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        FloatControl floatControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        floatControl.setValue(-16.6f);
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

    public void commandButtonsRotate() {
        buttonRotate = new JButton();
        buttonRotate.setBounds(30, 240, allbuttonsSize, allbuttonsSize);
        buttonRotate.setBackground(Color.black);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\eyvaz\\Downloads\\tetris (8).png");
        Image image = imageIcon.getImage();
        Image img = image.getScaledInstance(buttonRotate.getWidth(), buttonRotate.getHeight(), 5);
        buttonRotate.setIcon(new ImageIcon(img));

        buttonRotate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!TetrisPanel.pause_cont && TetrisScorePanel.v != 0) {
                    TetrisPanel.rotateCheck = true;
                    TetrisPanel.rotate++;
                }
            }
        });

        this.add(buttonRotate);

    }

    public void buttonsAdd (){

            commandbuttonsRights();
            commandbuttonsLefts();
            commandbuttonsDown();
            commandbuttonsReset();
            commandButtonsRotate();
    }

    public void checkIsGameOver(Graphics g){

        if (TetrisPanel.gameOver()){

            buttonResume.setEnabled(false);


            this.remove(buttonRight);
            this.remove(buttonLeft);
            this.remove(buttonDown);
            this.remove(buttonReset);
            this.remove(buttonRotate);

        }
            clrs1 = randomColors.nextInt(0, 255);
            clrs2 = randomColors.nextInt(0, 255);
            clrs3 = randomColors.nextInt(0, 255);

        drawRectPermanent(g);
    }
    public void drawRectPermanent(Graphics g){


            g.drawRect(150, 300, allbuttonsSize, allbuttonsSize);
            g.setColor(new Color(clrs1,clrs2,clrs3));
            g.drawRect(30, 300, allbuttonsSize, allbuttonsSize);
            g.setColor(new Color(clrs1,clrs2,clrs3));
            g.drawRect(90, 360, allbuttonsSize, allbuttonsSize);
            g.setColor(new Color(clrs1,clrs2,clrs3));
            g.drawRect(150, 420, allbuttonsSize, allbuttonsSize);
            g.setColor(new Color(clrs1,clrs2,clrs3));
            g.drawRect(30, 420, allbuttonsSize, allbuttonsSize);
            g.setColor(new Color(clrs1,clrs2,clrs3));
            g.drawRect(30, 240, allbuttonsSize, allbuttonsSize);
            g.setColor(new Color(clrs1,clrs2,clrs3));

    }
}
