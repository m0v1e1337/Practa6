package org.example;

import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Application started");

        Scanner scanner = new Scanner(System.in);

        try {
            // Ваш код
            String[] firms = {"Nike", "Adidas", "Puma"};
            String[][] trainers = {{"Nike - Brand 1", "Nike - Brand 2"},
                    {"Adidas - Brand 1", "Adidas - Brand 2"}, {"Puma - Brand 1", "Puma - Brand 2"}
            };
            ArrayList<Customer> customers = new ArrayList<>();

            for (int i = 0; i < 3; i++) {
                System.out.println("Введите свои данные:");
                System.out.print("ФИО: ");
                String fullName = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Номер телефона: ");
                String phoneNumber = scanner.nextLine();
                System.out.println("Список доступных позиций в магазине:");
                for (int j = 0; j < firms.length; j++) {
                    for (int k = 0; k < trainers[j].length; k++) {
                        System.out.println((j + 1) + "." + (k + 1) + " - " + trainers[j][k]);
                    }
                }
                System.out.print("Выберите позицию (фирму и бренд): ");
                int firmIndex = scanner.nextInt() - 1;
                int brandIndex = scanner.nextInt() - 1;
                scanner.nextLine();
                System.out.print("Введите количество: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                Order order = new Order(trainers[firmIndex][brandIndex], quantity);
                Customer customer = new Customer(fullName, email, phoneNumber, order);
                customers.add(customer);
            }

            System.out.println("Информация о клиентах и заказах:");
            for (Customer customer : customers) {
                System.out.println("ФИО: " + customer.getFullName());
                System.out.println("Email: " + customer.getEmail());
                System.out.println("Номер телефона: " + customer.getPhoneNumber());
                System.out.println("Заказ: " + customer.getOrder().getPosition() + ", Количество: " + customer.getOrder().getQuantity());
                System.out.println("---------------");
            }
        } catch (Exception e) {
            logger.error("Error occurred", e);
        }

        logger.info("Application finished");
    }
}


class Customer {
    private final String fullName;
    private final String email;
    private final String phoneNumber;
    private final Order order;

    public Customer(String fullName, String email, String phoneNumber, Order order) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.order = order;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Order getOrder() {
        return order;
    }
}

class Order {
    private final String position;
    private final int quantity;

    public Order(String position, int quantity) {
        this.position = position;
        this.quantity = quantity;
    }

    public String getPosition() {
        return position;
    }

    public int getQuantity() {
        return quantity;
    }
}