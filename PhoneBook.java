package lessons;

import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook {

    private List<Contact> contacts = new ArrayList<>();

    // Добавление контакта
    public void addContact(Contact c) {
        contacts.add(c);
    }

    // Показ всех контактов
    public void showContacts() {
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    // Поиск по полному имени
//    public Contact findContactByName(String name) {
//        for (Contact c : contacts) {
//            if (c.name.equals(name)) {
//                return c;
//            }
//        }
//        return null;
//    }

    // Удаление контакта по имени
    public boolean removeContact(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                contacts.remove(i);
                return true;
            }
        }
        return false;
    }

    // Обновление номера телефона
    public boolean updatePhoneNumber(String name, String newPhone) {
        for (Contact c : contacts) {
            if (c.getName().equals(name)) {
                c.setPhoneNumber(newPhone);
                return true;
            }
        }
        return false;
    }

    // Поиск по части имени
    public List<Contact> searchByNamePart(String part) {
        List<Contact> filtred = contacts.stream()
                .filter(s -> s.getName().startsWith(part))
                .collect(Collectors.toList());

        return filtred;
    }
    public void sortBy(Comparator<Contact>) {
                contacts.sort(contacts);
            }
}

