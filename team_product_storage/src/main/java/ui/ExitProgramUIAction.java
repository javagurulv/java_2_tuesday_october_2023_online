package ui;

import java.util.Scanner;

public class ExitProgramUIAction implements UIAction{

    @Override
    public void execute() {
        System.out.println("Exit!");
        System.exit(0);
    }
}
