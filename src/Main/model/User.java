package Main.model;

import java.time.LocalDate;

public class User {
    private static long totalUsers = 1;
    private long id;
    private String name;
    private String surname;
    private LocalDate birthday;

    public LocalDate getBirthday() {
        return birthday;
    }

    public User(String name, String surname, LocalDate birthday) {
        id = totalUsers++;  //на каждом новом созданом user мы увеличиваем id
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                "}\n";
    }

    public String getName() {
        return name;
    }
}
