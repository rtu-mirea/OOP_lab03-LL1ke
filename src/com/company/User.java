package com.company;
import java.util.Scanner;

public class User {
    private String name;
    private String login;
    private String password;
    private int price;
    private boolean check = false;
    private Scanner in = new Scanner(System.in);
    public User(){
        name = "Tester";
        login = "login";
        password = "password";
    }

    public User(String nam,String log,String pas){
        name = nam;
        login = log;
        password = pas;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getCheck() { return check; }

    public void setCheck(boolean check){
        this.check = check;
    }

}
