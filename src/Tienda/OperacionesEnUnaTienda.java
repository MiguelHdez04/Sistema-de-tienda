//13 de Agosto del 2021
//Miguel Angel Hernandez Orbe
//Programa que permite administrar el inventario y ventas de una tienda
//Practica #1 libre
package Tienda;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author MATIAS
 */
public class OperacionesEnUnaTienda {
    int pago;
    File Inventario= new File("Inventario.txt");
    //Metodo que ajusta las imagenes de etiquetas y botones para el frame Inicio
public Icon ImagenInicio (JLabel EtiMargen, JButton BotonInventario, JButton BotonVender){
        ImageIcon Imagen1 = new ImageIcon(getClass().getResource("/Imagenes/Margen.jpg"));
        Icon Fondo1 = new ImageIcon(Imagen1.getImage().getScaledInstance(EtiMargen.getWidth(), EtiMargen.getHeight(), Image.SCALE_DEFAULT));
        EtiMargen.setIcon(Fondo1);
        ImageIcon Imagen2 = new ImageIcon(getClass().getResource("/Imagenes/Inventario.png"));
        Icon Fondo2 = new ImageIcon(Imagen2.getImage().getScaledInstance(BotonInventario.getWidth(), BotonInventario.getHeight(), Image.SCALE_DEFAULT));
        BotonInventario.setIcon(Fondo2);
        ImageIcon Imagen3 = new ImageIcon(getClass().getResource("/Imagenes/Vender.jpg"));
        Icon Fondo3 = new ImageIcon(Imagen3.getImage().getScaledInstance(BotonVender.getWidth(), BotonVender.getHeight(), Image.SCALE_DEFAULT));
        BotonVender.setIcon(Fondo3);
    return Fondo2;
}

//Metodo que ajusta el fondo al frame de la página AbastecerInventario
public Icon ImagenAbastecer (JLabel EtiFondo){
    ImageIcon Imagen1 = new ImageIcon(getClass().getResource("/Imagenes/Fondo.jpg"));
        Icon Fondo1 = new ImageIcon(Imagen1.getImage().getScaledInstance(EtiFondo.getWidth(), EtiFondo.getHeight(), Image.SCALE_DEFAULT));
        EtiFondo.setIcon(Fondo1);
        return Fondo1;

}
//Metodo que ajusta las imagenes de etiquetas y botones para el frame Inventario
public Icon ImagenInventario (JLabel EtiMargen, JButton BotonRevisar, JButton BotonAbastecer){
    ImageIcon Imagen1 = new ImageIcon(getClass().getResource("/Imagenes/Margen.jpg"));
        Icon Fondo1 = new ImageIcon(Imagen1.getImage().getScaledInstance(EtiMargen.getWidth(), EtiMargen.getHeight(), Image.SCALE_DEFAULT));
        EtiMargen.setIcon(Fondo1);
        ImageIcon Imagen2 = new ImageIcon(getClass().getResource("/Imagenes/Revisar.jpg"));
        Icon Fondo2 = new ImageIcon(Imagen2.getImage().getScaledInstance(BotonRevisar.getWidth(), BotonRevisar.getHeight(), Image.SCALE_DEFAULT));
        BotonRevisar.setIcon(Fondo2);
        ImageIcon Imagen3 = new ImageIcon(getClass().getResource("/Imagenes/Abastecer.jpg"));
        Icon Fondo3 = new ImageIcon(Imagen3.getImage().getScaledInstance(BotonAbastecer.getWidth(), BotonAbastecer.getHeight(), Image.SCALE_DEFAULT));
        BotonAbastecer.setIcon(Fondo3);
    return Fondo2;
}
    //Metodo que solo permite numeros
 public void Solonumeros(JTextField Numeros){
         Numeros.addKeyListener(new KeyAdapter() {
            public void keyTyped (KeyEvent e){
                char c=e.getKeyChar();
                if (Character.isLetter(c)){
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
                }
            }
    });
    }
 
 //Metodo que crea un archivo para las existencias de los productos y crea los nombres de productos con 0 existencias
 public void ArchivoInventario(){
     if (Inventario.exists()==false){
         try{
             Inventario.createNewFile();
         }
         catch (IOException ex) {
             Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
         }
             try{
                 FileWriter Productos;
                 Productos= new FileWriter(Inventario.getAbsoluteFile(),true);
                 BufferedWriter BW= new BufferedWriter(Productos);
                 BW.write("Sabritas=0"+"\n"+"Coca cola=0"+"\n"+"Donitas=0"+"\n"+"Del valle=0"+"\n"+"Takis=0"+"\n"+"Leche alpura=0");
                 BW.close();
             }   
             catch (IOException ex) {
             Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
 }
 
 //Metodo que ingresa la cantidad de productos al inventario
 public void Abastecer (JLabel EtiSelección, JTextField TextoCantidad){
     String Producto= EtiSelección.getText();
     ArrayList <String> cadena;
     cadena= new ArrayList<String>();
     switch (Producto){
         case "Sabritas":
             try{
             FileReader LeerI;
        LeerI= new FileReader(Inventario);
        BufferedReader BR= new BufferedReader(LeerI);
        try {
            for (int i=0;i<6 ;i++){
                int Existente=0;
                int Total;
                String Linea= BR.readLine();
                cadena.add(Linea);
                String Ban=Linea;
                String Patron= "\\d+";
                Ban= Ban.replaceAll("Sabritas", "");
                Ban= Ban.replaceAll("=", "");
                Linea=Linea.replaceAll(Patron, "");
                Linea=Linea.replaceAll("=", "");
                if (Linea.equals("Sabritas")){
                    int Cantidad= Integer.parseInt(TextoCantidad.getText());
                    Existente= Integer.valueOf(Ban);
                    Total= Existente+Cantidad;
                    Ban= "Sabritas="+String.valueOf(Total);
                    cadena.set(0, null);
                    cadena.set(0, Ban);
            }}
            FileWriter Productos;
        Productos= new FileWriter(Inventario.getAbsoluteFile(),true);
        BufferedWriter BW= new BufferedWriter(Productos);
            PrintWriter Salida= new PrintWriter(Inventario);
            Salida.write("");
            Salida.close();
            for (int a=0;a<cadena.size();a++){
            BW.write(cadena.get(a)+"\n");
                        }
            JOptionPane.showMessageDialog(null, "Inventario actualizado");
            BW.close();
            } catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }}
             catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
             cadena.clear();
             TextoCantidad.setText("");
             EtiSelección.setText("");
             break;
         case "Coca cola":
             try{
             FileReader LeerI;
        LeerI= new FileReader(Inventario);
        BufferedReader BR= new BufferedReader(LeerI);
        try {
            for (int i=0;i<6 ;i++){
                int Existente=0;
                int Total;
                String Linea= BR.readLine();
                cadena.add(Linea);
                String Ban=Linea;
                String Patron= "\\d+";
                Ban= Ban.replaceAll("Coca cola", "");
                Ban= Ban.replaceAll("=", "");
                Linea=Linea.replaceAll(Patron, "");
                Linea=Linea.replaceAll("=", "");
                if (Linea.equals("Coca cola")){
                    int Cantidad= Integer.parseInt(TextoCantidad.getText());
                    Existente= Integer.valueOf(Ban);
                    Total= Existente+Cantidad;
                    Ban= "Coca cola="+String.valueOf(Total);
                    cadena.set(1, null);
                    cadena.set(1, Ban);
            }}
            FileWriter Productos;
        Productos= new FileWriter(Inventario.getAbsoluteFile(),true);
        BufferedWriter BW= new BufferedWriter(Productos);
            PrintWriter Salida= new PrintWriter(Inventario);
            Salida.write("");
            Salida.close();
            for (int a=0;a<cadena.size();a++){
            BW.write(cadena.get(a)+"\n");
                        }
            JOptionPane.showMessageDialog(null, "Inventario actualizado");
            BW.close();
            } catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }}
             catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
             cadena.clear();
             TextoCantidad.setText("");
             EtiSelección.setText("");
             break;
             case "Donitas":
             try{
             FileReader LeerI;
        LeerI= new FileReader(Inventario);
        BufferedReader BR= new BufferedReader(LeerI);
        try {
            for (int i=0;i<6 ;i++){
                int Existente=0;
                int Total;
                String Linea= BR.readLine();
                cadena.add(Linea);
                String Ban=Linea;
                String Patron= "\\d+";
                Ban= Ban.replaceAll("Donitas", "");
                Ban= Ban.replaceAll("=", "");
                Linea=Linea.replaceAll(Patron, "");
                Linea=Linea.replaceAll("=", "");
                if (Linea.equals("Donitas")){
                    int Cantidad= Integer.parseInt(TextoCantidad.getText());
                    Existente= Integer.valueOf(Ban);
                    Total= Existente+Cantidad;
                    Ban= "Donitas="+String.valueOf(Total);
                    cadena.set(2, null);
                    cadena.set(2, Ban);
            }}
            FileWriter Productos;
        Productos= new FileWriter(Inventario.getAbsoluteFile(),true);
        BufferedWriter BW= new BufferedWriter(Productos);
            PrintWriter Salida= new PrintWriter(Inventario);
            Salida.write("");
            Salida.close();
            for (int a=0;a<cadena.size();a++){
            BW.write(cadena.get(a)+"\n");
                        }
            JOptionPane.showMessageDialog(null, "Inventario actualizado");
            BW.close();
            } catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }}
             catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
             cadena.clear();
             TextoCantidad.setText("");
             EtiSelección.setText("");
             break;
             case "Del valle":
             try{
             FileReader LeerI;
        LeerI= new FileReader(Inventario);
        BufferedReader BR= new BufferedReader(LeerI);
        try {
            for (int i=0;i<6 ;i++){
                int Existente=0;
                int Total;
                String Linea= BR.readLine();
                cadena.add(Linea);
                String Ban=Linea;
                String Patron= "\\d+";
                Ban= Ban.replaceAll("Del valle", "");
                Ban= Ban.replaceAll("=", "");
                Linea=Linea.replaceAll(Patron, "");
                Linea=Linea.replaceAll("=", "");
                if (Linea.equals("Del valle")){
                    int Cantidad= Integer.parseInt(TextoCantidad.getText());
                    Existente= Integer.valueOf(Ban);
                    Total= Existente+Cantidad;
                    Ban= "Del valle="+String.valueOf(Total);
                    cadena.set(3, null);
                    cadena.set(3, Ban);
            }}
            FileWriter Productos;
        Productos= new FileWriter(Inventario.getAbsoluteFile(),true);
        BufferedWriter BW= new BufferedWriter(Productos);
            PrintWriter Salida= new PrintWriter(Inventario);
            Salida.write("");
            Salida.close();
            for (int a=0;a<cadena.size();a++){
            BW.write(cadena.get(a)+"\n");
                        }
            JOptionPane.showMessageDialog(null, "Inventario actualizado");
            BW.close();
            } catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }}
             catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
             cadena.clear();
             TextoCantidad.setText("");
             EtiSelección.setText("");
             break;
             case "Takis":
             try{
             FileReader LeerI;
        LeerI= new FileReader(Inventario);
        BufferedReader BR= new BufferedReader(LeerI);
        try {
            for (int i=0;i<6 ;i++){
                int Existente=0;
                int Total;
                String Linea= BR.readLine();
                cadena.add(Linea);
                String Ban=Linea;
                String Patron= "\\d+";
                Ban= Ban.replaceAll("Takis", "");
                Ban= Ban.replaceAll("=", "");
                Linea=Linea.replaceAll(Patron, "");
                Linea=Linea.replaceAll("=", "");
                if (Linea.equals("Takis")){
                    int Cantidad= Integer.parseInt(TextoCantidad.getText());
                    Existente= Integer.valueOf(Ban);
                    Total= Existente+Cantidad;
                    Ban= "Takis="+String.valueOf(Total);
                    cadena.set(4, null);
                    cadena.set(4, Ban);
            }}
            FileWriter Productos;
        Productos= new FileWriter(Inventario.getAbsoluteFile(),true);
        BufferedWriter BW= new BufferedWriter(Productos);
            PrintWriter Salida= new PrintWriter(Inventario);
            Salida.write("");
            Salida.close();
            for (int a=0;a<cadena.size();a++){
            BW.write(cadena.get(a)+"\n");
                        }
            JOptionPane.showMessageDialog(null, "Inventario actualizado");
            BW.close();
            } catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }}
             catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
             cadena.clear();
             TextoCantidad.setText("");
             EtiSelección.setText("");
             break;
             case "Leche alpura":
             try{
             FileReader LeerI;
        LeerI= new FileReader(Inventario);
        BufferedReader BR= new BufferedReader(LeerI);
        try {
            for (int i=0;i<6 ;i++){
                int Existente=0;
                int Total;
                String Linea= BR.readLine();
                cadena.add(Linea);
                String Ban=Linea;
                String Patron= "\\d+";
                Ban= Ban.replaceAll("Leche alpura", "");
                Ban= Ban.replaceAll("=", "");
                Linea=Linea.replaceAll(Patron, "");
                Linea=Linea.replaceAll("=", "");
                if (Linea.equals("Leche alpura")){
                    int Cantidad= Integer.parseInt(TextoCantidad.getText());
                    Existente= Integer.valueOf(Ban);
                    Total= Existente+Cantidad;
                    Ban= "Leche alpura="+String.valueOf(Total);
                    cadena.set(5, null);
                    cadena.set(5, Ban);
            }}
            FileWriter Productos;
        Productos= new FileWriter(Inventario.getAbsoluteFile(),true);
        BufferedWriter BW= new BufferedWriter(Productos);
            PrintWriter Salida= new PrintWriter(Inventario);
            Salida.write("");
            Salida.close();
            for (int a=0;a<cadena.size();a++){
            BW.write(cadena.get(a)+"\n");
                        }
            JOptionPane.showMessageDialog(null, "Inventario actualizado");
            BW.close();
            } catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }}
             catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
             cadena.clear();
             TextoCantidad.setText("");
             EtiSelección.setText("");
             break;
     }
 }
 
 //Metodo para mostrar la cantidad de producto que hay
 public void RevisarInventario(JLabel EtiSelección, JTextField TextoInventario){
     String Producto= EtiSelección.getText();
     ArrayList <String> cadena;
     cadena= new ArrayList<String>();
     switch (Producto){
         case "Sabritas":
             try{
             FileReader LeerI;
        LeerI= new FileReader(Inventario);
        BufferedReader BR= new BufferedReader(LeerI);
        try {
            for (int i=0;i<6 ;i++){
                String Linea= BR.readLine();
                cadena.add(Linea);}
            TextoInventario.setText(cadena.get(0));
            } catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }}
             catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
             cadena.clear();
             break;
             case "Coca cola":
             try{
             FileReader LeerI;
        LeerI= new FileReader(Inventario);
        BufferedReader BR= new BufferedReader(LeerI);
        try {
            for (int i=0;i<6 ;i++){
                String Linea= BR.readLine();
                cadena.add(Linea);}
            TextoInventario.setText(cadena.get(1));
            } catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }}
             catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
             cadena.clear();
             break;
             case "Donitas":
             try{
             FileReader LeerI;
        LeerI= new FileReader(Inventario);
        BufferedReader BR= new BufferedReader(LeerI);
        try {
            for (int i=0;i<6 ;i++){
                String Linea= BR.readLine();
                cadena.add(Linea);}
            TextoInventario.setText(cadena.get(2));
            } catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }}
             catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
             cadena.clear();
             break;
             case "Del valle":
             try{
             FileReader LeerI;
        LeerI= new FileReader(Inventario);
        BufferedReader BR= new BufferedReader(LeerI);
        try {
            for (int i=0;i<6 ;i++){
                String Linea= BR.readLine();
                cadena.add(Linea);}
            TextoInventario.setText(cadena.get(3));
            } catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }}
             catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
             cadena.clear();
             break;
             case "Takis":
             try{
             FileReader LeerI;
        LeerI= new FileReader(Inventario);
        BufferedReader BR= new BufferedReader(LeerI);
        try {
            for (int i=0;i<6 ;i++){
                String Linea= BR.readLine();
                cadena.add(Linea);}
            TextoInventario.setText(cadena.get(4));
            } catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }}
             catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
             cadena.clear();
             break;
             case "Leche alpura":
             try{
             FileReader LeerI;
        LeerI= new FileReader(Inventario);
        BufferedReader BR= new BufferedReader(LeerI);
        try {
            for (int i=0;i<6 ;i++){
                String Linea= BR.readLine();
                cadena.add(Linea);}
            TextoInventario.setText(cadena.get(5));
            } catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }}
             catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
             cadena.clear();
             break;
 }
}
 
 //Metodo que ajusta el fondo de la pestaña de ventas
public Icon ImagenVentas (JLabel EtiFondo){
    ImageIcon Imagen1 = new ImageIcon(getClass().getResource("/Imagenes/Fondo1.jpg"));
        Icon Fondo1 = new ImageIcon(Imagen1.getImage().getScaledInstance(EtiFondo.getWidth(), EtiFondo.getHeight(), Image.SCALE_DEFAULT));
        EtiFondo.setIcon(Fondo1);
    return Fondo1;
}

///Metodo que permite la compra de productos
 public void Ventas(JLabel EtiSelección, JTextField TextoCantidad, JLabel EtiPrecio, JLabel EtiTotalapagar,JLabel EtiTotal, JLabel Eti$2){
     String Producto= EtiSelección.getText();
     ArrayList <String> cadena;
     cadena= new ArrayList<String>();
     switch (Producto){
         case "Sabritas":
             try{
             FileReader LeerI;
        LeerI= new FileReader(Inventario);
        BufferedReader BR= new BufferedReader(LeerI);
        try {
            for (int i=0;i<6 ;i++){
                int Existente=0;
                int Total;
                String Linea= BR.readLine();
                cadena.add(Linea);
                String Ban=Linea;
                String Patron= "\\d+";
                Ban= Ban.replaceAll("Sabritas", "");
                Ban= Ban.replaceAll("=", "");
                Linea=Linea.replaceAll(Patron, "");
                Linea=Linea.replaceAll("=", "");
                if (Ban.equals("0")&&Linea.equals("Sabritas")){
                    JOptionPane.showMessageDialog(null, "No hay productos en existencia");
                }
                else{
                if (Linea.equals("Sabritas")){
                    int Cantidad= Integer.parseInt(TextoCantidad.getText());
                    if (Cantidad<=0){
                        JOptionPane.showMessageDialog(null, "Escoja una cantidad válida");
                    }
                    else{
                    Existente= Integer.valueOf(Ban);
                    if(Existente<Cantidad){
                        JOptionPane.showMessageDialog(null, "La cantidad requerida excede lo que hay en inventario");
                    }
                    else{
                    Total= Existente-Cantidad;
                    Ban= "Sabritas="+String.valueOf(Total);
                    cadena.set(0, null);
                    cadena.set(0, Ban);
                    int Precio= Integer.valueOf(EtiPrecio.getText());
                    pago= Integer.parseInt(EtiTotalapagar.getText())+(Cantidad*Precio);
                    EtiTotalapagar.setText(String.valueOf(pago));
                    EtiTotal.setVisible(true);
                    EtiTotalapagar.setVisible(true);
                    Eti$2.setVisible(true);
            }}}}}
            FileWriter Productos;
        Productos= new FileWriter(Inventario.getAbsoluteFile(),true);
        BufferedWriter BW= new BufferedWriter(Productos);
            PrintWriter Salida= new PrintWriter(Inventario);
            Salida.write("");
            Salida.close();
            for (int a=0;a<cadena.size();a++){
            BW.write(cadena.get(a)+"\n");
                        }
            BW.close();
            } catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }}
             catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
             cadena.clear();
             TextoCantidad.setText("");
             EtiSelección.setText("");
             EtiPrecio.setText("");
             break;
             case "Coca cola":
             try{
             FileReader LeerI;
        LeerI= new FileReader(Inventario);
        BufferedReader BR= new BufferedReader(LeerI);
        try {
            for (int i=0;i<6 ;i++){
                int Existente=0;
                int Total;
                String Linea= BR.readLine();
                cadena.add(Linea);
                String Ban=Linea;
                String Patron= "\\d+";
                Ban= Ban.replaceAll("Coca cola", "");
                Ban= Ban.replaceAll("=", "");
                Linea=Linea.replaceAll(Patron, "");
                Linea=Linea.replaceAll("=", "");
                if (Ban.equals("0")&&Linea.equals("Coca cola")){
                    JOptionPane.showMessageDialog(null, "No hay productos en existencia");
                }
                else{
                if (Linea.equals("Coca cola")){
                    int Cantidad= Integer.parseInt(TextoCantidad.getText());
                    if (Cantidad<=0){
                        JOptionPane.showMessageDialog(null, "Escoja una cantidad válida");
                    }
                    else{
                    Existente= Integer.valueOf(Ban);
                    if(Existente<Cantidad){
                        JOptionPane.showMessageDialog(null, "La cantidad requerida excede lo que hay en inventario");
                    }
                    else{
                    Total= Existente-Cantidad;
                    Ban= "Coca cola="+String.valueOf(Total);
                    cadena.set(1, null);
                    cadena.set(1, Ban);
                    int Precio= Integer.valueOf(EtiPrecio.getText());
                    pago= Integer.parseInt(EtiTotalapagar.getText())+(Cantidad*Precio);
                    EtiTotalapagar.setText(String.valueOf(pago));
                    EtiTotal.setVisible(true);
                    EtiTotalapagar.setVisible(true);
                    Eti$2.setVisible(true);
            }}}}}
            FileWriter Productos;
        Productos= new FileWriter(Inventario.getAbsoluteFile(),true);
        BufferedWriter BW= new BufferedWriter(Productos);
            PrintWriter Salida= new PrintWriter(Inventario);
            Salida.write("");
            Salida.close();
            for (int a=0;a<cadena.size();a++){
            BW.write(cadena.get(a)+"\n");
                        }
            BW.close();
            } catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }}
             catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
             cadena.clear();
             TextoCantidad.setText("");
             EtiSelección.setText("");
             EtiPrecio.setText("");
             break;
             case "Donitas":
             try{
             FileReader LeerI;
        LeerI= new FileReader(Inventario);
        BufferedReader BR= new BufferedReader(LeerI);
        try {
            for (int i=0;i<6 ;i++){
                int Existente=0;
                int Total;
                String Linea= BR.readLine();
                cadena.add(Linea);
                String Ban=Linea;
                String Patron= "\\d+";
                Ban= Ban.replaceAll("Donitas", "");
                Ban= Ban.replaceAll("=", "");
                Linea=Linea.replaceAll(Patron, "");
                Linea=Linea.replaceAll("=", "");
                if (Ban.equals("0")&&Linea.equals("Donitas")){
                    JOptionPane.showMessageDialog(null, "No hay productos en existencia");
                }
                else{
                if (Linea.equals("Donitas")){
                    int Cantidad= Integer.parseInt(TextoCantidad.getText());
                    if (Cantidad<=0){
                        JOptionPane.showMessageDialog(null, "Escoja una cantidad válida");
                    }
                    else{
                    Existente= Integer.valueOf(Ban);
                    if(Existente<Cantidad){
                        JOptionPane.showMessageDialog(null, "La cantidad requerida excede lo que hay en inventario");
                    }
                    else{
                    Total= Existente-Cantidad;
                    Ban= "Donitas="+String.valueOf(Total);
                    cadena.set(2, null);
                    cadena.set(2, Ban);
                    int Precio= Integer.valueOf(EtiPrecio.getText());
                    pago= Integer.parseInt(EtiTotalapagar.getText())+(Cantidad*Precio);
                    EtiTotalapagar.setText(String.valueOf(pago));
                    EtiTotal.setVisible(true);
                    EtiTotalapagar.setVisible(true);
                    Eti$2.setVisible(true);
            }}}}}
            FileWriter Productos;
        Productos= new FileWriter(Inventario.getAbsoluteFile(),true);
        BufferedWriter BW= new BufferedWriter(Productos);
            PrintWriter Salida= new PrintWriter(Inventario);
            Salida.write("");
            Salida.close();
            for (int a=0;a<cadena.size();a++){
            BW.write(cadena.get(a)+"\n");
                        }
            BW.close();
            } catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }}
             catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
             cadena.clear();
             TextoCantidad.setText("");
             EtiSelección.setText("");
             EtiPrecio.setText("");
             break;
             case "Del valle":
             try{
             FileReader LeerI;
        LeerI= new FileReader(Inventario);
        BufferedReader BR= new BufferedReader(LeerI);
        try {
            for (int i=0;i<6 ;i++){
                int Existente=0;
                int Total;
                String Linea= BR.readLine();
                cadena.add(Linea);
                String Ban=Linea;
                String Patron= "\\d+";
                Ban= Ban.replaceAll("Del valle", "");
                Ban= Ban.replaceAll("=", "");
                Linea=Linea.replaceAll(Patron, "");
                Linea=Linea.replaceAll("=", "");
                if (Ban.equals("0")&&Linea.equals("Del valle")){
                    JOptionPane.showMessageDialog(null, "No hay productos en existencia");
                }
                else{
                if (Linea.equals("Del valle")){
                    int Cantidad= Integer.parseInt(TextoCantidad.getText());
                    if (Cantidad<=0){
                        JOptionPane.showMessageDialog(null, "Escoja una cantidad válida");
                    }
                    else{
                    Existente= Integer.valueOf(Ban);
                    if(Existente<Cantidad){
                        JOptionPane.showMessageDialog(null, "La cantidad requerida excede lo que hay en inventario");
                    }
                    else{
                    Total= Existente-Cantidad;
                    Ban= "Del valle="+String.valueOf(Total);
                    cadena.set(3, null);
                    cadena.set(3, Ban);
                    int Precio= Integer.valueOf(EtiPrecio.getText());
                    pago= Integer.parseInt(EtiTotalapagar.getText())+(Cantidad*Precio);
                    EtiTotalapagar.setText(String.valueOf(pago));
                    EtiTotal.setVisible(true);
                    EtiTotalapagar.setVisible(true);
                    Eti$2.setVisible(true);
            }}}}}
            FileWriter Productos;
        Productos= new FileWriter(Inventario.getAbsoluteFile(),true);
        BufferedWriter BW= new BufferedWriter(Productos);
            PrintWriter Salida= new PrintWriter(Inventario);
            Salida.write("");
            Salida.close();
            for (int a=0;a<cadena.size();a++){
            BW.write(cadena.get(a)+"\n");
                        }
            BW.close();
            } catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }}
             catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
             cadena.clear();
             TextoCantidad.setText("");
             EtiSelección.setText("");
             EtiPrecio.setText("");
             break;
             case "Takis":
             try{
             FileReader LeerI;
        LeerI= new FileReader(Inventario);
        BufferedReader BR= new BufferedReader(LeerI);
        try {
            for (int i=0;i<6 ;i++){
                int Existente=0;
                int Total;
                String Linea= BR.readLine();
                cadena.add(Linea);
                String Ban=Linea;
                String Patron= "\\d+";
                Ban= Ban.replaceAll("Takis", "");
                Ban= Ban.replaceAll("=", "");
                Linea=Linea.replaceAll(Patron, "");
                Linea=Linea.replaceAll("=", "");
                if (Ban.equals("0")&&Linea.equals("Takis")){
                    JOptionPane.showMessageDialog(null, "No hay productos en existencia");
                }
                else{
                if (Linea.equals("Takis")){
                    int Cantidad= Integer.parseInt(TextoCantidad.getText());
                    if (Cantidad<=0){
                        JOptionPane.showMessageDialog(null, "Escoja una cantidad válida");
                    }
                    else{
                    Existente= Integer.valueOf(Ban);
                    if(Existente<Cantidad){
                        JOptionPane.showMessageDialog(null, "La cantidad requerida excede lo que hay en inventario");
                    }
                    else{
                    Total= Existente-Cantidad;
                    Ban= "Takis="+String.valueOf(Total);
                    cadena.set(4, null);
                    cadena.set(4, Ban);
                    int Precio= Integer.valueOf(EtiPrecio.getText());
                    pago= Integer.parseInt(EtiTotalapagar.getText())+(Cantidad*Precio);
                    EtiTotalapagar.setText(String.valueOf(pago));
                    EtiTotal.setVisible(true);
                    EtiTotalapagar.setVisible(true);
                    Eti$2.setVisible(true);
            }}}}}
            FileWriter Productos;
        Productos= new FileWriter(Inventario.getAbsoluteFile(),true);
        BufferedWriter BW= new BufferedWriter(Productos);
            PrintWriter Salida= new PrintWriter(Inventario);
            Salida.write("");
            Salida.close();
            for (int a=0;a<cadena.size();a++){
            BW.write(cadena.get(a)+"\n");
                        }
            BW.close();
            } catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }}
             catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
             cadena.clear();
             TextoCantidad.setText("");
             EtiSelección.setText("");
             EtiPrecio.setText("");
             break;
             case "Leche alpura":
             try{
             FileReader LeerI;
        LeerI= new FileReader(Inventario);
        BufferedReader BR= new BufferedReader(LeerI);
        try {
            for (int i=0;i<6 ;i++){
                int Existente=0;
                int Total;
                String Linea= BR.readLine();
                cadena.add(Linea);
                String Ban=Linea;
                String Patron= "\\d+";
                Ban= Ban.replaceAll("Leche alpura", "");
                Ban= Ban.replaceAll("=", "");
                Linea=Linea.replaceAll(Patron, "");
                Linea=Linea.replaceAll("=", "");
                if (Ban.equals("0")&&Linea.equals("Leche alpura")){
                    JOptionPane.showMessageDialog(null, "No hay productos en existencia");
                }
                else{
                if (Linea.equals("Leche alpura")){
                    int Cantidad= Integer.parseInt(TextoCantidad.getText());
                    if (Cantidad<=0){
                        JOptionPane.showMessageDialog(null, "Escoja una cantidad válida");
                    }
                    else{
                    Existente= Integer.valueOf(Ban);
                    if(Existente<Cantidad){
                        JOptionPane.showMessageDialog(null, "La cantidad requerida excede lo que hay en inventario");
                    }
                    else{
                    Total= Existente-Cantidad;
                    Ban= "Leche alpura="+String.valueOf(Total);
                    cadena.set(5, null);
                    cadena.set(5, Ban);
                    int Precio= Integer.valueOf(EtiPrecio.getText());
                    pago= Integer.parseInt(EtiTotalapagar.getText())+(Cantidad*Precio);
                    EtiTotalapagar.setText(String.valueOf(pago));
                    EtiTotal.setVisible(true);
                    EtiTotalapagar.setVisible(true);
                    Eti$2.setVisible(true);
            }}}}}
            FileWriter Productos;
        Productos= new FileWriter(Inventario.getAbsoluteFile(),true);
        BufferedWriter BW= new BufferedWriter(Productos);
            PrintWriter Salida= new PrintWriter(Inventario);
            Salida.write("");
            Salida.close();
            for (int a=0;a<cadena.size();a++){
            BW.write(cadena.get(a)+"\n");
                        }
            BW.close();
            } catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }}
             catch (IOException ex) {
            Logger.getLogger(OperacionesEnUnaTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
             cadena.clear();
             TextoCantidad.setText("");
             EtiSelección.setText("");
             EtiPrecio.setText("");
             break;
}

 }
}