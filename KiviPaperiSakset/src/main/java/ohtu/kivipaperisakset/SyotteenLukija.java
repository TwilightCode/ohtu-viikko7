package ohtu.kivipaperisakset;

import java.util.Scanner;

public class SyotteenLukija implements IO {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String lueSyote() {
        return scanner.nextLine();
    }
}
