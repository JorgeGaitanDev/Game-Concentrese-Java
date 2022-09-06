import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;





/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jorge Gaitan
 */
public class Main {

     static Lista l;
     static FileReader fw;
     static BufferedReader br;
    
    public static void main(String[] args) {
        
        Index i= new Index();        
        l = new Lista();
        l.setVisible(false);        
      
        try
        {
            
            fw = new FileReader("src/imagenes/file.txt");
            br = new BufferedReader(fw);
            String linea;
            while((linea=br.readLine())!=null)               
                Lista.dl.addElement(linea);

        }
        catch(FileNotFoundException e)
        {
           JOptionPane.showMessageDialog(null,"No se pudo abrir el archivo");
        }
        catch(Exception ex)
        {
           JOptionPane.showMessageDialog(null,"Error");
        }
        
        
          
        
              
    } 
    
   
}
