//package com.springjava.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.springjava.model.User;
//
//public interface UserRepository  extends JpaRepository<User, Integer> {
//	User findByUsernameOrEmail(String username, String email);
//
//}
package com.springjava.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springjava.model.User;
public interface UserRepository extends JpaRepository<User, Integer> {
User findByUsernameOrEmail(String username, String email);

boolean existsByUserName(String username);

boolean existsByEmail(String email);
}