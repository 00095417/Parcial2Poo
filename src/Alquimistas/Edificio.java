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
    
    private  String nombre;
    private  RecursoAlquimista recurso1, recurso2, recurso3;
    private  int vida, costo1, costo2, costo3, 
            tiempoEspera, produccion, nivel,
            capacidad_recurso1, capacidad_recurso2, capacidad_recurso3;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRecurso1(RecursoAlquimista recurso) {
        this.recurso1 = recurso;
    }

    public void setRecurso2(RecursoAlquimista recurso) {
        this.recurso2 = recurso;
    }

    public void setRecurso3(RecursoAlquimista recurso) {
        this.recurso3 = recurso;
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

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public void setProduccion(int produccion) {
        this.produccion = produccion;
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

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public String getNombre() {
        return nombre;
    }

    public RecursoAlquimista getRecurso1() {
        return recurso1;
    }

    public RecursoAlquimista getRecurso2() {
        return recurso2;
    }

    public RecursoAlquimista getRecurso3() {
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

    public int getTiempoEspera() {
        return tiempoEspera;
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
