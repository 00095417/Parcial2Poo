/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heroica;

/**
 *
 * @author Carlos Ruiz
 */
public class Edificio {
    
    private String nombre, granito,ether,carbono;
    private TropasHeroicas tropa;
    private VehiculosHeroicos vehiculo;
    private int vida, cantidadGranito, cantidadEther, cantidadCarbono, costo1, costo2, costo3, 
                capacidad_recurso1, capacidad_recurso2,capacidad_recurso3, tiempo_espera, faseCreacion, produccion, nivel;

    public void  EdificioP(String nombre, String granito, String elixir, String cobalto, int vida,
                            int cantidadGranito, int cantidadEther, int cantidadCarbono, 
                            int costo1, int costo2, int costo3, int capacidad_recurso1,
                            int capacidad_recurso2, int capacidad_recurso3, int nivel) {
        this.nombre = nombre;
        this.granito = granito;
        this.ether = elixir;
        this.carbono = cobalto;
        this.vida = vida;
        this.cantidadGranito = cantidadGranito;
        this.cantidadEther = cantidadEther;
        this.cantidadCarbono = cantidadCarbono;
        this.costo1 = costo1;
        this.costo2 = costo2;
        this.costo3 = costo3;
        this.capacidad_recurso1 = capacidad_recurso1;
        this.capacidad_recurso2 = capacidad_recurso2;
        this.capacidad_recurso3 = capacidad_recurso3;
        this.nivel = nivel;
    }

    public void EdificioR(String nombre, String recurso, int vida, int cantidad, int costo1, int costo2, int costo3,
                    int capacidad_recurso, int tiempo_espera, int produccion, int faseCreacion) {
        this.nombre = nombre;
        this.vida = vida;
        this.costo1 = costo1;
        this.costo2 = costo2;
        this.costo3 = costo3;
        this.tiempo_espera = tiempo_espera;
        this.produccion = produccion;
        this.faseCreacion = faseCreacion;
        
        switch(nombre){
            case "Generador de Granito":
                this.granito = recurso;
                this.cantidadGranito = cantidad;
                this.capacidad_recurso1 = capacidad_recurso;
                break;
            case "Recolector de Ether":
                this.ether = recurso;
                this.cantidadEther = cantidad;
                this.capacidad_recurso2 = capacidad_recurso;
                break;
            case "Recolector de Carbono":
                this.carbono = recurso;
                this.cantidadCarbono = cantidad;
                this.capacidad_recurso3 = capacidad_recurso;
                break;
        }
    }

    public void EdificioT(String nombre, TropasHeroicas tropa, int vida, 
                    int costo1, int costo2, int costo3, int produccion, int faseCreacion, int tiempo_espera) {
        this.nombre = nombre;
        this.vida = vida;
        this.costo1 = costo1;
        this.costo2 = costo2;
        this.costo3 = costo3;
        this.produccion = produccion;
        this.tropa = tropa;
        this.faseCreacion = faseCreacion;
        this.tiempo_espera = tiempo_espera;
    }
    
    public void EdificioV(String nombre, VehiculosHeroicos vehiculo, int vida, 
                    int costo1, int costo2, int costo3, int produccion, int faseCreacion, int tiempo_espera) {
        this.nombre = nombre;
        this.vida = vida;
        this.costo1 = costo1;
        this.costo2 = costo2;
        this.costo3 = costo3;
        this.produccion = produccion;
        this.vehiculo = vehiculo;
        this.faseCreacion = faseCreacion;
        this.tiempo_espera = tiempo_espera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGranito() {
        return granito;
    }

    public void setGranito(String granito) {
        this.granito = granito;
    }

    public String getEther() {
        return ether;
    }

    public void setEther(String ether) {
        this.ether = ether;
    }

    public String getCarbono() {
        return carbono;
    }

    public void setCarbono(String carbono) {
        this.carbono = carbono;
    }

    public TropasHeroicas getTropa() {
        return tropa;
    }

    public void setTropa(TropasHeroicas tropa) {
        this.tropa = tropa;
    }

    public VehiculosHeroicos getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculosHeroicos vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getCantidadGranito() {
        return cantidadGranito;
    }

    public void setCantidadGranito(int cantidadGranito) {
        this.cantidadGranito = cantidadGranito;
    }

    public int getCantidadEther() {
        return cantidadEther;
    }

    public void setCantidadEther(int cantidadEther) {
        this.cantidadEther = cantidadEther;
    }

    public int getCantidadCarbono() {
        return cantidadCarbono;
    }

    public void setCantidadCarbono(int cantidadCarbono) {
        this.cantidadCarbono = cantidadCarbono;
    }

    public int getCosto1() {
        return costo1;
    }

    public void setCosto1(int costo1) {
        this.costo1 = costo1;
    }

    public int getCosto2() {
        return costo2;
    }

    public void setCosto2(int costo2) {
        this.costo2 = costo2;
    }

    public int getCosto3() {
        return costo3;
    }

    public void setCosto3(int costo3) {
        this.costo3 = costo3;
    }

    public int getCapacidad_recurso1() {
        return capacidad_recurso1;
    }

    public void setCapacidad_recurso1(int capacidad_recurso1) {
        this.capacidad_recurso1 = capacidad_recurso1;
    }

    public int getCapacidad_recurso2() {
        return capacidad_recurso2;
    }

    public void setCapacidad_recurso2(int capacidad_recurso2) {
        this.capacidad_recurso2 = capacidad_recurso2;
    }

    public int getCapacidad_recurso3() {
        return capacidad_recurso3;
    }

    public void setCapacidad_recurso3(int capacidad_recurso3) {
        this.capacidad_recurso3 = capacidad_recurso3;
    }

    public int getTiempo_espera() {
        return tiempo_espera;
    }

    public void setTiempo_espera(int tiempo_espera) {
        this.tiempo_espera = tiempo_espera;
    }

    public int getFaseCreacion() {
        return faseCreacion;
    }

    public void setFaseCreacion(int faseCreacion) {
        this.faseCreacion = faseCreacion;
    }

    public int getProduccion() {
        return produccion;
    }

    public void setProduccion(int produccion) {
        this.produccion = produccion;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
    
}
