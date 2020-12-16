package silab.nst.dan11.springData.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import silab.nst.dan11.springData.config.Config;
import silab.nst.dan11.springData.domain.User;
import silab.nst.dan11.springData.repository.UserRepository;
import silab.nst.dan11.springData.service.UserService;

import java.util.List;

@Component
public class Main {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Main main = context.getBean(Main.class);


//        main.addNewUser();

//        main.getUserById(1l);

//        main.deleteUser(20l);

        main.updateUser(23l);

        main.getAllUsers();

    }

    private void updateUser(Long id) {
        try {
            User foundUser = userService.findUserById(id);
            if (foundUser != null) {
                foundUser.setFirstName("c");
                foundUser.setLastName("c");
                foundUser.setUsername("c");
                foundUser.setPassword("c");
                userService.update(foundUser);
                System.out.println("User updated successfully.");
            } else {
                System.out.println("User doesn't exist!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteUser(long id) {
        try {
            System.out.println();
            int row = userService.delete(id);
            if (row > 0) {
                System.out.println("User was deleted.");
            } else {
                System.out.println("User doesn't exist!");
            }

            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getUserById(Long id) {
        try {
            User user = userService.findUserById(id);
            if (user != null) {
                System.out.println("User found: => " + user);
            } else {
                System.out.println("User doesn't exist.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addNewUser() {
        try {
            User user = new User("John", "Smith", "john", "smith");
            System.out.println(userService.add(user));
            System.out.println("User was inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getAllUsers() {
        try {
            List users = userService.getAllUsers();
            System.out.println("\n\n\nAll Users: => ");
            users.forEach(user -> System.out.println(user));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
