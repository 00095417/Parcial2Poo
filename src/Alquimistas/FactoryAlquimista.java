/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alquimistas;

import Creacionista.Creacionista;
import Factory.AbstracFactoryRazas;
import Heroica.Heroica;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Carlos Ruiz
 */
public class FactoryAlquimista implements AbstracFactoryRazas {
    
    private final Menu menuAlquimista = Menu.getInstance();
    private Edificio edificioPrincipal;
    private Edificio edificioRecurso = new Edificio();
    private Edificio edificioTropas = new Edificio();
    private Edificio edificioVehiculo = new Edificio();
    private RecursosAlquimistas recursoMana = new RecursosAlquimistas("Mana", 2000);
    private RecursosAlquimistas recursoElixir = new RecursosAlquimistas("Elixir", 1000);
    private RecursosAlquimistas recursoCobalto = new RecursosAlquimistas("Cobalto", 1000);
    private ArrayList<Edificio> listaEdificioRecurso = new ArrayList<>();
    private ArrayList<Edificio> listaEdificioGuarnicion = new ArrayList<>();
    private ArrayList<Edificio> listaEdificioTalleres = new ArrayList<>();
    Scanner entrada = new Scanner(System.in);
    
    @Override
    public void getAlquimista() {
        if (edificioPrincipal == null){
            setEdificioPrincipal();
        }
        
        mostrarRaza();
        menuAlquimista.menuPrincipal();
        
        switch(entrada.nextLine()){
        
            case "1":
                switch (menuAlquimista.menuEdificios()){
                    case "Generador de Mana":
                        setEdificioRecurso("mana");
                        if (edificioPrincipal.getRecurso2().getCantidad()>edificioRecurso.getCosto2()&&
                            edificioPrincipal.getRecurso3().getCantidad()>edificioRecurso.getCosto3()){
                            edificioPrincipal.getRecurso2().setCantidad(edificioPrincipal.getRecurso2().getCantidad()-edificioRecurso.getCosto2());
                            edificioPrincipal.getRecurso3().setCantidad(edificioPrincipal.getRecurso3().getCantidad()-edificioRecurso.getCosto3());
                            listaEdificioRecurso.add(edificioRecurso);
                        }
                        else{
                            System.out.println("Recurso Insuficiente");
                        }
                        break;
                    case "Recolector de Elixir":
                        setEdificioRecurso("elixir");
                        if (edificioPrincipal.getRecurso1().getCantidad()>edificioRecurso.getCosto1()&&
                            edificioPrincipal.getRecurso3().getCantidad()>edificioRecurso.getCosto3()){
                            edificioPrincipal.getRecurso1().setCantidad(edificioPrincipal.getRecurso1().getCantidad()-edificioRecurso.getCosto1());
                            edificioPrincipal.getRecurso3().setCantidad(edificioPrincipal.getRecurso3().getCantidad()-edificioRecurso.getCosto3());
                            listaEdificioRecurso.add(edificioRecurso);
                        }
                        else{
                            System.out.println("Recurso Insuficiente");
                        }
                        break;
                    case "Recolector de Cobalto":
                        setEdificioRecurso("cobalto");
                        if (edificioPrincipal.getRecurso1().getCantidad()>edificioRecurso.getCosto1()&&
                            edificioPrincipal.getRecurso2().getCantidad()>edificioRecurso.getCosto2()){
                            edificioPrincipal.getRecurso1().setCantidad(edificioPrincipal.getRecurso1().getCantidad()-edificioRecurso.getCosto1());
                            edificioPrincipal.getRecurso2().setCantidad(edificioPrincipal.getRecurso2().getCantidad()-edificioRecurso.getCosto2());
                            listaEdificioRecurso.add(edificioRecurso);
                        }
                        else{
                            System.out.println("Recurso Insuficiente");
                        }
                        break;
                }
                break;
            case "2":
                menuAlquimista.menuTropas();
                
                break;
        
        }
        mostrarRaza();
        
    }

    @Override
    public Heroica getHeroica(String type) {
        return null;
    }

    @Override
    public Creacionista getCreacionista(String type) {
        return null;
    }
    
    //Creando el Centro de Mando
    public void setEdificioPrincipal(){
        edificioPrincipal = new Edificio();
        edificioPrincipal.EdificioP("Abadia", recursoMana, recursoElixir, recursoCobalto, 
                                    500, 100, 100, 100, 10000, 5000, 5000, 1);
    }
    //Creando los edificios que te generan recursos
    public void setEdificioRecurso(String recurso){
        
        int rAux;
        
        switch(recurso){
            
            case "mana":
                rAux = recursoMana.getCantidad();
                recursoMana.setCantidad(0);
                edificioRecurso.EdificioR("Generador de Mana", recursoMana, 1000, 0, 50, 50, 500, 3, 100);
                System.out.println(recursoMana.getCantidad());
                recursoMana.setCantidad(rAux);
                break;
                
            case "elixir":
                rAux = recursoElixir.getCantidad();
                recursoElixir.setCantidad(0);
                edificioRecurso.EdificioR("Recolector de Elixir", recursoElixir, 1000, 50, 0, 50, 500, 3, 100);
                recursoElixir.setCantidad(rAux);
                break;
                
            case "cobalto":
                rAux = recursoCobalto.getCantidad();
                recursoCobalto.setCantidad(0);
                edificioRecurso.EdificioR("Recolector de Cobalto", recursoCobalto, 1000, 50, 50, 0, 500, 3, 100);
                recursoCobalto.setCantidad(rAux);
                break;                      
        }
    }
    //Creando las Guarniciones que crearan las tropas
    public void setEdificoTropa(String guarnicio){
        
        TropasAlquimistas tropa = new TropasAlquimistas();
        
        switch(guarnicio){
            case "gremio":
                tropa.TropasAlquimistas("Gremio", 100, 35, 25, 10, 10, 5);
                edificioTropas.EdificioT("Guarnicio de Gremios", tropa, 150, 75, 75, 75, 2);
                break;
            case "magos":
                tropa.TropasAlquimistas("Magos", 10, 7, 6, 5, 5, 0);
                edificioTropas.EdificioT("Guarnicio de Magos", tropa, 100, 50, 50, 50, 5);
                break;
            case "especial":
                tropa.TropasAlquimistas("Chaman", 100, 50, 50, 50, 50, 1);
        }
    }
    //Creando los Talleres que crearan los vehiculos
    public void setEdificioVehiculo(String taller){
    
        VehiculosAlquimistas vehiculo = new VehiculosAlquimistas();
        
        switch (taller){
            case "aerodeslizador":
                vehiculo.VehiculosAlquimistas("Aerodeslizador", 100, 30, 0, 25, 25);
                edificioVehiculo.EdificioV("Taller de Aerodeslizadores", vehiculo, 100, 100, 100, 100, 1);
                break;
            case "espejo de fuego":
                vehiculo.VehiculosAlquimistas("Espejo de Fuego", 100, 30, 0, 25, 25);
                edificioVehiculo.EdificioV("Taller de Espejos de Fuego", vehiculo, 100, 100, 100, 100, 1);
                break;
        }
    }
    //Mostrando los elementos que posee la raza alquimista
    public void mostrarRaza(){
    
        System.out.println("------Raza Alquimista------");
        System.out.println("---------Recursos----------");
        System.out.println(edificioPrincipal.getRecurso1().getNombre() + ": " + edificioPrincipal.getRecurso1().getCantidad());
        System.out.println(edificioPrincipal.getRecurso2().getNombre() + ": " + edificioPrincipal.getRecurso2().getCantidad());
        System.out.println(edificioPrincipal.getRecurso3().getNombre() + ": " + edificioPrincipal.getRecurso3().getCantidad());
        System.out.println("---------Edificios---------");
        if (listaEdificioRecurso.isEmpty()){
            System.out.println("No hay edificios que generen recursos");
        }
        else{
            for (Edificio edificioR: listaEdificioRecurso){
                if("Generador de Mana".equals(edificioR.getNombre())){
                    System.out.println(edificioR.getNombre() + ":" + edificioR.getRecurso1().getCantidad());
                }
                if("Recolector de Elixir".equals(edificioR.getNombre())){
                    System.out.println(edificioR.getNombre() + ":" + edificioR.getRecurso2().getCantidad());
                }
                if("Recolector de Cobalto".equals(edificioR.getNombre())){
                    System.out.println(edificioR.getNombre() + ":" + edificioR.getRecurso3().getCantidad());
                }   
            }
        }
        if (listaEdificioGuarnicion.isEmpty()){
            System.out.println("No hay guarniciones");
        }
        else{
            for (Edificio edificioR: listaEdificioRecurso){
                System.out.println(edificioR.getNombre());
            }
        }
        if (listaEdificioTalleres.isEmpty()){
            System.out.println("No hay talleres");
        }
        else{
            for (Edificio edificioR: listaEdificioRecurso){
                System.out.println(edificioR.getNombre());
            }
        }
        System.out.println("---------Tropas------------");
    
    }
      
}
