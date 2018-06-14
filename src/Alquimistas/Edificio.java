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
    
    private String nombre, mana,elixir,cobalto;
    private TropasAlquimistas tropa1, tropa2;
    private VehiculosAlquimistas vehiculo1, vehiculo2;
    private int vida, cantidadMana, cantidadElixir, cantidadCobalto, costo1, costo2, costo3, 
                capacidad_recurso1, capacidad_recurso2,capacidad_recurso3, tiempo_espera, produccion, nivel;

    public void  EdificioP(String nombre, String mana, String elixir, String cobalto, int vida,
                            int cantidadMana, int cantidadElixir, int cantidadCobalto, 
                            int costo1, int costo2, int costo3, int capacidad_recurso1,
                            int capacidad_recurso2, int capacidad_recurso3, int nivel) {
        this.nombre = nombre;
        this.mana = mana;
        this.elixir = elixir;
        this.cobalto = cobalto;
        this.vida = vida;
        this.cantidadMana = cantidadMana;
        this.cantidadElixir = cantidadElixir;
        this.cantidadCobalto = cantidadCobalto;
        this.costo1 = costo1;
        this.costo2 = costo2;
        this.costo3 = costo3;
        this.capacidad_recurso1 = capacidad_recurso1;
        this.capacidad_recurso2 = capacidad_recurso2;
        this.capacidad_recurso3 = capacidad_recurso3;
        this.nivel = nivel;
    }

    public void EdificioR(String nombre, String recurso, int vida, int cantidad, int costo1, int costo2, int costo3,
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
                this.mana = recurso;
                this.cantidadMana = cantidad;
                this.capacidad_recurso1 = capacidad_recurso;
                break;
            case "Recolector de Elixir":
                this.elixir = recurso;
                this.cantidadElixir = cantidad;
                this.capacidad_recurso2 = capacidad_recurso;
                break;
            case "Recolector de Cobalto":
                this.cobalto = recurso;
                this.cantidadCobalto = cantidad;
                this.capacidad_recurso3 = capacidad_recurso;
                break;
        }
    }

    public void EdificioT(String nombre, TropasAlquimistas tropa, int vida, 
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
    
    public void EdificioV(String nombre, VehiculosAlquimistas vehiculo, int vida, 
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

    public void setMana(String mana) {
        this.mana = mana;
    }

    public void setElixir(String elixir) {
        this.elixir = elixir;
    }

    public void setCobalto(String cobalto) {
        this.cobalto = cobalto;
    }

    public void setCantidadMana(int cantidadMana) {
        this.cantidadMana = cantidadMana;
    }

    public void setCantidadElixir(int cantidadElixir) {
        this.cantidadElixir = cantidadElixir;
    }

    public void setCantidadCobalto(int cantidadCobalto) {
        this.cantidadCobalto = cantidadCobalto;
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

    public String getMana() {
        return mana;
    }

    public String getElixir() {
        return elixir;
    }

    public String getCobalto() {
        return cobalto;
    }

    public int getCantidadMana() {
        return cantidadMana;
    }

    public int getCantidadElixir() {
        return cantidadElixir;
    }

    public int getCantidadCobalto() {
        return cantidadCobalto;
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
