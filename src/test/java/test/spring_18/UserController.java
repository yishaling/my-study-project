package test.spring_18;

import test.spring_18.annotations.Autowared;
import test.spring_18.annotations.Controller;

@Controller
public class UserController {
    @Autowared
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
