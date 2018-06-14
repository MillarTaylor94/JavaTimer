import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.toIntExact;

public class TimerPanel extends PanelComponent {
    public TimerPanel() {

        //panel.setPreferredSize(new Dimension(220, 40));
        //panel.setBackground(Color.BLACK);`
        this.setPreferredSize(new Dimension(500, 100));
        JButton start = new JButton("Start");
        JLabel remainingTime = new JLabel(getUserTime());
        add(remainingTime);
        add(start);

    }


    private String getUserTime() {


        return "20:15:30";
    }
}


class Stopwatch extends PanelComponent {

    private JButton start;
    private JButton stop;
    private JButton pause;
    private JLabel runTime;
    private stopTimer timer;

    //initialize and set components
    public Stopwatch() {

        start = new JButton("Start");
        stop = new JButton("Stop");
        pause = new JButton("Pause");
        runTime = new JLabel("00:00:00");
        timer = new stopTimer(this);
        //set panel components
        add(runTime);
        add(start);
        add(pause);
        add(stop);


        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.pause();
            }
        });
    }

    //Dynamically update runTime Component with accurate hours/minutes/seconds
    public void setTime(long time) {
        int totalSeconds = toIntExact(TimeUnit.SECONDS.convert(time, TimeUnit.NANOSECONDS));
        int hours, minutes, seconds;

        hours = totalSeconds / 3600;
        minutes = (totalSeconds % 3600) / 60;
        seconds = totalSeconds % 60;

        runTime.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }


}

//Class stopTimer
//purpose: create a thread that tracks the current elapsed time, used in stopwatch class.

class stopTimer implements Runnable {
    private Thread timerThread;
    private boolean isRunning = false;
    private boolean isPaused = false;
    private Stopwatch stopwatch;
    long elapsedTime = 0;


    public stopTimer(Stopwatch stopwatch) {
        this.stopwatch = stopwatch;


    }

    public void start() {

if(isRunning&&!isPaused)
   return;

        isPaused = false;

            isRunning = true;

            timerThread = new Thread(this);

            timerThread.start();
    }

    public void pause() {

        isPaused = true;
    }

    public void stop() {

        isPaused = false;
        isRunning = false;
    }

    @Override
    public void run() {

        long startTime = System.nanoTime();
        while (isRunning && !isPaused) {
            stopwatch.setTime(elapsedTime + System.nanoTime() - startTime);
        }

        if (isPaused)
            elapsedTime += System.nanoTime() - startTime;
        else
            elapsedTime = 0;
    }
}






