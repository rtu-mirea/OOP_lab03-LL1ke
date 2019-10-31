package com.company;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private static Scanner in = new Scanner(System.in);
    private static int Budget;
    private int minSum;
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Project> project = new ArrayList<>();
    public void main(){
        boolean tmp = true;
        int n;

        // Происходит сортировка проектов
        project.sort(new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                if (o1.getPoint() < o2.getPoint())
                    return 1;
                else if (o1.getPoint() > o2.getPoint())
                    return -1;
                else
                    return 0;
            }
        });
        while(tmp){
            System.out.println("1.Запуск конкурса.\n2.Ввод бюджета конкурса.\n3.Просмотр участников.\n4.Выйти");
            n = in.nextInt();
            switch (n){
                case 1:
                    task(users);
                    break;
                case 2:
                    System.out.print("Введите бюджет конкурса: ");
                    Budget = in.nextInt();
                    System.out.print("Введите минималньую сумму которую могут получить участники: ");
                    minSum = in.nextInt();
                    break;
                case 3:
                    for (Project i: project){
                        System.out.println("Имя: " + i.getUser().getLogin() + " Баллы: "+ i.getPoint()
                                + " Название проекта: " + i.getName());
                    }
                    break;
                case 4:
                    tmp = false;
                    break;
            }

        }
    }

    // Метод запуска конкурса
    void task(ArrayList<User> users){
        if (Budget > 0) {
            int sum = 0;
            for(int i = 0; i < project.size(); ++i){
                sum += project.get(i).getPoint();
            }
            int moneyPerPoint = Budget / sum;
            for(int i = 0; i < project.size(); ++i){
                project.get(i).getUser().setPrice(project.get(i).getPoint() * moneyPerPoint);
            }

            System.out.println("\t Топ участников");
            for (int x = 0; x < project.size(); x++) {
                if (project.get(x).getUser().getPrice() >= minSum)
                    System.out.println((x+1) + ")" + " Логин: " + project.get(x).getUser().getLogin()
                            +" ; Название проекта: "+ project.get(x).getName()
                            + " ; Приз: " + project.get(x).getUser().getPrice());
            }
        }
        else
            System.out.println("Вы не ввели бюджет.");
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        Admin.users = users;
    }

    public static ArrayList<Project> getProject() {
        return project;
    }

    public static void setProject(ArrayList<Project> project) {
        Admin.project = project;
    }
}
