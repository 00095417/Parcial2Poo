/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Creacionista.Creacionista;
import Heroica.Heroica;

/**
 *
 * @author Carlos Ruiz
 */
public interface AbstracFactoryRazas {
    
    void getAlquimista();
    int getVidaEdificioPrincipal();
    void setFase(int fase);
    Heroica getHeroica(String type);
    Creacionista getCreacionista(String type);
    
    
}
