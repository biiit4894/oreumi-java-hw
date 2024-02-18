package addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    private static List<Contact> contactList = new ArrayList<>();

    public void start() {
        try(Scanner sc = new Scanner(System.in)) {
            while(true) {
                System.out.println("---------------------");
                System.out.println("1. 비즈니스 연락처 추가");
                System.out.println("2. 개인 연락처 추가");
                System.out.println("3. 연락처 출력");
                System.out.println("4. 연락처 검색");
                System.out.println("5. 종료");
                System.out.println("---------------------");
                System.out.print("메뉴를 선택해주세요: ");
                String menu = sc.next();
                switch(menu) {
                    case("1"):
                        createBusinessContact(sc);
                        break;
                    case("2"):
                        createPersonalContact(sc);
                        break;
                    case("3"):
                        displayContacts();
                        break;
                    case("4"):
                        searchContacts(sc);
                        break;
                    case("5"):
                        System.out.println("프로그램을 종료합니다.");
                        System.exit(0);
                    default:
                        System.out.println("잘못된 메뉴를 입력하셨습니다.");
                }
            }
        }
    }

    public static void createBusinessContact(Scanner sc) {
        System.out.print("이름을 입력하세요: ");
        String name = sc.next();
        System.out.print("전화번호를 입력하세요: ");
        String phoneNumber = sc.next();
        System.out.print("회사명을 입력하세요: ");
        String company = sc.next();
        BusinessContact contact = new BusinessContact(name, phoneNumber, company);
        addContact(contact);
    }

    public static void createPersonalContact(Scanner sc) {
        System.out.print("이름을 입력하세요: ");
        String name = sc.next();
        System.out.print("전화번호를 입력하세요: ");
        String phoneNumber = sc.next();
        System.out.print("관계를 입력하세요: ");
        String relationship = sc.next();
        PersonalContact contact = new PersonalContact(name, phoneNumber, relationship);
        addContact(contact);
    }
    public static void addContact(Contact contact) {
        contactList.add(contact);
    }

    public void printContact(Contact contact) {
        String name = contact.getName();
        String phoneNumber = contact.getPhoneNumber();
        if(contact instanceof PersonalContact) {
            PersonalContact personalContact = (PersonalContact) contact;
            String relationship = personalContact.getRelationship();
            System.out.println("이름: " + name + ", 전화번호: " + phoneNumber + ", 관계: " + relationship);
        } else if(contact instanceof BusinessContact) {
            BusinessContact businessContact = (BusinessContact) contact;
            String company = businessContact.getCompany();
            System.out.println("이름: " + name + ", 전화번호: " + phoneNumber + ", 회사명: " + company);
        }
    }

    public void displayContacts() {
        if(contactList.isEmpty()) {
            System.out.println("연락처가 비어있습니다.");
        } else {
            for(Contact contact : contactList) {
                printContact(contact);
            }
        }
    }

    public void searchContacts(Scanner sc) {
        System.out.print("검색할 이름을 입력하세요: ");
        String searchName = sc.next();
        boolean isFound = false;

        for(Contact contact:contactList) {
            if(contact.getName().equals(searchName)) {
                isFound = true;
                printContact(contact);
            }
        }
        if(!isFound) {
            System.out.println("연락처를 찾을 수 없습니다.");
        }
    }

}
