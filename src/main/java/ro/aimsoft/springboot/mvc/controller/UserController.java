package ro.aimsoft.springboot.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.aimsoft.springboot.mvc.dto.UserDTO;
import ro.aimsoft.springboot.mvc.form.UserCreationForm;
import ro.aimsoft.springboot.mvc.service.UserService;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String signup(UserCreationForm userCreationForm) {
        return "add-user";
    }

    @PostMapping("/add")
    public String addUser(@Valid UserCreationForm userCreationForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        userService.createUser(userCreationForm);
        model.addAttribute("userList", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/list")
    public ModelAndView userListV1() {
        ModelAndView userListMV = new ModelAndView("users");
        userListMV.addObject("userList", userService.getAllUsers());

        return userListMV;
    }

    @GetMapping("/listV2")
    public String userListV2(Model model) {
        model.addAttribute("userList", userService.getAllUsers());

        return "users";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") UUID id, Model model) {
        UserDTO user = userService.getUser(id);

        model.addAttribute("user", user);
        return "edit-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") UUID id, @Valid UserDTO user,
                             BindingResult result, Model model) {
        System.out.println("ID: " + id);
        if (result.hasErrors()) {
            user.setId(id);
            model.addAttribute("user", user);
            System.out.println("ID: " + result.getAllErrors());
            return "edit-user";
        }

        userService.update(user);
        model.addAttribute("userList", userService.getAllUsers());

        return "users";
    }

}
