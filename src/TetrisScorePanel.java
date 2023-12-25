
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

public class TetrisScorePanel extends JPanel {
    public static final int FRAME_SCORE_WIGHT = 250;
    public static final int FRAME_SCORE_HEIGHT = 550;
    public static final int UNICS = 25;
    public static final int colS = FRAME_SCORE_WIGHT/25;
    public static final int rowS = 4;
    public static final int allbuttonsSize = 50;

    public static final int UNIC = 25;
    static int p = 0;
    static int v = 0;
    public static int rnd = 0;
    public int x = 10;
    static int strt = 0;
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
    TetrisScorePanel(int random){
        this.setBounds(420,0,FRAME_SCORE_WIGHT,FRAME_SCORE_HEIGHT);
        this.setBackground(Color.white);
        this.setLayout(null);
        scoreLabel();
        score();
        commandbuttonsRights();
        commandbuttonsLefts();
        commandbuttonsDown();
        commandbuttonsReset();
        commandbuttonsStartResume();
        commandButtonsRotate();
        this.setFocusable(true);
        this.setVisible(true);
        rnd = random;
    }
    public void move(){

    }
    public void scoreLabel(){

        JLabel jLabelScore = new JLabel("SCORE");
        jLabelScore.setBounds(20,0,200,50);
        jLabelScore.setFont(new Font("BOLD",Font.BOLD,20));
        jLabelScore.setForeground(Color.blue);
        this.add(jLabelScore);
        this.setLayout(null);

        JLabel next = new JLabel("NEXT");
        next.setBounds(20,70,100,50);
        next.setFont(new Font("BOLD",Font.BOLD,20));
        next.setForeground(Color.blue);
        this.add(next);
        this.setLayout(null);

    }
    public void score(){

        JLabel scoreL = new JLabel();
        scoreL.setText("0");
        scoreL.setBounds(160,-10,100,100);
        scoreL.setFont(new Font("BOLD",Font.BOLD,60));
        scoreL.setForeground(Color.blue);
        this.add(scoreL);
        this.setLayout(null);

    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);


        BufferedImage image0;

        try {
            image0 = ImageIO.read(new File("C:\\Users\\eyvaz\\OneDrive\\Desktop\\images\\x.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image img0 = image0.getScaledInstance(getWidth(),getHeight(),5);
        g.drawImage(img0,0,0,this);


        BufferedImage image, image2;
        try {
            image = ImageIO.read(new File("C:\\Users\\eyvaz\\OneDrive\\Desktop\\images\\22.png"));
            image2 = ImageIO.read(new File("C:\\Users\\eyvaz\\Downloads\\Solid_white_bordered.svg.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image img = image.getScaledInstance(250,150,5);
        g.drawImage(img,0,75,this);

        Image img2 = image2.getScaledInstance(250,60,5);
        g.drawImage(img2,0,10,this);
        for(int i=-1; i<=colS; i++){
            for(int j=-1; j<=rowS; j++){
                g.drawRect(i*UNICS, j*UNICS+100, UNICS,UNICS);
                g.setColor(Color.white);
            }
        }


        for(int i=0; i<T[4].length-1; i++){
            for (int j=0; j<T[4][0][0].length; j++){
                if (T[rnd][0][i][j] !=0){
                    switch (rnd) {
                        case 0 -> g.setColor(new Color(31, 82, 5));
                        case 1 -> g.setColor(new Color(255, 109, 1));
                        case 2 -> g.setColor(new Color(0, 255, 255));
                        case 3 -> g.setColor(new Color(0, 255, 0));
                        case 4 -> g.setColor(new Color(0, 0, 255));
                        case 5 -> g.setColor(new Color(255, 0, 0));
                    }
                    g.fill3DRect(i*UNIC+4*UNIC+x,j*UNIC+125, UNIC,UNIC,true);
                }
            }
        }
        if (!TetrisPanel.pause_cont){
            try {
                x -=23;
                Thread.sleep(0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (x<-170){
            x=100;
        }
        System.out.println(x);
        repaint();
    }

    public void commandbuttonsRights(){
        JButton buttonRight = new JButton();
        buttonRight.setBounds(150,300,allbuttonsSize,allbuttonsSize);
        buttonRight.setBackground(Color.white);
        this.add(buttonRight);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\eyvaz\\Downloads\\tetris (2).png");
        Image image = imageIcon.getImage();
        Image img = image.getScaledInstance(buttonRight.getWidth(),buttonRight.getHeight(),5);
        buttonRight.setIcon(new ImageIcon(img));
        this.add(buttonRight);

        buttonRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!TetrisPanel.pause_cont && TetrisScorePanel.v!=0){
                    TetrisPanel.x +=25;
                }

            }
        });

    }
    public void commandbuttonsLefts(){
        JButton buttonLeft = new JButton();
        buttonLeft.setBounds(30,300,allbuttonsSize,allbuttonsSize);
        buttonLeft.setBackground(Color.white);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\eyvaz\\Downloads\\tetris (1).png");
        Image image = imageIcon.getImage();
        Image img = image.getScaledInstance(buttonLeft.getWidth(),buttonLeft.getHeight(),5);
        buttonLeft.setIcon(new ImageIcon(img));
        this.add(buttonLeft);

        buttonLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!TetrisPanel.pause_cont && TetrisScorePanel.v!=0){
                    TetrisPanel.x -=25;
                }

            }
        });

    }
    public void commandbuttonsDown(){
        JButton buttonDown = new JButton();
        buttonDown.setBounds(90,360,allbuttonsSize,allbuttonsSize);
        buttonDown.setBackground(Color.WHITE);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\eyvaz\\Downloads\\tetris (3).png");
        Image image = imageIcon.getImage();
        Image img = image.getScaledInstance(buttonDown.getWidth(), buttonDown.getHeight(),5);
        buttonDown.setIcon(new ImageIcon(img));
        this.add(buttonDown);
    }
    public void commandbuttonsReset(){
        JButton buttonReset = new JButton();
        buttonReset.setBounds(150,420,allbuttonsSize,allbuttonsSize);
        buttonReset.setBackground(Color.WHITE);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\eyvaz\\Downloads\\tetris (4).png");
        Image image = imageIcon.getImage();
        Image img = image.getScaledInstance(buttonReset.getWidth(),buttonReset.getHeight(),5);
        buttonReset.setIcon(new ImageIcon(img));
        this.add(buttonReset);

        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (strt==0)
                strt = 1;
                else
                    strt = 0;
            }
        });

    }
    public void commandbuttonsStartResume(){
        JButton buttonResume = new JButton();
        buttonResume.setBounds(30,420,allbuttonsSize,allbuttonsSize);
        buttonResume.setBackground(Color.WHITE);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\eyvaz\\Downloads\\tetris.png");
        Image image = imageIcon.getImage();
        Image img = image.getScaledInstance(buttonResume.getWidth(),buttonResume.getHeight(),5);
        buttonResume.setIcon(new ImageIcon(img));

        buttonResume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v = 1;
                if (p==0){
                    TetrisScorePanel.p++;
                    TetrisPanel.pause_cont = false;
                    buttonResume.setBackground(Color.white);
                    //music();
                } else if (p==1) {
                    TetrisScorePanel.p--;
                    TetrisPanel.pause_cont = true;
                    buttonResume.setBackground(Color.blue);
                }

            }
        });

        this.add(buttonResume);
    }
    public static void music(){
        InputStream music;


        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\eyvaz\\Downloads\\Mindless(MP3_160K)_1.mp3"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }
    public void commandButtonsRotate(){
        JButton buttonRotate = new JButton();
        buttonRotate.setBounds(30,240,allbuttonsSize,allbuttonsSize);
        buttonRotate.setBackground(Color.WHITE);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\eyvaz\\Downloads\\blocks.png");
        Image image = imageIcon.getImage();
        Image img = image.getScaledInstance(buttonRotate.getWidth(),buttonRotate.getHeight(),5);
        buttonRotate.setIcon(new ImageIcon(img));
        this.add(buttonRotate);

        buttonRotate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!TetrisPanel.pause_cont && TetrisScorePanel.v!=0){
                    TetrisPanel.rotateCheck = true;
                    TetrisPanel.rotate ++;
                }
            }
        });

    }
}
