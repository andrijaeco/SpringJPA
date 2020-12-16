package silab.nst.dan11.springData.service;

import silab.nst.dan11.springData.domain.User;

import java.util.List;

public interface UserService {
    User add(User user) throws Exception;

    int delete(Long id) throws Exception;

    User update(User user) throws Exception;

    User findUserById(Long id) throws Exception;

    List<User> getAllUsers() throws Exception;


}
