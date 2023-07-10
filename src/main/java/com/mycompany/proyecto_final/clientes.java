/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final;

/**
 *
 * @author victo
 */
public class clientes {

    private String cui;
    private String nit;
//direccion residencia
    private String dRecidencia;
// nombre de la entidad donde labora
    private String nEmpresa;
// direccion donde labora
    private String dEmpresa;
//fecha de nacimiento
    private String fNacimiento;
// nombres
    private String pNombre;
    private String sNombre;
// Apellidos
    private String pApellido;
    private String sApellido;
// numero telefonico
    private String nTelefono;
// estado 
    private String estadoCliente = "1";

    public clientes(String cui, String nit, String dRecidencia, String nEmpresa, String dEmpresa, String fNacimiento, String pNombre, String sNombre, String pApellido, String sApellido, String nTelefono, String estadoCliente) {
        this.cui = cui;
        this.nit = nit;
        this.dRecidencia = dRecidencia;
        this.nEmpresa = nEmpresa;
        this.dEmpresa = dEmpresa;
        this.fNacimiento = fNacimiento;
        this.pNombre = pNombre;
        this.sNombre = sNombre;
        this.pApellido = pApellido;
        this.sApellido = sApellido;
        this.nTelefono = nTelefono;
        this.estadoCliente = estadoCliente;
    //12
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getdRecidencia() {
        return dRecidencia;
    }

    public void setdRecidencia(String dRecidencia) {
        this.dRecidencia = dRecidencia;
    }

    public String getnEmpresa() {
        return nEmpresa;
    }

    public void setnEmpresa(String nEmpresa) {
        this.nEmpresa = nEmpresa;
    }

    public String getdEmpresa() {
        return dEmpresa;
    }

    public void setdEmpresa(String dEmpresa) {
        this.dEmpresa = dEmpresa;
    }

    public String getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(String fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getpNombre() {
        return pNombre;
    }

    public void setpNombre(String pNombre) {
        this.pNombre = pNombre;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getpApellido() {
        return pApellido;
    }

    public void setpApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public String getsApellido() {
        return sApellido;
    }

    public void setsApellido(String sApellido) {
        this.sApellido = sApellido;
    }

    public String getnTelefono() {
        return nTelefono;
    }

    public void setnTelefono(String nTelefono) {
        this.nTelefono = nTelefono;
    }

    public String getEstado() {
        return estadoCliente;
    }

    public void setEstado(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    @Override
    public String toString() {
        return "clientes{" + "cui=" + cui + ", nit=" + nit + ", dRecidencia=" + dRecidencia + ", nEmpresa=" + nEmpresa + ", dEmpresa=" + dEmpresa + ", fNacimiento=" + fNacimiento + ", pNombre=" + pNombre + ", sNombre=" + sNombre + ", pApellido=" + pApellido + ", sApellido=" + sApellido + ", nTelefono=" + nTelefono + ", estadoCliente=" + estadoCliente + '}';
    }

}
