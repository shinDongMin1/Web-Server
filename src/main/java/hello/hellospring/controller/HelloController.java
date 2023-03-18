package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    
    // 1.정적 있는 그대로 보여줌

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    // 2.템플릿엔진은 모델에 대한 컨트롤러와 뷰를 반환
    
    // hello-mvc?name=값을 파라미터로 받겟다 ctrl+P하면 속성알수있다.
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    // 3.api는 뷰가 없이 모델값을 리턴하는 방식

    //http에서 body부분에 있는 값을 파라미터로 받겟다
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    //httpMessageConverter가 제이슨, 스트링방식 등 다양하고 리턴해주는데 객체를 넘길때 디폴트는 제이슨 방식으로 즉 key와 value로 이루어져있다.
    //@ResponseBody는 http인 주소창의 body에 있는 문자내용을 직접반환 ?name=값
    @GetMapping("hello-api")
    @ResponseBody
    public Hello hellpApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    
    //ctrl+N에서 찾아 자동완성
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}


