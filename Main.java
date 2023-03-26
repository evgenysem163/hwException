public class Main {
    public static void main(String[] args) {
        boolean result = Validator.validate("login", "123", "123");
        if (result) {
            System.out.println("Логин и пароль корректны");
        } else {
            System.out.println("Логин или пароль не корректные ");
        }
    }
}