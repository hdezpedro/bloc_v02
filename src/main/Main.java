/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import views.Views;
import models.Models;
import controllers.Controllers;

/**
 *
 * @author HP
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Views viewbloc = new Views();
        Models modelbloc = new Models();
        Controllers controllerbloc = new Controllers(viewbloc, modelbloc);
// TODO code application logic here
    }
    
}
