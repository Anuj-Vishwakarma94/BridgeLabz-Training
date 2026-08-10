package com.DemoGreetingsApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DemoGreetingsApp.model.User;
import com.DemoGreetingsApp.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // ── Register (CREATE) ─────────────────────────────
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userService.registerUser(user);
        return "redirect:/login";
    }

    // ── Login (READ) ──────────────────────────────────
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            Model model,
                            HttpSession session) {

        User user = userService.loginUser(email, password);

        if (user != null) {
            // Store user id and name in session for later operations
            session.setAttribute("userId", user.getId());
            session.setAttribute("userName", user.getName());
            model.addAttribute("name", user.getName());
            return "welcome";
        }

        model.addAttribute("error", "Invalid Email or Password");
        return "login";
    }

    // ── Update Password (UPDATE) ──────────────────────
    @GetMapping("/update-password")
    public String updatePasswordPage(HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/login";
        }
        return "update-password";
    }

    @PostMapping("/update-password")
    public String updatePassword(@RequestParam String newPassword,
                                 HttpSession session,
                                 Model model) {

        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/login";
        }

        boolean updated = userService.updatePassword(userId, newPassword);

        if (updated) {
            model.addAttribute("name", session.getAttribute("userName"));
            model.addAttribute("success", "Password updated successfully!");
            return "welcome";
        }

        model.addAttribute("error", "Failed to update password.");
        return "update-password";
    }

    // ── Delete Account (DELETE) ───────────────────────
    @PostMapping("/delete-account")
    public String deleteAccount(HttpSession session) {

        Long userId = (Long) session.getAttribute("userId");

        if (userId != null) {
            userService.deleteUser(userId);
            session.invalidate();   // clear session after deletion
        }

        return "redirect:/register";
    }

    // ── Logout ────────────────────────────────────────
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}