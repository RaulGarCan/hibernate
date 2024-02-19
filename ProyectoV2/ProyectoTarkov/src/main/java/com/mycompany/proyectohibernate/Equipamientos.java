package com.mycompany.proyectohibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

@Entity
@Table(name = "equipamientos")
public class Equipamientos {
    @Id
    @Column(name = "nombre")
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "casco", nullable = false)
    private Cascos casco;
    @ManyToOne
    @JoinColumn(name = "auriculares", nullable = false)
    private Auriculares auriculares;
    @ManyToOne
    @JoinColumn(name = "chaleco", nullable = false)
    private Chalecos chaleco;
    @ManyToOne
    @JoinColumn(name = "idarmaprincipal", nullable = false)
    private Armas idarmaprincipal;

    public Equipamientos(String nombre, Cascos casco, Auriculares auriculares, Chalecos chaleco, Armas idarmaprincipal) {
        this.nombre = nombre;
        this.casco = casco;
        this.auriculares = auriculares;
        this.chaleco = chaleco;
        this.idarmaprincipal = idarmaprincipal;
    }
    public Equipamientos(String nombre){
        this.nombre = nombre;
    }
    public Equipamientos(){}

    public String getNombre() {
        return nombre;
    }

    public Cascos getCasco() {
        return casco;
    }

    public Auriculares getAuriculares() {
        return auriculares;
    }

    public Chalecos getChaleco() {
        return chaleco;
    }

    public Armas getIdarmaprincipal() {
        return idarmaprincipal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCasco(Cascos casco) {
        this.casco = casco;
    }

    public void setAuriculares(Auriculares auriculares) {
        this.auriculares = auriculares;
    }

    public void setChaleco(Chalecos chaleco) {
        this.chaleco = chaleco;
    }

    public void setIdarmaprincipal(Armas idarmaprincipal) {
        this.idarmaprincipal = idarmaprincipal;
    }

    public static Equipamientos creacionEquipamientosConId(ManejadorHibernate m){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Introduce el nombre del equipamiento: ");
        String nombre = userInput.nextLine();
        System.out.println("Datos del Casco");
        Cascos casco = Cascos.creacionCascos();
        m.update(casco);
        System.out.println("Datos de los Auriculares");
        Auriculares auriculares = Auriculares.creacionAuriculares();
        m.update(auriculares);
        System.out.println("Datos del Chaleco");
        Chalecos chaleco = Chalecos.creacionChalecos();
        m.update(chaleco);
        System.out.println("Datos del Arma Principal");
        Armas armaPrincipal = Armas.creacionArmasConId();
        m.update(armaPrincipal);
        return new Equipamientos(nombre, casco, auriculares, chaleco, armaPrincipal);
    }
    public static Equipamientos creacionEquipamientosSinId(ManejadorHibernate m){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Introduce el nombre del equipamiento: ");
        String nombre = userInput.nextLine();
        System.out.println("Datos del Casco");
        Cascos casco = Cascos.creacionCascos();
        if(m.read(Cascos.class, casco.getNombre())==null){
            m.save(casco);
        }
        System.out.println("Datos de los Auriculares");
        Auriculares auriculares = Auriculares.creacionAuriculares();
        if(m.read(Auriculares.class, auriculares.getNombre())==null) {
            m.save(auriculares);
        }
        System.out.println("Datos del Chaleco");
        Chalecos chaleco = Chalecos.creacionChalecos();
        if(m.read(Chalecos.class, chaleco.getNombre())==null) {
            m.save(chaleco);
        }
        System.out.println("Datos del Arma Principal");
        System.out.print("¿Vas a crear un arma nueva? (S/N) ");
        String respuesta = userInput.nextLine();
        Armas armaPrincipal;
        if(respuesta.equalsIgnoreCase("S")){
            armaPrincipal = Armas.creacionArmasSinId();
        } else {
            armaPrincipal = Armas.creacionArmasConId();
        }
        if(m.read(Armas.class,armaPrincipal.getId())==null){
            m.save(armaPrincipal);
        }
        return new Equipamientos(nombre, casco, auriculares, chaleco, armaPrincipal);
    }

    @Override
    public String toString() {
        return "Equipamientos{" +
                "nombre='" + nombre + '\'' +
                ", casco=" + casco +
                ", auriculares=" + auriculares +
                ", chaleco=" + chaleco +
                ", idarmaprincipal=" + idarmaprincipal +
                '}';
    }
}
