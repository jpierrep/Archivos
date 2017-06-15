/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
     
    
}
