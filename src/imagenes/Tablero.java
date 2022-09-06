package imagenes;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author santi
 */
public class Tablero extends JFrame {
    
  /*   int contp=0, pul=0;
     JPanel panel;
     JLabel tab[][];
     JLabel tab1[][];
     int clic11;
     int clic12;
     int clic21;
     int clic22;
     Icon imgs[];
     Icon fnd;
     int random[];
     int[][] posi;     
     static JLabel time;
     Thread tm;
     JButton nuevo;
   public Tablero()
   {  
       panel = new JPanel();
       panel.setLayout(null);
       panel.setBounds(75,20,559,559);
       panel.setBackground(Color.black);
       random = new int[16];
       posi = new int[4][4];
       this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       nuevo = new JButton("Nuevo Juego");
       nuevo.setBounds(700, 500, 150, 30);
       time = new JLabel("Tiempo");
       tab = new JLabel[4][4];
       tab1 = new JLabel[4][4];
       for (int i=0; i<4; i++)
       {
          for (int j=0; j<4; j++)
          {            
            tab[i][j] = new JLabel();      
            tab1[i][j] = new JLabel();                       
          }
       }
       
       
      nj();
      nuevo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               
                nj();
                
            }
        });
       
       
       
       
       
       for (int i=0; i<4; i++)
       {
           for (int j=0; j<4; j++)
           {
              tab[i][j].setBounds(j*135+17, i*135+17, 125, 125);
              tab1[i][j].setBounds(j*135+17, i*135+17, 125, 125);
           }
       }
       
       this.setLayout(null);
       this.setBounds(180, 5, 1000, 850);
      
       
       
       
       
       time.setBounds(700, 0, 70, 70);
       
             
       this.setVisible(true);
   }
   
   public void win()
   {
       int puntaje=1250,ti;
       String p, t, t1, t2;
      if(!tab1[0][0].isVisible() && !tab1[0][1].isVisible() && !tab1[0][2].isVisible() && !tab1[0][3].isVisible() && !tab1[1][0].isVisible() && !tab1[1][1].isVisible() && !tab1[1][2].isVisible() && !tab1[1][3].isVisible() && !tab1[2][0].isVisible() && !tab1[2][1].isVisible() && !tab1[2][2].isVisible() && !tab1[2][3].isVisible() && !tab1[3][0].isVisible() && !tab1[3][1].isVisible() && !tab1[3][2].isVisible() && !tab1[3][3].isVisible() )
      {       
          p= time.getText();
          t1 = p.substring(0,1);
          t2 = p.substring(2);
          t= t1+t2;
          ti = Integer.parseInt(t);
          puntaje = (puntaje-(pul*18))-(ti*2);
          JOptionPane.showMessageDialog(this,"intentos : "+pul);
          JOptionPane.showMessageDialog(this,"tiempo : "+ti);
          JOptionPane.showMessageDialog(this,"puntaje : "+puntaje);
          
      }      
   }
   
   public void nj()
   {
        panel.removeAll(); 
        
        
        int s=0;
        while (s<16)
        {
           
          int num = (int)(Math.random()*(17-1)+1);
          int cont = 0;
          
        
          for (int pos=0;pos<16;pos++)
          {
              if (random[pos] != num)
              {
                  cont=cont+1;
                 
              }
            
          }
          
          
              if (cont == 16)
              {
                  random[s]=num;
                  s++;
                 
              }
              
          
      }
        tm = new Thread(new Hilo1());
        tm.start();
       
       
              
       
       
       
      
       
       int h=0;
       imgs = new Icon[16];
       fnd = new ImageIcon(getClass().getResource("/imagenes/f1.jpg"));
       
       for (int i=0; i<16; i++)
       {
           if (random[h]>8)
               random[h]=random[h]-8;
          imgs[i]=new ImageIcon(getClass().getResource("/imagenes/s"+random[h]+".jpg"));
          h++;
       }       
       
       int pos =0;
       for(int i=0; i<4; i++)
       {
           for(int j=0; j<4; j++)
           {
               posi[i][j]=(random[pos]);               
               pos++;
           }
           
       }
       
       int cont=1;
       for (int i=0; i<4; i++)
       {
          for (int j=0; j<4; j++)
          {         
            tab[i][j].setIcon(imgs[cont-1]);    
            tab1[i][j].setIcon(fnd);                      
            cont++;
            if(cont>16)
                cont=1;
          }
       }   
                     
          
                     
                    
       
       
       for (int i=0; i<4; i++)
       {
           for (int j=0; j<4; j++)
           {      
             panel.add(tab1[i][j]);
           }
       }
       
       for (int i=0; i<4; i++)
       {
           for (int j=0; j<4; j++)
           {      
             panel.add(tab[i][j]);
           }
       }
       this.add(time);
       this.add(nuevo);             
       this.add(panel); 
       
       tab1[0][0].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic11=0;
                clic12=0;
                tab1[clic11][clic12].setVisible(false);                
                contp++;
                
                
                    
                 panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                    if(contp==2)
                    {
                         pul++;   
                         if(posi[clic11][clic12] == posi[clic21][clic22])
                         {
                           tab1[clic11][clic12].setVisible(false);
                           tab1[clic21][clic22].setVisible(false);       
                           contp=0;
                           win();
                         }
                        else
                        {
                           tab1[clic21][clic22].setVisible(true);
                           tab1[clic11][clic12].setVisible(true);  
                           contp=0;
                        }                
                     }                 
                    else
                    {
                      clic11=0;
                      clic12=0;
                    }
                
               }
               });                   
                   
            }        
            
        });
       
      
      
            tab1[0][1].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=0;
                clic22=1;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
                
               panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;                    
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                    
                    }
                    contp=0;
                    
                }
                else
                {
                    clic11=0;
                    clic12=1;
                }
                
            }
        });
                }        
            
        });
            
            
             tab1[0][2].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=0;
                clic22=2;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
              panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                    
                    }
                    contp=0;
                }
                else
                {
                    clic11=0;
                    clic12=2;
                }
                
            }
        });
              }        
            
        });
             
             tab1[0][3].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=0;
                clic22=3;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
              panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                    
                    }
                    contp=0;
                }
                else
                {
                    clic11=0;
                    clic12=3;
                }
                
            }
        });
              }        
            
        });
          
             
             tab1[1][0].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=1;
                clic22=0;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
              panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                  
                    }
                    contp=0;
                }
                else
                {
                    clic11=1;
                    clic12=0;
                }
               
            }
        });
             }        
            
        });
             
             
             tab1[1][1].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=1;
                clic22=1;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
              panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                   
                    }
                    contp=0;
                }
                else
                {
                    clic11=1;
                    clic12=1;
                }
                
            }
        });
}        
            
        });
      
      tab1[1][2].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=1;
                clic22=2;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
              panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                  
                    }
                    contp=0;
                }
                else
                {
                    clic11=1;
                    clic12=2;
                }
              
            }
        });
}        
            
        });
      
       tab1[1][3].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=1;
                clic22=3;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
              panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                  
                    }
                    contp=0;
                }
                else
                {
                    clic11=1;
                    clic12=3;
                }
               
            }
        });
}        
            
        });
       
       tab1[2][0].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=2;
                clic22=0;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
              panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                  
                    }
                    contp=0;
                }
                else
                {
                    clic11=2;
                    clic12=0;
                }
               
            }
        });
}        
            
        });
       
       tab1[2][1].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=2;
                clic22=1;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
              panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                   
                    }
                    contp=0;
                }
                else
                {
                    clic11=2;
                    clic12=1;
                }
              
            }
        });
}        
            
        });
       
       tab1[2][2].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=2;
                clic22=2;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
              panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                  
                    }
                    contp=0;
                }
                else
                {
                    clic11=2;
                    clic12=2;
                }
              
            }
        });
}        
            
        });
       
       tab1[2][3].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=2;
                clic22=3;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
              panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                  
                    }
                    contp=0;
                }
                else
                {
                    clic11=2;
                    clic12=3;
                }
               
            }
        });
}        
            
        });
       
       tab1[3][0].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=3;
                clic22=0;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
              panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                   
                    }
                    contp=0;
                }
                else
                {
                    clic11=3;
                    clic12=0;
                }
               
            }
        });
}        
            
        });
       
       tab1[3][1].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=3;
                clic22=1;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
              panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                       win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                    
                    }
                    
                }
                else
                {
                    clic11=3;
                    clic12=1;
                }
              
            }
        });
}        
            
        });
       
       tab1[3][2].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=3;
                clic22=2;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
              panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                  
                    }
                    contp=0;
                }
                else
                {
                    clic11=3;
                    clic12=2;
                }
               
            }
        });
}        
            
        });
       
       tab1[3][3].addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clic21=3;
                clic22=3;
                tab1[clic21][clic22].setVisible(false);                
                contp++;
             panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                        @Override
                 public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(contp==2)
                {
                    pul++;
                    if(posi[clic11][clic12] == posi[clic21][clic22])
                    {
                       tab1[clic11][clic12].setVisible(false);
                       tab1[clic21][clic22].setVisible(false);
                       contp=0;
                        win();
                    }
                    else
                    {
                    tab1[clic21][clic22].setVisible(true);
                    tab1[clic11][clic12].setVisible(true);  
                    contp=0;
                   
                    }
                    contp=0;
                }
                else
                {
                    clic11=3;
                    clic12=3;
                }
               
            }
        });
}        
            
        });
       
       
       
       
   }*/
   
   
}
