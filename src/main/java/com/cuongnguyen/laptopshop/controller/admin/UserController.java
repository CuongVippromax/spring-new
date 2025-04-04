package com.cuongnguyen.laptopshop.controller.admin;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/admin/user/create") // GET
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

        // save
        this.userService.handleSaveUser(cuong);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        User detailUser = this.userService.getDetailUser(id);
        model.addAttribute("detailUser", detailUser);
        return "admin/user/userdetail";
    }

    @RequestMapping("/admin/user")
    public String getAllUsers(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users1", users); // (truyền data qua view)
        return "admin/user/detail";
    }

    @RequestMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User currentUser = this.userService.getUserById(id);
        model.addAttribute("newUser", currentUser);
        return "admin/user/update";
    }

    @PostMapping("/admin/user/update")
    public String postUpdateUser(Model model, @ModelAttribute("newUser") User cuong) {
        User currentUser = this.userService.getUserById(cuong.getId());
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        User user = new User();
        user.setId(id);
        model.addAttribute("newUser", user);
        return "admin/user/delete";
    }

    @PostMapping("/admin/user/delete")
    public String postDeleteUserPage(Model model, @ModelAttribute("newUser") User cuong) {
        this.userService.deleteAUser(cuong.getId());
        return "redirect:/admin/user";
    }
}
