import java.io.*;
import javax.swing.JOptionPane;

public class Escritura {

  /**
   * @param args
   */
  public static void main(String[] args) {
    File archivo; //Para manipular el archivo
    FileWriter escribir; //Para escribir en el archivo
    PrintWriter linea; //para escribir en el arrchivo
    String nombre = "", dir = "", email = "", cadena = "";
    int registros = 1;
    archivo = new File("Usuario.txt"); //Preparando el archivo
    BufferedReader almacenamiento;

    if (!archivo.exists()) {
      try {
        archivo.createNewFile();
        nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre: ");
        dir = JOptionPane.showInputDialog(null, "Ingresa la direccion: ");
        email = JOptionPane.showInputDialog(null, "Ingresa el email : ");

        escribir = new FileWriter(archivo, true);
        linea = new PrintWriter(escribir);
        //Escribimos en el archivo
        linea.println(nombre);
        linea.println(dir);
        linea.println(email);
        linea.close();
        escribir.close();
        JOptionPane.showMessageDialog(null, "Guardado con exito");
      } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "Error en el guardado");
      }
    } else {
      try {
        nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre: ");
        dir = JOptionPane.showInputDialog(null, "Ingresa la direccion: ");
        email = JOptionPane.showInputDialog(null, "Ingresa el email : ");

        escribir = new FileWriter(archivo, true);
        linea = new PrintWriter(escribir);
        //Escribimos en el archivo
        linea.println(nombre);
        linea.println(dir);
        linea.println(email);
        linea.close();
        escribir.close();
        JOptionPane.showMessageDialog(null, "Guardado con exito");
      } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "Error en el guardado");
      }
    }

    try {
      FileReader leer = new FileReader(archivo);
      almacenamiento = new BufferedReader(leer);
      while (cadena != "") {
        try {
          cadena = almacenamiento.readLine();
          nombre = cadena;
          cadena = almacenamiento.readLine();
          dir = cadena;
          cadena = almacenamiento.readLine();
          email = cadena;
          if (cadena != null) {
            JOptionPane.showMessageDialog(
              null,
              "nombre: " +
              nombre +
              "\n Direccion: " +
              dir +
              "\n Correo: " +
              email +
              registros
            );
            registros++;
          }
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      try {
        almacenamiento.close();
        leer.close();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
