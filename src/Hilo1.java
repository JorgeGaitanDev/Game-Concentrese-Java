

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jorge Gaitan
 */
public class Hilo1 extends Thread{
    
    
 
int  minutos=0, segundos=0;
   
    

   public void run() {
   
       try
       {
           
         while(true) 
         { 
          synchronized(Tablero2.time) 
          {
            if(segundos==59) { segundos=0; minutos++; }            
            segundos++;
            if(segundos>9)
            Tablero2.time.setText(minutos+":"+segundos);
            else
            Tablero2.time.setText(minutos+":0"+segundos);
            this.sleep(1000); }
         }
        }
       
       catch (InterruptedException e) { System.out.println(e.getMessage()); }
      
 }

   }        
    
    
    
    
    
    




