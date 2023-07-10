package com.mycompany.proyecto_final;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author victo
 */
//historial
public class RegistroPagosParqueo {
//nit cliente

    private String nitCliente;
    //numero del parqueo del vehiculo

    private String nParqueo;
    //opcion de pago -> codigo del tipo de pago
    private String cPago;
    //monto del pago
    private String mPago;
    //numero de autorizacion 
//Numero de autorizacion
    private String nComprobantePago;
//fecha del pago
    private String fPago;

    public RegistroPagosParqueo(String nitCliente, String nParqueo, String cPago, String mPago, String nComprobantePago, String fPago) {
        this.nParqueo = nParqueo;
        this.cPago = cPago;
        this.mPago = mPago;
        this.nComprobantePago = nComprobantePago;
        this.fPago = fPago;
        this.nitCliente = nitCliente;
    }

    public String getNitCliente() {
        return nitCliente;
    }

    public void setNitCliente(String nitCliente) {
        this.nitCliente = nitCliente;
    }

    public String getnParqueo() {
        return nParqueo;
    }

    public void setnParqueo(String nParqueo) {
        this.nParqueo = nParqueo;
    }

    public String getcPago() {
        return cPago;
    }

    public void setcPago(String cPago) {
        this.cPago = cPago;
    }

    public String getmPago() {
        return mPago;
    }

    public void setmPago(String mPago) {
        this.mPago = mPago;
    }

    public String getnComprobantePago() {
        return nComprobantePago;
    }

    public void setnComprobantePago(String nComprobantePago) {
        this.nComprobantePago = nComprobantePago;
    }

    public String getfPago() {
        return fPago;
    }

    public void setfPago(String fPago) {
        this.fPago = fPago;
    }

    @Override
    public String toString() {
        return "RegistroPagosParqueo{" + "nitCliente=" + nitCliente + ", nParqueo=" + nParqueo + ", cPago=" + cPago + ", mPago=" + mPago + ", nComprobantePago=" + nComprobantePago + ", fPago=" + fPago + '}';
    }

}
