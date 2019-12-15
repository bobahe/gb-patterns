package ru.bobahe.service;

import ru.bobahe.api.TerminalService;

import java.io.InputStreamReader;
import java.util.Scanner;

public class TerminalServiceImpl implements TerminalService {

    private final Scanner scanner = new Scanner(new InputStreamReader(System.in));

    @Override
    public void println(final String text) {
        System.out.println(text);
    }

    @Override
    public void printerr(final String text) {
        System.err.println(text);
    }

    @Override
    public String getLine() {
        return scanner.nextLine();
    }

}
