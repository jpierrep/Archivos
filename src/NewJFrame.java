
import Model.MovContable;
import archivos.Clase;
import static archivos.gestionaArchivos.exportarDiccionario;
import archivos.getData;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;
import java.awt.Component;
import java.awt.Container;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.lang.String;
import java.sql.Date;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.io.File;
import java.text.ParseException;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jean
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    DefaultTableModel tableModel;
    private JTextField filename = new JTextField(), dir = new JTextField();
   private int empresaForm=0;
   private int añoForm=2017;
   private String mesForm="01";
   private String areaForm="Todas";
   private String fechaForm= Integer.toString(añoForm)+mesForm+"01";
   private String procesoForm;
   private getData getdata=new getData();
   private  List<MovContable> listaMov=  getdata.getResumenCuentasMes(fechaForm,empresaForm,areaForm);
            
    
    
    public NewJFrame() throws IOException, FileNotFoundException, ClassNotFoundException {
        initComponents();
        postInitComponents();
        
        llenarTabla(listaMov,0, 2017,"01","Todas");
           int[] totales=this.getTotalesMov(listaMov);
            jLabel8.setText(Integer.toString(totales[0]));
             jLabel9.setText(Integer.toString(totales[1]));
        
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"  }));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2017","2016","2015"  }));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GuardService Seguridad S.A.","GS Tecnologías S.A.","GS Outsourcing S.A.","Inversiones Odin Ltda."  }));
        
        getData data=new getData();
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(data.getAreasNegocios(fechaForm, empresaForm,true).toArray()));
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Proceso...","Anticipos","Remuneraciones","Reliquidaciones"  }));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Generar Archivos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Año: ");

        jLabel2.setText("Mes:");

        jLabel3.setText("Empresa: ");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Resumen del Mes");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Centralización Remuneraciones");

        jLabel5.setText("Area:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Total:");

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel9");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Proceso:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, 209, Short.MAX_VALUE)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(189, 189, 189))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(240, 240, 240))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(131, 131, 131)
                        .addComponent(jLabel8)
                        .addGap(132, 132, 132)
                        .addComponent(jLabel9)
                        .addGap(130, 130, 130))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void postInitComponents(){
        
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               try{
			   jComboBox1ActionPerformed(evt);
			   }catch(IOException | ClassNotFoundException e){
					   e.printStackTrace();
				   }
            }
        });
        
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
                   try{
			   jComboBox2ActionPerformed(evt);
				   }catch(IOException | ClassNotFoundException e){
					   e.printStackTrace();
				   }
				   
					   
            }
        });
        
        	jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
				try{
				jComboBox3ActionPerformed(evt);
				}catch(IOException | ClassNotFoundException e){
					   e.printStackTrace();
				   }
            }
        });
        
                jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
				try{
				jComboBox4ActionPerformed(evt);
				}catch(IOException | ClassNotFoundException e){
					   e.printStackTrace();
				   }
            }
        });
                
                
                    jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               try{
			   jComboBox5ActionPerformed(evt);
			   }catch(IOException | ClassNotFoundException e){
					   e.printStackTrace();
				   }
            }
        });
        
    }
            
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
       
        if(jComboBox5.getSelectedItem().toString().equals("Seleccione Proceso...")){ // inicia if proceso
         // Caso en que no sea seleccionado el proceso
            
            JOptionPane.showMessageDialog(null, "Seleccione el Proceso a cargar ej. Liquidaciones, Reliquidaciones, etc.·",
  "Error", JOptionPane.ERROR_MESSAGE);   
          jLabel10.setForeground (Color.red); 
            
        }else{
        // si seleccionó proceso, se marca negro el label
            jLabel10.setForeground (Color.black); 
        
        List<String> listaArea= new ArrayList(); 
        
       
        int[] debeHaberAreas=getTotalesMov( getdata.getResumenCuentasMes(fechaForm,empresaForm,"Todas"));
        //Mostrar mensaje si no cuadra debe y haber
        if(debeHaberAreas[1]!=debeHaberAreas[0]){
          JOptionPane.showMessageDialog(null, "Debe y Haber general no coinciden, se generarán los archivos de las áreas cuyo Debe y Haber coincidan. ",
  "Error", JOptionPane.ERROR_MESSAGE);  
        }
        
        listaArea=getdata.getAreasNegocios(fechaForm, empresaForm,false);
        //se deben generar los archivos solo de las areas cuadradas
        
        System.out.println("fecha "+fechaForm+", mes "+mesForm+",año "+añoForm+"empresa "+empresaForm);
        
        System.out.println("seleecionado:"+ jComboBox1.getSelectedItem().toString());
        System.out.println("seleecionado2:"+ jComboBox2.getSelectedItem().toString());
        System.out.println("seleecionado3 empresa:"+ jComboBox2.getSelectedItem().toString());
        JFileChooser c = new JFileChooser();
      //disableTextField(c);
      c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      int rVal = c.showOpenDialog(NewJFrame.this);
    
      
      if (rVal == JFileChooser.APPROVE_OPTION) {
     filename.setText(c.getSelectedFile().getName());
     
        // disableTextField(c);

 dir.setText(c.getCurrentDirectory().toString());
         System.out.println(filename.getText());
        System.out.println(dir.getText());// TODO add your handling code here:
        String filepath=dir.getText()+"\\"+filename.getText();
          System.out.println(filepath);
          
          File folder=new File(filepath+"\\"+jComboBox3.getSelectedItem().toString());
          if(!folder.exists()){
              folder.mkdir();}
          filepath=filepath+"\\"+jComboBox3.getSelectedItem().toString();
          
       
          
          
          List<MovContable> listamov= new ArrayList(); 

        getData getdata=new getData();
     //   listamov=getdata.getResumenCuentasMes("20170101",0);
          try {
             
              for (String area:listaArea){
                  
                  
        int[] totalesArea=getTotalesMov(getdata.getResumenCuentasMes(fechaForm,empresaForm,area));
           
             if(totalesArea[1]==totalesArea[0]){ //solo si el debe y haber son iguales se genera el archivo
        
        
                  listamov=getdata.getResumenPorArea(fechaForm, empresaForm, area,"ADM",true); //ADMINITRATIVOS
                   exportarDiccionario(procesoForm,listamov,filepath,Integer.toString(empresaForm)+"-"+area,false); //el nombre del archivo será el area
                
                   listamov=getdata.getResumenPorArea(fechaForm, empresaForm, area,"ADM",false); // NO ADMINISTRATIVOS
                 
                  exportarDiccionario(procesoForm,listamov,filepath,Integer.toString(empresaForm)+"-"+area,true); //el nombre del archivo será el area
                  
                  listamov=getdata.getOtrasCuentas(fechaForm, empresaForm, area); // NO ADMINISTRATIVOS
                 
                  exportarDiccionario(procesoForm,listamov,filepath,Integer.toString(empresaForm)+"-"+area,true); //el nombre del archivo será el area
                 
             } //fin if
             
              } //fin for
              
              
              
         
              JOptionPane.showMessageDialog(null,"Archivos generado correctamente.","Exito",JOptionPane.INFORMATION_MESSAGE);
          } catch (IOException ex) {
              Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Error al generar los archivos. "+ ex.toString(),
  "Error", JOptionPane.ERROR_MESSAGE);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al generar los archivos. "+ ex.toString(),
  "Error", JOptionPane.ERROR_MESSAGE);
          }
          
    }
	
    } //fin if proceso
    }
	//GEN-LAST:event_jButton1ActionPerformed

	
    	 private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException, FileNotFoundException, ClassNotFoundException {  
             //Año
             
             
             System.out.println(jComboBox1.getSelectedItem().toString());
           añoForm=Integer.parseInt(jComboBox1.getSelectedItem().toString());
           fechaForm= Integer.toString(añoForm)+mesForm+"01";
           
              System.out.println(empresaForm+" "+añoForm+" "+mesForm);
              listaMov=  getdata.getResumenCuentasMes(fechaForm,empresaForm,areaForm);
               getData data=new getData();
        //jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(data.getAreasNegocios(fechaForm, empresaForm,true).toArray()));
           
             llenarTabla(listaMov,empresaForm, añoForm, mesForm,areaForm);
             
             int[] totales=this.getTotalesMov(listaMov);
            jLabel8.setText(Integer.toString(totales[0]));
             jLabel9.setText(Integer.toString(totales[1]));
             
           
// TODO add your handling code here:
    } 
    
	 private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) throws IOException, FileNotFoundException, ClassNotFoundException {                                           
             //Mes 
             //System.out.println(jComboBox2.getSelectedIndex());
            
             int mes=jComboBox2.getSelectedIndex()+1; //comienza de 0 aumentamos 1 para que se adapte al real
           mesForm= mes>=10 ? Integer.toString(mes) : "0"+Integer.toString(mes)   ;  
           fechaForm= Integer.toString(añoForm)+mesForm+"01";
              System.out.println(empresaForm+" "+añoForm+" "+mesForm);  
           listaMov=  getdata.getResumenCuentasMes(fechaForm,empresaForm,areaForm);
              
               getData data=new getData();
        //jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(data.getAreasNegocios(fechaForm, empresaForm,true).toArray()));
           
        int[] totales=this.getTotalesMov(listaMov);
            jLabel8.setText(Integer.toString(totales[0]));
             jLabel9.setText(Integer.toString(totales[1]));
        
           llenarTabla(listaMov,empresaForm, añoForm, mesForm,areaForm);
          
             
    } 
		
	 private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) throws IOException, FileNotFoundException, ClassNotFoundException {    
            //Empresa
            
              
            
            
            empresaForm=jComboBox3.getSelectedIndex(); //empresa coincide con el nombre
            listaMov=  getdata.getResumenCuentasMes(fechaForm,empresaForm,areaForm);
                 System.out.println(empresaForm+" "+añoForm+" "+mesForm);
                 
                  getData data=new getData();
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(data.getAreasNegocios(fechaForm, empresaForm,true).toArray()));
               
        int[] totales=this.getTotalesMov(listaMov);
            jLabel8.setText(Integer.toString(totales[0]));
             jLabel9.setText(Integer.toString(totales[1]));
                 
              llenarTabla(listaMov,empresaForm, añoForm, mesForm,areaForm);
        // TODO add your handling code here:
    } 
         
         private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) throws IOException, FileNotFoundException, ClassNotFoundException {    
            //Area
             
            areaForm=jComboBox4.getSelectedItem().toString(); //empresa coincide con el nombre
            
             listaMov=  getdata.getResumenCuentasMes(fechaForm,empresaForm,areaForm);  
           
              
                 System.out.println(empresaForm+" "+añoForm+" "+mesForm+" "+areaForm);
              
             int[] totales=this.getTotalesMov(listaMov);
            jLabel8.setText(Integer.toString(totales[0]));
             jLabel9.setText(Integer.toString(totales[1]));
                 
                 llenarTabla(listaMov,empresaForm, añoForm, mesForm,areaForm);
       
              // TODO add your handling code here:
    
         
         
         } 
         
         	 private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) throws IOException, FileNotFoundException, ClassNotFoundException {
                     procesoForm=jComboBox5.getSelectedItem().toString(); //empresa coincide con el nombre
                     System.out.println("proceso "+ procesoForm);
                     
                     
                 }
	
	
	
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new NewJFrame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
    
        
    }
    
   public  void llenarTabla( List<MovContable> lista,int empresa, int año,String mes,String area) throws IOException, FileNotFoundException, ClassNotFoundException{
        
       System.out.println("print "+empresa+" "+mes+" "+año );
       String fecha=Integer.toString(año)+mes+"01";
       
 
           String[] titulos={"Nº Cuenta","Nombre","Debe","Haber"}; 
           String[] datos= new String[4]; 
        tableModel= new DefaultTableModel(null, titulos); 
        for (MovContable mov: lista){
            datos[0]=mov.getCodCuenta();
            datos[1]=mov.getNombreCuenta();
            datos[2]= Integer.toString(mov.getDebe());
            datos[3]= Integer.toString(mov.getHaber());
          //  System.out.println("datos"+datos[0]);
            
           tableModel.addRow(datos);
            jTable1.setModel(tableModel);
           
           int[] debeHaberAreas=getTotalesMov( lista);
      
        if(debeHaberAreas[1]!=debeHaberAreas[0]){
           
          jLabel8.setForeground (Color.red); 
          jLabel9.setForeground (Color.red); 
        }else{
             jLabel8.setForeground (Color.BLACK); 
             jLabel9.setForeground (Color.BLACK); 
        }
        
             
              
    
    }
   }
        
    
   
   public boolean disableTextField(Container container) {
   Component[] comps = container.getComponents();

   for (Component comp : comps) {
      if (comp instanceof JTextField) {
         ((JTextField) comp).setEnabled(false);
         return true;
      }
      if (comp instanceof Container) {
         if (disableTextField((Container) comp)) return true;
      }
   }
   return false;
}
   
   
 
        
    public static void exportarDiccionario(String proceso,List<MovContable> lista,String path,String nombreArchivo,boolean sobrescribe) throws IOException, FileNotFoundException, ClassNotFoundException{
      
        
 proceso=proceso.toUpperCase();
        
 java.util.Date utilDate = new java.util.Date();
 DateFormat df = new SimpleDateFormat("dd-MM-YYYY");
 String fecha=df.format(utilDate);
        
        String realPath; 
        if (path==null){
    String sys = System.getProperty("user.home");    
    realPath=sys+"\\"+nombreArchivo+"-"+fecha+".txt"; // Sustituye "/" por el directorio ej: "/upload"
        }else{
        realPath=path+"\\"+nombreArchivo+"-"+fecha+".txt";
        }
  
        
  //El diccionario
 

 
 
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(realPath,sobrescribe);
            pw = new PrintWriter(fichero);

            
               for (MovContable termino: lista){
                   
             if(sobrescribe==false){
                       // Administrativos es la 2a entrada al archivo
                    termino.setCodCuenta(termino.getCodCuenta().replace("50-01-", "50-02-"));
                       
                   }    
             
             if(termino.getCodCuenta().startsWith("50-")){
            pw.println(termino.getCodCuenta()+","+termino.getDebe()+","+termino.getHaber()+","+proceso +" DEL MES,,,,,,,,,,,,"+termino.getCentroCosto()+",,,,,,"+termino.getUltimoDiaMes()+","+termino.getUltimoDiaMes()+",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
             }else{
             pw.println(termino.getCodCuenta()+","+termino.getDebe()+","+termino.getHaber()+","+proceso +" DEL MES"+termino.getNombre()+" ,,,,,,,,,,,,,,,"+termino.getCodAux()+","+termino.getTipoMov()+","+termino.getNumDoc()+","+termino.getUltimoDiaMes()+","+termino.getUltimoDiaMes()+","+termino.getTipoMov()+","+termino.getNumDoc()+",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");  
             }
             
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
    
        public int[] getTotalesMov(List<MovContable> listaMov){
            int debe=0;
            int haber=0;
            int[] totales= new int[2];
          
            for(MovContable mov:listaMov){
                debe=debe+mov.getDebe();
                haber=haber+mov.getHaber();

            }
            
            
            
            totales[0]= debe;
           totales[1]=haber;
                
           
           return totales;
            
        }
    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
