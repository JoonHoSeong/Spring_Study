package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam(name = "name", required = true) String name, Model model) {
        model.addAttribute("name",name);
        return "hello-template"; //HTML을 내려줌
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //데이터를 그대로 내려줌 StringConverter 작동
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloAPI(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체가 반환 되어서 기본적으로 json으로 반환 JsonConvertor작동
    }
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

