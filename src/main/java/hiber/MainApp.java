package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("Oleg", "Sidorov", "22@mail.ru", new Car("Volvo", 3)));
        userService.add(new User("Vasilyi", "Petrov", "33@mail.ru", new Car("BMV", 4)));
        System.out.println(userService.listUsers());
        System.out.println(userService.getUserByCar("Volvo"));

        context.close();
    }
}
