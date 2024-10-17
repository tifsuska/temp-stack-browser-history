package com.github.affandes.kuliah.pm;

import java.util.Scanner;
import java.util.Stack;

class BrowserHistory {
    private Stack<String> history = new Stack<>();

    public void view() {
        if (history.isEmpty()) {
            System.out.println("History browser kosong.");
        } else {
            System.out.println("History browser (dari yang paling baru):");
            Stack<String> tempStack = (Stack<String>) history.clone();
            while (!tempStack.isEmpty()) {
                System.out.println("- " + tempStack.pop());
            }
        }
    }

    public void browse(String website) {
        history.push(website);
        System.out.println("Mengunjungi: " + website);
    }

    public void back() {
        if (history.isEmpty()) {
            System.out.println("Tidak ada website yang bisa kembali.");
        } else {
            String lastVisited = history.pop();
            System.out.println("Kembali dari: " + lastVisited);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BrowserHistory browserHistory = new BrowserHistory();
        boolean running = true;

        System.out.println("Menu Browser:");
        System.out.println("1. Lihat History");
        System.out.println("2. Kunjungi Website Baru");
        System.out.println("3. Kembali ke Website Sebelumnya");
        System.out.println("4. Keluar");

        while (running) {
            System.out.print("\nPilih opsi: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    browserHistory.view();
                    break;
                case 2:
                    boolean browsing = true;
                    while (browsing) {
                        System.out.print("Masukkan URL website (ketik 'kembali' untuk kembali ke menu utama): ");
                        String website = input.nextLine();
                        if (website.equalsIgnoreCase("kembali")) {
                            browsing = false;
                        } else {
                            browserHistory.browse(website);
                        }
                    }
                    break;
                case 3:
                    browserHistory.back();
                    break;
                case 4:
                    running = false;
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }

        input.close();
    }
}
