package com.workintech.arraylist.grocerylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GroceryListApp {
    private static ArrayList<String> groceryList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("0: Çıkış");
            System.out.println("1: Eleman ekle");
            System.out.println("2: Eleman çıkar");
            System.out.println("3: Liste elemanlarını görüntüle");
            System.out.print("Seçiminizi yapınız: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Buffer temizleme

            switch (choice) {
                case 0:
                    System.out.println("Uygulama sonlandırılıyor...");
                    break;
                case 1:
                    System.out.print("Eklenmesini istediğiniz elemanları giriniz: ");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    break;
                case 2:
                    System.out.print("Çıkarılmasını istediğiniz elemanları giriniz: ");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    break;
                case 3:
                    printSorted();
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        } while (choice != 0);

        scanner.close();
    }

    public static void addItems(String items) {
        String[] itemsArray = items.split(",");
        for (String item : itemsArray) {
            String trimmedItem = item.trim();
            if (!trimmedItem.isEmpty() && !checkItemIsInList(trimmedItem)) {
                groceryList.add(trimmedItem);
            }
        }
        Collections.sort(groceryList);
        printSorted();
    }

    public static void removeItems(String items) {
        String[] itemsArray = items.split(",");
        for (String item : itemsArray) {
            String trimmedItem = item.trim();
            if (!trimmedItem.isEmpty() && checkItemIsInList(trimmedItem)) {
                groceryList.remove(trimmedItem);
            }
        }
        Collections.sort(groceryList);
        printSorted();
    }

    public static boolean checkItemIsInList(String item) {
        return groceryList.contains(item);
    }

    public static void printSorted() {
        System.out.println("Alışveriş Listesi:");
        for (String item : groceryList) {
            System.out.println("- " + item);
        }
    }
}
