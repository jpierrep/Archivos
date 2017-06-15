/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import Model.MovContable;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jean
 */

public class gestionaArchivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        // TODO code application logic here
        
        List<MovContable> lista= new ArrayList(); 
        getData getdata=new getData();
        lista=getdata.getResumenCuentasMes("20170101",0,"Todas");
        exportarDiccionario(lista);
        
        
        
    }
    
    public static void exportarDiccionario(List<MovContable> lista) throws IOException, FileNotFoundException, ClassNotFoundException{
        
    String sys = System.getProperty("user.home");    
 String realPath=sys+"\\archivotest.txt"; // Sustituye "/" por el directorio ej: "/upload"
  
        
  //El diccionario
 

 
 
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(realPath);
            pw = new PrintWriter(fichero);

            
             for (MovContable termino: lista){
                System.out.println("relato"+termino);
            pw.println(termino.getCodCuenta());
   
  //           pw.println(termLamina.getTermino()+","+connotacion+"\t"+termLamina.getTerminosAsociadosString());
                
                
            }
            
            
            
            
            
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        
        
        
        
    }
    
    
    
}
