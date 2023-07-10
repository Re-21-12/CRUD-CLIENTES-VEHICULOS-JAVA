/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_final;

import java.io.*;
import java.util.*;

/**
 *
 * @author victo
 */
public class ArchivoSecuencial {

    //validar numero de telefono
    public static boolean validarNumeroTelefono(String NumeroTelefono) {
        boolean validarNumero = false;
        int cuentaNumero = 0;
        for (int i = 0; i < NumeroTelefono.length(); i++) {
            switch (NumeroTelefono.charAt(i)) {
                case '1':
                    cuentaNumero++;
                    break;
                case '2':
                    cuentaNumero++;

                    break;
                case '3':
                    cuentaNumero++;

                    break;
                case '4':
                    cuentaNumero++;

                    break;
                case '5':
                    cuentaNumero++;

                    break;
                case '6':
                    cuentaNumero++;

                    break;
                case '7':
                    cuentaNumero++;

                    break;
                case '8':
                    cuentaNumero++;

                    break;
                case '9':
                    cuentaNumero++;

                    break;
                case '0':
                    cuentaNumero++;

                    break;
            }
        }
        if (cuentaNumero == NumeroTelefono.length()) {
            validarNumero = true;
        }
        return validarNumero;
    }

    //validar fecha del cliente
    public static boolean validarFecha(String fechaNacimiento) {
        boolean validarFecha = false;
        // dd/mm/yyyy
        if (fechaNacimiento.length() == 10) {
            if (fechaNacimiento.charAt(2) == '/' && fechaNacimiento.charAt(5) == '/') {
                int cuentaLetras = 0;
                for (int i = 0; i < fechaNacimiento.length(); i++) {
                    switch (fechaNacimiento.charAt(i)) {
                        case '1':
                            cuentaLetras++;
                            break;
                        case '2':
                            cuentaLetras++;
                            break;
                        case '3':
                            cuentaLetras++;
                            break;
                        case '4':
                            cuentaLetras++;
                            break;
                        case '5':
                            cuentaLetras++;
                            break;
                        case '6':
                            cuentaLetras++;
                            break;
                        case '7':
                            cuentaLetras++;
                            break;
                        case '8':
                            cuentaLetras++;
                            break;
                        case '9':
                            cuentaLetras++;
                            break;
                        case '0':
                            cuentaLetras++;
                            break;
                        case '/':
                            cuentaLetras++;
                            break;
                        default:
                            System.out.println("La fecha no es valida");
                    }
                }
                if (cuentaLetras == fechaNacimiento.length()) {
                    System.out.println("La fecha es valida");
                    validarFecha = true;
                }
            }
        }
        return validarFecha;
    }

    //clientes archivo secuncial
    //uso del NIT O CUI
    //generar formato cliente
    public static void llenarCliente(clientes cliente, BufferedWriter bW) throws IOException {
        bW.write(cliente.getCui() + "%" + cliente.getNit() + "%" + cliente.getdRecidencia() + "%" + cliente.getnEmpresa() + "%" + cliente.getdEmpresa() + "%" + cliente.getfNacimiento() + "%" + cliente.getpNombre() + "%" + cliente.getsNombre() + "%" + cliente.getpApellido() + "%" + cliente.getsApellido() + "%" + cliente.getnTelefono() + "%" + cliente.getEstado());
        bW.newLine();
        bW.close();
    }

    //registrar cliente
    public static void registrarCliente(clientes cliente) throws IOException {
        File file = new File("clientes.txt");
        if (file.exists() && file.length() != 0) {
            BufferedWriter bW = new BufferedWriter(new FileWriter(file, true));
            llenarCliente(cliente, bW);
        } else {
            BufferedWriter bW = new BufferedWriter(new FileWriter(file));
            llenarCliente(cliente, bW);
        }
    }
    //eliminar cliente

    /**
     * Elimina lógicamente un cliente en base a su CUI.
     *
     * @param cui El CUI del cliente a eliminar.
     */
    public static void eliminarClienteLogico(String cui) {
        File file = new File("clientes.txt");
        if (file.exists()) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String linea;
                int numerodeLineas = 0;
                boolean personaEncontrada = false;

                while ((linea = bufferedReader.readLine()) != null) {
                    numerodeLineas++;
                }
                bufferedReader.close();
                fileReader.close();

                String[] lineas = new String[numerodeLineas];

                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                int contador = 0;
                while ((linea = bufferedReader.readLine()) != null) {
                    lineas[contador] = linea;
                    contador++;
                }
                bufferedReader.close();
                fileReader.close();

                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (int i = 0; i < lineas.length; i++) {
                    String[] Clientesatributos = lineas[i].split("%");
                    if (Clientesatributos[0].equalsIgnoreCase(cui)) {
                        clientes persona = new clientes(Clientesatributos[0], Clientesatributos[1], Clientesatributos[2], Clientesatributos[3], Clientesatributos[4], Clientesatributos[5], Clientesatributos[6], Clientesatributos[7], Clientesatributos[8], Clientesatributos[9], Clientesatributos[10], Clientesatributos[11]);
                        persona.setEstado("2"); // Modificar el estado de la persona a "2"
                        personaEncontrada = true;
                        Clientesatributos[11] = persona.getEstado(); // Actualizar el estado en el arreglo
                    }
                    bufferedWriter.write(String.join("%", Clientesatributos));
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
                fileWriter.close();

                if (personaEncontrada) {
                    System.out.println("Cliente eliminado lógicamente");
                } else {
                    System.out.println("No se encontró registro");
                }

            } catch (Exception error) {
                System.err.println(error + " error encontrado");
            }
        } else {
            System.out.println("El archivo no existe");
        }
    }

//modificar clientes
    public static void modificarCliente(String Cui, String Nit) {
        File file = new File("clientes.txt");
        if (file.exists()) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String linea;
                int numerodeLineas = 0;
                boolean personaEncontrada = false;
                bufferedReader = new BufferedReader(new FileReader(file));
                while ((linea = bufferedReader.readLine()) != null) {
                    numerodeLineas++;
                    System.out.println(linea);
                }
                System.out.println("El número de personas es: " + numerodeLineas);
                String arreglo[] = new String[numerodeLineas];

                bufferedReader = new BufferedReader(new FileReader(file));
                int contador = 0;

                while ((linea = bufferedReader.readLine()) != null) {
                    arreglo[contador] = linea;
                    System.out.println(arreglo[contador]);
                    contador++;
                }
                System.out.println("Las personas almacenadas son: " + arreglo[contador - 1]);

                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                for (int i = 0; i < arreglo.length; i++) {
                    String Clientesatributos[] = arreglo[i].split("%");
                    if (Cui == null || Clientesatributos[0].equalsIgnoreCase(Cui) && Nit == null || Clientesatributos[1].equalsIgnoreCase(Nit)) {
                        clientes persona = new clientes(Clientesatributos[0], Clientesatributos[1], Clientesatributos[2], Clientesatributos[3], Clientesatributos[4], Clientesatributos[5], Clientesatributos[6], Clientesatributos[7], Clientesatributos[8], Clientesatributos[9], Clientesatributos[10], Clientesatributos[11]);
                        Scanner entrada = new Scanner(System.in);
                        personaEncontrada = !personaEncontrada;
                        //modificar residencia
                        System.out.println("Ingrese una residencia nueva: ");
                        String dResidencia = entrada.nextLine();
                        // entidad labora
                        System.out.println("Ingrese un nuevo nombre de la empresa: ");
                        String nEmpresa = entrada.nextLine();
                        //direccion empresa
                        System.out.println("Ingrese una nueva direccion de la empresa: ");
                        String dEmpresa = entrada.nextLine();
                        //fecha de nacimiento
                        System.out.println("Ingrese una fecha de nacimiento: ");
                        String fNacimiento = entrada.nextLine();
                        System.out.println("Ingrese el primer nombre: ");
                        String pNombre = entrada.nextLine();
                        System.out.println("Ingrese el segundo nombre: ");
                        String sNombre = entrada.nextLine();
                        System.out.println("Ingrese el primer apellido: ");
                        String pApellido = entrada.nextLine();
                        System.out.println("Ingrese el segundo apellido: ");
                        String sApellido = entrada.nextLine();
                        System.out.println("Ingrese un nuevo numero de telefono: ");
                        String nTelefono = entrada.nextLine();
                        if (validarFecha(fNacimiento) == true) {
                            //modificar atributos
                            if (validarNumeroTelefono(nTelefono) == true) {
                                persona.setdRecidencia(dResidencia);
                                persona.setnEmpresa(nEmpresa);
                                persona.setdEmpresa(dEmpresa);
                                persona.setfNacimiento(fNacimiento);
                                persona.setpNombre(pNombre);
                                persona.setsNombre(sNombre);
                                persona.setpApellido(pApellido);
                                persona.setsApellido(sApellido);
                                persona.setnTelefono(nTelefono);
                                llenarCliente(persona, bufferedWriter);
                                //System.out.println("Registro eliminado logicamente");
                                System.out.println("Cliente modificado exitosamente!: \n" + persona.toString());
                                bufferedReader.close();

                            }
                        }
                    } else {
                        bufferedWriter.write(arreglo[i]);
                        System.out.println(arreglo[i]);
                        bufferedWriter.newLine();
                        bufferedReader.close();

                    }
                }

                if (personaEncontrada == false) {
                    System.out.println("No se encontró registro");
                }

                bufferedWriter.close();
                fileWriter.close();

            } catch (Exception error) {
                System.err.println(error + " error encontrado");
            }
        } else {
            System.out.println("El archivo no existe");
        }
    }

    /*public static void modificarCliente(String Cui, String Nit) throws IOException {
        File file = new File("clientes.txt");
        File tmpFile = new File("clientes.tmp");
        if (file.exists()) {
            BufferedReader bR = new BufferedReader(new FileReader(file));
            BufferedWriter bW = new BufferedWriter(new FileWriter(tmpFile));
            String linea;
            while ((linea = bR.readLine()) != null) {
                String Clientesatributos[] = linea.split("%");
                //System.out.println(linea);
                clientes cliente = new clientes(Clientesatributos[0], Clientesatributos[1], Clientesatributos[2], Clientesatributos[3], Clientesatributos[4], Clientesatributos[5], Clientesatributos[6], Clientesatributos[7], Clientesatributos[8], Clientesatributos[9], Clientesatributos[10], Clientesatributos[11]);

                if (Cui == null || Clientesatributos[0].equalsIgnoreCase(Cui) && Nit == null || Clientesatributos[1].equalsIgnoreCase(Nit)) {
                    Scanner entrada = new Scanner(System.in);
                    //modificar residencia
                    System.out.println("Ingrese una residencia nueva: ");
                    String dResidencia = entrada.nextLine();
                    // entidad labora
                    System.out.println("Ingrese un nuevo nombre de la empresa: ");
                    String nEmpresa = entrada.nextLine();
                    //direccion empresa
                    System.out.println("Ingrese una nueva direccion de la empresa: ");
                    String dEmpresa = entrada.nextLine();
                    //fecha de nacimiento
                    System.out.println("Ingrese una fecha de nacimiento: ");
                    String fNacimiento = entrada.nextLine();
                    System.out.println("Ingrese el primer nombre: ");
                    String pNombre = entrada.nextLine();
                    System.out.println("Ingrese el segundo nombre: ");
                    String sNombre = entrada.nextLine();
                    System.out.println("Ingrese el primer apellido: ");
                    String pApellido = entrada.nextLine();
                    System.out.println("Ingrese el segundo apellido: ");
                    String sApellido = entrada.nextLine();
                    System.out.println("Ingrese un nuevo numero de telefono: ");
                    String nTelefono = entrada.nextLine();

                    if (validarFecha(fNacimiento) == true) {
                        //modificar atributos
                        if (validarNumeroTelefono(nTelefono) == true) {
                            cliente.setdRecidencia(dResidencia);
                            cliente.setnEmpresa(nEmpresa);
                            cliente.setdEmpresa(dEmpresa);
                            cliente.setfNacimiento(fNacimiento);
                            cliente.setpNombre(pNombre);
                            cliente.setsNombre(sNombre);
                            cliente.setpApellido(pApellido);
                            cliente.setsApellido(sApellido);
                            cliente.setnTelefono(nTelefono);
                            llenarCliente(cliente, bW);
                            //System.out.println("Registro eliminado logicamente");
                        }
                    }
                    //
                }
            }
            bR.close();
            bW.close();
            file.delete();
            tmpFile.renameTo(file);//renombrar
        }
    }
     */
    //eliminacion logica cliente
    //Elimininacion Logica de clientes solo con uno o mas?
    //vechiculos archivo secuencial
    //uso de PLACA 
    //generar formato 
    //throws IOException 
    /*public static void eliminarClienteLogico(String Cui) {
        try {

            File file = new File("clientes.txt");
            File tmpFile = new File("clientes.tmp");
            if (file.exists()) {
                BufferedReader bR = new BufferedReader(new FileReader(file));
                BufferedWriter bW = new BufferedWriter(new FileWriter(tmpFile));
                String linea;
                while ((linea = bR.readLine()) != null) {
                    String Clientesatributos[] = linea.split("%");
                    clientes cliente = new clientes(Clientesatributos[0], Clientesatributos[1], Clientesatributos[2], Clientesatributos[3], Clientesatributos[4], Clientesatributos[5], Clientesatributos[6], Clientesatributos[7], Clientesatributos[8], Clientesatributos[9], Clientesatributos[10], Clientesatributos[11]);

                    if (Clientesatributos[0].equalsIgnoreCase(Cui)) {
                        cliente.setEstado("2");
                        llenarCliente(cliente, bW);
                        System.out.println("Registro eliminado logicamente");
                    } else {
                        bW.write(linea);
                        bW.newLine();
                        System.out.println("No se encontro registro");
                    }
                }
                bR.close();
                bW.close();
                file.delete();
                tmpFile.renameTo(file);//renombrar
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // buscar cliente/consultar un cliente por:
    /*
Código único de identificación
○ NIT
○ Nombres
○ Apellidos.    
     */
    public static boolean consultarCliente(String Cui, String NIT, String pNombre, String sNombre, String pApellido, String sApellido) throws IOException {
        File file = new File("clientes.txt");
        boolean banderaCliente = false;
        if (file.exists()) {
            BufferedReader bR = new BufferedReader(new FileReader(file));
            String linea;
            while ((linea = bR.readLine()) != null) {
                String[] Clientesatributos = linea.split("%");
                clientes cliente = new clientes(Clientesatributos[0], Clientesatributos[1], Clientesatributos[2], Clientesatributos[3], Clientesatributos[4], Clientesatributos[5], Clientesatributos[6], Clientesatributos[7], Clientesatributos[8], Clientesatributos[9], Clientesatributos[10], Clientesatributos[11]);

                if ((Cui == null || cliente.getCui().equals(Cui))
                        && (NIT == null || cliente.getNit().equals(NIT))
                        && (pNombre == null || cliente.getpNombre().equals(pNombre)) && (sNombre == null || cliente.getsNombre().equals(sNombre))
                        && (pApellido == null || cliente.getpApellido().equals(pApellido)) && (sApellido == null || cliente.getsApellido().equals(sApellido))) {
                    banderaCliente = true;
                    System.out.println(cliente.toString());

                }
            }
            bR.close();
        } else {
            System.out.println("El archivo no existe.");
        }
        return banderaCliente;

    }

//consultar clientes
    //terminar
    public static void consultarClientes() throws IOException {
        File file = new File("clientes.txt");
        if (file.exists() && file.length() != 0) {
            try (BufferedReader bR = new BufferedReader(new FileReader(file))) {
                String linea;
                while ((linea = bR.readLine()) != null) {
                    String[] Clientesatributos = linea.split("%");
                    if (Clientesatributos.length <= 12) {
                        clientes cliente = new clientes(Clientesatributos[0], Clientesatributos[1], Clientesatributos[2], Clientesatributos[3], Clientesatributos[4], Clientesatributos[5], Clientesatributos[6], Clientesatributos[7], Clientesatributos[8], Clientesatributos[9], Clientesatributos[10], Clientesatributos[11]);
                        System.out.println(cliente.toString());

                    }else{
                        System.out.println("No tiene el formato esperado!");
                    }
                }
            } catch (IOException e) {
                System.out.println(e + "Ocurrio un error");
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }

    //vehiculo
    public static void llenarVehiculo(vehiculos vehiculo, BufferedWriter bW) throws IOException {
        bW.write(vehiculo.getnPlaca() + "%" + vehiculo.getmVehiculo() + "%" + vehiculo.getlVehiculo() + "%" + vehiculo.getModVehiculo() + "%" + vehiculo.getcVehiculo() + "%" + vehiculo.getnCliente() + "%" + vehiculo.getEstadoVehiculo() + "%");
        bW.newLine();
        bW.close();
    }

    //registrar vehiculo
    public static void registrarVehiculo(vehiculos vehiculo) throws IOException {
        File file = new File("vehiculos.txt");
        if (file.exists() && file.length() != 0) {
            BufferedWriter bW = new BufferedWriter(new FileWriter(file, true));
            llenarVehiculo(vehiculo, bW);
            bW.close();
        } else {
            BufferedWriter bW = new BufferedWriter(new FileWriter(file));
            llenarVehiculo(vehiculo, bW);
            bW.close();
        }
    }
//modificar vehiculos
    //debera modificarse en atributos solo:

    /*
    marca,
    linea,
    modelo,
    color,
    NIT del propietario{cliente}
    estado= 1|2: activo|inactivo
     */
    //?
    //buscar por nuemero de placa del vehiculo --> eliminacion logica incluida?
    public static void modificarVehiculo(String placa) {
        File file = new File("vehiculos.txt");
        if (file.exists()) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String linea;
                int numerodeLineas = 0;
                boolean personaEncontrada = false;

                bufferedReader = new BufferedReader(new FileReader(file));
                while ((linea = bufferedReader.readLine()) != null) {
                    numerodeLineas++;
                }
                System.out.println("El número de personas es: " + numerodeLineas);
                String arreglo[] = new String[numerodeLineas];
                bufferedReader.close();
                fileReader.close();

                bufferedReader = new BufferedReader(new FileReader(file));
                int contador = 0;

                while ((linea = bufferedReader.readLine()) != null) {
                    arreglo[contador] = linea;
                    contador++;
                }

                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                for (int i = 0; i < arreglo.length; i++) {
                    String Vehiculosatributos[] = arreglo[i].split("%");
                    if (Vehiculosatributos[0].equalsIgnoreCase(placa)) {
                        vehiculos vehiculo = new vehiculos(Vehiculosatributos[0], Vehiculosatributos[1], Vehiculosatributos[2], Vehiculosatributos[3], Vehiculosatributos[4], Vehiculosatributos[5], Vehiculosatributos[6]);
                        Scanner entrada = new Scanner(System.in);
                        System.out.println("Ingrese una marca de vehiculo a modificar: ");
//marca del vehiculo
                        String mVehiculo = entrada.nextLine();
                        System.out.println("Ingrese una linea de vehiculo a modificar: ");

                        // linea del vehiculo
                        String lVehiculo = entrada.nextLine();
                        System.out.println("Ingrese un modelo de vehiculo a modificar: ");
                        // modelo del vehiculo
                        String modVehiculo = entrada.nextLine();
                        System.out.println("Ingrese un color de vehiculo a modificar: ");
                        if (validarModelo(modVehiculo) == true) {
                            //color del vehiculo
                            String cVehiculo = entrada.nextLine();
                            System.out.println("Ingrese un nit para remplazar: ");
                            //nit del cliente
                            String nCliente = entrada.nextLine();
                            if (validarNIT(nCliente) == true) {
                                //estado del vehiculo 1|2
                                System.out.println("Ingrese un estado para el vehiculo a modificar [1]:ACTIVO / [2]INACTIVO: ");
                                String estadoVehiculo = entrada.nextLine();

                                //validar placa
                                //modificar atributos
                                vehiculo.setmVehiculo(mVehiculo);
                                vehiculo.setlVehiculo(lVehiculo);
                                vehiculo.setModVehiculo(modVehiculo);
                                vehiculo.setcVehiculo(cVehiculo);
                                vehiculo.setnCliente(nCliente);
                                vehiculo.setEstadoVehiculo(estadoVehiculo);
                                llenarVehiculo(vehiculo, bufferedWriter);
                            }
                        }
                    } else {
                        bufferedWriter.write(arreglo[i]);
                        bufferedWriter.newLine();
                    }
                }

                if (personaEncontrada == false) {
                    System.out.println("No se encontró registro");
                }

                bufferedWriter.close();
                fileWriter.close();

            } catch (Exception error) {
                System.err.println(error + " error encontrado");
            }
        } else {
            System.out.println("El archivo no existe");
        }
    }

    /*public static void modificarVehiculo(String Placa) throws IOException {
        File file = new File("vehiculos.txt");
        File tmpFile = new File("vehiculos.tmp");
        if (file.exists()) {
            BufferedReader bR = new BufferedReader(new FileReader(file));
            BufferedWriter bW = new BufferedWriter(new FileWriter(tmpFile));
            String linea;
            while ((linea = bR.readLine()) != null) {
                String Vehiculosatributos[] = linea.split("%");
                System.out.println(linea);
//(String nPlaca, String mVehiculo, String lVehiculo, String modVehiculo, String cVehiculo, String nCliente, String estadoVehiculo) {

                vehiculos vehiculo = new vehiculos(Vehiculosatributos[0], Vehiculosatributos[1], Vehiculosatributos[2], Vehiculosatributos[3], Vehiculosatributos[4], Vehiculosatributos[5], Vehiculosatributos[6]);

                if (Vehiculosatributos[0].equalsIgnoreCase(Placa)) {
                    Scanner entrada = new Scanner(System.in);
                    System.out.println("Ingrese una marca de vehiculo a modificar: ");
//marca del vehiculo
                    String mVehiculo = entrada.nextLine();
                    System.out.println("Ingrese una linea de vehiculo a modificar: ");

                    // linea del vehiculo
                    String lVehiculo = entrada.nextLine();
                    System.out.println("Ingrese un modelo de vehiculo a modificar: ");
                    // modelo del vehiculo
                    String modVehiculo = entrada.nextLine();
                    System.out.println("Ingrese un color de vehiculo a modificar: ");
                    if (validarModelo(modVehiculo) == true) {
                        //color del vehiculo
                        String cVehiculo = entrada.nextLine();
                        System.out.println("Ingrese un nit para remplazar: ");
                        //nit del cliente
                        String nCliente = entrada.nextLine();
                        if (validarNIT(nCliente) == true) {
                            //estado del vehiculo 1|2
                            System.out.println("Ingrese un estado para el vehiculo a modificar [1]:ACTIVO / [2]INACTIVO: ");
                            String estadoVehiculo = entrada.nextLine();

                            //validar placa
                            //modificar atributos
                            vehiculo.setmVehiculo(mVehiculo);
                            vehiculo.setlVehiculo(lVehiculo);
                            vehiculo.setModVehiculo(modVehiculo);
                            vehiculo.setcVehiculo(cVehiculo);
                            vehiculo.setnCliente(nCliente);
                            vehiculo.setEstadoVehiculo(estadoVehiculo);
                            llenarVehiculo(vehiculo, bW);
                        }
                    }
                    //
                }
            }
            bR.close();
            bW.close();
            file.delete();
            tmpFile.renameTo(file);//renombrar
        }
    }*/
//consultar vehiculo
    public static boolean consultarVehiculo(String Placa) throws IOException {
        boolean banderaVehiculo = false;
        File file = new File("vehiculos.txt");
        if (file.exists()) {
            BufferedReader bR = new BufferedReader(new FileReader(file));
            String linea;
            while ((linea = bR.readLine()) != null) {
                String Vehiculosatributos[] = linea.split("%");
                vehiculos vehiculo = new vehiculos(Vehiculosatributos[0], Vehiculosatributos[1], Vehiculosatributos[2], Vehiculosatributos[3], Vehiculosatributos[4], Vehiculosatributos[5], Vehiculosatributos[6]);

                if (Vehiculosatributos[0].equalsIgnoreCase(Placa)) {
                    banderaVehiculo = true;
                    System.out.println(vehiculo.toString());
                }
            }
            bR.close();
        } else {
            System.out.println("El archivo no existe.");
        }
        return banderaVehiculo;
    }

    //funcion para buscar vehiculo por nit 
    public static boolean consultarVehiculoporNit(String Nit) throws IOException {
        boolean banderaVehiculo = false;
        File file = new File("vehiculos.txt");
        if (file.exists()) {
            BufferedReader bR = new BufferedReader(new FileReader(file));
            String linea;
            while ((linea = bR.readLine()) != null) {
                String Vehiculosatributos[] = linea.split("%");
                vehiculos vehiculos = new vehiculos(Vehiculosatributos[0], Vehiculosatributos[1], Vehiculosatributos[2], Vehiculosatributos[3], Vehiculosatributos[4], Vehiculosatributos[5], Vehiculosatributos[6]);

                if (Vehiculosatributos[5].equalsIgnoreCase(Nit)) {
                    banderaVehiculo = true;
                    System.out.println(vehiculos.toString());
                }
            }
            bR.close();
        } else {
            System.out.println("El archivo no existe.");
        }
        return banderaVehiculo;
    }

    //consultar vehiculos
    public static void consultarVehiculos() throws IOException {
        File file = new File("vehiculos.txt");
        if (file.exists()) {
            BufferedReader bR = new BufferedReader(new FileReader(file));
            String linea;
            while ((linea = bR.readLine()) != null) {
                String Vehiculosatributos[] = linea.split("%");
                vehiculos vehiculos = new vehiculos(Vehiculosatributos[0], Vehiculosatributos[1], Vehiculosatributos[2], Vehiculosatributos[3], Vehiculosatributos[4], Vehiculosatributos[5], Vehiculosatributos[6]);
                System.out.println(vehiculos.toString());
            }
            bR.close();
        } else {
            System.out.println("El archivo no existe.");
        }
    }

    //pagos parqueo achivos secuenciales
    //formato para archivo secuencial pagos de parqueo
    public static void llenarPagosParqueo(RegistroPagosParqueo parqueo, BufferedWriter bW) throws IOException {
        bW.write(parqueo.getNitCliente() + "%" + parqueo.getnParqueo() + "%" + parqueo.getcPago() + "%" + parqueo.getmPago() + "%" + parqueo.getnComprobantePago() + "%" + parqueo.getfPago());
        bW.newLine();
        bW.close();
    }
//registrar los pagos de parqueo registrta uno

    public static void registrarPagoParqueo(RegistroPagosParqueo parqueo) throws IOException {
        File file = new File("pagos.txt");
        if (file.exists() && file.length() != 0) {
            BufferedWriter bW = new BufferedWriter(new FileWriter(file, true));
            llenarPagosParqueo(parqueo, bW);
        } else {
            BufferedWriter bW = new BufferedWriter(new FileWriter(file));
            llenarPagosParqueo(parqueo, bW);
        }

    }
//conulstar los pagos arreglar

    public static void consultarPagos(String NIT, String numeroParqueo) throws IOException {
        File file = new File("pagos.txt");
        if (file.exists()) {
            BufferedReader bR = new BufferedReader(new FileReader(file));
            String linea;
            while ((linea = bR.readLine()) != null) {
                String[] Pagosatributos = linea.split("%");
                RegistroPagosParqueo pago = new RegistroPagosParqueo(Pagosatributos[0], Pagosatributos[1], Pagosatributos[2], Pagosatributos[3], Pagosatributos[4], Pagosatributos[5]);
                if (Pagosatributos[0].equalsIgnoreCase(NIT) && numeroParqueo == null) {
                    System.out.println(pago.toString());

                }
                if (Pagosatributos[1].equalsIgnoreCase(numeroParqueo) && NIT == null) {
                    System.out.println(pago.toString());
                }
            }
            bR.close();
        } else {
            System.out.println("El archivo no existe.");
        }
    }

    public static boolean validarModelo(String modelo) {
        boolean vldModelo = false;
        int contadorDigitos = 0;
        if (modelo.length() == 4) {
            for (int i = 0; i < modelo.length(); i++) {
                switch (i) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        switch (modelo.charAt(i)) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                contadorDigitos++;
                        }
                }
            }
        }
        if (modelo.length() == contadorDigitos) {
            vldModelo = true;
        }
        return vldModelo;
    }

    public static boolean validarNIT(String nit) {
        // Asegurarse de que el NIT tenga 10 caracteres
        if (nit.length() >= 2 && nit.length() <= 13) {
            // Realizar validación adicional si es necesario

        } else {
            return false;
        }

        String partes[] = nit.split("-");

        String parte1 = partes[0];
        String parte2 = partes[1];
        // Separamos los primeros  dígitos del NIT, y el dígito verificador es el último
        // String primerosocho = nit.substring(0, 8);
        String digitoVerificador = parte2;

        int factor = parte1.length() + 1;
        int valor = 0;
        //10482781-5
        //8+1=9 AQUI EMPIEZA EL FACTOR
        //9*1=9 8*0=0 4*7=28 Y ASI SUSECIMAMENTE CON EL RESTO DE NUMEROS DEL NIT SIN INCLUIR EL DIGITO VERIFICADOR 
        for (int i = 0; i < parte1.length(); i++) {
            // Convertimos carácter por carácter de los primeros 9 y los multiplicamos por el factor
            valor += Character.getNumericValue(parte1.charAt(i)) * factor;
            factor--;
        }

        // A VALOR QUE ES EL NUMERO DE LA SUMA DE LAS MULTIPLICACIONES DEL FACTOR POR EL NIT SE LE SACA MOD 11
        //System.out.println("este es el valor" + valor);
        int residuo = valor % 11;
        //System.out.println("aqui eta elresiduio" + residuo);
        int resultado = 11 - residuo;
        //System.out.println("aqui eta resultado" + resultado);

        if (resultado >= 10) {
            resultado = 0;
        }

        if (Integer.parseInt(digitoVerificador) == resultado) {
            return true;
        }

        return false;
    }

}
