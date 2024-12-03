package com.group8.alomilktea.controller.admin;

import com.group8.alomilktea.entity.Roles;
import com.group8.alomilktea.entity.User;
import com.group8.alomilktea.service.IRoleService;
import com.group8.alomilktea.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/list")
    public String showUserList(ModelMap model,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "size", defaultValue = "10") int size) {

        Page<User> userPage = userService.findAll(PageRequest.of(page, size));
        List<User> users = userPage.getContent();

        // Map user roles for display
        var userRoleMap = users.stream()
                .collect(Collectors.toMap(
                        User::getUserId,
                        user -> user.getRoles().stream()
                                .map(role -> role.getRole().name()) // Get role name from enum
                                .collect(Collectors.joining(", "))
                ));

        model.addAttribute("users", users);
        model.addAttribute("userRoleMap", userRoleMap);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", userPage.getTotalPages());
        model.addAttribute("totalItems", userPage.getTotalElements());
        model.addAttribute("pageSize", size);

        return "admin/users/apps-ecommerce-user-list";
    }

    @GetMapping("/add")
    public String addUser(ModelMap model) {
        List<Roles> roles = roleService.findAll(); // Get all roles for combobox

        model.addAttribute("user", new User());
        model.addAttribute("roles", roles);  // Pass roles to the view
        model.addAttribute("isEdit", false);

        return "admin/users/apps-ecommerce-user-create";
    }

    @PostMapping("/add/save")
    public String saveUser(
            @ModelAttribute User user,
            @RequestParam("roleIds") List<Integer> roleIds, // Get selected role IDs
            ModelMap model) {

        Set<Roles> roles = roleService.findByIds(roleIds); // Fetch roles by IDs
        user.setRoles(roles);

        userService.save(user);
        model.addAttribute("message", "User created successfully!");
        return "redirect:/admin/user/list";
    }

    @GetMapping("/edit/{userId}")
    public String editUser(@PathVariable Integer userId, ModelMap model) {
        User user = userService.findById(userId);
        if (user == null) {
            model.addAttribute("errorMessage", "User not found!");
            return "redirect:/admin/user/list";
        }

        List<Roles> roles = roleService.findAll(); // Get all roles for combobox

        model.addAttribute("user", user);
        model.addAttribute("roles", roles); // Pass roles to the view
        model.addAttribute("isEdit", true);

        return "admin/users/apps-ecommerce-user-create";
    }

    @PostMapping("/edit/save")
    public String updateUser(
            @ModelAttribute User user,
            @RequestParam("roleIds") List<Integer> roleIds,
            ModelMap model) {

        Set<Roles> roles = roleService.findByIds(roleIds); // Fetch roles by IDs
        user.setRoles(roles);

        userService.save(user);
        model.addAttribute("message", "User updated successfully!");
        return "redirect:/admin/user/list";
    }

    @PostMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId, ModelMap model) {
        User user = userService.findById(userId);
        if (user == null) {
            model.addAttribute("errorMessage", "User not found!");
        } else {
            userService.deleteById(userId);
            model.addAttribute("message", "User deleted successfully!");
        }
        return "redirect:/admin/user/list";
    }
}
