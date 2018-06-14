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
    private ArrayList<Edificio> listaEdificioRecurso = new ArrayList<>();
    private ArrayList<Edificio> listaEdificioGuarnicion = new ArrayList<>();
    private ArrayList<Edificio> listaEdificioTalleres = new ArrayList<>();
    Scanner entrada = new Scanner(System.in);
    
    @Override
    public void getAlquimista() {
        if (edificioPrincipal == null)
        {
            setEdificioPrincipal();
        }
        mostrarRaza();
        menuAlquimista.menuPrincipal();
        menus();
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
        edificioPrincipal.EdificioP("Abadia","Mana","Elixir","Cobalto", 
                                    500, 10000, 5000, 5000, 100, 100, 100, 10000, 5000, 5000, 1);
    }
    //Creando los edificios que te generan recursos
    public void setEdificioRecurso(String recurso){
        
        switch(recurso)
        {
            
            case "mana":
                edificioRecurso.EdificioR("Generador de Mana", "Mana", 1000, 0, 0, 50, 50, 500, 3, 100);
                break;
                
            case "elixir":
                edificioRecurso.EdificioR("Recolector de Elixir", "Elixir", 1000, 0, 50, 0, 50, 500, 3, 100);
                break;
                
            case "cobalto":
                edificioRecurso.EdificioR("Recolector de Cobalto", "Cobalto", 1000, 0, 50, 50, 0, 500, 3, 100);
                break;                      
        }
    }
    //Creando las Guarniciones que crearan las tropas
    public void setEdificoTropa(String guarnicio){
        
        TropasAlquimistas tropa = new TropasAlquimistas();
        
        switch(guarnicio)
        {
            case "gremio":
                tropa.TropasAlquimistas("Gremio", 100, 35, 25, 10, 10, 5);
                edificioTropas.EdificioT("Guarnicion de Gremios", tropa, 150, 75, 75, 75, 2);
                break;
            case "magos":
                tropa.TropasAlquimistas("Magos", 10, 7, 6, 5, 5, 0);
                edificioTropas.EdificioT("Guarnicion de Magos", tropa, 100, 50, 50, 50, 5);
                break;
            case "especial":
                tropa.TropasAlquimistas("Chaman", 100, 50, 50, 50, 50, 1);
                edificioTropas.EdificioT("Guarnicion Especial", tropa, 100, 75, 75, 75, 1);
                break;
        }
    }
    //Creando los Talleres que crearan los vehiculos
    public void setEdificioVehiculo(String taller){
    
        VehiculosAlquimistas vehiculo = new VehiculosAlquimistas();
        
        switch (taller)
        {
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
        System.out.println(edificioPrincipal.getMana() + ": " + edificioPrincipal.getCantidadMana());
        System.out.println(edificioPrincipal.getElixir() + ": " + edificioPrincipal.getCantidadElixir());
        System.out.println(edificioPrincipal.getCobalto() + ": " + edificioPrincipal.getCantidadCobalto());
        System.out.println("---------Edificios---------");
        if (listaEdificioRecurso.isEmpty())
        {
            System.out.println("No hay edificios que generen recursos");
        }
        else{
            for (Edificio edificioR: listaEdificioRecurso)
            {
                if("Generador de Mana".equals(edificioR.getNombre()))
                {
                    System.out.println(edificioR.getNombre() + ":" + edificioR.getCantidadMana());
                }
                if("Recolector de Elixir".equals(edificioR.getNombre()))
                {
                    System.out.println(edificioR.getNombre() + ":" + edificioR.getCantidadElixir());
                }
                if("Recolector de Cobalto".equals(edificioR.getNombre()))
                {
                    System.out.println(edificioR.getNombre() + ":" + edificioR.getCantidadCobalto());
                }   
            }
        }
        if (listaEdificioGuarnicion.isEmpty())
        {
            System.out.println("No hay guarniciones");
        }
        else{
            for (Edificio edificioG: listaEdificioGuarnicion)
            {
                System.out.println(edificioG.getNombre());
            }
        }
        if (listaEdificioTalleres.isEmpty())
        {
            System.out.println("No hay talleres");
        }
        else{
            for (Edificio edificioT: listaEdificioTalleres)
            {
                System.out.println(edificioT.getNombre());
            }
        }
        System.out.println("---------Tropas------------");
    
    }
    //Mostrando las acciones que el jugador puede realizar atravez de una secuencia de menús
    public void menus(){
        
        switch(entrada.nextLine())
        {
            //Menú que te muestra los edificios que se pueden crear y las condiciones para poder hacerlo
            case "1":
                switch (menuAlquimista.menuEdificios())
                {
                    case "Generador de Mana":
                        setEdificioRecurso("mana");
                        if (edificioPrincipal.getCantidadElixir()>edificioRecurso.getCosto2()&&
                            edificioPrincipal.getCantidadCobalto()>edificioRecurso.getCosto3())
                        {    
                            edificioPrincipal.setCantidadElixir(edificioPrincipal.getCantidadElixir()-edificioRecurso.getCosto2());
                            edificioPrincipal.setCantidadCobalto(edificioPrincipal.getCantidadCobalto()-edificioRecurso.getCosto3());
                            listaEdificioRecurso.add(edificioRecurso);
                        }
                        else{
                            System.out.println("Recurso Insuficiente");
                        }
                        break;
                    case "Recolector de Elixir":
                        setEdificioRecurso("elixir");
                        if (edificioPrincipal.getCantidadMana()>edificioRecurso.getCosto1()&&
                            edificioPrincipal.getCantidadCobalto()>edificioRecurso.getCosto3())
                        {
                            edificioPrincipal.setCantidadMana(edificioPrincipal.getCantidadMana()-edificioRecurso.getCosto1());
                            edificioPrincipal.setCantidadCobalto(edificioPrincipal.getCantidadCobalto()-edificioRecurso.getCosto3());
                            listaEdificioRecurso.add(edificioRecurso);
                        }
                        else{
                            System.out.println("Recurso Insuficiente");
                        }
                        break;
                    case "Recolector de Cobalto":
                        setEdificioRecurso("cobalto");
                        if (edificioPrincipal.getCantidadMana()>edificioRecurso.getCosto1()&&
                            edificioPrincipal.getCantidadElixir()>edificioRecurso.getCosto2())
                        {
                            edificioPrincipal.setCantidadMana(edificioPrincipal.getCantidadMana()-edificioRecurso.getCosto1());
                            edificioPrincipal.setCantidadElixir(edificioPrincipal.getCantidadElixir()-edificioRecurso.getCosto2());
                            listaEdificioRecurso.add(edificioRecurso);
                        }
                        else{
                            System.out.println("Recurso Insuficiente");
                        }
                        break;
                    case "Guarnicion de Gremios":
                        setEdificoTropa("gremio");
                        if (edificioPrincipal.getCantidadMana()>edificioTropas.getCosto1()&&
                            edificioPrincipal.getCantidadElixir()>edificioTropas.getCosto2()&&
                            edificioPrincipal.getCantidadCobalto()>edificioTropas.getCosto3())
                        {
                            edificioPrincipal.setCantidadMana(edificioPrincipal.getCantidadMana()- edificioTropas.getCosto1());
                            edificioPrincipal.setCantidadElixir(edificioPrincipal.getCantidadElixir()- edificioTropas.getCosto2());
                            edificioPrincipal.setCantidadCobalto(edificioPrincipal.getCantidadCobalto()- edificioTropas.getCosto3());
                            listaEdificioGuarnicion.add(edificioTropas);
                        }
                        else{
                            System.out.println("Recurso Insuficiente");
                        }
                        break;
                    case "Guarnicion de Magos":
                         setEdificoTropa("magos");
                        if (edificioPrincipal.getCantidadMana()>edificioTropas.getCosto1()&&
                            edificioPrincipal.getCantidadElixir()>edificioTropas.getCosto2()&&
                            edificioPrincipal.getCantidadCobalto()>edificioTropas.getCosto3())
                        {
                            edificioPrincipal.setCantidadMana(edificioPrincipal.getCantidadMana()- edificioTropas.getCosto1());
                            edificioPrincipal.setCantidadElixir(edificioPrincipal.getCantidadElixir()- edificioTropas.getCosto2());
                            edificioPrincipal.setCantidadCobalto(edificioPrincipal.getCantidadCobalto()- edificioTropas.getCosto3());
                            listaEdificioGuarnicion.add(edificioTropas);
                        }
                        else{
                            System.out.println("Recurso Insuficiente");
                        }
                        break;
                    case "Guarnicion Especial":
                         setEdificoTropa("especial");
                        if (edificioPrincipal.getCantidadMana()>edificioTropas.getCosto1()&&
                            edificioPrincipal.getCantidadElixir()>edificioTropas.getCosto2()&&
                            edificioPrincipal.getCantidadCobalto()>edificioTropas.getCosto3())
                        {
                            edificioPrincipal.setCantidadMana(edificioPrincipal.getCantidadMana()- edificioTropas.getCosto1());
                            edificioPrincipal.setCantidadElixir(edificioPrincipal.getCantidadElixir()- edificioTropas.getCosto2());
                            edificioPrincipal.setCantidadCobalto(edificioPrincipal.getCantidadCobalto()- edificioTropas.getCosto3());
                            listaEdificioGuarnicion.add(edificioTropas);
                        }
                        else{
                            System.out.println("Recurso Insuficiente");
                        }
                        break;
                    case "Taller de Aerodeslizador":
                         setEdificioVehiculo("aerodeslizador");
                        if (edificioPrincipal.getCantidadMana()>edificioVehiculo.getCosto1()&&
                            edificioPrincipal.getCantidadElixir()>edificioVehiculo.getCosto2()&&
                            edificioPrincipal.getCantidadCobalto()>edificioVehiculo.getCosto3())
                        {
                            edificioPrincipal.setCantidadMana(edificioPrincipal.getCantidadMana()- edificioVehiculo.getCosto1());
                            edificioPrincipal.setCantidadElixir(edificioPrincipal.getCantidadElixir()- edificioVehiculo.getCosto2());
                            edificioPrincipal.setCantidadCobalto(edificioPrincipal.getCantidadCobalto()- edificioVehiculo.getCosto3());
                            listaEdificioTalleres.add(edificioVehiculo);
                        }
                        else{
                            System.out.println("Recurso Insuficiente");
                        }
                        break;
                    case "Taller de Espejos de Fuego":
                        setEdificioVehiculo("espejo de fuego");
                        if (edificioPrincipal.getCantidadMana()>edificioVehiculo.getCosto1()&&
                            edificioPrincipal.getCantidadElixir()>edificioVehiculo.getCosto2()&&
                            edificioPrincipal.getCantidadCobalto()>edificioVehiculo.getCosto3())
                        {
                            edificioPrincipal.setCantidadMana(edificioPrincipal.getCantidadMana()- edificioVehiculo.getCosto1());
                            edificioPrincipal.setCantidadElixir(edificioPrincipal.getCantidadElixir()- edificioVehiculo.getCosto2());
                            edificioPrincipal.setCantidadCobalto(edificioPrincipal.getCantidadCobalto()- edificioVehiculo.getCosto3());
                            listaEdificioGuarnicion.add(edificioVehiculo);
                        }
                        else{
                            System.out.println("Recurso Insuficiente");
                        }
                        break;
                    default:
                        menuAlquimista.menuPrincipal();
                        menus();
                        break;       
                }
                break;
            //Menú que te muestra las tropas a crear y las condiciones para hacerlo
            case "2":
                menuAlquimista.menuTropas();
                break;
        
        }
    }
}
