/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase13.threads;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author george
 */
public class ThreadReloj extends Thread {

    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:MM:ss");
        while (!Thread.interrupted()) {
            System.out.println(sdf.format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Interrupted!");
                return;
            }
        }
    }

}
