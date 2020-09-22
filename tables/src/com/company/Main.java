package com.company;
import java.util.Scanner;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import static java.lang.System.out;

public class Main {

    public static void tableInit(String[][] table) {
        Scanner scan = new Scanner(System.in);
        String text;

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 4; j++){
                if (j == 1){
                    table[j][i] = "|";
                }
                else {
                    text = scan.nextLine();
                    table[j][i] = "| " + text;
                }
            }
        }
    }
    public static String tableAlignment(String[][] table){
        int maxLengthString;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 3; i++){
            maxLengthString = 0;
            for (int j = 0; j < 4; j++) {
                if (maxLengthString < table[j][i].length()) {
                    maxLengthString = table[j][i].length();
                }
            }
            for (int z = 0; z < 4; z++) {
                if (z == 1){
                    table[z][i] += new String(new char[maxLengthString - table[z][i].length()]).replace("\0", "-");
                }
                else if (table[z][i].length() - maxLengthString != 0) {
                    table[z][i] += new String(new char[maxLengthString - table[z][i].length()]).replace("\0", " ");
                }
            }
        }

        for (int i = 0; i < 4; i++){
            table[i][2] += " |";
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++){
                s.append(table[i][j]);
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {

	String s;
	int rows;
    int columns;
    Scanner scan = new Scanner(System.in);

    out.println("How many rows: ");
    rows = scan.nextInt();
    out.println("How many columns: ");
    columns = scan.nextInt();
    String [][] table = new String[rows][columns];

    tableInit(table);
    s = tableAlignment(table);
    out.println(s);

    StringSelection stringSelection = new StringSelection(s);
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(stringSelection, null);

    }
}
