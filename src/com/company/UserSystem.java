package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserSystem {
    private static Scanner in = new Scanner(System.in);

    public void main(ArrayList<User> users, User user){
        boolean tmp = true;
        int n;
        while(tmp){
            System.out.println("1.Оставить заявку.\n2.Изменить личную информацию.\n3.Просмотр списков участников.\n4.Выйти из профиля.");
            n = in.nextInt();
            switch (n){
                case 1:
                    Proj(user);
                    break;
                case 2:
                    ChangProf(user);
                    break;
                case 3:
                    ArrayList<Project> projects =Admin.getProject();
                    projects.sort(new Comparator<Project>() {
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
                    for (Project i: projects){
                        if(i.getUser().getLogin() == user.getLogin()){
                            System.out.println("Вы: Имя: " + i.getUser().getLogin() + " Баллы: " + i.getPoint());
                        }
                        else
                            System.out.println("Имя: " + i.getUser().getLogin() + " Баллы: " + i.getPoint());
                    }
                    break;
                case 4:
                    tmp = false;
                    break;
            }
        }
    }
    void Proj(User user){
        int n;
        String temp;
        Project project = new Project();
        ArrayList<Project> projects = Admin.getProject();
        if(user.getCheck() == false) {
            try {
                System.out.println("Введите название вашего проекта.");
                project.setName(in.next());
                System.out.print("Введите колличество баллов, выставленное вам жюри: ");
                temp = in.next();
                project.setPoint(Integer.parseInt(temp));
                System.out.println("Заявка оставлена.");
                user.setCheck(true);
                project.setUser(user);
                projects.add(project);
                Admin.setProject(projects);
            } catch (Exception e) {
                System.out.println("Баллы нужно вводить числом!");
                Proj(user);
            }
        }
        else
            System.out.println("Вы уже оставляли заявку.");
    }
    void ChangProf(User user){
        boolean tmp = true;
        int n;
        String k;
        while (tmp){
            System.out.println("Ваши текущие данные: Имя - " + user.getName() + " Логин - "
                    + user.getLogin() + " Пароль - " + user.getPassword());
            System.out.println("1.Изменить имя.\n2.Изменить логин.\n3.Изменить пароль.\n4.Сохранить изменения.");
            n = in.nextInt();
            switch (n){
                case 1:
                    System.out.println("Введите новое имя: ");
                    k = in.next();
                    user.setName(k);
                    break;
                case 2:
                    System.out.println("Введите новый логин: ");
                    k = in.next();
                    user.setLogin(k);
                    break;
                case 3:
                    System.out.println("Введите новый пароль: ");
                    k = in.next();
                    user.setPassword(k);
                    break;
                case 4:
                    tmp = false;
                    break;
            }
        }
    }


}

