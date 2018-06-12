/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alquimistas;


/**
 *
 * @author Carlos Ruiz
 */
public class Edificio {
    
    private String nombre;
    private RecursosAlquimistas recurso1, recurso2,recurso3;
    private TropasAlquimistas tropa1, tropa2;
    private VehiculosAlquimistas vehiculo1, vehiculo2;
    private int vida, costo1, costo2, costo3, 
                capacidad_recurso1, capacidad_recurso2, 
                capacidad_recurso3, tiempo_espera, produccion, nivel;

    public Edificio(String nombre, RecursosAlquimistas recurso1, RecursosAlquimistas recurso2,
                    RecursosAlquimistas recurso3, int vida, int costo1, int costo2, int costo3, 
                    int capacidad_recurso1, int capacidad_recurso2, int capacidad_recurso3, int nivel) {
        this.nombre = nombre;
        this.recurso1 = recurso1;
        this.recurso2 = recurso2;
        this.recurso3 = recurso3;
        this.vida = vida;
        this.costo1 = costo1;
        this.costo2 = costo2;
        this.costo3 = costo3;
        this.capacidad_recurso1 = capacidad_recurso1;
        this.capacidad_recurso2 = capacidad_recurso2;
        this.capacidad_recurso3 = capacidad_recurso3;
        this.nivel = nivel;
    }

    public Edificio(String nombre, RecursosAlquimistas recurso, int vida, int costo1, int costo2, int costo3,
                    int capacidad_recurso, int tiempo_espera, int produccion) {
        this.nombre = nombre;
        this.vida = vida;
        this.costo1 = costo1;
        this.costo2 = costo2;
        this.costo3 = costo3;
        this.tiempo_espera = tiempo_espera;
        this.produccion = produccion;
        
        switch(nombre){
            case "Generador de Mana":
                this.recurso1 = recurso;
                this.capacidad_recurso1 = capacidad_recurso;
                break;
            case "Recolector de Elixir":
                this.recurso2 = recurso;
                this.capacidad_recurso2 = capacidad_recurso;
                break;
            case "Recolector de Cobalto":
                this.recurso3 = recurso;
                this.capacidad_recurso3 = capacidad_recurso;
                break;
        }
    }

    public Edificio(String nombre, TropasAlquimistas tropa, int vida, 
                    int costo1, int costo2, int costo3, int produccion) {
        this.nombre = nombre;
        this.vida = vida;
        this.costo1 = costo1;
        this.costo2 = costo2;
        this.costo3 = costo3;
        this.produccion = produccion;
        
        switch (nombre){
            case "Guarnicion de Gremios":
                this.tropa1 = tropa;
                break;
            case "Guarnicion de Magos":
                this.tropa2 = tropa;
                break;
        }
    }
    
    public Edificio(String nombre, VehiculosAlquimistas vehiculo, int vida, 
                    int costo1, int costo2, int costo3, int produccion) {
        this.nombre = nombre;
        this.vida = vida;
        this.costo1 = costo1;
        this.costo2 = costo2;
        this.costo3 = costo3;
        this.produccion = produccion;
        
        switch (nombre){
            case "Taller de Aerodeslizadores":
                this.vehiculo1 = vehiculo;
                break;
            case "Taller de Espejos de Fuego":
                this.vehiculo2 = vehiculo;
                break;
        }
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRecurso1(RecursosAlquimistas recurso1) {
        this.recurso1 = recurso1;
    }

    public void setRecurso2(RecursosAlquimistas recurso2) {
        this.recurso2 = recurso2;
    }

    public void setRecurso3(RecursosAlquimistas recurso3) {
        this.recurso3 = recurso3;
    }

    public void setTropa1(TropasAlquimistas tropa1) {
        this.tropa1 = tropa1;
    }

    public void setTropa2(TropasAlquimistas tropa2) {
        this.tropa2 = tropa2;
    }

    public void setVehiculo1(VehiculosAlquimistas vehiculo1) {
        this.vehiculo1 = vehiculo1;
    }

    public void setVehiculo2(VehiculosAlquimistas vehiculo2) {
        this.vehiculo2 = vehiculo2;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setCosto1(int costo1) {
        this.costo1 = costo1;
    }

    public void setCosto2(int costo2) {
        this.costo2 = costo2;
    }

    public void setCosto3(int costo3) {
        this.costo3 = costo3;
    }

    public void setCapacidad_recurso1(int capacidad_recurso1) {
        this.capacidad_recurso1 = capacidad_recurso1;
    }

    public void setCapacidad_recurso2(int capacidad_recurso2) {
        this.capacidad_recurso2 = capacidad_recurso2;
    }

    public void setCapacidad_recurso3(int capacidad_recurso3) {
        this.capacidad_recurso3 = capacidad_recurso3;
    }

    public void setTiempo_espera(int tiempo_espera) {
        this.tiempo_espera = tiempo_espera;
    }

    public void setProduccion(int produccion) {
        this.produccion = produccion;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public TropasAlquimistas getTropa1() {
        return tropa1;
    }

    public TropasAlquimistas getTropa2() {
        return tropa2;
    }

    public VehiculosAlquimistas getVehiculo1() {
        return vehiculo1;
    }

    public VehiculosAlquimistas getVehiculo2() {
        return vehiculo2;
    }  
    
    public String getNombre() {
        return nombre;
    }

    public RecursosAlquimistas getRecurso1() {
        return recurso1;
    }

    public RecursosAlquimistas getRecurso2() {
        return recurso2;
    }

    public RecursosAlquimistas getRecurso3() {
        return recurso3;
    }

    public int getVida() {
        return vida;
    }

    public int getCosto1() {
        return costo1;
    }

    public int getCosto2() {
        return costo2;
    }

    public int getCosto3() {
        return costo3;
    }

    public int getTiempo_espera() {
        return tiempo_espera;
    }

    public int getProduccion() {
        return produccion;
    }

    public int getCapacidad_recurso1() {
        return capacidad_recurso1;
    }

    public int getCapacidad_recurso2() {
        return capacidad_recurso2;
    }

    public int getCapacidad_recurso3() {
        return capacidad_recurso3;
    }

    public int getNivel() {
        return nivel;
    }
 
}
