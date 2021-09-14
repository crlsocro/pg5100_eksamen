package no.kristiania.exam.website.website.backend.service;

import no.kristiania.exam.website.website.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collections;

@Service
@Transactional
public class UserService {

    @Autowired
    private EntityManager em;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public boolean createUser(String username,String first_name, String surname, String email, String password) {

        String hashedPassword = passwordEncoder.encode(password);

        if (em.find(User.class, username) != null) {
            return false;
        }
        User user = new User();
        user.setUsername(username);
        user.setFirst_name(first_name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPassword(hashedPassword);
        user.setRoles(Collections.singleton("USER"));
        user.setEnabled(true);
        em.persist(user);

        return true;
    }
}
