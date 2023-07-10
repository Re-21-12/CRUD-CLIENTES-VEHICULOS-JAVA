/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final;

/**
 *
 * @author victo
 */
//poo de registro asignacion
public class RegistroAsignacionParqueos {
    private static final int TAMANIO_REGISTRO = 30; // Tamaño en bytes de cada registro
    private static final int NUM_REGISTROS = 155; // Número total de registros
    //numero de parqueo -> en bytes 3 referente a 155 espacios
    //125 vehiculos livianos
    //30 motocicletas
    // numero de parqueo 3
    private String nParqueo;
    //numero de placa vehiculo o moto 7 espacios en bytes
    private String nPlaca;
    //nit de propietario 10 hipoteticos en bytes
    private String nitCliente;
    // fecha de registro en el parqueo dd/mm/yyyy = 10 digitos en byytes
    private String fRegistroParqueo;

    public RegistroAsignacionParqueos(String nParqueo, String nPlaca, String nitCliente, String fRegistroParqueo) {
        this.nParqueo = nParqueo;
        this.nPlaca = nPlaca;
        this.nitCliente = nitCliente;
        this.fRegistroParqueo = fRegistroParqueo;
    }

    public String getnParqueo() {
        return nParqueo;
    }

    public void setnParqueo(String nParqueo) {
        this.nParqueo = nParqueo;
    }

    public String getnPlaca() {
        return nPlaca;
    }

    public void setnPlaca(String nPlaca) {
        this.nPlaca = nPlaca;
    }

    public String getNitCliente() {
        return nitCliente;
    }

    public void setNitCliente(String nitCliente) {
        this.nitCliente = nitCliente;
    }

    public String getfRegistroParqueo() {
        return fRegistroParqueo;
    }

    public void setfRegistroParqueo(String fRegistroParqueo) {
        this.fRegistroParqueo = fRegistroParqueo;
    }
    //retornar el espacio necesario para el tamanio del objeto en el archivo
    public int getTAMANIO_REGISTRO(){
        return TAMANIO_REGISTRO;
    }
    //retorna la cantidad de objetos totales disponibles o epsacios disponibles en el archivo
   public int getNUM_REGISTROS(){
        return NUM_REGISTROS;
    }
    @Override
    public String toString() {
        return "registroAsignacionParqueos{" + "nParqueo=" + nParqueo + ", nPlaca=" + nPlaca + ", nitCliente=" + nitCliente + ", fRegistroParqueo=" + fRegistroParqueo + '}';
    }

}
