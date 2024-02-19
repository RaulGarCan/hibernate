package com.mycompany.proyectohibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Entity
@Table(name = "cascos")
public class Cascos {
    @Id
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "armorclass")
    private int armorclass;
    @Column(name = "precio")
    private int precio;
    @OneToMany(mappedBy = "casco", cascade = CascadeType.ALL)
    private List<Equipamientos> equipamientos = new ArrayList<>();

    public Cascos(String nombre, int armorclass, int precio) {
        this.nombre = nombre;
        this.armorclass = armorclass;
        this.precio = precio;
    }
    public Cascos(String nombre){
        this.nombre=nombre;
    }
    public Cascos(){}

    public String getNombre() {
        return nombre;
    }

    public int getArmorclass() {
        return armorclass;
    }

    public int getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setArmorclass(int armorclass) {
        this.armorclass = armorclass;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setEquipamientos(List<Equipamientos> equipamientos) {
        this.equipamientos = equipamientos;
    }

    public List<Equipamientos> getEquipamientos() {
        return equipamientos;
    }

    public static Cascos creacionCascos(){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Introduce el nombre del casco: ");
        String nombre = userInput.nextLine();
        int armorclass;
        do {
            System.out.print("Introduce el armorclass del casco: ");
            armorclass = Integer.parseInt(userInput.nextLine());
        }while (armorclass<1 || armorclass>6);
        System.out.print("Introduce el precio del casco: ");
        int precio = Integer.parseInt(userInput.nextLine());
        return new Cascos(nombre,armorclass,precio);
    }

    @Override
    public String toString() {
        return "Cascos{" +
                "nombre='" + nombre + '\'' +
                ", armorclass=" + armorclass +
                ", precio=" + precio+"}";
    }
}
