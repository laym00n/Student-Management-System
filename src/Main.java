import service.StudentManager;
import ui.UserInterface;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // create instances of Scanner and StudentManager
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        // create an instance of UserInterface
        UserInterface ui = new UserInterface(scanner, manager);
        ui.run();
    }
}