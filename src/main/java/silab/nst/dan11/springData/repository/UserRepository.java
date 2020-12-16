package silab.nst.dan11.springData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import silab.nst.dan11.springData.domain.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.id = ?1")
    User getUserById(Long id);

    //    this method has to return void/int type, it returns how many rows are affected
    @Transactional
    @Modifying
    @Query("delete from User u where u.id = ?1")
    int deleteUserById(Long id);

    @Transactional
    @Modifying
    @Query("update User u set u.firstName = ?1, u.lastName = ?2, u.username = ?3, u.password = ?4 where u.id = ?5")
    int updateUser(String firstName, String lastName, String username, String password, Long id);
}
