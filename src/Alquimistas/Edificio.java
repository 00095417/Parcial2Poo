/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alquimistas;

import java.util.ArrayList;

/**
 *
 * @author Carlos Ruiz
 */
public class Edificio implements Alquimista {
    
    private final String nombre;
    private final RecursoAlquimista recurso1;
    private final RecursoAlquimista recurso2;
    private final RecursoAlquimista recurso3;
    private final int vida;
    private final int costo1;
    private final int costo2;
    private final int costo3;
    private final int tiempoEspera;
    private final int produccion;
    private final int capacidad;
    private final int nivel;
    
    private Edificio(EdificioBuilder builder){
        this.nombre = builder.nombre;
        this.recurso1 = builder.recurso1;
        this.recurso2 = builder.recurso2;
        this.recurso3 = builder.recurso3;
        this.vida = builder.vida;
        this.costo1 = builder.costo1;
        this.costo2 = builder.costo2;
        this.costo3 = builder.costo3;
        this.tiempoEspera = builder.tiempoEspera;
        this.produccion = builder.produccion;
        this.capacidad = builder.capacidad;
        this.nivel = builder.nivel;
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

    public int getCapacidad() {
        return capacidad;
    }

    public int getNivel() {
        return nivel;
    }
    
    @Override
    public Edificio crearEdificio(){
        return null;
    }

    @Override
    public void usarEdificio() {
    }       
    
    public static class EdificioBuilder{
        
        private final String nombre;
        private RecursoAlquimista recurso1, recurso2, recurso3;
        private int vida, costo1, costo2, costo3, tiempoEspera, produccion, capacidad, nivel;

        public EdificioBuilder(String nombre){
            this.nombre = nombre;
        }

        public EdificioBuilder recurso1(String recurso, int capacidad){
            this.recurso1.setNombre(nombre);
            this.recurso1.setCantidad(capacidad);
            return this;
        }

        public EdificioBuilder recurso2(String recurso, int capacidad){
            this.recurso2.setNombre(nombre);
            this.recurso2.setCantidad(capacidad);
            return this;
        }

        public EdificioBuilder recurso3(String recurso, int capacidad){
            this.recurso3.setNombre(nombre);
            this.recurso3.setCantidad(capacidad);
            return this;
        }

        public EdificioBuilder vida(int vida){
            this.vida = vida;
            return this;
        }

        public EdificioBuilder costo1(int costo1){
            this.costo1 = costo1;
            return this;
        }

        public EdificioBuilder costo2(int costo2){
            this.costo2 = costo2;
            return this;
        }

        public EdificioBuilder costo3(int costo3){
            this.costo3 = costo3;
            return this;
        }

        public EdificioBuilder tiempoEspera(int tiempoEspera){
            this.tiempoEspera = tiempoEspera;
            return this;
        }

        public EdificioBuilder produccion(int produccion){
            this.produccion = produccion;
            return this;
        }

        public EdificioBuilder capacidad(int capacidad){
            this.capacidad = capacidad;
            return this;
        }

        public EdificioBuilder nivel(int nivel){
            this.nivel = nivel;
            return this;
        }

        public Edificio build(){
            return new Edificio(this);
        }
    }

}
