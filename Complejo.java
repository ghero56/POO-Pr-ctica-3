/**
* @author Código elaborado en la práctica 2 por:
* Fernando Arciga Guzmán:      4
* Hernández Acosta Arturo:    18
* Jaime Lagunas Parra:        23
* Luis Fernando Walls Chávez: 39
* @brief Clase Complejo:
* Esta clase genera un objeto con dos valores, uno real y uno imaginario
* tambien contiene varios metodos que modifican el objeto del cual son instanciados.
*/
public class Complejo{
  /**
  * Dos variables de tipo double para mayor precision
  */
  double real;
  double imaginario;
  /**
  * Constructores:
  * El primer constructor no recibe parametros.
  */
  public Complejo(){ // vacio
  }
  /**
  * El segundo recibe dos parametros, para la parte real y compleja respectivamente.
  */
  public Complejo(double a, double b){ // con datos
    this.real = a;
    this.imaginario = b;
  }
  /**
  * Metodos
  * El metodo suma recibe un valor complejo y opera sobre el invocador.
  */
  public void suma(Complejo operando){
    this.real += operando.real;
    this.imaginario += operando.imaginario;
  }
  /**
  * El metodo resta recibe un valor complejo y opera igual que suma.
  */
  public void resta(Complejo operando){
    this.real -= operando.real;
    this.imaginario -= operando.imaginario;
  }
  /**
  * El metodo multi multiplica el valor complejo que recibe con el invocador
  * utiliza una variable temp para guardar la parte real en lo que se terminan
  * los calculos de la parte compleja.
  */
  public void multi(Complejo operando){
    double temp = (operando.real * this.real) - (operando.imaginario * this.imaginario);
    this.imaginario = (operando.imaginario * this.real) + (operando.real * this.imaginario);
    this.real = temp;
  }
  /**
  * El metodo divid divide dos numeros complejos, utiliza dos variables temporales
  * para llamar a otros metodos sin afectar al valor invocador hasta el termino de
  * los calculos.
  */
  public void divid(Complejo operando){
    Complejo temporal = new Complejo(this.real , this.imaginario);
    Complejo operandoMod = new Complejo(operando.real , -operando.imaginario);
    double div = Math.pow(operando.real, 2) - Math.pow(operando.imaginario , 2);
    temporal.multi(operandoMod);
    this.real = (temporal.real)/div;
    this.imaginario = (temporal.imaginario)/div;
  }
  /**
  * El metodo polar calcula la forma polar de un numero complejo
  * utiliza 3 variables para obtener un resultado que puede ser visto por el
  * usuario.
  * La funcion unicamente imprime en pantalla, no retorna el valor.
  */
  public void polar(){
    double div = imaginario/real;
    double r = Math.sqrt((real * real) + (imaginario * imaginario));
    double ang;
    if(real > 0){ // a > 0
      if(imaginario >= 0) // ambos positivos -> b / a
        ang = Math.toDegrees(Math.atan(div));
      else // -b / a
        ang = 360 + Math.toDegrees(Math.atan(div));
    }else{ // a != +
      if(real == 0){ // infinito b / 0
        if(imaginario >= 0)
          ang = 90;
        else // 360 - 90 -> -b / 0
          ang = 270;
      }else{ // -a
        if(imaginario >= 0){ // b / -a
          ang = 180 + Math.toDegrees(Math.atan(div));
        }
        else // ambos negativos -b / -a
          ang = 180 + Math.toDegrees(Math.atan(div));
      }
    }
    System.out.println("\n"+r+" * e^("+ang+"i)");
  }
}

class test{
  public static void main(String[] args){
    Complejo a = new Complejo(0 , 0);
    Complejo b = new Complejo(0 , 0);
    Complejo c = new Complejo(); // residual
    c.real = a.real;
    c.imaginario = a.imaginario;
    c.suma(b);
    System.out.println(
      "\n("+a.real+ (a.imaginario>=0? " + " + a.imaginario : " - " + (-a.imaginario)) + "i) + (" // numero a y operador
      +   b.real  + (b.imaginario>=0? " + " + b.imaginario : " - " + (-b.imaginario)) + "i) = "  // numero b
      +   c.real  + (c.imaginario>=0? " + " + c.imaginario : " - " + (-c.imaginario)) + "i"      // resultado
    );
    c.real = a.real;
    c.imaginario = a.imaginario;
    c.resta(b);
    System.out.println(
      "\n("+a.real+ (a.imaginario>=0? " + " + a.imaginario : " - " + (-a.imaginario)) + "i) - (" // numero a y operador
      +   b.real  + (b.imaginario>=0? " + " + b.imaginario : " - " + (-b.imaginario)) + "i) = "  // numero b
      +   c.real  + (c.imaginario>=0? " + " + c.imaginario : " - " + (-c.imaginario)) + "i"      // resultado
    );
    c.real = a.real;
    c.imaginario = a.imaginario;
    c.multi(b);
    System.out.println(
      "\n("+a.real+ (a.imaginario>=0? " + " + a.imaginario : " - " + (-a.imaginario)) + "i) * (" // numero a y operador
      +   b.real  + (b.imaginario>=0? " + " + b.imaginario : " - " + (-b.imaginario)) + "i) = "  // numero b
      +   c.real  + (c.imaginario>=0? " + " + c.imaginario : " - " + (-c.imaginario)) + "i"      // resultado
    );
    c.real = a.real;
    c.imaginario = a.imaginario;
    c.divid(b);
    System.out.println(
      "\n("+a.real+ (a.imaginario>=0? " + " + a.imaginario : " - " + (-a.imaginario)) + "i) / (" // numero a y operador
      +   b.real  + (b.imaginario>=0? " + " + b.imaginario : " - " + (-b.imaginario)) + "i) = "  // numero b
      +   c.real  + (c.imaginario>=0? " + " + c.imaginario : " - " + (-c.imaginario)) + "i"      // resultado
    );
    a.polar();
    b.polar();
    System.out.println();
  }
}
