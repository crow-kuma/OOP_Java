package first;

public class StringTwist {
  public static void main(String[] args) {
    String funnyStr = "Computer!Science,!long!walks!on!the!beach";
    funnyStr = funnyStr.replace("!", " ");
    funnyStr = funnyStr.replace("the beach", "");
    funnyStr = funnyStr.replace(", long", "");
    funnyStr = funnyStr.replace("wal", "roc");
    funnyStr = funnyStr.toUpperCase();
    System.out.println(funnyStr);
  }
}