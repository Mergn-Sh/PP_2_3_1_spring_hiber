package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.entity.User;
import web.service.UserService;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String showAllUsers(Model model){
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);

        return "all-users";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model){
        User user = new User();
        model.addAttribute("user", user);

        return "user-info";
    }

    @RequestMapping("/saveOrUpdateUser")
    public String saveOrUpdateUser(@ModelAttribute("user") User user){
        userService.saveOrUpdateUser(user);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateUser(@RequestParam("userId") int id, Model model){
        model.addAttribute("user", userService.getUser(id));

        return "user-info";
    }

    @RequestMapping("/deleteUser")
    public String deleteEmployee(@RequestParam("userId") int id){
        userService.deleteUser(id);
        return "redirect:/";
    }
}
