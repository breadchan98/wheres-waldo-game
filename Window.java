import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import acm.graphics.GCanvas;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Window extends JFrame
{
    GCanvas canvas;
    GLabel label;
    Font font1 = new Font("Arial", Font.PLAIN, 120);
    Timer timer;
    Font font2 = new Font("Arial", Font.PLAIN, 30);

    int sec;

    public void windowBorder()
    {   
        //JFrame
        this.setVisible(true);
        this.setTitle("game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //Canvas itself
        this.canvas = new GCanvas();
        this.add(this.canvas);

        //Canvas for background
        GImage bgimage = new GImage("FinalGame/wheres waldo 1080.png");
        this.canvas.add(bgimage);

        GRect rect = new GRect(200, 200);
        rect.setLocation(1720, 0);
        rect.setFillColor(Color.WHITE);
        rect.setFilled(true);
        rect.setVisible(true);
        this.canvas.add(rect);
        
    }

    public void titleGame()
    {
        GLabel title = new GLabel("Find Waldo using the arrow keys! (Hover at his head though)");
        title.setLocation(900, 30);
        title.setFont(font2);
        this.canvas.add(title);
    }

    public void requirements()
    {
        GLabel title = new GLabel("If you can't find him, the game ends and your PC will lock to the login screen (:");
        title.setLocation(680, 70);
        title.setFont(font2);
        this.canvas.add(title);
    }

    public void theTimer()
    {
        label = new GLabel("");
        label.setLabel("");
        label.setLocation(1720, 150);
        label.setFont(font1);
        this.canvas.add(label);

        sec = 60;
        aTimer();
        timer.start();
    }

    public void aTimer() {
        timer = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                sec--;
                label.setLabel(" " + sec);

                if (sec == -1)
                {
                    
                    try {
                        Process process = Runtime.getRuntime().exec("rundll32.exe user32.dll,LockWorkStation"); 
                        StringBuilder output = new StringBuilder(); 
                        BufferedReader reader = new BufferedReader(new InputStreamReader (process.getInputStream()));
                        String line;
                        while((line = reader.readLine()) != null) {
                            output.append(line + "\n");
                        }
                        
                        int exitVal = process.waitFor();
                        if (exitVal == 0) {
                            System.out.println("Success");
                            System.out.println(output);
                            System.exit(0);
                        } else {
                            System.out.println("fbm");
                        }
                            
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (InterruptedException xd) {
                        xd.printStackTrace();
                    }
                }
            }
        });
    }
}
