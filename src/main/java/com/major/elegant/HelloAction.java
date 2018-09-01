package com.major.elegant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloAction {

    //注入配置文件中的参数
    @Autowired
    private Child child;

    @RequestMapping(value = "say", method = RequestMethod.GET)
    public String say(){
        return "say hello";
    }

    @RequestMapping("child")
    public String child(){
        return "child " + child;
    }

    @RequestMapping(value = "get1", method = RequestMethod.GET)
    public String get1(@RequestParam("name") String name) {
        return "get1 你的名字：" + name;
    }

    @RequestMapping(value = "get2", method = RequestMethod.GET)
    public String get2(@RequestParam(value = "name", defaultValue = "默认") String name) {
        return "get1 你的名字：" + name;
    }

    @RequestMapping(value = "calc", method = RequestMethod.GET)
    public String calc(@RequestParam(value = "name", required = false) String name) {
        if (name == null) {
            return "计算什么好呢";
        }
        return "你的名字：" + name;
    }

    @RequestMapping(value = "get3/{id}", method = RequestMethod.GET)
    public Integer get3(@PathVariable("id") Integer id){
        return id;
    }
}
