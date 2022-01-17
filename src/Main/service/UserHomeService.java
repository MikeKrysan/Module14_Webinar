package Main.service;

import Main.model.User;
import Main.model.Home;

import java.util.TreeMap;

public class UserHomeService {
    public TreeMap<User, Home> data = new TreeMap<>();
    {   //если мы создадим пользователя через new,тогда то, что мы изменяем в main, не перейдет в UserHomeService, а это не есть хорошо, особенно работая с базами данных
        UserService userService = UserService.getInstance();    //создали возможность генерировать автоматом новых пользователей
        for (User user : userService.getData()) {
                data.put(user, new Home(user.getName() + " street"));
        }
    }
}

