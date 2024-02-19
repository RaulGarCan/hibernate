package com.mycompany.proyectohibernate;

import javax.persistence.Query;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManejadorHibernate manejadorHibernate = new ManejadorHibernate("hibernate.cfg.xml");
        manejadorHibernate.addClass(Armas.class);
        manejadorHibernate.addClass(Auriculares.class);
        manejadorHibernate.addClass(Cascos.class);
        manejadorHibernate.addClass(Chalecos.class);
        manejadorHibernate.addClass(Equipamientos.class);
        manejadorHibernate.addClass(Piezas.class);
        manejadorHibernate.initSession();
        boolean ejecucion = true;
        do {
            Scanner userInput = new Scanner(System.in);
            System.out.println("1- Cascos\n2- Auriculares\n3- Chalecos\n4- Armas\n5- Piezas\n6- Equipamientos");
            System.out.print("Elige la tabla sobre la que deseas operar: ");
            String opcion = userInput.nextLine();
            switch (opcion){
                case "1": // Cascos
                    manejadorHibernate.initSession();
                    System.out.println("1- Create\n2- Read\n3- Update\n4- Delete");
                    System.out.print("Operación a realizar: ");
                    String opcionCascos = userInput.nextLine();
                    switch (opcionCascos){
                        case "1": // Create
                            Cascos cCreate = Cascos.creacionCascos();
                            manejadorHibernate.beginTransaction();
                            manejadorHibernate.save(cCreate);
                            manejadorHibernate.commit();
                            break;
                        case "2": // Read
                            System.out.print("Introduce el nombre del Casco a leer: ");
                            String nombreRead = userInput.nextLine();
                            manejadorHibernate.beginTransaction();
                            Cascos cRead = (Cascos)manejadorHibernate.read(Cascos.class,nombreRead);
                            manejadorHibernate.commit();
                            System.out.println(cRead.toString());
                            break;
                        case "3": // Update
                            Cascos cUpdate = Cascos.creacionCascos();
                            manejadorHibernate.beginTransaction();
                            manejadorHibernate.update(cUpdate);
                            manejadorHibernate.commit();
                            break;
                        case "4": // Delete
                            System.out.print("Introduce el nombre del Casco a leer: ");
                            String nombreDelete = userInput.nextLine();
                            manejadorHibernate.beginTransaction();
                            manejadorHibernate.remove(new Cascos(nombreDelete));
                            manejadorHibernate.commit();
                            break;
                        default:
                            break;
                    }
                    break;
                case "2": // Auriculares
                    manejadorHibernate.initSession();
                    System.out.println("1- Create\n2- Read\n3- Update\n4- Delete");
                    System.out.print("Operación a realizar: ");
                    String opcionAuriculares = userInput.nextLine();
                    switch (opcionAuriculares){
                        case "1": // Create
                            Auriculares aurCreate = Auriculares.creacionAuriculares();
                            manejadorHibernate.beginTransaction();
                            manejadorHibernate.save(aurCreate);
                            manejadorHibernate.commit();
                            break;
                        case "2": // Read
                            System.out.print("Introduce el nombre de los Auriculares a leer: ");
                            String nombreRead = userInput.nextLine();
                            manejadorHibernate.beginTransaction();
                            Auriculares aurRead = (Auriculares)manejadorHibernate.read(Auriculares.class,nombreRead);
                            manejadorHibernate.commit();
                            System.out.println(aurRead.toString());
                            break;
                        case "3": // Update
                            Auriculares aurUpdate = Auriculares.creacionAuriculares();
                            manejadorHibernate.beginTransaction();
                            manejadorHibernate.update(aurUpdate);
                            manejadorHibernate.commit();
                            break;
                        case "4": // Delete
                            System.out.print("Introduce el nombre de los Auriculares a borrar: ");
                            String nombreDelete = userInput.nextLine();
                            manejadorHibernate.beginTransaction();
                            manejadorHibernate.remove(new Auriculares(nombreDelete));
                            manejadorHibernate.commit();
                            break;
                        default:
                            break;
                    }
                    break;
                case "3": // Chalecos
                    manejadorHibernate.initSession();
                    System.out.println("1- Create\n2- Read\n3- Update\n4- Delete");
                    System.out.print("Operación a realizar: ");
                    String opcionChalecos = userInput.nextLine();
                    switch (opcionChalecos){
                        case "1": // Create
                            Chalecos chalCreate = Chalecos.creacionChalecos();
                            manejadorHibernate.beginTransaction();
                            manejadorHibernate.save(chalCreate);
                            manejadorHibernate.commit();
                            break;
                        case "2": // Read
                            System.out.print("Introduce el nombre de los Auriculares a leer: ");
                            String nombreRead = userInput.nextLine();
                            manejadorHibernate.beginTransaction();
                            Chalecos aurRead = (Chalecos)manejadorHibernate.read(Chalecos.class,nombreRead);
                            manejadorHibernate.commit();
                            System.out.println(aurRead.toString());
                            break;
                        case "3": // Update
                            Chalecos chalUpdate = Chalecos.creacionChalecos();
                            manejadorHibernate.beginTransaction();
                            manejadorHibernate.update(chalUpdate);
                            manejadorHibernate.commit();
                            break;
                        case "4": // Delete
                            System.out.print("Introduce el nombre de los Auriculares a borrar: ");
                            String nombreDelete = userInput.nextLine();
                            manejadorHibernate.beginTransaction();
                            manejadorHibernate.remove(new Chalecos(nombreDelete));
                            manejadorHibernate.commit();
                            break;
                        default:
                            break;
                    }
                    break;
                case "4": // Armas
                    manejadorHibernate.initSession();
                    System.out.println("1- Create\n2- Read\n3- Update\n4- Delete");
                    System.out.print("Operación a realizar: ");
                    String opcionArmas = userInput.nextLine();
                    switch (opcionArmas){
                        case "1": // Create
                            Armas armaCreate = Armas.creacionArmasSinId();
                            String respuesta;
                            do {
                                System.out.print("¿Quieres añadir una pieza al arma? (S/N) ");
                                respuesta = userInput.nextLine();
                                if(respuesta.equalsIgnoreCase("S")){
                                    System.out.print("Introduce el nombre de la pieza: ");
                                    String nombre = userInput.nextLine();
                                    Piezas p = (Piezas) manejadorHibernate.read(Piezas.class, nombre);
                                    if(p==null){
                                        p = Piezas.creacionPiezasConId(nombre);
                                        manejadorHibernate.save(p);
                                    }
                                    armaCreate.addPieza(p);
                                }
                            }while (respuesta.equalsIgnoreCase("S"));
                            manejadorHibernate.beginTransaction();
                            manejadorHibernate.save(armaCreate);
                            manejadorHibernate.commit();
                            break;
                        case "2": // Read
                            System.out.print("Introduce el id del Arma a leer: ");
                            int idRead = Integer.parseInt(userInput.nextLine());
                            manejadorHibernate.beginTransaction();
                            Armas armaRead = (Armas)manejadorHibernate.read(Armas.class,idRead);
                            manejadorHibernate.commit();
                            System.out.println(armaRead.toString());
                            break;
                        case "3": // Update
                            Armas armaUpdate = Armas.creacionArmasConId();
                            manejadorHibernate.beginTransaction();
                            manejadorHibernate.update(armaUpdate);
                            manejadorHibernate.commit();
                            break;
                        case "4": // Delete
                            System.out.print("Introduce el id del Arma a borrar: ");
                            int idDelete = Integer.parseInt(userInput.nextLine());
                            manejadorHibernate.beginTransaction();
                            manejadorHibernate.remove(new Armas(idDelete));
                            manejadorHibernate.commit();
                            break;
                        default:
                            break;
                    }
                    break;
                case "5": // Piezas
                    manejadorHibernate.initSession();
                    System.out.println("1- Create\n2- Read\n3- Update\n4- Delete");
                    System.out.print("Operación a realizar: ");
                    String opcionPiezas = userInput.nextLine();
                    switch (opcionPiezas){
                        case "1": // Create
                            Piezas piezaCreate = Piezas.creacionPiezasConId();
                            manejadorHibernate.beginTransaction();
                            manejadorHibernate.save(piezaCreate);
                            manejadorHibernate.commit();
                            break;
                        case "2": // Read
                            System.out.print("Introduce el id de la pieza a leer: ");
                            int idRead = Integer.parseInt(userInput.nextLine());
                            manejadorHibernate.beginTransaction();
                            Piezas piezaRead = (Piezas)manejadorHibernate.read(Piezas.class,idRead);
                            manejadorHibernate.commit();
                            System.out.println(piezaRead.toString());
                            break;
                        case "3": // Update
                            Piezas piezaUpdate = Piezas.creacionPiezasConId();
                            manejadorHibernate.beginTransaction();
                            manejadorHibernate.update(piezaUpdate);
                            manejadorHibernate.commit();
                            break;
                        case "4": // Delete
                            System.out.print("Introduce el id de la pieza a borrar: ");
                            String idDelete = userInput.nextLine();
                            manejadorHibernate.beginTransaction();
                            manejadorHibernate.remove(new Piezas(idDelete));
                            manejadorHibernate.commit();
                            break;
                        default:
                            break;
                    }
                    break;
                case "6": // Equipamientos
                    manejadorHibernate.initSession();
                    System.out.println("1- Create\n2- Read\n3- Update\n4- Delete");
                    System.out.print("Operación a realizar: ");
                    String opcionEquipamientos = userInput.nextLine();
                    switch (opcionEquipamientos){
                        case "1": // Create
                            Equipamientos equipCreate = Equipamientos.creacionEquipamientosSinId(manejadorHibernate);
                            manejadorHibernate.beginTransaction();
                            manejadorHibernate.save(equipCreate);
                            manejadorHibernate.commit();
                            break;
                        case "2": // Read
                            System.out.print("Introduce el nombre del equipamiento a leer: ");
                            String nombreRead = userInput.nextLine();
                            manejadorHibernate.beginTransaction();
                            Equipamientos equipRead = (Equipamientos)manejadorHibernate.read(Equipamientos.class,nombreRead);
                            manejadorHibernate.commit();
                            System.out.println(equipRead.toString());
                            break;
                        case "3": // Update
                            Equipamientos piezaUpdate = Equipamientos.creacionEquipamientosConId(manejadorHibernate);
                            manejadorHibernate.beginTransaction();
                            manejadorHibernate.update(piezaUpdate);
                            manejadorHibernate.commit();
                            break;
                        case "4": // Delete
                            System.out.print("Introduce el id de la pieza a borrar: ");
                            String nombreDelete = userInput.nextLine();
                            manejadorHibernate.beginTransaction();
                            manejadorHibernate.remove(new Equipamientos(nombreDelete));
                            manejadorHibernate.commit();
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    System.out.println("Cerrando el programa...");
                    ejecucion=false;
                    break;
            }
        }while (ejecucion);
    }
}
