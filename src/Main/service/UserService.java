package Main.service;

import Main.model.User;
import Main.util.Validator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserService {
    private static UserService userService;
     private List<User> data = new ArrayList<>();

    {
        data.add(new User("Egor", "Ivanov", LocalDate.now().minusYears(20)));
        data.add(new User("Ivan", "Ivanov", LocalDate.now().minusYears(10)));
        data.add(new User("Egor", "Olegov", LocalDate.now().minusYears(40)));
        data.add(new User("Oleg", "Ivanov", LocalDate.now().minusYears(12)));
        data.add(new User("Sergey", "Ivanov", LocalDate.now().minusYears(25)));
    }

//    private UserService(List<User> data) {
//        this.data = data;
//    }

    public static UserService getInstance() {
        if(userService == null) //воспользуемся паттерном - Singleton. У нас будет статический метод, который создает объект UserHomeService если он не был создан, и возвращает его же в той ситуации, когда он был уже ранее создан
            userService = new UserService();

        return userService;
    }

    //создадим метод, который будет возвращать пользователя по id
    public Optional<User> getUserById(int id)   {
        if(id < data.size())
            return Optional.of(data.get(id));
        else
            return Optional.empty();
    }

    public List<User> getData() {
        return data;
    }

    //создадим публичный метод, который будет возвращать нам список пользователей
    public List<User>  getValidUsers(Validator validator) {
        return data.stream()
//                .filter(validator::validate);
                .filter(validator::validate)
                .collect(Collectors.toList());  //.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

//        List <User> validUsers = new ArrayList<>();
//        for (User user : data) {
//            if(validator.validate(user)) {
//                validUsers.add(user);
//            }
//        }
//        return validUsers;
    }

    public Optional<User> getReducedUser(BinaryOperator<User> binaryOperator) {
        return data.stream()
                .reduce(binaryOperator);
    }

    public List<User> getSortedUsers(Comparator<User> comparator) {
        return data.stream()
                .sorted(comparator)
                .collect(Collectors.toList());

    }

}
