package p0070;

import java.util.Locale;

public class Controller {
    Validation Vad = new Validation();
    
    public void login(Locale locale){
        EBank e = new EBank();
        e.setLocale(locale);
        System.out.print(e.getMessage("account"));
        String account = Vad.input();
        while (e.checkAccount(account) != null) {
            System.err.println(e.getMessage("accountError"));
            System.out.print(e.getMessage("account"));
            account = Vad.input();
        }
        

        System.out.print(e.getMessage("password"));
        String password = Vad.input();
        while (e.checkPassword(password) != null) {
            System.err.println(e.getMessage("passwordError"));
            System.out.print(e.getMessage("password"));
            password = Vad.input();
        }
        String captcha = e.generateCaptcha();
        System.out.println(e.getMessage("captcha") + captcha);
        System.out.print(e.getMessage("captchaInput"));
        String captchaInput = Vad.input().trim();
        while (e.checkCaptcha(captcha, captchaInput) != null) {
            System.err.println(e.getMessage("captchaError"));
            System.out.print(e.getMessage("captchaInput"));
            captchaInput = Vad.input().trim();
        }
        System.out.println(e.getMessage("loginSuccess"));
    }
}
