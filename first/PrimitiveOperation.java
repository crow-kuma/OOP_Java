package first;

public class PrimitiveOperation {
  public static void main(String[] args) {
    int i = 5;
    float f = 12.34f;

    System.out.println(i);
    System.out.println(f);

    float multiply = i * f;
    System.out.println(multiply);

    float floatInt = (float) i;
    System.out.println(floatInt);

    int intFloat = (int) f;
    System.out.println(intFloat);

    char c = 'A';
    System.out.println(c);

    System.out.println((char) (c + 32));

  }
}
