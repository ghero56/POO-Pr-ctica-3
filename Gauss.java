import java.util.Scanner;
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
  public static double[] calc3x3(double[][] valores){
    double[] tmp;
    double[] pos = new double[3];
    int used = 0;
    int index_pos = 0;
    double[] f1 = new double[4];  // x y z r
    double[] f2 = new double[3];  // y z r
    double[] res = new double[3]; // resultados x y z
    if(valores[0][0] != 0 || valores[1][0] != 0 || valores[2][0] != 0){
      if(valores[0][1] != 0 || valores[1][1] != 0 || valores[2][1] != 0){
        if(valores[0][2] != 0 || valores[1][2] != 0 || valores[2][2] != 0){ // todas existen
          if(valores[0][0] != 0){
            for(int i = 0; i < 4; ++i){
              f1[i] = valores[0][i];
            }
            if(valores[1][0] != 0){
              double div = valores[1][0]/f1[0];
              if((valores[1][0] > 0 && valores[0][0] > 0) || (valores[1][0] < 0 && valores[0][0] < 0)){
                for(int i = 0 ; i < 4 ; ++i ){
                  valores[1][i] -= f1[i] * div;
                }
              }else{
                for(int i = 0 ; i < 4 ; ++i ){
                  valores[1][i] += f1[i] * div;
                }
              }
              if(valores[2][0] != 0){
                div = valores[2][0]/f1[0];
                if((valores[2][0] > 0 && valores[0][0] > 0) || (valores[2][0] < 0 && valores[0][0] < 0)){
                  for(int i = 0 ; i < 4 ; ++i ){
                    valores[2][i] -= f1[i] * div;
                  }
                }else{
                  for(int i = 0 ; i < 4 ; ++i ){
                    valores[2][i] += f1[i] * div;
                  }
                }
              }else{

              }
            }
          }
          else{
            if(valores[1][0] != 0){
              for (int i = 0; i < 4; ++i) {
                f1[i] = valores[0][i];
              }
              if(valores[2][0] != 0){

              }else{

              }
            }else{

            }
          }
          /*for(int i = 0; i < 3; i++ ){
            for(int j = 0 ; j < 3 ; j++ ){
              if(valores[i][j] == 0){
                used = i;
                intercambio(i,0,valores,res);
              }
            }
          }
          if(res[0] != 0){// tenemos x
            if(res[1] != 0){ // tenemos y
              if(res[2] != 0){ // tenemos z
                return res;
              }
              else{
                for(int i = 0; i < 3; ++i){
                  if(valores[i][2] != 0){
                    valores[i][0] *= -res[0];
                    valores[i][1] *= -res[1];
                    res[2] = (valores[i][3] + valores[i][0] + valores[i][1])/valores[i][2];
                    return res;
                  }
                }
              }
            }
            else{
              if(res[2] != 0){ // tenemos z
                for(int i = 0; i < 3; ++i){
                  if(valores[i][1] != 0){
                    valores[i][0] *= -res[0];
                    valores[i][2] *= -res[2];
                    res[1] = (valores[i][3] + valores[i][0] + valores[i][2])/valores[i][1];
                    return res;
                  }
                }
              }
              else{ // ni y ni z
                double[][] yzr= new double[2][3];
                int i;
                int tope;
                if(used == 0){
                  tope = 3;
                  for(i=1 ; i < tope; ++i){
                    for(int j = 1 ; j < tope ; ++j ){
                      yzr[i-1][j] = valores[i][j];
                      yzr[i-1][2] = valores[i][2] - (valores[i][0] * res[0]);
                    }
                  }
                  tmp = calc2x2(yzr);
                  res[1] = tmp[0];
                  res[2] = tmp[1];
                  return res;
                }else if(used == 1){
                  for(int j = 1 ; j < 3 ; ++j ){
                    yzr[0][j] = valores[0][j];
                    yzr[1][j] = valores[2][j];
                    yzr[0][2] = valores[0][2] -( valores[0][0] * res[0]);
                    yzr[1][2] = valores[1][2] -( valores[1][0] * res[0]);
                  }
                  tmp = calc2x2(yzr);
                  res[1] = tmp[0];
                  res[2] = tmp[1];
                  return res;
                }else{
                  tope = 2;
                  for(i=0 ; i < tope; ++i){
                    for(int j = 1 ; j < tope ; ++j ){
                      yzr[i][j] = valores[i][j];
                      yzr[i][2] = valores[i][2] - (valores[i][0] * res[0]);
                    }
                  }
                  tmp = calc2x2(yzr);
                  res[1] = tmp[0];
                  res[2] = tmp[1];
                  return res;
                }
              }
            }
          }
          else{
            if(res[1] != 0){ // tenemos y
              if(res[2] != 0){ // tenemos z

              }else{

              }
            }else{
              if(res[2] != 0){ // tenemos z

              }else{

              }
            }
          }*/
        }else{ // hay xs y ys
          System.out.println("Imposible resolverla");
          return res;
        }
      }else{ // no hay ys
        System.out.println("Imposible resolverla");
        return res;
      }
    }else{ // no hay xs
      System.out.println("Imposible resolverla");
      return res;
    }
    return res;
  }
  /**
  */
  public static double[] calc2x2(double[][] valores){
    double[] res = new double[2]; // x y
    double[] tmp = new double[3];
    tmp[0] = valores[0][0];
    tmp[1] = valores[0][1];
    tmp[2] = valores[0][2];
    if(Math.abs(valores[0][0]) != Math.abs(valores[1][0]) && valores[0][0] != 0 && valores[1][0] != 0){
      if(valores[0][0] > 0){ // valores[0][0]
        if(valores[1][0] > 0){ // valores[1][0]
          tmp[0] *= valores[1][0]; tmp[1] *= valores[1][0]; tmp[2]*= valores[1][0]; // (valores[0][0] + valores[0][1] = valores[0][2]) * valores[1][0]
          valores[1][0] *= -valores[0][0]; valores[1][1] *= -valores[0][0]; valores[1][2] *= -valores[0][0];     // (valores[1][0] + valores[1][1] = valores[1][2]) * -valores[0][0]
          valores[1][0] += tmp[0]; valores[1][1] += tmp[1];valores[1][2] += tmp[2];
          // (valores[1][0] + valores[0][0]) + (valores[1][1] + valores[0][1]) = valores[1][2] + valores[0][2]
          res[1] = valores[1][2]/valores[1][1];
        }else{ // -valores[1][0]
          tmp[0] *= valores[1][0]; tmp[1] *= valores[1][0]; tmp[2]*= valores[1][0]; // (valores[0][0] + valores[0][1] = valores[0][2]) * valores[1][0]
          valores[1][0] *= valores[0][0]; valores[1][1] *= valores[0][0]; valores[1][2] *= valores[0][0];     // (valores[1][0] + valores[1][1] = valores[1][2]) * valores[0][0]
          valores[1][0] += tmp[0]; valores[1][1] += tmp[1];valores[1][2] += tmp[2];
          // (valores[1][0] + valores[0][0]) + (valores[1][1] + valores[0][1]) = (valores[1][2] + valores[0][2])
          res[1] = valores[1][2]/valores[1][1];
        }
      }else{ // valores[0][0] < 0
        if(valores[1][0] > 0){
          tmp[0] *= valores[1][0]; tmp[1] *= valores[1][0]; tmp[2]*= valores[1][0]; // (valores[0][0] + valores[0][1] = valores[0][2]) * valores[1][0]
          valores[1][0] *= valores[0][0]; valores[1][1] *= valores[0][0]; valores[1][2] *= valores[0][0];     // (valores[1][0] + valores[1][1] = valores[1][2]) * -valores[0][0]
          valores[1][0] += tmp[0]; valores[1][1] += tmp[1];valores[1][2] += tmp[2];
          // (valores[1][0] + valores[0][0]) + (valores[1][1] + valores[0][1]) = valores[1][2] + valores[0][2]
          res[1] = valores[1][2]/valores[1][1];
        }else{ // valores[1][0] < 0
          tmp[0] *= valores[1][0]; tmp[1] *= valores[1][0]; tmp[2]*= valores[1][0]; // (valores[0][0] + valores[0][1] = valores[0][2]) * valores[1][0]
          valores[1][0] *= -valores[0][0]; valores[1][1] *= -valores[0][0]; valores[1][2] *= -valores[0][0];     // (valores[1][0] + valores[1][1] = valores[1][2]) * -valores[0][0]
          valores[1][0] += tmp[0]; valores[1][1] += tmp[1];valores[1][2] += tmp[2];
          // (valores[1][0] + valores[0][0]) + (valores[1][1] + valores[0][1]) = valores[1][2] + valores[0][2]
          res[1] = valores[1][2]/valores[1][1];
        }
      }
      res[0] = (((-res[1])*valores[0][1]) + valores[0][2])/valores[0][0];
    }else{ // o valores[0][0] == 0 o valores[1][0] == 0 + valores[0][0] == valores[1][0]
      if(valores[0][0] == 0){
        if(valores[0][1] == 0){
          if(valores[0][2] == 0){
            System.out.println("Sin solución");
            return res;
          }else{
            System.out.println("Sin solución");
            return res;
          }
        }else{ // valores[0][1] != 0
          if(valores[1][0] == 0){
            System.out.println("Sin solución");
            return res;
          }else
            res[1] = valores[0][2]/valores[0][1];
          res[0] = (((-res[1])*valores[1][1]) + valores[1][2])/valores[1][0];
          return res;
        }
      }
      if(valores[1][0] == 0){ // valores[0][0] != 0
        if(valores[1][1] == 0){
          System.out.println("Sin solución");
          return res;
        }else
          res[1] = valores[1][2]/valores[1][1];
        res[0] = (((-res[1])*valores[0][1]) + valores[0][2])/valores[0][0];
        return res;
      }
      if(valores[0][0] != valores[1][0]){ // + -
        valores[1][0] += tmp[0]; valores[1][1] += tmp[1];valores[1][2] += tmp[2];
        res[1] = valores[1][2]/valores[1][1];
      }
      else{ // mismo numero
        valores[1][0] -= tmp[0]; valores[1][1] -= tmp[1];valores[1][2] -= tmp[2];
        res[1] = valores[1][2]/valores[1][1];
      }
      res[0] = (((-res[1])*valores[0][1]) + valores[0][2])/valores[0][0];
    }
    return res;
  }
  /**
  * Metodo calc1x1G
  * recibe
  */
  public static double[] calc1x1G(double a, double b, double c){
    double[] res = new double[2]; // valores[0][0] x2
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
    Scanner scan = new Scanner(System.in);
    System.out.print("Ingresa el numero de variables: ");
    int op = scan.nextInt();
    double[][] arreglo2 = new double[2][3];
    switch(op){
      case 1:
      break;
      case 2:
        for(int i = 0; i < 2; ++i){
          for(int j = 0; j < 3; ++j){
            System.out.print("ingesa el valor ["+i+"]["+j+"]: ");
            arreglo2[i][j] = scan.nextDouble();
          }
        }
        double[] arreglo = calc2x2(arreglo2);
        System.out.println("valor x: "+arreglo[0]);
        System.out.println("valor y: "+arreglo[1]);
      break;
      case 3:
    }
    /*double[][] arreglo3 = new double[3][4];
    for(int i = 0; i < 3; ++i){
      for(int j = 0; j < 4; ++j){
        arreglo3[i][j] = scan.nextDouble();
      }
    }
    double[] arreglo = calc3x3(arreglo3);
    for (double i : arreglo) {
      System.out.print(" " + i);
    }
    */
  }
}
