/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import views.Views;

/**
 * Se generan las variables a utilizar 
 * Path: para la ruta que va a recibir la ruta del archivo.
 * Mensaje: es el el texto que se guardara el archivo.
 * row: es la fila que existe en el mensaje.


 *
 * @author HP
 */
public class Models {
  Views viewbloc;
       private String path;
       private String mensaje = "";
       boolean bandera = false;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    /**
     * Permite seleccionar un archivo dentro de una ventana de dialogo
     */
    public void openFile(){
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.showOpenDialog(viewbloc);
        File archivo = jfc.getSelectedFile();
        if ((archivo == null) || (archivo.getName().equals(" "))){
            JOptionPane.showMessageDialog(viewbloc, " archvio inválido");
        }
        else
            path = archivo.getAbsolutePath();
    }
    
    /**
     *  Lee un archivo según la ruta especificada
     * 
     */
    public void readFile(){
        try{
                String row; 
            try (FileReader file = new FileReader(path); BufferedReader bufferedReader = new BufferedReader(file)){
                while ((row = bufferedReader.readLine()) != null){    
                        mensaje = mensaje + row + "\n";
                }
            } 
        }catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(viewbloc,"No se econtró el archivo" + ex.getMessage());
        } catch (IOException ex) {
                JOptionPane.showMessageDialog(viewbloc,"Error en I/O operación" + ex.getMessage());
        }
    }
     /**
     * Realiza la escritura o mdoficación a un archivo ya existente o en caso de no ser así crea el archivo.
     * 
     */
    public void writeFile(){
             try{
                File file = new File(path);
                FileWriter fileWriter = new FileWriter (file,bandera);
                try (PrintWriter printWriter  = new PrintWriter(fileWriter)){
                        printWriter.print(mensaje);
                        printWriter.close();
                        JOptionPane.showMessageDialog(viewbloc,"Se modificó ");
            }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(viewbloc,"Error en I/O operación" + ex.getMessage());
                }
            }
  
}
