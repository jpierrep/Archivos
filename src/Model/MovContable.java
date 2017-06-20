/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author jpierre
 */
public class MovContable {
    
    private String codCuenta;
    private String nombreCuenta;
    private String CentroCosto;
    private int monto;
    private String area;
    private String fecha;
    private String empresa;
    private int debe;
    private int haber;
    //parametros por persona (cuentas diferente de 50-
    private String tipoMov;
    private String ficha;
    private String rut;
    private String nombre;
    

    public MovContable(String codCuenta, String CentroCosto, String area, String fecha, String empresa, int debe, int haber, String tipoMov,String ficha, String rut, String nombre) {
        this.codCuenta = codCuenta;
        this.CentroCosto = CentroCosto;
        this.area = area;
        this.fecha = fecha;
        this.empresa = empresa;
        this.debe = debe;
        this.haber = haber;
        this.tipoMov = tipoMov;
        this.ficha=ficha;
        this.rut = rut;
        this.nombre = nombre;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public String getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(String tipoMov) {
        this.tipoMov = tipoMov;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public MovContable(String codCuenta, String nombreCuenta, int debe, int haber) {
        this.codCuenta = codCuenta;
        this.nombreCuenta = nombreCuenta;
        this.debe = debe;
        this.haber = haber;
    }

    public int getDebe() {
        return debe;
    }

    public MovContable(String codCuenta, String CentroCosto, String area, String fecha, String empresa, int debe, int haber) {
        this.codCuenta = codCuenta;
        this.CentroCosto = CentroCosto;
        this.area = area;
        this.fecha = fecha;
        this.empresa = empresa;
        this.debe = debe;
        this.haber = haber;
    }

    public void setDebe(int debe) {
        this.debe = debe;
    }

    public int getHaber() {
        return haber;
    }

    public void setHaber(int haber) {
        this.haber = haber;
    }
   

    public MovContable(String codCuenta, String nombreCuenta, int monto) {
        this.codCuenta = codCuenta;
        this.nombreCuenta = nombreCuenta;
        this.monto = monto;
    }

    public MovContable() {
    }
    
   

    public String getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(String codCuenta) {
        this.codCuenta = codCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getCentroCosto() {
        return CentroCosto;
    }

    public void setCentroCosto(String CentroCosto) {
        this.CentroCosto = CentroCosto;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    public String getCodAux(){
    String aux=rut.substring(0,rut.length()-2);
    aux=aux.replace(".", ""); // sin puntos
    int auxInt=Integer.parseInt(aux); //quita los 0s del comienzo
    aux=Integer.toString(auxInt); //retorna el string
    return aux;
}
    
    public String getNumDoc(){ // corresponde al mes en cuestion donde se efectua la contabilizacion (ultimo dia)
        String ultimoDia="";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyymmdd");
        try {
        Date fecha2=formatter.parse(fecha);
         Calendar c = Calendar.getInstance();
        c.setTime(fecha2);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat formatter2 = new SimpleDateFormat("ddmmyyyy");
        ultimoDia=   formatter2.format(c.getTime()); 
    
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ultimoDia;
    }
    
}
