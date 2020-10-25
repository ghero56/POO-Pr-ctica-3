import java.util.*;

public class Dxdiag{
  final Properties sistema = System.getProperties();
  final String[] values = {"os.name","os.version","os.arch","user.name","user.home","java.version","java.vm.version"};
  final String[] mensaje = {"SO","Version","Arquitectura","Usuario","Ruta principal","Version de Java","Version de la VM de Java"};

  public static void printDataS(){
    Dxdiag sys = new Dxdiag();
    for(int i = 0; i< 7 ; ++i){
      System.out.println("\n" + sys.mensaje[i] + " : " + sys.sistema.getProperty(sys.values[i]));
    }
    System.out.println();
  }

  public static void printDataC(){
    Dxdiag sys = new Dxdiag();
    sys.sistema.list(System.out);
  }

  public static void main(String[] args) {
    System.out.println("\n***********Version completa***********");
    printDataC();
    System.out.println("\n***********Version simplificada***********");
    printDataS();
  }
}
