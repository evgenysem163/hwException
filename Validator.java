import org.w3c.dom.html.HTMLTableRowElement;

public class Validator {
    private Validator() {
    }

    public static boolean validate(String login, String password, String confirnPassword) {
        try {
            check(login, password, confirnPassword);
            return true;
        } catch (WrongloginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void check(String login, String password, String confirnPassword)
            throws WrongloginException, WrongPasswordException {

        if (login.length() > 20) {
            throw new WrongloginException("Длина логина должна быть меньше или равна 20!");
        }
        if (password.length() >= 20) {
            throw new WrongPasswordException("Длина пароля должна быть меньше 20 !");
        }
        if (!password.equals(confirnPassword)) {
            throw new WrongPasswordException("Пароли должны быть одинаковы");

        }
        Checker checker = new CheckerLoop();
        if(!checker.check(login)){
            throw new WrongloginException("Логин содержит не корректные символы");
        }
        if(!checker.check(password)){
            throw new WrongPasswordException("Пароль содержит не корректные символы");
        }
    }
}



