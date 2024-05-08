public class CheckImpl implements Check {

    @Override
    public void checkLogin(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        checkLength(login, true);
        checkLength(password, false);
        verificationOfSymbols(login, true);
        verificationOfSymbols(password, false);
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают!");
        }
    }

    private void verificationOfSymbols(String a, boolean login) throws WrongLoginException, WrongPasswordException {
        if (a == null) {
            throwException(login, "Пароль не введен!");
        }
        char[] chars = a.toCharArray();
        String acceptebaleCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";
        for (char aChar : chars) {
            if (acceptebaleCharacters.contains(Character.toString(aChar))) {
                continue;
            }
            throwException(login, "Использованы недопустимые символы!");
        }
    }

    private void checkLength(String a, boolean login) throws WrongLoginException, WrongPasswordException {
        if (a != null && a.length() <= 20) {
            return;
        }
        throwException(login, "Пароль слишком длинный!");
    }

    private void throwException(boolean login, String message) throws WrongLoginException, WrongPasswordException {
        if (login) {
            throw new WrongLoginException(message);
        } else {
            throw new WrongPasswordException(message);
        }
    }
}

