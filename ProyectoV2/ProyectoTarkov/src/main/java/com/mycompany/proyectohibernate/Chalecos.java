package com.mycompany.proyectohibernate;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Entity
@Table(name = "chalecos")
public class Chalecos {
    @Id
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "armorclass")
    private int armorclass;
    @Column(name = "precio")
    private int precio;
    @OneToMany(mappedBy = "chaleco", cascade = CascadeType.ALL)
    private List<Equipamientos> equipamientos = new ArrayList<>();

    public Chalecos(String nombre, int armorclass, int precio) {
        this.nombre = nombre;
        this.armorclass = armorclass;
        this.precio = precio;
    }
    public Chalecos(String nombre){
        this.nombre=nombre;
    }
    public Chalecos(){}

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

    public List<Equipamientos> getEquipamientos() {
        return equipamientos;
    }

    public void setEquipamientos(List<Equipamientos> equipamientos) {
        this.equipamientos = equipamientos;
    }

    public static Chalecos creacionChalecos(){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Introduce el nombre del chaleco: ");
        String nombre = userInput.nextLine();
        int armorclass;
        do {
            System.out.print("Introduce el armorclass del chaleco: ");
            armorclass = Integer.parseInt(userInput.nextLine());
        }while (armorclass<1 || armorclass>6);
        System.out.print("Introduce el precio del chaleco: ");
        int precio = Integer.parseInt(userInput.nextLine());
        return new Chalecos(nombre,armorclass,precio);
    }

    @Override
    public String toString() {
        return "Chalecos{" +
                "nombre='" + nombre + '\'' +
                ", armorclass=" + armorclass +
                ", precio=" + precio +
                '}';
    }
}
