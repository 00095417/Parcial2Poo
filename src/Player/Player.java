/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import Factory.FactoryProducerRazas;
import java.util.Scanner;

/**
 *
 * @author Carlos Ruiz
 */
public class Player {
    
    private String eleccion, razaE;
    private int fase;
    
    Scanner entrada = new Scanner(System.in);
    FactoryProducerRazas raza = new FactoryProducerRazas();

    public void setFase(int fase) {
        this.fase = fase;
    }

    public int getFase() {
        return fase;
    }

    public String getRazaE() {
        return razaE;
    }

    public void setRazaE(String razaE) {
        this.razaE = razaE;
    }
    
    public void eleccionRaza(){
        
        System.out.println("Elija una raza:\n1. Alquimista\n2. Creacionista\n3. Heroica");
        
        this.eleccion = entrada.nextLine();
        
        switch(this.eleccion){
            case "1":
                setRazaE("Alquimista");
                break;
            case "2":
                setRazaE("Creacionista");
                break;
            case "3":
                setRazaE("Heroico");
                break;
        }
    }
    
    public void jugar(){
        
        switch(getRazaE()){
            case "Alquimista":
                raza.getFactory("1").getAlquimista();
                break;
            case "Creacionista":
                raza.getFactory("2").getCreacionista();
                break;
            case "Heroico":
                raza.getFactory("3").getHeroica();
                break;
        }
    }
    
    public int getVidaEdificioPrincipal(){
        
        switch(getRazaE()){
            case "Alquimista":
                return raza.getFactory("1").getVidaEdificioPrincipal();
            case "Creacionista":
                return raza.getFactory("2").getVidaEdificioPrincipal();
            case "Heroico":
                return raza.getFactory("3").getVidaEdificioPrincipal();
        }
        return 0;
    }
    
    public void setFasejuego(){
        
        switch(getRazaE()){
            case "Alquimista":
                raza.getFactory("1").setFase(this.fase);
                break;
            case "Creacionista":
                raza.getFactory("2").setFase(this.fase);
                break;
            case "Heroico":
                raza.getFactory("3").setFase(this.fase);
                break;
        } 
    }
}
