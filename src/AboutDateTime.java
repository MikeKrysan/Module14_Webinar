import java.time.*;

public class AboutDateTime {
    public static void main(String[] args) {
        //Получение текущего времени
//        System.out.println(new Date()); // Old
//        System.out.println(LocalDateTime.now());    //New

        //Изменение спецефических полей
//        int month = new GregorianCalendar().get(Calendar.MONTH);    //Old
//        Month monthNew = LocalDateTime.now().getMonth();   //New
//        System.out.println(monthNew.minus(3));

        //Представление конкретного времени:
//        Date birthDay = new GregorianCalendar(1990, Calendar.DECEMBER, 15).getTime();   //Old
//        LocalDate birthDayNew = LocalDate.of(1990, Month.DECEMBER, 15); //New
//        System.out.println(LocalDateTime.of(2020, 1, 10, 1, 1));    //При вводе в месяц "0" - выбрасывается исключение

        //Взаимодейсвие со старым API
//        System.out.println(LocalDateTime.ofInstant((new Date()).toInstant(), ZoneId.of(("UTC")))); //2022-01-17

        //Получение промежутка времени между двумя точками во времени:
        //Old
//        GregorianCalendar calendar = new GregorianCalendar();
//        Date now = new Date();
//        calendar.add(Calendar.HOUR, 1);
//        Date hourLater = calendar.getTime();
//        long elapsed = hourLater.getTime() - now.getTime();
//        System.out.println(elapsed);

        //New
//        LocalDateTime nowNew= LocalDateTime.now();
//        LocalDateTime hourlaterNew = LocalDateTime.now().plusHours(1);
//        Duration span = Duration.between(nowNew, hourlaterNew);
//        System.out.println(span);
//
//        //Либо для дат
//        LocalDate Id1 = LocalDate.now();
//        LocalDate Id2 = LocalDate.now().plusDays(1);
//        Period p = Period.between(Id1, Id2);
//        System.out.println(p);

        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().plusDays(20);
        System.out.println(Duration.between(start, end));   //PT480H
        LocalDate start1 = LocalDate.now();
        LocalDate end1 = LocalDate.now().plusDays(20);
        System.out.println(Period.between(start1, end1));   //P20D
    }
}
