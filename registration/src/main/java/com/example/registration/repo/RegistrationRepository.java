package com.example.registration.repo;


import com.example.registration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<User, Integer> {
    public  User findByEmailId(String email);

   public User findByEmailIdAndPassword(String emailId, String password);
}
