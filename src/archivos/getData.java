/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import Model.MovContable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jean
 */
public class getData extends Dao {
    
    
    
    
    public void ingresarNcafas(String nombrefamilia ,int parteproceso ,String rutUsuario)  {
    
        
    try{
           
        this.Conectar();
        PreparedStatement stmt = null;
        
            stmt = con.prepareStatement("INSERT INTO ncfas (nombrefamilia,parteproceso,fecha,Usuario_rut)"
            + " values (?,?,?,?)");  
            stmt.setString(1, nombrefamilia);
            stmt.setInt(2, parteproceso);
            stmt.setString(4, rutUsuario);
            /*stmt.setString(4, usuario.getRut())*/
            int retorno = stmt.executeUpdate();
            System.out.println("biiieennntoo");

        }catch (SQLException sqle) {
            System.out.println("SQLState: "
                    + sqle.getSQLState());
            System.out.println("SQLErrorCode: "
                    + sqle.getErrorCode());
            sqle.printStackTrace();
        } finally { 
            this.Cerrar();
        }
    }
    
     public List<String> getidTestsExaminado(String fecha,int empresa){
    
        Statement stmt = null;
        ResultSet rs = null;      
      List<String> lista= new ArrayList();   
    try{
           
   
        this.Conectar();
      
        stmt = this.con.createStatement();
      //      rs = stmt.executeQuery("SELECT idTest FROM relato WHERE test_idTest ='"+rutExaminado+"' ORDER BY idTest ASC");
            // rs = stmt.executeQuery("SELECT idRelato FROM relato WHERE test_idTest =511");
                String queryString = "/****** Script for SelectTopNRows command from SSMS  ******/\n" +
"\n" +
"SELECT [CENCO2_CODI]\n" +
"      ,[FECHA]\n" +
"      ,[AREA_CODI]\n" +
"      ,[EMP_CODI]\n" +
"      ,[CTA3]\n" +
"      ,[DEBE-HABER]\n" +
"      ,SUM([VARIABLE_MONTO]) as MONTO\n" +
"      \n" +
"       from\n" +
"\n" +
"(\n" +
"SELECT [CENCO2_CODI]\n" +
"      ,[FECHA]\n" +
"      ,[VARIABLE_CODI]\n" +
"      ,[VARIABLE_MONTO]\n" +
"      ,[AREA_CODI]\n" +
"      ,[EMP_CODI]\n" +
"      ,case when VARIABLE_CODI IN ('H008','H007','H001','H650') then '50-01-001'\n" +
"        when VARIABLE_CODI IN ('H003','H002') then '50-01-003' \n" +
"        when VARIABLE_CODI IN ('H031','H030','H029') then '50-01-002'\n" +
"        when VARIABLE_CODI IN ('H350','H074','H044','H043','H024','H020','H013','H050') then '50-01-004'\n" +
"        when VARIABLE_CODI IN ('H073','H064','H062','H060') then '50-01-006'\n" +
"        when VARIABLE_CODI IN ('H351','H080') then '50-01-005'\n" +
"        when VARIABLE_CODI IN ('H027','H026','H025') then '50-01-014'\n" +
"        when VARIABLE_CODI IN ('P991') then '50-01-008'\n" +
"        when VARIABLE_CODI IN ('D200') then '50-01-009'\n" +
"        when VARIABLE_CODI IN ('H085') then '50-01-016'\n" +
"        when VARIABLE_CODI IN ('P205') then '50-01-018'\n" +
"        when VARIABLE_CODI IN ('P044') then '50-01-022'\n" +
"        when VARIABLE_CODI IN ('P016') then '50-01-023'\n" +
"       --HABER\n" +
"       when VARIABLE_CODI IN ('D090') then '50-01-001'\n" +
"       \n" +
"       \n" +
"       end as 'CTA3'\n" +
"       ,case when VARIABLE_CODI in ('H008','H007','H001','H650','H003','H002','H031','H030','H029','H350','H074','H044','H043','H024','H020','H013','H050',\n" +
"       'H073','H064','H062','H060','H351','H080','H027','H026','H025','P991','D200','H085','P205','P044','P016') then 'DEBE' \n" +
"          when variable_codi in('D090') then 'HABER' end as 'DEBE-HABER' \n" +
"      \n" +
"  FROM [Inteligencias].[dbo].[RRHH_ESTRUCTURA_SUELDO]\n" +
"  \n" +
"  where DIA_DESC='HASTA MES EN CURSO' and ESTADO_PER='V' and FECHA='"+fecha+"' and EMP_CODI='"+empresa+"' and AREA_CODI='002'\n" +
"  \n" +
"  )a\n" +
"   \n" +
"   where [CTA3] is not null\n" +
"  \n" +
"   group by \n" +
"  \n" +
"  [CENCO2_CODI]\n" +
"      ,[FECHA]\n" +
"      ,[VARIABLE_CODI]\n" +
"      ,[VARIABLE_MONTO]\n" +
"      ,[AREA_CODI]\n" +
"      ,[EMP_CODI]\n" +
"      ,[CTA3]\n" +
"      ,[DEBE-HABER]\n" +
"      \n" +
"     ";
            
            
      rs = stmt.executeQuery(queryString);      
            
            while (rs.next()) {
              
                lista.add(rs.getObject(1).toString());
            } 

            System.out.println(" la lista es ");
            for (String list: lista){
                System.out.println("relato"+list);
            }
            
            
            /*stmt.setString(4, usuario.getRut())*/
     
            System.out.println("biiieennntoo");

         } catch (SQLException e) {
           
        }  finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {
            }
        }
    
     return lista;
    }
     

              public List<String> getAreasNegocios(String fecha,int empresa,boolean todas){
    
        Statement stmt = null;
        ResultSet rs = null;      
      List<String> lista= new ArrayList();   
    try{
           
   
        this.Conectar();
      
        stmt = this.con.createStatement();
      //      rs = stmt.executeQuery("SELECT idTest FROM relato WHERE test_idTest ='"+rutExaminado+"' ORDER BY idTest ASC");
            // rs = stmt.executeQuery("SELECT idRelato FROM relato WHERE test_idTest =511");
                String queryString = "select distinct  AREA_CODI\n" +
"  \n" +
"  FROM [Inteligencias].[dbo].[RRHH_ESTRUCTURA_SUELDO]\n" +
"  where DIA_DESC='HASTA MES EN CURSO' and ESTADO_PER='V' and EMP_CODI="+empresa+" and FECHA='"+fecha+"'  ";
            
            
      rs = stmt.executeQuery(queryString);      
            
           if(todas==true){
               lista.add("Todas");
           }
      
            while (rs.next()) {
                String area=rs.getObject(1).toString();
     
                lista.add(area);
            } 

          //  System.out.println(" la lista es ");
          //  for (String list: lista){
          //      System.out.println("relato"+list);
          //  }
            
            
            /*stmt.setString(4, usuario.getRut())*/
     
            System.out.println("biiieennntoo");

         } catch (SQLException e) {
           
        }  finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {
            }
        }
    
     return lista;
    }




     

     
     
         public List<MovContable> getResumenCuentasMes(String fecha,int empresa,String area){
             
            String areaQuery= area.equals("Todas")?"":"and AREA_CODI='"+area+"'" ;
    
        Statement stmt = null;
        ResultSet rs = null;      
      List<MovContable> lista= new ArrayList();   
    try{
           
   
        this.Conectar();
      
        stmt = this.con.createStatement();
      //      rs = stmt.executeQuery("SELECT idTest FROM relato WHERE test_idTest ='"+rutExaminado+"' ORDER BY idTest ASC");
            // rs = stmt.executeQuery("SELECT idRelato FROM relato WHERE test_idTest =511");
                String queryString = " SELECT  \n" +
"      [CTA3] \n" +
"      ,CTA3_DESC \n" +
"      ,case when [DEBE-HABER]='DEBE' then  SUM([VARIABLE_MONTO]) else 0 end as 'DEBE' \n" +
"      ,case when [DEBE-HABER]='HABER' then  SUM([VARIABLE_MONTO]) else 0 end as 'HABER' \n" +                      
"      ,SUM([VARIABLE_MONTO]) as 'MONTO' \n" +
"       \n" +
"       from \n" +
" \n" +
"( \n" +
"SELECT [CENCO2_CODI] \n" +
"      ,[FECHA] \n" +
"      ,[VARIABLE_CODI] \n" +
"      ,[VARIABLE_MONTO] \n" +
"      ,[AREA_CODI] \n" +
"      ,[EMP_CODI] \n" +
"      ,case when VARIABLE_CODI IN ('H008','H007','H001','H650') then '50-01-001' \n" +
"        when VARIABLE_CODI IN ('H003','H002') then '50-01-003'  \n" +
"        when VARIABLE_CODI IN ('H031','H030','H029') then '50-01-002' \n" +
"        when VARIABLE_CODI IN ('H350','H074','H044','H043','H024','H020','H013','H050') then '50-01-004' \n" +
"        when VARIABLE_CODI IN ('H073','H064','H062','H060') then '50-01-006' \n" +
"         when VARIABLE_CODI IN ('H065','H063','H061') then '50-01-007' -- se añadio completo\n" +
"        when VARIABLE_CODI IN ('H351','H080') then '50-01-005' \n" +
"        when VARIABLE_CODI IN ('H027','H026','H025') then '50-01-014' \n" +
"        when VARIABLE_CODI IN ('P991') then '50-01-008' \n" +
"        when VARIABLE_CODI IN ('D200') then '50-01-009' \n" +
"        when VARIABLE_CODI IN ('H085') then '50-01-016' \n" +
"        when VARIABLE_CODI IN ('P205') then '50-01-018' \n" +
"        when VARIABLE_CODI IN ('P044') then '50-01-022' \n" +
"        when VARIABLE_CODI IN ('H016') then '50-01-023' \n" +
" \n" +
"               --OTRAS CUENTAS \n" +
"        --DEBE-- \n" +
"        when VARIABLE_CODI IN ('H072','H071','H015') then '20-01-106' \n" +
"\n" +
"        \n" +
"        \n" +
"       end as 'CTA3' \n" +
"       ,'DEBE' as  'DEBE-HABER' \n" +
"         \n" +
"\n" +
"       \n" +
"  FROM [Inteligencias].[dbo].[RRHH_ESTRUCTURA_SUELDO] \n" +
"   \n" +
"--  where DIA_DESC='HASTA MES EN CURSO' and ESTADO_PER='V' and EMP_CODI=empresa and FECHA='20170101' and AREA_CODI='002'  \n" +
"  where DIA_DESC='HASTA MES EN CURSO'    and ESTADO_PER='V'  and  EMP_CODI="+empresa+" and FECHA='"+fecha+"' "+areaQuery+"  \n" +"    \n" +
"  and VARIABLE_CODI in ('H008','H007','H001','H650','H003','H002','H031','H030','H029','H350','H074','H044','H043','H024','H020','H013','H050', \n" +
"       'H073','H064','H062','H060','H065','H063','H061','H351','H080','H027','H026','H025','P991','D200','H085','P205','P044','H016'\n" +
"       --OTRAS CUENTAS\n" +
"       ,'H072','H071','H015'\n" +
"       )\n" +
"       \n" +
"        )a \n" +
"   \n" +
"  left join Inteligencias.dbo.CUENTAS_APERTURA_FUNC as ap on ap.CTA3_CODI=a.CTA3  \n" +
"    \n" +
"   where [CTA3] is not null \n" +
"   \n" +
"   group by  \n" +
"   \n" +
" \n" +
" \n" +
"       \n" +
"      [CTA3] \n" +
"      ,ap.CTA3_DESC \n" +
"      ,[DEBE-HABER]\n" +
"\n" +
"  \n" +
"  \n" +
"  UNION\n" +
"  \n" +
"  SELECT  \n" +
"      [CTA3] \n" +
"      ,CTA3_DESC \n" +
"      ,case when [DEBE-HABER]='DEBE' then  SUM([VARIABLE_MONTO]) else 0 end as 'DEBE' \n" +
"      ,case when [DEBE-HABER]='HABER' then  SUM([VARIABLE_MONTO]) else 0 end as 'HABER' \n" +
"      ,SUM([VARIABLE_MONTO]) as 'MONTO' \n" +
"       \n" +
"       from \n" +
" \n" +
"( \n" +
"  \n" +
"  \n" +
"  SELECT [CENCO2_CODI] \n" +
"      ,[FECHA] \n" +
"      ,[VARIABLE_CODI] \n" +
"      ,[VARIABLE_MONTO] \n" +
"      ,[AREA_CODI] \n" +
"      ,[EMP_CODI] \n" +
"      ,case \n" +
"       --HABER \n" +
"       when VARIABLE_CODI IN ('D090') then '50-01-001' \n" +
"       \n" +
"               --OTRAS CUENTAS \n" +
"        --HABER \n" +
"        when VARIABLE_CODI IN ('P205','D200','D009','D007','D006','D005','D004','D003') then '20-01-107' \n" +
"        when VARIABLE_CODI IN ('D021') then '20-01-108' \n" +
"        when VARIABLE_CODI IN ('D022','D020') then '20-01-109' \n" +
"        when VARIABLE_CODI IN ('D040','D032','D031','D030') then '20-01-110' \n" +
"        when VARIABLE_CODI IN ('D050') then '20-01-111' \n" +
"        when VARIABLE_CODI IN ('D080','D065') then '20-01-060' \n" +
"        when VARIABLE_CODI IN ('D070') then '20-01-112' \n" +
"        when VARIABLE_CODI IN ('P991') then '20-01-113' \n" +
"        when VARIABLE_CODI IN ('H303') then '20-01-072' \n" +
"        when VARIABLE_CODI IN ('D063','D062','D060') then '10-01-081' \n" +
"        when VARIABLE_CODI IN ('D091') then '40-03-999' \n" +
"        \n" +
"        \n" +
"       end as 'CTA3'  \n" +
"         ,'HABER' as 'DEBE-HABER'  \n" +
"       \n" +
"  FROM [Inteligencias].[dbo].[RRHH_ESTRUCTURA_SUELDO] \n" +
"   \n" +
"--  where DIA_DESC='HASTA MES EN CURSO' and ESTADO_PER='V' and EMP_CODI=empresa and FECHA='20170101' and AREA_CODI='002'  \n" +
"  where DIA_DESC='HASTA MES EN CURSO'    and ESTADO_PER='V'  and  EMP_CODI="+empresa+" and FECHA='"+fecha+"' "+areaQuery+"  \n" +"    \n" +
"  and variable_codi in('D090'\n" +
"          --OTRAS CUENTAS\n" +
"          ,'P205','D200','D009','D007','D006','D005','D004','D003','D021','D022','D020','D040','D032','D031','D030','D050','D080','D065'\n" +
"          ,'D070','P991','H303','D063','D062','D060','D091')\n" +
"          \n" +
"                  )a \n" +
"   \n" +
"  left join Inteligencias.dbo.CUENTAS_APERTURA_FUNC as ap on ap.CTA3_CODI=a.CTA3  \n" +
"    \n" +
"   where [CTA3] is not null \n" +
"   \n" +
"   group by  \n" +
"   \n" +
" \n" +
" \n" +
"       \n" +
"      [CTA3] \n" +
"      ,ap.CTA3_DESC \n" +
"      ,[DEBE-HABER]\n" +
"      \n" +
"      order by cta3 asc\n" +
"  \n" +
"                           \n" +
" \n" +
"      ";
            
            
      rs = stmt.executeQuery(queryString);      
            
            while (rs.next()) {
                String num_cuenta=rs.getObject(1).toString();
                String nombre_cuenta=rs.getObject(2).toString();
                int debe=  ((Number)rs.getObject(3)).intValue();
                int haber= ((Number)rs.getObject(4)).intValue();
                
              MovContable mov=new MovContable(num_cuenta, nombre_cuenta, debe, haber);
                lista.add(mov);
            } 

          //  System.out.println(" la lista es ");
          //  for (String list: lista){
          //      System.out.println("relato"+list);
          //  }
            
            
            /*stmt.setString(4, usuario.getRut())*/
     
            System.out.println("biiieennntoo");

         } catch (SQLException e) {
           
        }  finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {
            }
        }
    
     return lista;
    }
         
         
         
         
          public List<MovContable> getResumenPorArea(String fecha,int empresa,String area,String likeFicha,boolean notlike){
              //genera statement para la ficha si es administrativo o no
             String notlikevarchar=notlike==true? "":"not";
             

             // String likeStmt= likeFicha==null ? "": "and FICHA "+notlikevarchar+"  like '%"+likeFicha+"%' ";
             String likeStmt= likeFicha==null ? "": "and "+notlikevarchar+" (FICHA  like 'ADM%' or FICHA like '13ADM%' or FICHA='HOVIC75')  ";
              
              
        Statement stmt = null;
        ResultSet rs = null;      
      List<MovContable> lista= new ArrayList();   
    try{
           
   
        this.Conectar();
      
        stmt = this.con.createStatement();
      //      rs = stmt.executeQuery("SELECT idTest FROM relato WHERE test_idTest ='"+rutExaminado+"' ORDER BY idTest ASC");
            // rs = stmt.executeQuery("SELECT idRelato FROM relato WHERE test_idTest =511");
                String queryString = "SELECT [CENCO2_CODI] \n" +
"      ,[FECHA] \n" +
"      ,[AREA_CODI] \n" +
"      ,[EMP_CODI] \n" +
"      ,[CTA3] \n" +
"      ,[DEBE-HABER] \n" +
"      ,SUM([VARIABLE_MONTO]) as MONTO \n" +
"       \n" +
"       from \n" +
" \n" +
"( \n" +
"SELECT [CENCO2_CODI] \n" +
"      ,[FECHA] \n" +
"      ,[VARIABLE_CODI] \n" +
"      ,[VARIABLE_MONTO] \n" +
"      ,[AREA_CODI] \n" +
"      ,[EMP_CODI] \n" +
"      ,case when VARIABLE_CODI IN ('H008','H007','H001','H650') then '50-01-001' \n" +
"        when VARIABLE_CODI IN ('H003','H002') then '50-01-003'  \n" +
"        when VARIABLE_CODI IN ('H031','H030','H029') then '50-01-002' \n" +
"        when VARIABLE_CODI IN ('H350','H074','H044','H043','H024','H020','H050','H013') then '50-01-004'\n" +
"        when VARIABLE_CODI IN ('H073','H064','H062','H060') then '50-01-006' \n" +
"         when VARIABLE_CODI IN ('H065','H063','H061') then '50-01-007' -- se añadio completo\n" +
"        when VARIABLE_CODI IN ('H351','H080') then '50-01-005' \n" +
"        when VARIABLE_CODI IN ('H027','H026','H025') then '50-01-014' \n" +
"        when VARIABLE_CODI IN ('P991') then '50-01-008' \n" +
"        when VARIABLE_CODI IN ('D200') then '50-01-009' \n" +
"        when VARIABLE_CODI IN ('H085') then '50-01-016' \n" +
"        when VARIABLE_CODI IN ('P205') then '50-01-018' \n" +
"        when VARIABLE_CODI IN ('P044') then '50-01-022' \n" +
"        when VARIABLE_CODI IN ('H016') then '50-01-023' --cambio de p a h\n" +
"       --HABER \n" +
"       when VARIABLE_CODI IN ('D090') then '50-01-001' \n" +
"        \n" +
"        \n" +
"       end as 'CTA3' \n" +
"       ,case when VARIABLE_CODI in ('H008','H007','H001','H650','H003','H002','H031','H030','H029','H350','H074','H044','H043','H024','H020','H050','H013', \n" +
"      'H065','H063','H061', 'H073','H064','H062','H060','H351','H080','H027','H026','H025','P991','D200','H085','P205','P044','H016') then 'DEBE'  \n" +
"          when variable_codi in('D090') then 'HABER' end as 'DEBE-HABER'  \n" +
"       \n" +
"  FROM [Inteligencias].[dbo].[RRHH_ESTRUCTURA_SUELDO] \n" +
"   \n" +
"  where DIA_DESC='HASTA MES EN CURSO'    and ESTADO_PER='V'  and  EMP_CODI="+empresa+" and FECHA='"+fecha+"' and AREA_CODI='" +area+"' "+likeStmt+"    \n" +
"   \n" +
"  )a \n" +
"    \n" +
"   where [CTA3] is not null \n" +
"   \n" +
"   group by  \n" +
"   \n" +
"  [CENCO2_CODI] \n" +
"      ,[FECHA] \n" +
"      ,[AREA_CODI] \n" +
"      ,[EMP_CODI] \n" +
"      ,[CTA3] \n" +
"      ,[DEBE-HABER]  ";
                
         //       System.out.println(queryString);
            
            
      rs = stmt.executeQuery(queryString);      
            
            while (rs.next()) {
                String num_cuenta=rs.getObject(5).toString();
             //   String nombre_cuenta=rs.getObject(2).toString();
             int debe=0;
             int haber=0;
             
             if( rs.getObject(6).toString().equals("DEBE")){
                 debe=((Number)rs.getObject(7)).intValue();
                
            } if( rs.getObject(6).toString().equals("HABER")){
                 haber=((Number)rs.getObject(7)).intValue();
            }
             
          String centroCosto=rs.getObject(1).toString();
          String fechaMov=rs.getObject(2).toString();
          String areaMov=rs.getObject(3).toString();
          String empresaMov=rs.getObject(4).toString();
                
              MovContable mov=new MovContable(num_cuenta, centroCosto, area, fecha, empresaMov, debe, haber);
                lista.add(mov);
            } 

          //  System.out.println(" la lista es ");
          //  for (String list: lista){
          //      System.out.println("relato"+list);
          //  }
            
            
            /*stmt.setString(4, usuario.getRut())*/
     
            System.out.println("biiieennntoo");

         } catch (SQLException e) {
           
        }  finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {
            }
        }
    
     return lista;
    }

          
          
          public List<MovContable> getOtrasCuentas(String fecha,int empresa,String area){
              //genera statement para la ficha si es administrativo o no
           
              
              
        Statement stmt = null;
        ResultSet rs = null;      
      List<MovContable> lista= new ArrayList();   
    try{
           
   
        this.Conectar();
      
        stmt = this.con.createStatement();
      //      rs = stmt.executeQuery("SELECT idTest FROM relato WHERE test_idTest ='"+rutExaminado+"' ORDER BY idTest ASC");
            // rs = stmt.executeQuery("SELECT idRelato FROM relato WHERE test_idTest =511");
                                String queryString = "SELECT a.[CENCO2_CODI]     \n" +
"        ,a.[FECHA]     \n" +
"        ,a.[AREA_CODI]     \n" +
"        ,a.[EMP_CODI]     \n" +
"        ,a.[CTA3]     \n" +
"        ,a.[DEBE-HABER]  \n" +
"        ,a.[FICHA]    \n" +
"        ,pers.NOMBRES\n" +
"        ,pers.RUT\n" +
"        ,SUM(a.[VARIABLE_MONTO]) as MONTO     \n" +
"             \n" +
"         from     \n" +
"       \n" +
"  (     \n" +
"  SELECT [CENCO2_CODI]     \n" +
"        ,[FECHA]     \n" +
"        ,[VARIABLE_CODI]     \n" +
"        ,[VARIABLE_MONTO]     \n" +
"        ,[AREA_CODI]     \n" +
"        ,[EMP_CODI] \n" +
"        ,[FICHA]    \n" +
"        ,case     \n" +
"             \n" +
"         --OTRAS CUENTAS    \n" +
"         --DEBE--    \n" +
"         when VARIABLE_CODI IN ('H072','H071','H015') then '20-01-106'    -- En esta lista si aparece otra cuenta al debe que coincida con una al haber es necesario separar las querys y hacer union\n" +
"         --HABER    \n" +
"         when VARIABLE_CODI IN ('P205','D200','D009','D007','D006','D005','D004','D003') then '20-01-107'    \n" +
"         when VARIABLE_CODI IN ('D021') then '20-01-108'    \n" +
"         when VARIABLE_CODI IN ('D022','D020') then '20-01-109'    \n" +
"         when VARIABLE_CODI IN ('D040','D032','D031','D030') then '20-01-110'    \n" +
"         when VARIABLE_CODI IN ('D050') then '20-01-111'    \n" +
"         when VARIABLE_CODI IN ('D080','D065') then '20-01-060'    \n" +
"         when VARIABLE_CODI IN ('D070') then '20-01-112'    \n" +
"         when VARIABLE_CODI IN ('P991') then '20-01-113'    \n" +
"         when VARIABLE_CODI IN ('H303') then '20-01-072'    \n" +
"         when VARIABLE_CODI IN ('D063','D062','D060') then '10-01-081'    \n" +
"         when VARIABLE_CODI IN ('D091') then '40-03-999'    \n" +
"              \n" +
"              \n" +
"         end as 'CTA3'     \n" +
"         ,case when VARIABLE_CODI in ('H072','H071','H015') then 'DEBE'      \n" +
"            when variable_codi in('P205','D200','D009','D007','D006','D005','D004','D003','D021','D022','D020','D040','D032','D031','D030','D050','D080','D070','P991','H303','D063','D062','D060','D091') then 'HABER' end as 'DEBE-HABER'      \n" +
"             \n" +
"    FROM [Inteligencias].[dbo].[RRHH_ESTRUCTURA_SUELDO]     \n" +
"         \n" +
"  where DIA_DESC='HASTA MES EN CURSO'    and ESTADO_PER='V'  and  EMP_CODI="+empresa+" and FECHA='"+fecha+"' and AREA_CODI='" +area+"' \n" +
"    )a  \n" +
"    left join inteligencias.dbo.RRHH_PERSONAL_SOFT as pers  on a.FICHA=pers.FICHA and a.EMP_CODI=pers.EMP_CODI and a.FECHA=pers.FECHA_SOFT   \n" +
"          \n" +
"     where [CTA3] is not null     \n" +
"         \n" +
"     group by      \n" +
"         \n" +
"    a.[CENCO2_CODI]     \n" +
"        ,a.[FECHA]     \n" +
"        ,a.[VARIABLE_CODI]     \n" +
"        ,a.[VARIABLE_MONTO]     \n" +
"        ,a.[AREA_CODI]     \n" +
"        ,a.[EMP_CODI]     \n" +
"        ,a.[CTA3]     \n" +
"        ,a.[DEBE-HABER] \n" +
"        ,a.[FICHA] \n" +
"        ,pers.NOMBRES\n" +
"        ,pers.RUT";
                
         //       System.out.println(queryString);
            
            
      rs = stmt.executeQuery(queryString);      
            
            while (rs.next()) {
                String num_cuenta=rs.getObject(5).toString();
             //   String nombre_cuenta=rs.getObject(2).toString();
             int debe=0;
             int haber=0;
             
             if( rs.getObject(6).toString().equals("DEBE")){
                 debe=((Number)rs.getObject(10)).intValue();
                
            } if( rs.getObject(6).toString().equals("HABER")){
                 haber=((Number)rs.getObject(10)).intValue();
            }
             
          String centroCosto=rs.getObject(1).toString();
          String fechaMov=rs.getObject(2).toString();
          String areaMov=rs.getObject(3).toString();
          String empresaMov=rs.getObject(4).toString();
          String tipoMov="TR"; //Traspaso
          String ficha=rs.getObject(7).toString();
          String nombres=rs.getObject(8).toString();
          String rut=rs.getObject(9).toString();
                
       //       MovContable mov=new MovContable(num_cuenta, centroCosto, area, fecha, empresaMov, debe, haber);
        MovContable mov=new MovContable(num_cuenta, centroCosto, area, fecha, empresaMov, debe, haber,tipoMov,ficha,rut,nombres);
                lista.add(mov);
            } 

          //  System.out.println(" la lista es ");
          //  for (String list: lista){
          //      System.out.println("relato"+list);
          //  }
            
            
            /*stmt.setString(4, usuario.getRut())*/
     
            System.out.println("biiieennntoo");

         } catch (SQLException e) {
           
        }  finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {
            }
        }
    
     return lista;
    }
          
          //     public List<String> getAreasNegocios(String fecha,int empresa){
//    
//         
//      List<String> lista= new ArrayList();  
//      lista.add("002");
//      lista.add("012");
//      lista.add("003");
//      lista.add("006");
//   
//    
//     return lista;
//    }


    
          //     public List<MovContable> getResumenPorArea(String fecha,int empresa,String area,String likeFicha,boolean notlike){
//     
//         List<MovContable> lista=new ArrayList();
//         MovContable mov1=new MovContable("50-01-001","911-001","002", "20170101", "0",0,0);
//         MovContable mov2=new MovContable("50-01-002","911-001","012", "20170101", "0",0,0);
//         MovContable mov3=new MovContable("50-01-003","911-001","003", "20170101", "0",0,0);
//         MovContable mov4=new MovContable("50-01-004","911-001","006", "20170101", "0",0,0);
//         MovContable mov5=new MovContable("50-01-001","911-001","012", "20170101", "0",0,0);
//          MovContable mov6=new MovContable("50-01-002","911-001","002", "20170101", "0",0,0);
//         MovContable mov7=new MovContable("50-01-002","911-001","002", "20170101", "0",0,0);
//         lista.add(mov1);
//         lista.add(mov2);
//         lista.add(mov3);
//         lista.add(mov4);
//         lista.add(mov5);
//         lista.add(mov6);
//         lista.add(mov7);
//         
//         
//         return lista;
//         
//         
//     }
    
//     public List<MovContable> getResumenCuentasMes(String fecha,int empresa){
//             List<MovContable> lista=new ArrayList();
//         MovContable mov1=new MovContable("50-01-001","911-001","002", "20170101", "0",0,0);
//         MovContable mov2=new MovContable("50-01-002","911-001","012", "20170101", "0",0,0);
//         MovContable mov3=new MovContable("50-01-003","911-001","003", "20170101", "0",0,0);
//         MovContable mov4=new MovContable("50-01-004","911-001","006", "20170101", "0",0,0);
//         MovContable mov5=new MovContable("50-01-001","911-001","012", "20170101", "0",0,0);
//          MovContable mov6=new MovContable("50-01-002","911-001","002", "20170101", "0",0,0);
//         MovContable mov7=new MovContable("50-01-002","911-001","002", "20170101", "0",0,0);
//         lista.add(mov1);
//         lista.add(mov2);
//         lista.add(mov3);
//         lista.add(mov4);
//         lista.add(mov5);
//         lista.add(mov6);
//         lista.add(mov7);
//         
//         
//         return lista;
//         
//         
//     }
          
    
}