public interface Check {
    void checkLogin(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException;
}
