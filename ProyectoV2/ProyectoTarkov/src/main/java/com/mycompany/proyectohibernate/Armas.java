package com.mycompany.proyectohibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Entity
@Table(name = "armas")
public class Armas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "calibre")
    private String calibre;
    @Column(name = "precio")
    private int precio;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "piezasarmas",
            joinColumns = {@JoinColumn(name = "idarma")},
            inverseJoinColumns = {@JoinColumn(name = "idpieza")}
    )
    private List<Piezas> piezas = new ArrayList<>();
    @OneToMany(mappedBy = "idarmaprincipal")
    private List<Equipamientos> equipamientos;
    enum TipoArma{
        FUSIL,
        SUBFUSIL,
        FRANCOTIRADOR,
        RIFLE,
        PISTOLA,
        ESCOPETA,
        AMETRALLADORA
    }

    public Armas(int id, String nombre, String tipo, String calibre, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.calibre = calibre;
        this.precio = precio;
    }
    public Armas(String nombre, String tipo, String calibre, int precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.calibre = calibre;
        this.precio = precio;
    }
    public Armas(int id){
        this.id = id;
    }
    public Armas(){}

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
    public void addPieza(Piezas p) {
        piezas.add(p);
    }

    public static Armas creacionArmasConId(){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Introduce el id del arma: ");
        int id = Integer.parseInt(userInput.nextLine());
        System.out.print("Introduce el nombre del arma: ");
        String nombre = userInput.nextLine();
        for(int i = 0; i< TipoArma.values().length; i++){
            System.out.println(i+1+")"+ TipoArma.values()[i]);
        }
        System.out.print("Introduce el tipo del arma: ");
        int posicionTipoArma = Integer.parseInt(userInput.nextLine());
        String tipoArma = TipoArma.values()[posicionTipoArma-1].name();
        System.out.print("Introduce el calibre del arma: ");
        String calibre = userInput.nextLine();
        System.out.print("Introduce el precio del arma: ");
        int precio = Integer.parseInt(userInput.nextLine());
        return new Armas(id, nombre, tipoArma, calibre,precio);
    }
    public static Armas creacionArmasSinId(){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Introduce el nombre del arma: ");
        String nombre = userInput.nextLine();
        for(int i = 0; i< TipoArma.values().length; i++){
            System.out.println(i+1+")"+ Armas.TipoArma.values()[i]);
        }
        System.out.print("Introduce el tipo del arma: ");
        int posicionTipoArma = Integer.parseInt(userInput.nextLine());
        String tipoArma = TipoArma.values()[posicionTipoArma-1].name();
        System.out.print("Introduce el calibre del arma: ");
        String calibre = userInput.nextLine();
        System.out.print("Introduce el precio del arma: ");
        int precio = Integer.parseInt(userInput.nextLine());
        return new Armas(nombre, tipoArma,calibre, precio);
    }

    @Override
    public String toString() {
        return "Armas{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                ", precio=" + precio +
                '}';
    }
}
