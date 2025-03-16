package com.cuongnguyen.laptopshop.controller.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cuongnguyen.laptopshop.domain.User;
import com.cuongnguyen.laptopshop.service.UserService;

import jakarta.servlet.ServletContext;

@Controller
public class UserController {
    private UserService userService;
    private final ServletContext servletContext;

    public UserController(UserService userService, ServletContext servletContext) {
        this.userService = userService;
        this.servletContext = servletContext;
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
        // lấy giá trị newUser từ bên
        // form nhập có kiểu User và tên
        // biến là cuong

        try {

            byte[] bytes = file.getBytes();

            String rootPath = this.servletContext.getRealPath("/resources/images");

            File dir = new File(rootPath + File.separator + "avatar");
            if (!dir.exists())
                dir.mkdirs();

            // Create the file on server
            File serverFile = new File(
                    dir.getAbsolutePath() + File.separator + System.currentTimeMillis() + "-"
                            + file.getOriginalFilename());
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // this.userService.handleSaveUser(userService);
        return "redirect:/admin/user";
    }

    @RequestMapping("/admin/user")
    public String getAllUsers(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users1", users); // (truyền data qua view)
        return "admin/user/detail";
    }
}
