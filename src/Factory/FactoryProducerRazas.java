/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Alquimistas.FactoryAlquimista;
import Creacionista.FactoryCreacionista;
import Heroica.FactoryHeroica;

/**
 *
 * @author Carlos Ruiz
 */
public class FactoryProducerRazas {
    
    private FactoryAlquimista alquimista = new FactoryAlquimista();
    private FactoryCreacionista creacionista = new FactoryCreacionista();
    private FactoryHeroica heroico = new FactoryHeroica();
    
    public AbstracFactoryRazas getFactory(String type){
        
        switch(type){
            case "1":
                return alquimista;
            case "2":
                return creacionista;
            case "3":
                return heroico;
            default:
                return null;
        }
    }
    
}
