package Main;

import Main.service.UserService;
import Main.util.Validator;

import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void main(String[] args) {
        //UserService service = new UserService();
        UserService service = UserService.getInstance();    //органичили возможность создания объекта UserService через new в классе Main

        Validator adultValidator = user -> Validator.isAdult(user.getBirthday()); //минус лямбда-функции в том, что мы не можем воспользоватся дефолтными методами интерфейса, но это можно исправить благодаря статическим методам, которые принадлежат всему классу(или интерфейсу), а не только его объектам

        Validator youngValidator = user -> {
            return !Validator.isAdult(user.getBirthday());    // Переопределяем функциональный интерфейс(с одним нереализованным методом) проверяем возраст пользвователя на совершеннолетие
        };
//        System.out.println(Main.service.getValidUsers(adultValidator));
//        System.out.println("===========");
//        System.out.println(Main.service.getValidUsers(youngValidator));

//        service.getUserById(2)
//                .ifPresentOrElse(
//                        System.out::println,    //method references ((user) -> System.out.println(user)) - компилятор сам понимает что передается и ожидает на вывод
//                        () -> System.out.println("Nu such user"));

//        System.out.println(service.getValidUsers(adultValidator));
//        System.out.println(service.getValidUsers(youngValidator));

//        System.out.println(service.getSortedUsers(
//                (user1, user2) -> -Period.between(user1.getBirthday(), user2.getBirthday()).getYears() ));

        System.out.println(
                service.getReducedUser(
                        (user1, user2) -> {
                           return Period.between(user1.getBirthday(),
                                   user2.getBirthday()).getYears() > 0 ? user2 : user1;
                }));
    }
}

/*
Область видимости у лямбд отлична от абстрактных классов. У лямб есть доступ к статическим методам интерфейса, но нет доступа к дефолтным методам
 */
