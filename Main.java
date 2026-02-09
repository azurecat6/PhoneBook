package lessons;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PhoneBook book = new PhoneBook();

        Scanner sc = new Scanner(System.in);
        
        Contact c1 = new Contact("Alice", "999");
        Contact c2 = new Contact("Sasha", "888");
        Contact c3 = new Contact("Alina", "777");

        book.addContact(c1);
        book.addContact(c2);
        book.addContact(c3);


        while (true) {
            System.out.println("\n1. Добавить контакт\n" +
                    "2. Показать контакты\n" +
                    "3. Поиск по имени\n" +
                    "4. Обновить номер\n" +
                    "5. Удалить контакт\n" +
                    "6. Сортировка\n" +
                    "0. Выход");
            switch (sc.nextInt()) {
                case 1 -> {
                    sc.nextLine();
                    System.out.println("Введите имя :");
                    String namec = sc.nextLine();
                    System.out.println("Введите номер :");
                    String phonep = sc.nextLine();
                    Contact a1 = new Contact(namec, phonep);
                    book.addContact(a1);
                }
                case 2 -> {
                    book.showContacts();
                }
                case 3 -> {
                    sc.nextLine();
                    System.out.println("Введите имя или часть имени :");
                    book.searchByNamePart(sc.nextLine());
                }
                case 4 -> {
                    sc.nextLine();
                    System.out.println("Введите имя контакта, чей номер хотите обновить :");
                    String namesearch = sc.nextLine();
                    System.out.println("Введите новый номер");
                    String newPhone = sc.nextLine();
                    if(book.updatePhoneNumber(namesearch, newPhone)){
                        System.out.println("Номер обновлен");
                    } else {
                        System.out.println("Контакт не найден");
                    }
                }
                case 5 -> {
                    sc.nextLine();
                    System.out.println("Введите имя контакта :");
                    String namesearch = sc.nextLine();
                    if(book.removeContact(namesearch)) {
                        System.out.println("Номер удален");
                    } else {
                        System.out.println("Контакт не найден");
                    }
                }
               case 6 -> {
                    sc.nextLine();
                    System.out.println("Как произвести сортировку?");
                    System.out.println("\n1. По имени\n2. По номеру");
                    int choice = sc.nextInt();

                    if (choice == 1) {
                        book.sortBy((a, b) -> a.getName().compareTo(b.getName()));
                    } else if (choice == 2) {
                        book.sortBy((a, b) -> a.getPhoneNumber().compareTo(b.getPhoneNumber()));
                    } else {
                        System.out.println("Неверный выбор.");
                    }

                    System.out.println("Отсортированные контакты:");
                    book.showContacts();
                }

            }
        }
    }

}

