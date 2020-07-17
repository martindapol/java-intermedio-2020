/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase15.es;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author george
 */
public class PruebaCallable {

    public static void main(String[] args) {
        List<Future<Double>> futures = new ArrayList<>();
        
        TareaCalculo t1 = new TareaCalculo(500);
        TareaCalculo t2 = new TareaCalculo(1_000);
        TareaCalculo t3 = new TareaCalculo(2_000);

        ExecutorService es = Executors.newFixedThreadPool(10);

        Future<Double> f1 = es.submit(t1);
        Future<Double> f2 = es.submit(t2);
        Future<Double> f3 = es.submit(t3);

        while(!f1.isDone()){
            try {
                if (f1.isDone()) {
                    Double res1 = f1.get();
                    System.out.println("Res1: " + res1);
                } else {
                    System.out.println("La tarea no terminó todavía...");
                }
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            if (f2.isDone()) {
                Double res2 = f2.get();
                System.out.println("Res2: " + res2);
            } else {
                System.out.println("La tarea no terminó todavía...");
            }
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        try {
            if (f3.isDone()) {
                Double res3 = f3.get();
                System.out.println("Res3: " + res3);
            } else {
                System.out.println("La tarea no terminó todavía...");
            }
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        es.shutdown();
        
        try {
            es.awaitTermination(1, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
