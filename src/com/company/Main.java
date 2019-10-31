package com.company;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean tmp = true;
        int n;
        ArrayList<User> users = Admin.getUsers();
        User admin = new User();
        users.add(admin);
        while (tmp){
            System.out.println("1.Войти\n2.Зарегистрироваться\n3.Закрыть программу");
            try {
                n = Integer.parseInt(in.next());
                switch (n) {
                    case 1:
                        Auth(users);
                        break;
                    case 2:
                        Reg(users);
                        for (User i : users)
                            System.out.println(i.getLogin() + " " + i.getPassword());
                        break;
                    case 3:
                        tmp = false;
                        System.out.println("Работа завершена...");
                        break;
                }
            }
            catch (Exception e){}
        }
    }

    /// МЕТОДЫ АВТОРИЗАЦИИ И РЕГИСТРАЦИИ ///

    // Авторизация
    static void Auth(ArrayList<User> users){
        boolean n = false;
        int k;
        String log, pass;// login and password
        while (!n) {
            System.out.print("Login: ");
            log = in.next();
            System.out.print("Password: ");
            pass = in.next();
            // Admin account
            if (log.compareTo("admin") == 0 && pass.compareTo("admin") == 0) {
                Admin admin = new Admin();
                admin.main();
                n = true;
                break;
            }
            for (User i : users) {
                if (i.getLogin().compareTo(log) ==  0 && i.getPassword().compareTo(pass) == 0) {
                    UserSystem userSystem = new UserSystem();
                    userSystem.main(users,i);
                    n = true;
                    break;
                }
            }
            if (n == false) {
                k =0;
                while (k > 2 || k < 1) {
                    System.out.println("Логин или Пароль введены неверно\n 1.Повторить ввод данных\n2.Вернуться к окну авторизации");
                    k = in.nextInt();
                    switch (k) {
                        case 1:
                            break;
                        case 2:
                            n = true;
                            break;
                    }
                }
            }
        }
    }

    // Регистрация
    static void Reg(ArrayList<User> users){
        String log = "", pass = "",name = "";
        boolean n = true;
        System.out.println("Введите данные для регистрации аккаунта.");
        while (n) {
            System.out.print("Name: ");
            name = in.next();
            System.out.print("Login: ");
            log = in.next();
            System.out.print("Password: ");
            pass = in.next();
            for (User i : users) {
                if (i.getLogin().compareTo(log) == 0) {
                    System.out.println("Введенный логин занят!");
                    n = true;
                    break;
                }
                n =false;
            }
        }
        User user = new User(name,log,pass);
        users.add(user);
        Admin.setUsers(users);
    }
}
