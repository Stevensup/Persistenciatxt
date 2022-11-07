import java.io.*;
import javax.swing.JOptionPane;

public class Lectura {

  /**
   * @param args
   */
  public static void main(String[] args) {
    File archivo; //Para manipular el archivo
    FileReader leer;
    BufferedReader almacenamiento;
    String nombre = "", dir = "", email = "", cadena;
    int registros = 1;
    archivo = new File("Usuario.txt"); //Preparando el archivo

    try {
      leer = new FileReader(archivo);
      almacenamiento = new BufferedReader(leer);
      cadena = "";
      while (cadena != null) {
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
              registros +
              " .nombre: " +
              nombre +
              "\n Direccion: " +
              dir +
              "\n Correo: " +
              email
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
