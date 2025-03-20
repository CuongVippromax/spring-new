package com.cuongnguyen.laptopshop.controller.admin;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cuongnguyen.laptopshop.domain.User;
import com.cuongnguyen.laptopshop.service.UploadService;
import com.cuongnguyen.laptopshop.service.UserService;

@Controller
public class UserController {
    private UserService userService;
    private final UploadService uploadService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, UploadService uploadService,
            PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.uploadService = uploadService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping("/")

    public String getHomePage(Model model) {
        List<User> arrUsers = this.userService.getAllUsers();
        System.out.println(arrUsers);
        ;
        model.addAttribute("test", "test");
        return "hello";
    }

    @GetMapping("/admin/create") // GET
    public String getCreateUserPage(Model model) {
        // tạo thêm 1 attribute để nhận các giá trị của objetc User từ form create sang
        model.addAttribute("newUser", new User()); // newUser là key , new User() là giá trị lấy từ form bên kia sang
        return "admin/user/create";
    }

    @PostMapping(value = "/admin/user/create")
    public String createUserPage(Model model,
            @ModelAttribute("newUser") User cuong,
            @RequestParam("cuongFile") MultipartFile file) {
        String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
        String hashPassword = this.passwordEncoder.encode(cuong.getPassword());
        cuong.setAvatar(avatar);
        cuong.setPassword(hashPassword);
        cuong.setRole(this.userService.getRoleByName(cuong.getRole().getName()));
        this.userService.handleSaveUser(cuong);
        return "redirect:/admin/user";
    }

    @RequestMapping("/admin/user")
    public String getAllUsers(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users1", users); // (truyền data qua view)
        return "admin/user/detail";
    }
}
