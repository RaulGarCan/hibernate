package com.mycompany.proyectohibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Entity
@Table(name = "piezas")
public class Piezas {
    @Id
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "ergonomia")
    private int ergonomia;
    @Column(name = "retroceso")
    private int retroceso;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "precio")
    private int precio;
    @ManyToMany(mappedBy = "piezas")
    private List<Armas> armas = new ArrayList<>();
    enum TipoPieza {
        BOCACHA,
        EMPUÑADURA,
        MANGO,
        CULATA,
        CANION,
        LASER,
        LINTERNA,
        COMBO,
        MIRA,
        GUARDAPOLVO,
        GUARDAMANOS
    }

    public Piezas(String nombre, int ergonomia, int retroceso, String tipo, int precio) {
        this.nombre = nombre;
        this.ergonomia = ergonomia;
        this.retroceso = retroceso;
        this.tipo = tipo;
        this.precio = precio;
    }
    public Piezas(String nombre){
        this.nombre = nombre;
    }
    public Piezas(){}
    public String getNombre() {
        return nombre;
    }

    public int getErgonomia() {
        return ergonomia;
    }

    public int getRetroceso() {
        return retroceso;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPrecio() {
        return precio;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setErgonomia(int ergonomia) {
        this.ergonomia = ergonomia;
    }

    public void setRetroceso(int retroceso) {
        this.retroceso = retroceso;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public void addArma(Armas a){
        armas.add(a);
    }
    public static Piezas creacionPiezasConId(){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Introduce el nombre de la Pieza: ");
        String nombre = userInput.nextLine();
        System.out.print("Introduce la ergonomía de la Pieza: ");
        int ergonomia = Integer.parseInt(userInput.nextLine());
        System.out.print("Introduce el retroceso de la Pieza: ");
        int retroceso = Integer.parseInt(userInput.nextLine());
        for(int i=0; i<TipoPieza.values().length; i++){
            System.out.println(i+1+")"+TipoPieza.values()[i]);
        }
        System.out.print("Introduce el tipo de la Pieza: ");
        int posicionTipoPieza = Integer.parseInt(userInput.nextLine());
        String tipoPieza = TipoPieza.values()[posicionTipoPieza-1].name();
        System.out.print("Introduce el precio de la Pieza: ");
        int precio = Integer.parseInt(userInput.nextLine());
        return new Piezas(nombre,ergonomia,retroceso,tipoPieza,precio);
    }
    public static Piezas creacionPiezasConId(String nombre){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Introduce la ergonomía de la Pieza: ");
        int ergonomia = Integer.parseInt(userInput.nextLine());
        System.out.print("Introduce el retroceso de la Pieza: ");
        int retroceso = Integer.parseInt(userInput.nextLine());
        for(int i=0; i<TipoPieza.values().length; i++){
            System.out.println(i+1+")"+TipoPieza.values()[i]);
        }
        System.out.print("Introduce el tipo de la Pieza: ");
        int posicionTipoPieza = Integer.parseInt(userInput.nextLine());
        String tipoPieza = TipoPieza.values()[posicionTipoPieza-1].name();
        System.out.print("Introduce el precio de la Pieza: ");
        int precio = Integer.parseInt(userInput.nextLine());
        return new Piezas(nombre,ergonomia,retroceso,tipoPieza,precio);
    }

    @Override
    public String toString() {
        return "Piezas{" +
                ", nombre='" + nombre + '\'' +
                ", ergonomia=" + ergonomia +
                ", retroceso=" + retroceso +
                ", tipo=" + tipo +
                ", precio=" + precio +
                '}';
    }
}
