package Main.util;

import Main.model.User;

import java.time.LocalDate;
import java.time.Period;

@FunctionalInterface    //аннотацию можно не указывать
public interface Validator {    //функциональный интерфейс содержить только один нереализованный метод, а также наличие дополнительных реализованных методов (default)
    boolean validate(User user);

    //является ли наш пользователь совершеннолетним
    static boolean isAdult(LocalDate birthday) {   //дефолтный метод р
        return Period.between(birthday, LocalDate.now()).getYears() >= 18;
    }
}
