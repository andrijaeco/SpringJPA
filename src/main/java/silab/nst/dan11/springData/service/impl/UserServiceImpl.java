package silab.nst.dan11.springData.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import silab.nst.dan11.springData.domain.User;
import silab.nst.dan11.springData.repository.UserRepository;
import silab.nst.dan11.springData.service.UserService;

import java.util.List;

@Component
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User add(User user) throws Exception {
//        save method also returns user that was saved, and also returns user's id in database
        return userRepository.save(user);
    }

    @Override
    public int delete(Long id) throws Exception {
//        this method also returns user that was deleted, and also returns user's id in database
        int row = userRepository.deleteUserById(id);
        System.out.println("row => " + row);
        return row;
    }

    @Override
    public User update(User user) throws Exception {
        userRepository.updateUser(user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword(), user.getId());
        return null;
    }

    @Override
    public User findUserById(Long id) throws Exception {
        return userRepository.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        return userRepository.findAll();
    }
}
