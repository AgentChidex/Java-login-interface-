package dev.demonform.demonform.Repository;

import dev.demonform.demonform.mode.Usermode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usermode, Integer> {


    Optional<Usermode> findByloginAndPassword(String Login, String password);

    Optional<Usermode> findFirstBylogin(String login);

}
