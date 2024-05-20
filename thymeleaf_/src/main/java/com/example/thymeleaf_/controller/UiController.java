package com.example.thymeleaf_.controller;

import com.example.thymeleaf_.dto.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/basic")
@Controller
public class UiController {

    @GetMapping("/text-basic")
    // Model은 Thymeleaf로 데이터를 넘기기 위한 클랫스
    public String textBasic(Model model) {
        model.addAttribute("data", "Hello <b>Spring</b>");
        return "basic/text-basic";
    }

    @GetMapping(path = "/variable")
    public String variable(Model model) {
        User userA = User.builder().username("userA").age(20).build();
        User userB = User.builder().username("userB").age(10).build();

        List<User> list = Arrays.asList(userA, userB);

        Map<String, User> map = new HashMap<>();
        map.put("userA", userA);
        map.put("userB", userB);

        model.addAttribute("user", userA);
        model.addAttribute("users", list);
        model.addAttribute("userMap", map);

        return "basic/variable";
    }

    @GetMapping(path = "/basic-objects")
    public String basicObjects(HttpSession httpSession) {
        httpSession.setAttribute("sessionData", "Hello Session");
        return "basic/basic-objects";
    }

    @GetMapping(path = "/date")
    public String date(Model model) {
        model.addAttribute("LocalDateTime", LocalDateTime.now());
        return "basic/date";
    }

    @GetMapping(path = "/link")
    public String link(Model model) {
        model.addAttribute("param1", "data1");
        model.addAttribute("param2", "data2");

        return "basic/link";
    }

    @GetMapping(path = "/literal")
    public String literal(Model model) {
        model.addAttribute("data", "Spring!");
        return "basic/literal";
    }

    @GetMapping(path = "/operation")
    public String operation(Model model) {
        model.addAttribute("data", "Spring!");
        return "basic/operation";
    }

    @GetMapping(path = "/each")
    public String each(Model model) {
        List<User> users= Arrays.asList(User.builder().username("user1").age(20).build(),
                User.builder().username("user2").age(20).build(),
                User.builder().username("user3").age(30).build());

        model.addAttribute("users", users);
        return "basic/each";
    }

    @GetMapping(path = "/javascript")
    public String javascript(Model model) {
        model.addAttribute("user", User.builder().username("user1").age(20).build());
        return "basic/javascript";
    }
}
