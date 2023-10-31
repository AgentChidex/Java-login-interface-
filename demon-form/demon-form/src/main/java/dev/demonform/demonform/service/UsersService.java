package dev.demonform.demonform.service;


import dev.demonform.demonform.Repository.UserRepository;
import dev.demonform.demonform.mode.Usermode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private final UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Usermode registerUser(String login, String password, String email) {

        if (login == null || password == null) {
            return null;
        } else {
            if (userRepository.findFirstBylogin(login).isPresent()) {
                System.out.println("Duplicate login");

                return null;
            }
            Usermode usermode = new Usermode();
            usermode.setLogin(login);
            usermode.setPassword(password);
            usermode.setEmail(email);
            return userRepository.save(usermode);
        }
    }
    public Usermode authenticate(String login,  String password){
        return userRepository.findByloginAndPassword(login, password).orElse( null);
    }
}