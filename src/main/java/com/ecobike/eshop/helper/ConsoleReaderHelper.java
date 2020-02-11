package com.ecobike.eshop.helper;

import java.util.Scanner;

public class ConsoleReaderHelper {

    private Scanner scanner;

    public ConsoleReaderHelper() {
        scanner = new Scanner(System.in);
    }

    public String readString(String name) {
        System.out.print(name + ": ");
        return readString();
    }

    private String readString() {
        return scanner.next();
    }

    public int readInt(String name) {
        try {
            return Integer.parseInt(readString(name));
        } catch (NumberFormatException ex) {
            System.err.println("please give the correct number");
            return readInt(name);
        }
    }

    public Boolean readBoolean(String name) {
        String input = readString(name);
        if (input.equals("yes")) {
            return Boolean.TRUE;
        } else if (input.equals("no")) {
            return Boolean.FALSE;
        } else {
            System.err.println("please type 'yes' or 'no'");
            return readBoolean(name);
        }
    }

    public Integer readInt() {
        try {
            return Integer.parseInt(readString());
        } catch (NumberFormatException ex) {
            System.err.println("please give the correct number");
            return readInt();
        }
    }
}
