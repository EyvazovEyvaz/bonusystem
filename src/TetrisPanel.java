import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
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
    String str0 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (9_5).png";
    String str1 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (9_2).png";
    String str2 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (9_3).png";
    String str3 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (9_6).png";
    String str4 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (9_4).png";
    String str5 = "C:\\Users\\eyvaz\\OneDrive\\Pictures\\Screenshots\\tetris (9_!).png";
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

    static int speed = 80;

    int getXline = 0;
    int getYline = 0;

    TetrisPanel() {
        this.setBounds(55, 50, FRAME_WIGHT, FRAME_HEIGHT);
        this.setVisible(true);
        this.setLayout(null);
        this.setBackground(Color.black);
    }

    public static void thrEad() {
        try {
            Thread.sleep(speed);
            Y();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void Y() {
        if (pause_cont) return;
        if (y == 500 || test()) {
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
        BufferedImage image0;

        /*try {
            image0 = ImageIO.read(new File("C:\\Users\\eyvaz\\OneDrive\\Desktop\\images\\x.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image img0 = image0.getScaledInstance(getWidth(), getHeight(), 5);
        g.drawImage(img0, 0, 0, this);
*/
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

        if (y == 500 || test()) {
            arrayListChild = new ArrayList<>();
            arrayListChild.add(rnd);
            arrayListChild.add(rotate);
            speed = 80;
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

                    if (y == 500) {
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
                    } else if (test()) {
                        for (int c = 0; c < T[4].length - 1; c++) {
                            for (int z = 0; z < T[4][0][0].length; z++) {
                                if (T[rnd][rotate][c][z] != 0) {

                                    getX = c * UNIC + 6 * UNIC + x;
                                    getY = z * UNIC + y;

                                    arrayListChild.add(getX);
                                    arrayListChild.add(getY);
                                }
                            }
                        }
                    }
                }
            }
        }

        if (pause_cont && TetrisScorePanel.v != 0) {
            g.setColor(Color.RED);
            g.drawString("PAUSA", 200, 200);
            g.setFont(new Font("Bold", Font.PLAIN, 5));
        }

        if (y == 500 || test()) {
            arrayList.add(arrayListChild);
        }

        try {
            musicPanel();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }

        if (!gameOver()) {
            paint2(g);
            //paintLine(g);
            repaint();
            thrEad();
        } else {
            paint2(g);
            paintGameOver(g);
            try {
                musicGameOver();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                throw new RuntimeException(e);
            }
            Y();

        }

        if (gameOver()){
            whantIsNewGame();
        }

        /*for (int i = -1; i <= col; i++) {
            for (int j = -1; j <= row; j++) {
                g.drawRect(i * UNIC, j * UNIC, UNIC, UNIC);
                g.setColor(Color.cyan);
            }
        }*/
    }

    public void musicPanel() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File file = new File("C:\\Users\\eyvaz\\Downloads\\f68c40b3-1185-46a3-82ff-4dc4ffb04942.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        FloatControl floatControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        if (y == 500 || test() && !gameOver()) {
            floatControl.setValue(6.0f);
            clip.start();
        } else {
            clip.stop();
        }

    }

    public void paintLine(Graphics g) {
        getXline = 0;
        getYline = 0;
        for (int i = 0; i < T[4].length - 1; i++) {
            for (int j = 0; j < T[4][0][0].length; j++) {
                if (T[rnd][rotate][i][j] != 0) {
                    switch (rnd) {
                        case 0 -> g.setColor(Color.white);
                        case 1 -> g.setColor(Color.white);
                        case 2 -> g.setColor(Color.white);
                        case 3 -> g.setColor(Color.white);
                        case 4 -> g.setColor(Color.white);
                        case 5 -> g.setColor(Color.white);
                    }

                    getXline = i * UNIC + 6 * UNIC + x;
                    getYline = j * UNIC + 500;

                    if (getYline == j * UNIC + 500) {
                        if (rnd == 1 && rotate == 0 || rotate == 1 || rotate == 2 || rotate == 3) {
                            getYline -= 25;
                        }
                        if (rnd == 5 && rotate == 1) {
                            getYline += 50;
                        }
                        if (rnd == 5 && rotate == 0) {
                            getYline -= 25;
                        }
                        if (rnd == 0 && rotate == 3) {
                            getYline -= 25;
                        }
                        if (rnd == 2 && rotate == 0) {
                            //getY -=25;
                        }
                        if (rnd == 3 && rotate == 1) {
                            getYline += 25;
                        }
                        if (rnd == 2 && rotate == 1) {
                            //getY -=25;
                        }
                        if (rnd == 3 && rotate == 1) {
                            getYline -= 25;

                        }

                        //g.drawRect(getXline, getYline, UNIC, UNIC);
                    }

                    /*for(int s=0; s<arrayList.size(); s++){
                        int x = 0;
                        int y = 0;
                        for (int n=s+1; n<arrayList.size(); n++){
                            for (int d=0; d<10; d++){
                                if (d !=0 && d%2==0 && Objects.equals(arrayList.get(s).get(d), arrayList.get(n).get(d))){
                                    if (arrayList.get(s).get(d+1)>arrayList.get(n).get(d+1)){
                                        y = arrayList.get(s).get(d+1);
                                        x = arrayList.get(s).get(d);
                                    } else if (arrayList.get(s).get(d+1)<arrayList.get(n).get(d+1)) {
                                        y = arrayList.get(n).get(d+1);
                                        x = arrayList.get(n).get(d);
                                    }
                                    if (x == getXline - 25) {
                                        for (int f = 0; f < T[4].length - 1; f++) {
                                            for (int v = 0; v < T[4][0][0].length; v++) {
                                                if (T[rnd][rotate][f][v] != 0) {
                                                    getYline = y-50;
                                                    g.fillRect(getXline, getYline, UNIC, UNIC);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }*/
                    }
                    for (ArrayList<Integer> tt : arrayList) {
                        for (int c = 0; c < tt.size(); c++) {
                            if (c % 2 == 0 && tt.get(c) == getXline - 25) {
                                for (int f = 0; f < T[4].length - 1; f++) {
                                    for (int v = 0; v < T[4][0][0].length; v++) {
                                        if (T[rnd][rotate][f][v] != 0) {
                                            getYline = tt.get(c + 1)-75;
                                    }
                                }
                            }
                        }
                    }
                }
                g.drawRect(getXline, getYline, UNIC, UNIC);
            }
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

                    }
                    g.drawImage(imagef, rr.get(tX), rr.get(tY + 1), UNIC, UNIC, this);
                }
            }
        }
    }

    public static boolean test() {

        for (ArrayList<Integer> tt : arrayList) {
            for (int i = 0; i < tt.size(); i++) {
                if (i % 2 == 0 && tt.get(i) == getX && tt.get(i + 1) == getY + 25) {
                    System.out.println("yes"+getY);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean testLeft() {

        for (ArrayList<Integer> tt : arrayList) {
            for (int i = 0; i < tt.size(); i++) {
                if (i != 0 && i % 2 == 0 && tt.get(i) == getX - 25 && tt.get(i + 1) == getY) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean testRight() {

        for (ArrayList<Integer> tt : arrayList) {
            for (int i = 0; i < tt.size(); i++) {
                if (i != 0 && i % 2 == 0 && tt.get(i) == getX + 25 && tt.get(i + 1) == getY) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean gameOver() {

        if (test()) {
            if (getY == 25 || getY == -25 || getY == 0) {
                TetrisScorePanel.clip.stop();
                TetrisPanel.pause_cont = true;
                return true;
            }
        }
        return false;
    }

    public void paintGameOver(Graphics g) {

        BufferedImage imageOverGame;

        try {
            imageOverGame = ImageIO.read(new File("C:\\Users\\eyvaz\\Downloads\\gameOver.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Image imgGameOv = imageOverGame.getScaledInstance(380, 150, 4);
        g.drawImage(imgGameOv, 10, 170, this);

    }

    public void musicGameOver() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File file = new File("C:\\Users\\eyvaz\\Downloads\\928daa61-6297-4a75-8e12-bfac5aff4ef7.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }

    public void whantIsNewGame() {

       /* int a = JOptionPane.showConfirmDialog(this, "Yenidən oyna?");

        if (a == JOptionPane.YES_OPTION) {
            Main.createObjTetris();
        } else if (a == JOptionPane.NO_OPTION) {
            System.exit(1);
        }*/

        JLabel lEADtEXT= new JLabel();
        lEADtEXT.setText("Yenidən oyna");
        lEADtEXT.setBounds(170,240,300,100);
        lEADtEXT.setForeground(Color.orange);
        this.add(lEADtEXT);
        JLabel label= new JLabel();
        label.setBounds(50,300,300,100);
        label.setBackground(Color.blue);
        JButton button = new JButton("Yes");
        button.setBounds(45,0,100,30);
        label.add(button);
        JButton buttonj = new JButton("No");
        buttonj.setBounds(155,0,100,30);
        label.add(buttonj);
        this.add(label);

        buttonj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

    }

    public void checkisFillallXcoor(){


    }
}
