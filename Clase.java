/*class Prueba{
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder("Hola ");
    sb.append("mundo!");
    System.out.println(sb);
    String aText = "15";
    Integer b = 5; // autoboxing
    Integer a = new Integer(aText); // boxing
    String num = "4.5";
    Float f = new Float(num);
    Float z = f + (float) a;
    System.out.println("valor del objeto z: " + z.toString());
    System.out.println("valor del objeto b: " + b); // toString implicito
  }
}
        /
import java.util.ArrayList;
class ListaArray{
  public static void main(String[] args) {
    ArrayList<Float> al = new ArrayList<Float>();
    for (String x : args) {
      al.add(Float.parseFloat(x));
    }
    for ( Float f : al ) {
      System.out.println(f);
    }
  }
}
*/
import java.util.Hashtable;
class TablaHash{
  public static void main(String[] args) {
    Hashtable< String , Object > ht = new Hashtable< String , Object >();
    Integer i = 123;
    Float f = 43.26f;
    Character c = 'x';
    ht.put("Entero",i);
    ht.put("Flotante",f);
    ht.put("Caracter",c);
    System.out.println(ht.get("Entero"));
    System.out.println(ht.get("Flotante"));
    System.out.println(ht.get("Caracter"));
    System.out.println((ht.get(c) intanceof Character) ? "Soy un caracter":"Soy algo diferente");
  }
}
