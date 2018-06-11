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
    
    private final  String nombre;
    private final RecursoAlquimista recurso1;
    private final RecursoAlquimista recurso2;
    private final RecursoAlquimista recurso3;
    private final int vida; 
    private final int costo1; 
    private final int costo2; 
    private final int costo3;
    private final int tiempo_espera;
    private final int produccion;
    private final int nivel;
    private final int capacidad_recurso1;
    private final int capacidad_recurso2;
    private final int capacidad_recurso3;
    
    private Edificio(EdificioBuilder builder){
        this.nombre = builder.nombre;
        this.recurso1 = builder.recurso1;
        this.recurso2 = builder.recurso2;
        this.recurso3 = builder.recurso3;
        this.vida = builder.vida;
        this.costo1 = builder.costo1;
        this.costo2 = builder.costo2;
        this.costo3 = builder.costo3;
        this.capacidad_recurso1 = builder.capacidad_recurso1;
        this.capacidad_recurso2 = builder.capacidad_recurso2;
        this.capacidad_recurso3 = builder.capacidad_recurso3;
        this.tiempo_espera = builder.tiempo_espera;
        this.produccion = builder.produccion;
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
 
        public static class EdificioBuilder{
            
            private final  String nombre;
            private  RecursoAlquimista recurso1, recurso2, recurso3;
            private  int vida, costo1, costo2, costo3, 
                         tiempo_espera, produccion, nivel,
                         capacidad_recurso1, capacidad_recurso2, capacidad_recurso3;
                
            public EdificioBuilder(String nombre){
                this.nombre = nombre;
            }
            
            public EdificioBuilder recurso1(RecursoAlquimista recurso1){
                this.recurso1 = recurso1;
                return this;
            }
            
            public EdificioBuilder recurso2(RecursoAlquimista recurso2){
                this.recurso2 = recurso2;
                return this;
            }
            
            public EdificioBuilder recurso3(RecursoAlquimista recurso3){
                this.recurso3 = recurso3;
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
            
            public EdificioBuilder capacidad_recurso1(int capacidad_recurso1){
                this.capacidad_recurso1 = capacidad_recurso1;
                return this;
            }
            
            public EdificioBuilder capacidad_recurso2(int capacidad_recurso2){
                this.capacidad_recurso2 = capacidad_recurso2;
                return this;
            }
            
            public EdificioBuilder capacidad_recurso3(int capacidad_recurso3){
                this.capacidad_recurso3 = capacidad_recurso3;
                return this;
            }
            
            public EdificioBuilder produccion(int produccion){
                this.produccion = produccion;
                return this;
            }
            
            public EdificioBuilder tiempo_espera(int tiempo_espera){
                this.tiempo_espera = tiempo_espera;
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
