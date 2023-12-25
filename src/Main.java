import javax.swing.*;

public class Main {

    public static void main(String[] args){
        TetrisFirstPageFrame tetrisFirstPageFrame = new TetrisFirstPageFrame();
        try {
            Thread.sleep(4000);
            tetrisFirstPageFrame.setVisible(false);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        createObjTetris();

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