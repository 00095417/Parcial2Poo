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
public class TropasHeroicas {
    
    private String nombreTropa;
    private int vida, daAtaque, daDefensa, costoR1, costoR2, costoR3, cantidad;

    public void TropasHeroicas(String nombreTropa, int vida, int daAtaque, 
                             int daDefensa,int costoR1, int costoR2, int costoR3, int cantidad){
        this.nombreTropa = nombreTropa;
        this.vida = vida;
        this.daAtaque = daAtaque;
        this.daDefensa = daDefensa;
        this.costoR1 = costoR1;
        this.costoR2 = costoR2;
        this.costoR3 = costoR3;
        this.cantidad = cantidad;
    }
    
    public String getNombreTropa() {
        return nombreTropa;
    }

    public void setNombreTropa(String nombreTropa) {
        this.nombreTropa = nombreTropa;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDaAtaque() {
        return daAtaque;
    }

    public void setDaAtaque(int daAtaque) {
        this.daAtaque = daAtaque;
    }

    public int getDaDefensa() {
        return daDefensa;
    }

    public void setDaDefensa(int daDefensa) {
        this.daDefensa = daDefensa;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
