package first;

public class StringOperations {
  public static void main(String[] args) {
    String name = "Natsuki";
    char[] nameArray = name.toCharArray();

    nameArray[0] = 'A';
    nameArray[name.length() - 1] = 'Z';

    String newName = new String(nameArray);
    System.out.println(newName);

    String url = "www.google.com";
    System.out.println(url);

    String urlName = url.substring(4, url.length() - 4) + "1331";
    System.out.println(urlName);
  }
}
