package flower.flowercontinue.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {
    private AppUserRepository userRepository;
    public List<AppUser> getUser() {
        return userRepository.findAll();
    }

    public void addUser(AppUser user) {
        if (userRepository.findAppUserByEmail(user.getEmail()).isEmpty()) {
            userRepository.save(user);
        }
        else {
            System.out.println("Such user exists.");
        }
    }
}
