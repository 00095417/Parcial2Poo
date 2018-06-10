/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alquimistas;

import Creacionista.Creacionista;
import Factory.AbstracFactoryRazas;
import Heroica.Heroica;

/**
 *
 * @author Carlos Ruiz
 */
public class FactoryAlquimista implements AbstracFactoryRazas {

    @Override
    public Alquimista getAlquimista(String type) {
        return new RazaElegida();
    }

    @Override
    public Heroica getHeroica(String type) {
        return null;
    }

    @Override
    public Creacionista getCreacionista(String type) {
        return null;
    }
    
    
    
}
