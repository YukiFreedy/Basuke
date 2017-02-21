/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import basquet.v2.InGameController;
import javafx.concurrent.Task;

/**
 *
 * @author Yuki
 */
public class Timer {
    
    private boolean ongoing;
    
    private InGameController inGame;
    private Thread th;
    
    public Timer(InGameController inGame){
        this.inGame = inGame;
        start();
    }
    
    public synchronized void on(){
        ongoing = true;
        th.notify();
    }
    
    public synchronized void off(){
        ongoing = false;
    }
    
    private synchronized void start(){
        Task t = new Task() {
            @Override
            protected synchronized Object call() throws Exception {
                while(true){
                    if(!ongoing) wait();
                    wait(1000);
                    System.out.println("passed 1 sec");
                    inGame.timer(1);
                }
            }
        };
        th = new Thread(t);
        th.start();
    }
    
    public synchronized boolean isOn(){
        return ongoing;
    }
}
