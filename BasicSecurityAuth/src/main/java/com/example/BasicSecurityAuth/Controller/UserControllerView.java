package com.example.BasicSecurityAuth.Controller;

import com.example.BasicSecurityAuth.Repository.UserRepository;
import com.example.BasicSecurityAuth.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserControllerView {

    private final UserRepository userRepository;

    UserControllerView(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @GetMapping("/")
    public String loginnormal(){
        return "login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @PostMapping("/")
    public String loginUser(ModelMap model, @ModelAttribute User user){
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getEmail());
        User loginUser = userRepository.findByEmail(user.getEmail()).orElse(null);

        if(!user.getPassword().equals(loginUser.getPassword())) {
            return "Wrong password";
        }
        model.addAttribute("email", loginUser.getEmail());
        model.addAttribute("username",loginUser.getUsername());

        return "home";

    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/";
    }

    @QueryMapping
    User getUserById(@Argument  Long id) {
        return userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid id: " + id));
    }


    @MutationMapping
    User addUser(@Argument UserInput user) {
        User newUser = new User();
        newUser.setUsername(user.username());
        newUser.setPassword(user.password());
        newUser.setEmail(user.email());
        return userRepository.save(newUser);
    }

    record UserInput(String username, String password, String email){}
}
