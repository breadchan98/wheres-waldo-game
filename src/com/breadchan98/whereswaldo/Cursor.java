import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import acm.graphics.GImage;
import acm.graphics.GRect;

import java.awt.Color;

import java.awt.event.*;

import javax.swing.Timer;

public class Cursor extends Window implements ActionListener, KeyListener {
    Timer time = new Timer(5, this);
    GRect oval;

    int x = 0;
    int y = 0;
    int xSpeed = 0;
    int ySpeed = 0;

    public void theCharacter() 
    {   
        //GOval cursor
        oval = new GRect(10, 10);
        oval.setFilled(true);
        oval.setColor(Color.GREEN);
        this.canvas.add(oval);

        //Timer Swing starts
        time.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    //The action occurred
    public void actionPerformed(ActionEvent e)
    {
        if (x < 0)
        {
            xSpeed = 0;
            x = 0;
        }
        if (x > 1889)
        {
            xSpeed = 0;
            x = 1889;
        }
        if (y < 0)
        {
            ySpeed = 0;
            y = 0;
        }
        if (y > 996)
        {
            ySpeed = 0;
            y = 996;
        }

        //Waldo Answer Box top side X-axis
        if 
        ((x == 939 && y == 375) || (x == 940 && y == 375) || (x == 941 && y == 375) || (x == 942 && y == 375) || (x == 943 && y == 375) || (x == 944 && y == 375) || (x == 945 && y == 375))
        {
            GImage bgimage = new GImage("FinalGame/congratulations.png");
            this.canvas.add(bgimage);

            try 
            {
                File musicPath = new File("FinalGame/microsoft.wav");

                if (musicPath.exists())
                    {
                        AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInput);
                        clip.start();
                    }
                else
                {
                    System.out.println("No file");
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }

        //Waldo Answer Box right side Y-axis
        if 
        ((x == 945 && y == 375) || (x == 945 && y == 376) || (x == 945 && y == 377) || (x == 945 && y == 378) || (x == 945 && y == 379) || (x == 945 && y == 340) || (x == 945 && y == 341))
        {
            GImage bgimage = new GImage("FinalGame/congratulations.png");
            this.canvas.add(bgimage);

            try 
            {
                File musicPath = new File("FinalGame/microsoft.wav");

                if (musicPath.exists())
                    {
                        AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInput);
                        clip.start();
                    }
                else
                {
                    System.out.println("No file");
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }

        //Waldo Answer Box bottom side x-axis
        if 
        ((x == 945 && y == 341) || (x == 945 && y == 341) || (x == 945 && y == 341) || (x == 945 && y == 341) || (x == 945 && y == 341) || (x == 945 && y == 341) || (x == 945 && y == 341))
        {
            GImage bgimage = new GImage("FinalGame/congratulations.png");
            this.canvas.add(bgimage);

            try 
            {
                File musicPath = new File("FinalGame/microsoft.wav");

                if (musicPath.exists())
                    {
                        AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInput);
                        clip.start();
                    }
                else
                {
                    System.out.println("No file");
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }

        //Waldo Answer Box left side y-axis
        if 
        ((x == 945 && y == 375) || (x == 945 && y == 376) || (x == 945 && y == 377) || (x == 945 && y == 378) || (x == 945 && y == 379) || (x == 945 && y == 340) || (x == 945 && y == 341))
        {
            GImage bgimage = new GImage("FinalGame/congratulations.png");
            this.canvas.add(bgimage);

            try 
            {
                File musicPath = new File("FinalGame/microsoft.wav");

                if (musicPath.exists())
                    {
                        AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInput);
                        clip.start();
                    }
                else
                {
                    System.out.println("No file");
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }

        x = x + xSpeed;
        y = y + ySpeed;
        repaint();

        oval.setLocation(x, y);
    }

    //KeyEvent user inputs
    public void keyPressed(KeyEvent e)
    {
        int move = e.getKeyCode();

        if (move == KeyEvent.VK_LEFT)
        {
            xSpeed = -3;
            ySpeed = 0;
        }
        if (move == KeyEvent.VK_RIGHT)
        {
            xSpeed = 3;
            ySpeed = 0;
        }
        if (move == KeyEvent.VK_UP)
        {
            xSpeed = 0;
            ySpeed = -3;
        }
        if (move == KeyEvent.VK_DOWN)
        {
            xSpeed = 0;
            ySpeed = 3;
        }

        if (move == KeyEvent.VK_ENTER)
        {
            System.exit(0);
        }
    }

    public void keyTyped(KeyEvent e){}
    
    //When key is released
    public void keyReleased(KeyEvent e)
    {
        xSpeed = 0;
        ySpeed = 0;
    }

    //Background Audio
    public void playMusic(String musicLocation)
    {
        try 
        {
            File musicPath = new File(musicLocation);

            if (musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            else
            {
                System.out.println("No file");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
