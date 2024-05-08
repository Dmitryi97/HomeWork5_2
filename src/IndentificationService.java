public class IndentificationService {
    private static final Check CHECK = new CheckImpl();

    public static void determine(String login,
                                 String password,
                                 String confirmPassword) {
        try {
            CHECK.checkLogin(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException a) {
            System.out.println(a.getClass() + a.getMessage());
        }
    }
}
