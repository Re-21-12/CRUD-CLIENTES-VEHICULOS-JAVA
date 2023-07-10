package com.mycompany.proyecto_final;

import java.io.IOException;
import java.io.RandomAccessFile;

//manejo de archivos & metodos de parqueo
public class ArchivoDirecto {

    private RandomAccessFile archivo;

    //instanciar o abrir el archivo
    public void abrirArchivo() throws IOException {
        archivo = new RandomAccessFile("parqueos.txt", "rw");
    }

    //cerrar el archivo
    public void cerrarArchivo() throws IOException {
        if (archivo != null) {
            archivo.close();
        }
    }

    //escribe y rellena una cadena
    public void escribirCadena(String cadena, int longitud) throws IOException {
        StringBuffer buffer;
        if (cadena != null) {
            buffer = new StringBuffer(cadena);
        } else {
            buffer = new StringBuffer(30);
        }
        buffer.setLength(longitud);
        archivo.writeChars(buffer.toString());
    }

    //escribe un registro
    public void escribirRegistro(RegistroAsignacionParqueos parqueo) throws IOException {
        escribirCadena(parqueo.getnParqueo(), 3);
        escribirCadena(parqueo.getnPlaca(), 7);
        escribirCadena(parqueo.getNitCliente(), 10);
        escribirCadena(parqueo.getfRegistroParqueo(), 10);
    }

    //ingresa un registro
    public void ingresarRegistro(RegistroAsignacionParqueos parqueo) throws IOException {
        if (Integer.parseInt(parqueo.getnParqueo()) >= 1 && Integer.parseInt(parqueo.getnParqueo()) <= parqueo.getNUM_REGISTROS()) {
            archivo.seek((Integer.parseInt(parqueo.getnParqueo()) - 1) * parqueo.getTAMANIO_REGISTRO());
            escribirRegistro(parqueo);
        } else {
            System.out.println("El número de parqueo no es válido.");
        }
    }

    //lee una cadena del archivo
    /*public String leerCadena(int longitud) throws IOException {
        char[] arreglo = new char[longitud];
        int caracteresLeidos = 0;
        while (caracteresLeidos < longitud) {
            //nos aseguramos que lea hasta la longitud y no ocurra una exception 
            try {
                //lee el indicec y va leyendo en el archivo segun lee retorna -> luego lo asigna en la posicion [caracteresLeidos]
                arreglo[caracteresLeidos] = archivo.readChar();
            } catch (Exception e) {
                break;
            }
            caracteresLeidos++;
        }
        for (int i = 0; i < longitud; i++) {
        }
        return new String(arreglo).replace('\0', ' ').trim();
    }*/
    private String leerCadena(int longitud) throws IOException {
        char datos[] = new char[longitud], temp;
        for (int cuenta = 0; cuenta < datos.length; cuenta++) {
            try {
                temp = archivo.readChar();
                datos[cuenta] = temp;

            } catch (Exception e) {
                break;
            }
        }

        return new String(datos).replace('\0', ' ').trim();
    }

    //consulta parqueos disponibles
    public void consultarParqueosDisponibles() throws IOException {
        int parqueosDisponiblesContador = 0;
        for (int i = 1; i <= 155; i++) {
            archivo.seek((i - 1) * 30);
            String nParqueo = leerCadena(3);
            if (nParqueo.trim().isEmpty()) {
                parqueosDisponiblesContador++;
            }
        }
        System.out.println("Número de parqueo disponible: " + parqueosDisponiblesContador);
    }

    //consulta parqueos asignados
    public void consultarParqueosAsignados() throws IOException {
        for (int i = 1; i <= 155; i++) {
            archivo.seek((i - 1) * 30);
            String nParqueo = leerCadena(3);
            if (!nParqueo.trim().isEmpty()) {
                System.out.println("----------------------");
                System.out.println("Número de parqueo: " + nParqueo);
                System.out.println("Número de placa: " + leerCadena(7));
                System.out.println("NIT del cliente: " + leerCadena(10));
                System.out.println("Fecha de registro: " + leerCadena(10));
                System.out.println("----------------------");
            }
        }
    }

    //consulta un parqueo específico
    public boolean consultarParqueoEspecifico(int numeroParqueo) throws IOException {
        boolean parqueoEncontrado = false;
        if (numeroParqueo >= 1 && numeroParqueo <= 155) {
            archivo.seek((numeroParqueo - 1) * 30);
            String nParqueo = leerCadena(3);
            if (!nParqueo.trim().isEmpty()) {
                parqueoEncontrado = true;
                System.out.println("Número de parqueo: " + nParqueo);
                System.out.println("Número de placa: " + leerCadena(7));
                System.out.println("NIT del cliente: " + leerCadena(10));
                System.out.println("Fecha de registro: " + leerCadena(10));
            } else {
                System.out.println("El parqueo especificado está disponible.");
            }
        } else {
            System.out.println("El número de parqueo especificado no es válido.");
        }
        return parqueoEncontrado;
    }

    //escribe una cadena modificada en el archivo
    public void escribirCadenaModificada(String cadena, int longitud) throws IOException {
        StringBuffer buffer;
        if (cadena != null) {
            buffer = new StringBuffer(cadena);
        } else {
            buffer = new StringBuffer(longitud);
        }
        buffer.setLength(longitud);
        archivo.writeChars(buffer.toString());
    }

    //modifica un parqueo
    public void modificarParqueo(int numeroParqueo, String nuevaPlaca, String nuevoNIT, String nuevaFechaRegistro) throws IOException {
        int posicion = (numeroParqueo - 1) * 30;
        if (numeroParqueo >= 1 && numeroParqueo <= 155) {
            archivo.seek(posicion);
            escribirCadenaModificada(nuevaPlaca, 7);
            escribirCadenaModificada(nuevoNIT, 10);
            escribirCadenaModificada(nuevaFechaRegistro, 10);
        } else {
            throw new IllegalArgumentException("El número de parqueo especificado no es válido.");
        }
    }
}
