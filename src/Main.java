import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        createObjectFirstPage();
        createObjTetris();

    }
    public static void createObjectFirstPage(){
        TetrisFirstPageFrame tetrisFirstPageFrame = new TetrisFirstPageFrame();
        TetrsiFirstPagePanel.clip.start();
        try {
            Thread.sleep(4000);
            tetrisFirstPageFrame.setVisible(false);
            TetrsiFirstPagePanel.clip.stop();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void createObjTetris(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                  new TetrisFrame();
            }
        });
    }
}