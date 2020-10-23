/**
* @author Código elaborado en la práctica 2 por:
* Fernando Arciga Guzmán:      4
* Hernández Acosta Arturo:    18
* Jaime Lagunas Parra:        23
* Luis Fernando Walls Chávez: 39
*
* La clase Gauss contiene metodos para solucionar ecuaciones
*/
public class Gauss{
  /**
  * Metodo calc3x3
  */
  public static double[] calc3x3(
    double x1, double y1, double z1, double r1,
    double x2, double y2, double z2, double r2,
    double x3, double y3, double z3, double r3
  ){
    double[] res,tmp;
    double[] res = new Array[3]; // x y z
    double[] f1 = new Array[5];  // x y z r mult
    double[] f2 = new Array[4];  // y z r mult
    if(x3 != 0 && x1 != 0){
      if( (x3 > 0 && x1 > 0) || (x3 < 0 && x1 < 0) ){
        f1[4] = (x3/x1);  // multiplicador de fila valor residual
        f1[3] = r1*f1[4]; // multiplicacion en resultado
        f1[2] = z1*f1[4]; // multiplicacion en z
        f1[1] = y1*f1[4]; // multiplicacion en y
        f1[0] = x1*f1[4]; // multiplicacion en x
        x3 -= f1[0];
        y3 -= f1[1];
        z3 -= f1[2];
        r3 -= f1[3];
      }else{
        f1[4] = (x3/x1);  // multiplicador de fila valor residual
        f1[3] = r1*f1[4]; // multiplicacion en resultado
        f1[2] = z1*f1[4]; // multiplicacion en z
        f1[1] = y1*f1[4]; // multiplicacion en y
        f1[0] = x1*f1[4]; // multiplicacion en x
        x3 += f1[0];
        y3 += f1[1];
        z3 += f1[2];
        r3 += f1[3];
      }
    }
    if(x2 != 0 && x1 != 0){
      if((x2 > 0 && x1 > 0) || (x2 < 0 && x1 < 0)){
        f1[4] = (x2/x1);  // multiplicador de fila valor residual
        f1[3] = r1*f1[4]; // multiplicacion en resultado
        f1[2] = z1*f1[4]; // multiplicacion en z
        f1[1] = y1*f1[4]; // multiplicacion en y
        f1[0] = x1*f1[4]; // multiplicacion en x
        x2 -= f1[0];
        y2 -= f1[1];
        z2 -= f1[2];
        r2 -= f1[3];
      }else{
        f1[4] = (x2/x1);  // multiplicador de fila valor residual
        f1[3] = r1*f1[4]; // multiplicacion en resultado
        f1[2] = z1*f1[4]; // multiplicacion en z
        f1[1] = y1*f1[4]; // multiplicacion en y
        f1[0] = x1*f1[4]; // multiplicacion en x
        x2 += f1[0];
        y2 += f1[1];
        z2 += f1[2];
        r2 += f1[3];
      }
    }
    if(x3 == 0 && y3 != 0 && z3 != 0){
      tmp = calc2x2(y2,z2,r2,y3,z3,r3);
      res[0] = -(((y1*tmp[0]) + (z1*tmp[1]) - (r1)))/x1;
      res[1] = tmp[0];
      res[2] = tmp[1];
    }else{
      if(x3 == 0 && y3 == 0 && z3 != 0){
        res[2] = r3/z3;
        res[1] = (-((z2*res[2]) - (r2)))/y2;
        res[0] = (-((y1*res[1]) + (z1*res[2]) - (r1)))/x1;
      }else{
        if(x3 == 0 && y3 == 0 && z3 == 0){
          System.out.println("Indeterminada");
          return res;
        }
      }
    }
    return res;
  }
  /**
  */
  public static double[] calc2x2(
    double x1, double y1, double r1,
    double x2, double y2, double r2
  ){
    double[] res = new Array[2]; // x y
    double[] tmp = new Array[3];
    if(Math.abs(x1) != Math.abs(x2) && x1 != 0 && x2 != 0){
      tmp[0] = x1;
      tmp[1] = y1;
      tmp[2] = r1;
      if(x1 > 0){
        if(x2 > 0){
          tmp[0] *= x2; tmp[1] *= x2; tmp[2]*= x2; // (x1 + y1 = r1) * x2
          x2 *= -x1; y2 *= -x1; r2 *= -x1;     // (x2 + y2 = r2) * -x1
          x2 += tmp[0]; y2 += tmp[1];r2 += tmp[2];
          // (x2 + x1) + (y2 + y1) = r2 + r1
          res[1] = r2/y2;
        }else{ // x2 < 0
          tmp[0] *= x2; tmp[1] *= x2; tmp[2]*= x2; // (x1 + y1 = r1) * x2
          x2 *= x1; y2 *= x1; r2 *= x1;     // (x2 + y2 = r2) * x1
          x2 += tmp[0]; y2 += tmp[1];r2 += tmp[2];
          // (x2 + x1) + (y2 + y1) = (r2 + r1)
          res[1] = r2/y2;
        }
      }else{ // x1 < 0
        if(x2 > 0){

        }else{ // x2 < 0

        }
      }
    }else{
      if(x1 < x2){
        x1 += x2; // = 0
        y1 += y2;
        r1 += r2;
        res[1] = r1/y1; // y
      }else{ // x1 > x2
        if(x1 > x2){
          x2 += x1; // 0
          y2 += y1;
          r2 += r1;
          res[1] = r2/y2; // y
        }else{
          if(x1 == 0){
            if(y1 == 0){
              System.out.println("valores invalidos");
              return res;
            }else{
              res[1] = r1/y1;
              if(x2 != 0){
                if(y2 != 0){
                  res[0] = (((-res[1])*y2) + r2)/x2;
                  return res;
                }
              }else{
                System.out.println("Valores invalidos");
                return res;
              }
            }
          }else{ // x2 == 0
            if(y2 == 0){
              System.out.println("valores invalidos");
              return res;
            }else{
              res[1] = r2/y2;
              if(y1 != 0){
                res[0] = (((-res[1])*y1) + r1)/x1;
                return res;
              }else{
                res[0] = r1/x1;
                return res;
              }
            }
          }
        }
      }
    }
    res[0] = (((-res[1])*y1) + r1)/x1;
    return res;
  }
  /**
  * Metodo calc1x1G
  * recibe
  */
  public static double[] calc1x1G(double a, double b, double c){
    double[] res = new Array[2]; // x1 x2
    if(a==0){
      System.out.println("no se puede dividir entre cero");
    }else {
      res[0] = ( (-b) + (Math.sqrt(Math.pow(b,2) - (4*a*c))))/2*a;
      res[1] = ( (-b) - (Math.sqrt(Math.pow(b,2) - (4*a*c))))/2*a;
    }
    return res;
  }
  /**
  * Metodo main para realizar una prueba de codigo dentro de la clase
  */
  public static void main(String[] args) {
    double[] arreglo3 = calc3x3(3,2,1,4,6,5,7,8,9,1,3,2);
    for (double i : arreglo3) {
      System.out.println("\n" + i);
    }
  }
}
