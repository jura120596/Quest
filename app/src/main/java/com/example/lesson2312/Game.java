package com.example.lesson2312;

import java.util.Scanner;

public class Game {
    public static Character manager;
    public static Story story;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Вы прошли собеседование и вот-вот станете сотрудником Корпорации. \\n \"\n" +
                "                + \"Осталось уладить формальности - подпись под договором (Введите ваше имя):");
        manager = new Character(in.next());
        story = new Story();
        while (true) {
            manager.actives += story.currentSituation.dActives;
            manager.career += story.currentSituation.dCareer;
            manager.rating += story.currentSituation.dRating;
            System.out.println("=====\nКарьера:" + manager.career + "\tАктивы:"
                    + manager.actives + "\tРепутация:" + manager.rating + "\n=====");
            System.out.println("============="
                    + story.currentSituation.subject + "==============");
            System.out.println(story.currentSituation.text);
            if (story.isEnd()) {
                System.out
                        .println("====================the end!===================");
                return;
            }
            try {
                story.go(in.nextInt());
            } catch (IncorrectAnswerException e) {
            }
        }
    }
}