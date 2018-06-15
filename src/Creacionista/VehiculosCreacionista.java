/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creacionista;

/**
 *
 * @author Carlos Ruiz
 */
public class VehiculosCreacionista {
    
    private String nombreVehiculo;
    private int vida, ataque, costoR1, costoR2, costoR3, cantidad;

    public void VehiculosCreacionista(String nombreVehiculo, int vida, int ataque, 
                                int costoR1, int costoR2, int costoR3, int cantidad) {
        this.nombreVehiculo = nombreVehiculo;
        this.vida = vida;
        this.ataque = ataque;
        this.costoR1 = costoR1;
        this.costoR2 = costoR2;
        this.costoR3 = costoR3;
        this.cantidad = cantidad;
    }

    public String getNombreVehiculo() {
        return nombreVehiculo;
    }

    public void setNombreVehiculo(String nombreVehiculo) {
        this.nombreVehiculo = nombreVehiculo;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getCostoR1() {
        return costoR1;
    }

    public void setCostoR1(int costoR1) {
        this.costoR1 = costoR1;
    }

    public int getCostoR2() {
        return costoR2;
    }

    public void setCostoR2(int costoR2) {
        this.costoR2 = costoR2;
    }

    public int getCostoR3() {
        return costoR3;
    }

    public void setCostoR3(int costoR3) {
        this.costoR3 = costoR3;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }
    
}
