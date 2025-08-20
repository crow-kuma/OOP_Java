package third.HW06;

public class InvalidPetException extends Exception {
  private static final String INVALID_PET_MESSAGE = "Your pet is invalid!";

  public InvalidPetException() {
    super(INVALID_PET_MESSAGE);
  }

  public InvalidPetException(String s) {
    super(s);
  }
}
