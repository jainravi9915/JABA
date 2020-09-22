package com.company;
import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int maxLenghtString = 0;
	String s = new String("");
    String [][] table = new String[4][3];
	String text = new String();

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

    for (int i = 0; i < 3; i++){
        maxLenghtString = 0;
        for (int j = 0; j < 4; j++) {
            if (maxLenghtString < table[j][i].length()) {
                maxLenghtString = table[j][i].length();
            }
        }
        for (int z = 0; z < 4; z++) {
            if (z == 1){
                table[z][i] += new String(new char[maxLenghtString - table[z][i].length()]).replace("\0", "-");
            }
            else if (table[z][i].length() - maxLenghtString != 0) {
                table[z][i] += new String(new char[maxLenghtString - table[z][i].length()]).replace("\0", " ");
            }
        }
    }

    for (int i = 0; i < 4; i++){
            table[i][2] += " |";
    }

    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 3; j++){
            s += table[i][j];
        }
        s += "\n";
    }
    out.print(s);
    StringSelection stringSelection = new StringSelection(s);
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(stringSelection, null);

    }
}
