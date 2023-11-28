package uz.online.springbootpractica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.online.springbootpractica.domein.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String userUser);

    @Query("select u from User u where u.userName = :userName")
    User findByLogin(@Param("userName") String userName);
    Boolean existsByUserName(String userName);
}
