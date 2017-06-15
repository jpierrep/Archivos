/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Clase extends JFrame {
  private JTextField filename = new JTextField(), dir = new JTextField();

  private JButton open = new JButton("Open"), save = new JButton("Save");

  public Clase() {
    JPanel p = new JPanel();
    open.addActionListener(new OpenL());
    p.add(open);
    save.addActionListener(new SaveL());
    p.add(save);
    Container cp = getContentPane();
    cp.add(p, BorderLayout.SOUTH);
    dir.setEditable(false);
    filename.setEditable(false);
    p = new JPanel();
    p.setLayout(new GridLayout(2, 1));
    p.add(filename);
    p.add(dir);
    cp.add(p, BorderLayout.NORTH);
  }

  class OpenL implements ActionListener {
      
    public void actionPerformed(ActionEvent e) {
      JFileChooser c = new JFileChooser();
      // Demonstrate "Open" dialog:
      int rVal = c.showOpenDialog(Clase.this);
      if (rVal == JFileChooser.APPROVE_OPTION) {
        filename.setText(c.getSelectedFile().getName());
        dir.setText(c.getCurrentDirectory().toString());
          System.out.println(filename.getText());
          System.out.println(dir.getText());
          this.leeArchivo();
          
      }
      if (rVal == JFileChooser.CANCEL_OPTION) {
        filename.setText("You pressed cancel");
        dir.setText("");
      }
    }
    
     public void leeArchivo(){
      System.out.println("casca");
      String realPath="C:\\Users\\jean\\Desktop\\Test.txt";
        List lista= new ArrayList();
       File archivo = null;
       FileReader fr = null;
      BufferedReader br = null;
     
 
     
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File (realPath);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
 
         // Lectura del fichero
         String linea;
          List<String> areasNeg=new ArrayList();
          String[] columnas=new String [10];
         int lineasCant=0;
          
         while((linea=br.readLine())!=null){
             System.out.println(linea); 
            //separamos las columnas
            columnas=linea.split(";");
            if(!areasNeg.contains(columnas[1]))
                areasNeg.add(columnas[1]);
             
             
         }
         for(String areas: areasNeg){
             System.out.println(areas);
         }
      
  }
         
          
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
         
    }
   }
  
  }

  class SaveL implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JFileChooser c = new JFileChooser();
      // Demonstrate "Save" dialog:
      int rVal = c.showSaveDialog(Clase.this);
      if (rVal == JFileChooser.APPROVE_OPTION) {
        filename.setText(c.getSelectedFile().getName());
        dir.setText(c.getCurrentDirectory().toString());
      }
      if (rVal == JFileChooser.CANCEL_OPTION) {
        filename.setText("You pressed cancel");
        dir.setText("");
      }
    }
  }

  public static void main(String[] args) {
    run(new Clase(), 250, 110);
  }
  
 

  public static void run(JFrame frame, int width, int height) {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(width, height);
    frame.setVisible(true);
  }
} //