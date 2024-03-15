package web.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.DAO.UserDao;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String showUser(Model model) {
        List<User> allUser = userService.getAllUser();
        model.addAttribute("allUs", allUser);
        return "allUser";
    }

    @RequestMapping("/addNewUser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @RequestMapping("/updateInfo")
    public String updateUser(@RequestParam("usId") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user-info";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("usId") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
