package flower.flowercontinue.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/appuser")
public class AppUserController {
    private final AppUserService userService;

    @Autowired
    public AppUserController(AppUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<AppUser> getUser() {return userService.getUser();}

    @PostMapping
    public void addUser(@RequestBody AppUser user) {
        userService.addUser(user);

    }
}
