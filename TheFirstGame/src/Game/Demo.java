package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

/**
 * Created by cerebro on 27/06/16.
 */

public class Demo implements KeyListener, MouseListener {


    private static int playerXCord = 400;
    private static int playerYCord = 365;
    private static int playerYVel = 0;
    private static int playerYAcc = 0;
    private static Random randomGenerator = new Random();

    private static Rectangle playerRectangle = new Rectangle();
    private static Rectangle blockRectangle = new Rectangle();

    private static boolean isRunning = true;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        Dimension dimension1 = new Dimension(800, 500);
        panel.setPreferredSize(dimension1);

        frame.pack();

        panel.setFocusable(true);
        Demo demo1 = new Demo();
        panel.addKeyListener(demo1);
        panel.addMouseListener(demo1);
        panel.requestFocus();

        frame.setVisible(true);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("sleep function failed");
        }

        Image player1Image = null;
        Image player2Image = null;
        Image player3Image = null;
        Image player4Image = null;
        Image player5Image = null;
        Image grassImage = null;
        Image blockImage = null;

        try {
            player1Image = ImageIO.read(Demo.class.getResource("images/run_anim1.png"));
            player2Image = ImageIO.read(Demo.class.getResource("images/run_anim2.png"));
            player3Image = ImageIO.read(Demo.class.getResource("images/run_anim3.png"));
            player4Image = ImageIO.read(Demo.class.getResource("images/run_anim4.png"));
            player5Image = ImageIO.read(Demo.class.getResource("images/run_anim5.png"));
            grassImage = ImageIO.read(Demo.class.getResource("images/grass.png"));
            blockImage = ImageIO.read(Demo.class.getResource("images/block.png"));

        } catch (Exception e) {
            System.out.println("something went wrong");
        }

        Image[] playerImages = {
                player1Image,
                player2Image,
                player3Image,
                player4Image,
                player5Image,
                player4Image,
                player3Image,
                player2Image,
        };




        Graphics graphics1 = panel.getGraphics();


        int playerImageIndex = 0;

        int block1XCord = 900;
        int block1YCord = 405;
        boolean block1Visible = true;

//        int block2XCord = 1100;
//        int block2YCord = 405;
//
//        int block3XCord = 1300;
//        int block3YCord = 405;
//
//        int block4XCord = 1500;
//        int block4YCord = 405;
//
//        int block5XCord = 1700;
//        int block5YCord = 405;



        while (true) {

            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(!Demo.isRunning) {
                continue;
            }

            Demo.playerYVel = Demo.playerYVel + Demo.playerYAcc;
            Demo.playerYCord = Demo.playerYCord + Demo.playerYVel;

            if (Demo.playerYCord >= 365) {
                Demo.playerYCord = 365;
                Demo.playerYVel = 0;
                Demo.playerYAcc = 0;
            }

            playerImageIndex++;

            playerImageIndex = playerImageIndex % 8;


            block1XCord -= 10;

            if (block1XCord < -100) {
                block1XCord = 900;

                int randomInt = randomGenerator.nextInt(2);

                if (randomInt == 0) {
                    //draw on ground
                    block1YCord = 405;
                } else {
                    block1YCord = 350;
                }

                block1Visible = true;
            }

//            block2XCord -= 10;
//
//            if (block2XCord < -100) {
//                block2XCord = 900;
//
//                int randomInt = randomGenerator.nextInt(2);
//
//                if (randomInt == 0) {
//                    //draw on ground
//                    block2YCord = 405;
//                } else {
//                    block2YCord = 350;
//                }
//            }
//
//            block3XCord -= 10;
//
//            if (block3XCord < -100) {
//                block3XCord = 900;
//
//                int randomInt = randomGenerator.nextInt(2);
//
//                if (randomInt == 0) {
//                    //draw on ground
//                    block3YCord = 405;
//                } else {
//                    block3YCord = 350;
//                }
//            }
//            block4XCord -= 10;
//
//            if (block4XCord < -100) {
//                block4XCord = 900;
//
//                int randomInt = randomGenerator.nextInt(2);
//
//                if (randomInt == 0) {
//                    //draw on ground
//                    block4YCord = 405;
//                } else {
//                    block4YCord = 350;
//                }
//            }
//            block5XCord -= 10;
//
//            if (block5XCord < -100) {
//                block5XCord = 900;
//
//                int randomInt = randomGenerator.nextInt(2);
//
//                if (randomInt == 0) {
//                    //draw on ground
//                    block5YCord = 405;
//                } else {
//                    block5YCord = 350;
//                }
//            }


            Demo.playerRectangle.setBounds(Demo.playerXCord, Demo.playerYCord, 72, 90);
            Demo.blockRectangle.setBounds(block1XCord, block1YCord, 20, 50);


            if (block1Visible && Demo.playerRectangle.intersects(Demo.blockRectangle)) {
                Demo.playerXCord -= 100;
                block1Visible = false;
            }

            graphics1.clearRect(0,0,800,500);

            graphics1.setColor(Color.cyan);
            graphics1.fillRect(0,0,800,500);
            graphics1.setColor(Color.red);
            graphics1.fillRect(740, 10, 50, 50);
            graphics1.drawImage(grassImage, 0, 455, null);
            graphics1.drawImage(playerImages[playerImageIndex], Demo.playerXCord, Demo.playerYCord, null);

            if(block1Visible) {
                graphics1.drawImage(blockImage, block1XCord, block1YCord, null);
            }
//            graphics1.drawImage(blockImage, block2XCord, block2YCord, null);
//            graphics1.drawImage(blockImage, block3XCord, block3YCord, null);
//            graphics1.drawImage(blockImage, block4XCord, block4YCord, null);
//            graphics1.drawImage(blockImage, block5XCord, block5YCord, null);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(Demo.playerYCord == 365 && e.getKeyCode() == KeyEvent.VK_SPACE) {
            Demo.playerYVel = -25;
            Demo.playerYAcc = 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getX() > 740 && e.getX() < 790 && e.getY() > 10 && e.getY() < 60 ) {
            Demo.isRunning = !Demo.isRunning;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
