package com.example.lesson2312;

public class Story {
    private Situation startStory;
    public Situation currentSituation;
    Story() {
        startStory = new Situation(
                "первая сделка (Windows)",
                "Только вы начали работать и тут же удача! Вы нашли клиента и продаете ему "
                        + "партию ПО MS Windows. Ему в принципе достаточно взять 100 коробок версии HOME.\n"
                        + "(1)у клиента денег много, а у меня нет - вы выпишете ему счет на 120 коробок ULTIMATE по 50тр\n"
                        + "(2)чуть дороже сделаем, кто там заметит - вы выпишете ему счет на 100 коробок PRO по 10тр\n"
                        + "(3)как надо так и сделаем - вы выпишете ему счет на 100 коробок HOME по 5тр ",
                3, 0, 0, 0);
        startStory.direction[0] = new Situation(
                "корпоратив",
                "Неудачное начало, ну что ж, сегодня в конторе корпоратив! "
                        + "Познакомлюсь с коллегами, людей так сказать посмотрю, себя покажу",
                0, 0, -10, -10);
        startStory.direction[1] = new Situation(
                "совещание, босс доволен",
                "Сегодня будет совещание, меня неожиданно вызвали,"
                        + "есть сведения что \n босс доволен сегодняшней сделкой.\n" +
                        "1 - чтобы перейти к совещанию\n" +
                        "2 - чтобы пропустить совещание",
                2, 1, 100, 0);
        startStory.direction[1].direction[0] = new Situation(
                "Восхищение босса",
                "Как ты это провернул? Ты большой молодец!",
                0, 1, 0, 0);
        startStory.direction[1].direction[1] = new Situation(
                "Колега передал, что было на совещании",
                "Ты многое пропустил. Босс тебя похвалил.",
                0, 1, 0, 0);

        startStory.direction[2] = new Situation(
                "мой первый лояльный клиент",
                "Мой первый клиент доволен скоростью и качеством "
                        + "моей работы. Сейчас мне звонил лично \nдиректор компании,  сообщил что скоро состоится еще более крупная сделка"
                        + " и он хотел, чтобы по ней работал именно я!",
                0, 0, 50, 1);
        currentSituation = startStory;
    }

    public void go(int num) throws IncorrectAnswerException {
        if (num <= currentSituation.direction.length) {
            currentSituation = currentSituation.direction[num - 1];
        } else {
            System.out.println("Вы можете выбирать из "
                    + currentSituation.direction.length + " вариантов");
            throw new IncorrectAnswerException();
        }
    }

    public boolean isEnd() {
        return currentSituation.direction.length == 0;
    }
}
