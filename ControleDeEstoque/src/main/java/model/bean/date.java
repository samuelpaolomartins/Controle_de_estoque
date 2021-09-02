/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Aluno
 */
public class date implements Runnable{
    
    DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void main (String args[]){
        
        Runnable runnable = new date();
        Thread thread = new Thread(runnable);
        thread.start();
    }
    
    public void run(){
        
        while(true){
            
            System.out.println(data.format(new Date()));
            try{
               
                Thread.sleep(1000);
            
            }catch(InterruptedException ex){
                
                System.out.println("Testanda a bagassa"+ex);
            }
        }
    }
}
