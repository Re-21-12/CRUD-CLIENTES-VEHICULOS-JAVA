/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final;

/**
 *
 * @author victo
 */
public class vehiculos {
    //numero de placa
    private String nPlaca;
    //marca de vehiculo
    private String mVehiculo;
    //linea de vehiculo
    private String lVehiculo;
    //modelo del vehiculo
    private String modVehiculo;
    //color del vehiculo
    private String cVehiculo;
    private String nCliente;
    private String estadoVehiculo ="1";

    public vehiculos(String nPlaca, String mVehiculo, String lVehiculo, String modVehiculo, String cVehiculo, String nCliente, String estadoVehiculo) {
        this.nPlaca = nPlaca;
        this.mVehiculo = mVehiculo;
        this.lVehiculo = lVehiculo;
        this.modVehiculo = modVehiculo;
        this.cVehiculo = cVehiculo;
        this.nCliente = nCliente;
        this.estadoVehiculo = estadoVehiculo;
    }

    public String getnPlaca() {
        return nPlaca;
    }

    public void setnPlaca(String nPlaca) {
        this.nPlaca = nPlaca;
    }

    public String getmVehiculo() {
        return mVehiculo;
    }

    public void setmVehiculo(String mVehiculo) {
        this.mVehiculo = mVehiculo;
    }

    public String getlVehiculo() {
        return lVehiculo;
    }

    public void setlVehiculo(String lVehiculo) {
        this.lVehiculo = lVehiculo;
    }

    public String getModVehiculo() {
        return modVehiculo;
    }

    public void setModVehiculo(String modVehiculo) {
        this.modVehiculo = modVehiculo;
    }

    public String getcVehiculo() {
        return cVehiculo;
    }

    public void setcVehiculo(String cVehiculo) {
        this.cVehiculo = cVehiculo;
    }

    public String getnCliente() {
        return nCliente;
    }

    public void setnCliente(String nCliente) {
        this.nCliente = nCliente;
    }

    public String getEstadoVehiculo() {
        return estadoVehiculo;
    }

    public void setEstadoVehiculo(String estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    @Override
    public String toString() {
        return "vehiculos{" + "nPlaca=" + nPlaca + ", mVehiculo=" + mVehiculo + ", lVehiculo=" + lVehiculo + ", modVehiculo=" + modVehiculo + ", cVehiculo=" + cVehiculo + ", nCliente=" + nCliente + ", estadoVehiculo=" + estadoVehiculo + '}';
    }
    
    
   
    
}
