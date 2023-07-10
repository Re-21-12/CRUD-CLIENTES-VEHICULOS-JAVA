/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyecto_final;

/**
 *
 * @author victo
 */
//PRINCIPAL
import java.io.*;

import java.util.*;

public class Proyecto_final {

    public static void main(String[] args) throws IOException {
        ArchivoDirecto archivo = new ArchivoDirecto();
        Scanner entrada = new Scanner(System.in);
        String opcion = "";
        String salirPrincipal = "";//Variable para controlar el menu principal, permite terminar el programa incluso desde los submenu
        String regresar = "";//Variable para controlar los submenus y poder regresar al menu principal
        //menu principal
        while (salirPrincipal != "1") {
            menuPrincipal();
            System.out.println("Ingrese una opción");
            try {
                opcion = entrada.nextLine();
            } catch (Exception e) {
                System.out.println("Opcion no valida");
            }
            switch (opcion) {
                //Menu Clientes
                case "1":
                    while (regresar != "1") {
                        menuClientes();
                        System.out.println("Ingrese una opción");
                        try {
                            opcion = entrada.nextLine();
                        } catch (Exception e) {
                            System.out.println("Opcion no valida");
                        }
                        switch (opcion) {
                            //Ingresar nuevo cliente
                            case "1":
                                System.out.println("Ingrese un numero de cui: ");

                                String cui = entrada.nextLine();

                                if (validarCui(cui) == true) {
                                    System.out.println("Ingrese un numero de nit con guiones [010101010109-3]: ");
                                    String nit = entrada.nextLine();
                                    if (validarNIT(nit) == true) {
                                        System.out.println("Ingrese una direccion de residencia: ");
                                        String dResidencia = entrada.nextLine();
                                        System.out.println("Ingrese un nombre de la Empresa");
                                        String nEmpresa = entrada.nextLine();
                                        System.out.println("Ingrese una direccion de la empresa: ");
                                        String dEmpresa = entrada.nextLine();
                                        System.out.println("Ingrese una fecha de nacimiento: ");
                                        String fNacimiento = entrada.nextLine();
                                        if (validarFecha(fNacimiento) == true) {
                                            System.out.println("Ingrese el primer nombre: ");
                                            String pNombre = entrada.nextLine();
                                            System.out.println("Ingrese el segundo nombre: ");
                                            String sNombre = entrada.nextLine();
                                            System.out.println("Ingrese el primer apellido: ");
                                            String pApellido = entrada.nextLine();
                                            System.out.println("Ingrese el segundo apellido: ");
                                            String sApellido = entrada.nextLine();
                                            System.out.println("Ingrese el numero de telefono: ");
                                            String nTelefono = entrada.nextLine();
                                            if (validarNumeroTelefono(nTelefono) == true) {
                                                clientes cliente = new clientes(cui, nit, dResidencia, nEmpresa, dEmpresa, fNacimiento, pNombre, sNombre, pApellido, sApellido, nTelefono, "1");
                                                ArchivoSecuencial.registrarCliente(cliente);
                                            }
                                        }
                                    }
                                }

                                break;

                            case "2":
                                //Buscar cliente
                                System.out.println("Ingrese una opcion: \n 1. Buscar por CUI\n 2.Buscar por Nit\n 3. Buscar por primer Nombre \n 4. Buscar por segundo Nombre \n 5. buscar por primer Apellido \n 6. Buscar por segundo apellido");
                                String opcionBuscar = entrada.nextLine();
                                switch (opcionBuscar) {
                                    case "1":
                                        System.out.println("Ingrese un numero de cui: ");
                                        String Cui = entrada.nextLine();
                                        if (validarCui(Cui) == true) {
                                            ArchivoSecuencial.consultarCliente(Cui, null, null, null, null, null);
                                        }
                                        break;
                                    case "2":
                                        System.out.println("Ingrese un numero de nit con guiones [010101010109-3]: ");
                                        String nit = entrada.nextLine();
                                        if (validarNIT(nit) == true) {
                                            ArchivoSecuencial.consultarCliente(null, nit, null, null, null, null);
                                        }
                                        break;
                                    case "3":
                                        System.out.println("Ingrese un primer nombr a buscar: ");
                                        String primerNombre = entrada.nextLine();
                                        ArchivoSecuencial.consultarCliente(null, null, primerNombre, null, null, null);
                                        break;
                                    case "4":
                                        System.out.println("Ingrese un segundo nombre a buscar: ");
                                        String segundoNombre = entrada.nextLine();
                                        ArchivoSecuencial.consultarCliente(null, null, null, segundoNombre, null, null);
                                        break;
                                    case "5":
                                        System.out.println("Ingrese un primer apellido a buscar: ");
                                        String primerApellido = entrada.nextLine();
                                        ArchivoSecuencial.consultarCliente(null, null, null, null, primerApellido, null);
                                        break;
                                    case "6":
                                        System.out.println("Ingrese un segundo apellido a buscar: ");
                                        String segundoApellido = entrada.nextLine();
                                        ArchivoSecuencial.consultarCliente(null, null, null, null, null, segundoApellido);

                                        break;
                                }
                                break;
                            case "3":
                                //mostrar clientes
                                ArchivoSecuencial.consultarClientes();
                                break;
                            //Modificar datos de cliente	
                            case "4":
                                System.out.println("Ingrese una opcion: \n 1. Modificar por CUI \n 2. Modificar por NIT ");
                                String opcionModificar = entrada.nextLine();
                                switch (opcionModificar) {
                                    case "1":
                                        System.out.println("Ingrese un Cui");
                                        cui = entrada.nextLine();
                                        if (validarCui(cui) == true) {
                                            ArchivoSecuencial.modificarCliente(cui, null);
                                        }
                                        break;
                                    case "2":

                                        System.out.println("Ingrese un Nit");
                                        String nit = entrada.nextLine();
                                        ArchivoSecuencial.modificarCliente(null, nit);
                                        break;
                                }
                                break;
                            //Eliminar Cliente
                            case "5":
                                System.out.println("Ingrese un cui: ");
                                cui = entrada.nextLine();
                                ArchivoSecuencial.eliminarClienteLogico(cui);

                                break;
                            //Regresar al menu principal
                            case "6":
                                regresar = "1";
                                break;
                            case "7":
                                regresar = "1";
                                salirPrincipal = "1";
                                break;
                        }
                    }
                    regresar = "";
                    break;//Case1
                //Menu Vehiculos

                case "2":

                    while (regresar != "1") {
                        menuVehiculos();
                        System.out.println("Ingrese una opción");
                        try {
                            opcion = entrada.nextLine();
                        } catch (Exception e) {
                            System.out.println("Opcion no valida");
                        }
                        switch (opcion) {
                            //Ingresar nuevo vehiculo
                            case "1":
                                System.out.println("Ingrese un numero de placa: ");
                                String placa = entrada.nextLine();
                                if (validarPlaca(placa) == true) {
                                    System.out.println("Ingrese una marca del vehiculo: ");
                                    String marca = entrada.nextLine();
                                    System.out.println("Ingrese una linea del vehiculo: ");
                                    String linea = entrada.nextLine();
                                    System.out.println("Ingrese modelo del vehiculo: ");
                                    String modelo = entrada.nextLine();
                                    if (validarModelo(modelo) == true) {
                                        System.out.println("Ingrese color del vehiculo: ");
                                        String color = entrada.nextLine();
                                        System.out.println("Ingrese nit del propietario del vehiculo: ");
                                        String nit = entrada.nextLine();
                                        vehiculos vehiculo = new vehiculos(placa, marca, linea, modelo, color, nit, "1");
                                        ArchivoSecuencial.registrarVehiculo(vehiculo);

                                    }
                                }
                                break;
                            //Buscar vehiculo
                            case "2":
                                System.out.println("Ingrese un numero de placa: ");
                                placa = entrada.nextLine();
                                if (validarPlaca(placa) == true) {
                                    ArchivoSecuencial.consultarVehiculo(placa);
                                }

                                break;
                            //mostrar vehiculos
                            case "3":
                                ArchivoSecuencial.consultarVehiculos();
                                break;
                            //Modificar datos de vehiculo	
                            case "4":
                                System.out.println("Ingrese un numero de placa para modificar el vehiculo: ");
                                placa = entrada.nextLine();
                                if (validarPlaca(placa) == true) {

                                    /*System.out.println("Ingrese una marca del vehiculo: ");
                                    String marca = entrada.nextLine();
                                    System.out.println("Ingrese una linea del vehiculo: ");
                                    String linea = entrada.nextLine();
                                    System.out.println("Ingrese modelo del vehiculo: ");
                                    String modelo = entrada.nextLine();
                                    if (validarModelo(modelo) == true) {
                                        System.out.println("Ingrese color del vehiculo: ");
                                        String color = entrada.nextLine();
                                        System.out.println("Ingrese nit del propietario del vehiculo: ");
                                        String nit = entrada.nextLine();
                                        if (validarNIT(nit) == true) {
                                     */
                                    ArchivoSecuencial.modificarVehiculo(placa);

                                }
                                break;
                            //Regresar al menu principal
                            case "6":
                                regresar = "1";
                                break;
                            //salir 
                            case "7":
                                regresar = "1";

                                salirPrincipal = "1";
                                break;
                        }
                    }
                    regresar = "";
                    break;//case2
                //Menu registro de parqueos
                case "3":

                    while (regresar != "1") {
                        menuParqueos();
                        System.out.println("Ingrese una opción");
                        try {
                            opcion = entrada.nextLine();
                        } catch (Exception e) {
                            System.out.println("Opcion no valida");
                        }
                        switch (opcion) {
                            //Ingresar nuevo parqueo
                            case "1":
                                System.out.println("Ingrese un numero de parqueo que desee: ");
                                String numeroParqueo = entrada.nextLine();
                                System.out.println("Ingrese un numero de placa del vehiculo: ");
                                String placa = entrada.nextLine();
                                if (validarPlaca(placa) == true && ArchivoSecuencial.consultarVehiculo(placa) == true) {
                                    System.out.println("Ingrese un numero de nit del cliente: ");
                                    String nit = entrada.nextLine();
                                    if (validarNIT(nit) == true && ArchivoSecuencial.consultarCliente(null, nit, null, null, null, null) == true) {
                                        System.out.println("Ingrese una fecha del registro del parqueo");
                                        String fechaRegistro = entrada.nextLine();
                                        if (validarFecha(fechaRegistro)) {
                                            RegistroAsignacionParqueos parqueo = new RegistroAsignacionParqueos(numeroParqueo, placa, nit, fechaRegistro);
                                            //ArchivoDirecto archivo = new ArchivoDirecto();
                                            archivo.abrirArchivo();
                                            archivo.ingresarRegistro(parqueo);
                                            archivo.cerrarArchivo();

                                        }
                                    }
                                }

                                break;
                            //Buscar parqueo

                            case "2":
                                System.out.println("Ha seleccionado el menu de [Consultar Parqueos]: \n1.Parqueos asignados \n2.Parqueos disponibles. \n3.Parqueo especifico");
                                String opcionMenu = entrada.nextLine();
                                switch (opcionMenu) {
                                    case "1":
                                        System.out.println("Parqueos asignados");
                                        //parqueos asignado
                                        archivo.abrirArchivo();
                                        archivo.consultarParqueosAsignados();
                                        archivo.cerrarArchivo();
                                        break;
                                    case "2":
                                        System.out.println("Parqueos disponibles");
                                        archivo.abrirArchivo();
                                        archivo.consultarParqueosDisponibles();
                                        archivo.cerrarArchivo();
                                        break;
                                    case "3":
                                        System.out.println("Parqueo especifico");
                                        numeroParqueo = entrada.nextLine();
                                        archivo.abrirArchivo();
                                        archivo.consultarParqueoEspecifico(Integer.parseInt(numeroParqueo));
                                        archivo.cerrarArchivo();
                                        break;
                                }
                                break;
                            //modificar parqueos	
                            case "3":
                                System.out.println("Ha seleccionado el menu de [Modificar Parqueo]: \n1.Modificar Parqueo \n2.Liberar Parqueo");
                                opcionMenu = entrada.nextLine();
                                switch (opcionMenu) {
                                    case "1":
                                        System.out.println("Ha seleccionado modificar parqueo ");
                                        System.out.println("[NOTA!]: Para modificar un parqueo primero debe estar agregado por vehiculo o parqueo");
                                        System.out.println("Ingrese un numero de parqueo: ");
                                        numeroParqueo = entrada.nextLine();
                                        System.out.println("Ingrese un numero de placa del vehiculo: ");
                                        placa = entrada.nextLine();
                                        if (validarPlaca(placa) == true) {
                                            System.out.println("Ingrese un numero de nit del cliente: ");
                                            String nit = entrada.nextLine();
                                            System.out.println("Ingrese una fecha del registro del parqueo");
                                            String fechaRegistro = entrada.nextLine();
                                            if (validarFecha(fechaRegistro)) {
                                                archivo.abrirArchivo();
                                                archivo.modificarParqueo(Integer.parseInt(numeroParqueo), placa, nit, fechaRegistro);
                                                archivo.cerrarArchivo();
                                            }
                                        }
                                        break;

                                    case "2":
                                        System.out.println("Ha selecccionado liberar parqueo ");
                                        System.out.println("Ingrese un numero de parqueo: ");
                                        numeroParqueo = entrada.nextLine();
                                        archivo.abrirArchivo();
                                        archivo.modificarParqueo(Integer.parseInt(numeroParqueo), " ", " ", " ");
                                        archivo.cerrarArchivo();
                                        break;

                                }
                                break;
                            //Regresar al menu principal
                            case "4":
                                regresar = "1";
                                break;
                            case "5":
                                regresar = "1";
                                salirPrincipal = "1";
                                break;

                        }
                        regresar = "";
                        break;//case3
                    }
                    break;
//Menu pagos
                case "4":

                    while (regresar != "1") {
                        menuPagos();
                        System.out.println("Ingrese una opción");
                        try {
                            opcion = entrada.nextLine();
                        } catch (Exception e) {
                            System.out.println("Opcion no valida");
                        }
                        switch (opcion) {
                            //registar pago
                            case "1":
                                archivo.abrirArchivo();
                                System.out.println("Ingrese un numero de nit: ");
                                String nit = entrada.nextLine();
                                if (validarNIT(nit) == true && ArchivoSecuencial.consultarCliente(null, nit, null, null, null, null)) {
                                    System.out.println("Ingrese un numero de parqueo: ");
                                    String numeroParqueo = entrada.nextLine();
                                    if (archivo.consultarParqueoEspecifico(Integer.parseInt(numeroParqueo)) == true) {
                                        System.out.println("Ingrese un metodo de pago: \n1.Deposito de cuenta/Efecivo \n2.Targeta de credito \n3.Transferencia Bancaria");
                                        String opcionPago = entrada.nextLine();
                                        String codigoPago = opcionPago;
                                        String montoPago = "";
                                        String codigoAutorizacionPago = "";
                                        String fechaPago = "";
                                        switch (opcionPago) {
                                            case "1":
                                                System.out.println("Ingrese un monto de pago: ");
                                                montoPago = entrada.nextLine();
                                                System.out.println("Ingrese un numero de autorizacion: ");
                                                codigoAutorizacionPago = entrada.nextLine();
                                                System.out.println("Ingrese una fecha en la que se realizo el pago: ");
                                                fechaPago = entrada.nextLine();
                                                if (validarFecha(fechaPago)) {
                                                    RegistroPagosParqueo pago = new RegistroPagosParqueo(nit, numeroParqueo, codigoPago, montoPago, codigoAutorizacionPago, fechaPago);
                                                    ArchivoSecuencial.registrarPagoParqueo(pago);
                                                    archivo.cerrarArchivo();
                                                }
                                                break;
                                            case "2":
                                                System.out.println("Ingrese un monto de pago: ");
                                                montoPago = entrada.nextLine();
                                                System.out.println("Ingrese un numero de autorizacion: ");
                                                codigoAutorizacionPago = entrada.nextLine();
                                                System.out.println("Ingrese una fecha en la que se realizo el pago: ");
                                                fechaPago = entrada.nextLine();
                                                if (validarFecha(fechaPago)) {
                                                    RegistroPagosParqueo pago = new RegistroPagosParqueo(nit, numeroParqueo, codigoPago, montoPago, codigoAutorizacionPago, fechaPago);
                                                    ArchivoSecuencial.registrarPagoParqueo(pago);
                                                    archivo.cerrarArchivo();
                                                }
                                                break;
                                            case "3":
                                                System.out.println("Ingrese un monto de pago: ");
                                                montoPago = entrada.nextLine();
                                                System.out.println("Ingrese un numero de autorizacion: ");
                                                codigoAutorizacionPago = entrada.nextLine();
                                                System.out.println("Ingrese una fecha en la que se realizo el pago: ");
                                                fechaPago = entrada.nextLine();
                                                if (validarFecha(fechaPago)) {
                                                    RegistroPagosParqueo pago = new RegistroPagosParqueo(nit, numeroParqueo, codigoPago, montoPago, codigoAutorizacionPago, fechaPago);
                                                    ArchivoSecuencial.registrarPagoParqueo(pago);
                                                    archivo.cerrarArchivo();
                                                }
                                                break;
                                            default:
                                                System.out.println("Ingrese un metodo de pago correcto!");
                                        }
                                    }
                                }

                                break;
                            //consultar pago por numero de parqueo
                            case "2":
                                System.out.println("Ha seleccionado consultar parqueo: ");
                                System.out.println("Selecciona una opcion: \n1. Consultar por NIT \n2. Consultar por numero de Parqueo");
                                String opcionConsulta = entrada.nextLine();
                                switch (opcionConsulta) {
                                    case "1":
                                        System.out.println("Ingrese un numero de nit: ");
                                        nit = entrada.nextLine();
                                        if (validarNIT(nit) == true && ArchivoSecuencial.consultarCliente(null, nit, null, null, null, null) == true) {
                                            ArchivoSecuencial.consultarCliente(null, nit, null, null, null, null);
                                            if (ArchivoSecuencial.consultarVehiculoporNit(nit)) {
                                                ArchivoSecuencial.consultarVehiculoporNit(nit);
                                                ArchivoSecuencial.consultarPagos(nit, null);
                                            }
                                        }
                                        break;
                                    case "2":
                                        archivo.abrirArchivo();
                                        System.out.println("Ingrese un numero de parqueo: ");
                                        String numeroParqueo = entrada.nextLine();
                                        if (archivo.consultarParqueoEspecifico(Integer.parseInt(numeroParqueo))) {
                                            ArchivoSecuencial.consultarPagos(null, numeroParqueo);
                                            archivo.cerrarArchivo();
                                        }

                                        break;
                                }
                                break;
                            //Modificar datos de vehiculo	
                            case "3":
                                regresar = "1";
                                break;
                            case "4":
                                regresar = "1";
                                salirPrincipal = "1";
                                break;
                        }
                    }
                    regresar = "";
                    break;//case4
                case "5":
                    salirPrincipal = "1";

            }//finWhile
        }
        //Funcion para opciones en el menu principal
    }

    public static void menuPrincipal() {
        System.out.println("\tPARQUEO\n");
        System.out.println("MENU PRINCIPAL\n");
        System.out.println("1. CLIENTES");
        System.out.println("2. VEHICULOS");
        System.out.println("3. PARQUEOS");
        System.out.println("4. PAGOS");
        System.out.println("5. SALIR");
    }

    //Funcion para opciones en el menu clientes
    public static void menuClientes() {
        System.out.println("\tCLIENTES\n");
        System.out.println("1. INGRESAR CLIENTE NUEVO");
        System.out.println("2. BUSCAR CLIENTE");
        System.out.println("3. MOSTRAR CLIENTES");
        System.out.println("4. MODIFICAR DATOS DE CLIENTE");
        System.out.println("5. ELIMINAR CLIENTE");
        System.out.println("6. REGRESAR AL MENU PRINCIPAL");
        System.out.println("7. SALIR");

    }

    //Función para opciones en el menu vehiculos
    public static void menuVehiculos() {
        System.out.println("\tVEHICULOS\n");
        System.out.println("1. INGRESAR VEHICULO NUEVO");
        System.out.println("2. BUSCAR VEHICULO");
        System.out.println("3. MOSTRAR VEHICULOS");
        System.out.println("4. MODIFICAR DATOS DE UN VEHICULO");
        System.out.println("5. REGRESAR AL MENU PRINCIPAL");
        System.out.println("6. SALIR");

    }

    //Funcion para opciones en el menu parqueos
    public static void menuParqueos() {
        System.out.println("\tPARQUEOS\n");
        System.out.println("1. ASIGNAR PARQUEO");
        System.out.println("2. BUSCAR PARQUEO");
        System.out.println("3. LIBERAR PARQRUEO ");
        System.out.println("4. REGRESAR AL MENU PRINCIPAL");
        System.out.println("5. SALIR");

    }

    //Funcion para opciones en el menu pagos
    public static void menuPagos() {
        System.out.println("\tPAGOS\n");
        System.out.println("1. REGISTRAR PAGO");
        System.out.println("2. CONSULTAR PAGO/PAGOS");
        //System.out.println("4. ");
        System.out.println("3. REGRESAR AL MENU PRINCIPAL");
        System.out.println("4. SALIR");

    }

    public static boolean validarCui(String cui) {
        int contadorDigitos = 0;
        boolean cuiValido = false;
        String ultimosCuatroDigitos;
        //Validamos que el CUI tenga 13 caracteres para que sea correcto
        if (cui.length() == 13) {
            for (int i = 0; i < cui.length(); i++) {
                //Validamos que el primer caracter no sea cero
                if (i == 0) {
                    switch (cui.charAt(i)) {
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            contadorDigitos++;//Si son todos numeros 1-9 se aumenta el contador
                            break;
                    }
                }
                //Validamos que los digitos de las posiciones 1-12 sean todos digitos 
                switch (i) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        switch (cui.charAt(i)) {
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
                                contadorDigitos++;//Si son todos digitos 0-9 se aumenta el contador
                                break;
                        }
                }
            }
        } else {
            System.out.println("Ingrese un cui correcto");
        }
        ultimosCuatroDigitos = cui.substring(9);//termina en 13
        if (contadorDigitos == cui.length()) {//Validamos que el tamaño del contador sea igual que el cui
            if (!buscarEnArchivo(ultimosCuatroDigitos)) {//Se llama la funcion buscarEnArchivo para validar que los ultimos cuatro digitos se encuentren en el archivo
                cuiValido = false; //Se cambia a false cuando los ultimos 4 digitos no existen en el archivo
            } else {
                cuiValido = true;//Si encuentra los cuatro digitos se cabia a true
            }
        }

        return cuiValido;
    }

    public static boolean buscarEnArchivo(String ultimosCuatroDigitos) {
        //String archivo = "DepartamentosMunicipios.txt";//Variable con el nombre del archivo donde se encuentran los codigos
        boolean codigoEncontrado = false;
        //Abrimos el archivo para lectura
        try {
            BufferedReader br = new BufferedReader(new FileReader("DepartamentosMunicipios.txt"));
            String linea;
            //Leemos cada linea del archivo para comprobar que los ultimos 4 caracteres del cui existan en el archivo
            while ((linea = br.readLine()) != null) {
                if (linea.length() >= 4) {//Verifica si la linea tiene por lo menos 4 caracteres y a partir de esto se crea el siguiente substring
                    String codigo = linea.substring(0, 4);//Crea un sub string con los 4 primeros caracteres de la linea
                    if (codigo.equals(ultimosCuatroDigitos)) {//compara si los 4 caracteres de la linea son iguales a los ultimos 4 caracteres del CUI
                        codigoEncontrado = true;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("No se encontro el archivo");

        }

        return codigoEncontrado;
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

    private static boolean validarPlaca(String placa) {
        boolean validarPl = false;
        int contador = 0;
        if (placa.length() == 7) {
            for (int i = 0; i < placa.length(); i++) {
                if (i == 0) {
                    switch (placa.charAt(i)) {
                        case 'P':
                        case 'A':
                        case 'C':
                        case 'M':
                            contador++;
                            break;
                    }
                }
                switch (i) {
                    case 1:
                    case 2:
                    case 3:
                        switch (placa.charAt(i)) {
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
                                contador++;
                                break;
                        }
                    case 4:
                    case 5:
                    case 6:
                        switch (placa.charAt(i)) {
                            //case 'A': case 'E': case 'I': case 'O': case 'U': 
                            //case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': case '0':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'F':
                            case 'G':
                            case 'H':
                            case 'J':
                            case 'K':
                            case 'L':
                            case 'M':
                            case 'N':
                            case 'P':
                            case 'Q':
                            case 'R':
                            case 'S':
                            case 'T':
                            case 'V':
                            case 'W':
                            case 'X':
                            case 'Y':
                            case 'Z':
                                contador++;
                                break;
                        }
                    //default:
                    // contador ++;
                    //break;
                }
            }
        }
        if (contador == placa.length()) {
            validarPl = true;
        }
        return validarPl;
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
}
