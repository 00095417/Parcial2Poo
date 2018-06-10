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
    
    private String nombre;
    private RecursoAlquimista recurso1, recurso2, recurso3;
    private int vida, costo1, costo2, costo3, tiempoEspera, produccion, capacidad, nivel;
    ArrayList<Edificio> edificioRecursos = new ArrayList<>();
    ArrayList<Edificio> edificioGuerra = new ArrayList<>();
    

    @Override
    public Edificio crearEdificio(){
        return new Edificio();
    }

    @Override
    public void usarEdificio() {
    }       
    
}
