package kata5p2;

import java.io.File;

public class Kata5P2 {

    public static void main(String[] args) {
        Iterable<String> items = new MailLoader(new FileLoader(new File("email.txt"))).items();
        for (String mail : items) System.out.println(mail);
    }
    
}
