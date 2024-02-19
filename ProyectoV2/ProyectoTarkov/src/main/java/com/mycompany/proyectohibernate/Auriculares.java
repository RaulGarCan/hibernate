package com.mycompany.proyectohibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Entity
@Table(name = "auriculares")
public class Auriculares {
    @Id
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "precio")
    private int precio;
    @OneToMany(mappedBy = "auriculares", cascade = CascadeType.ALL)
    private List<Equipamientos> equipamientos = new ArrayList<>();

    public Auriculares(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    public Auriculares(String nombre){
        this.nombre=nombre;
    }
    public Auriculares(){}

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public static Auriculares creacionAuriculares(){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Introduce el nombre de los auriculares: ");
        String nombre = userInput.nextLine();
        System.out.print("Introduce el precio de los auriculares: ");
        int precio = Integer.parseInt(userInput.nextLine());
        return new Auriculares(nombre,precio);
    }

    @Override
    public String toString() {
        return "Auriculares{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
