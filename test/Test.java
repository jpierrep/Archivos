
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jpierre
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      Test test=new Test();
        System.out.println(test.getUltimoDiaMes());
    
    }
    
    
           public String getUltimoDiaMes(){ // corresponde al mes en cuestion donde se efectua la contabilizacion (ultimo dia)
        String ultimoDia="";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        try {
        java.util.Date fecha2=formatter.parse("20170201");
         Calendar c = Calendar.getInstance();
        c.setTime(fecha2);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
        ultimoDia=   formatter2.format(c.getTime()); 
    
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ultimoDia;
    }
    
    
}
