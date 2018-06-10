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
public class RazaElegida implements Creacionista{

    @Override
    public String creacionista(String type) {
        return "soy un " + type;        
    }
    
}
