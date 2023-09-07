package com.example.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.thymeleaf.model.Task;
import com.example.thymeleaf.repo.TaskRepo;
import com.example.thymeleaf.service.TaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller("/")
public class TaskController {

    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private TaskService taskService;

    @RequestMapping("index")
    public String index(Model model){
        model.addAttribute("list",taskService.getservice());
        return "login";
    }
    @RequestMapping("/addtodo")
    public String view(){
        
        return "addtodo";
    }



  

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute Task todo, BindingResult errors, Model model) {
        long count=this.taskRepo.count();
        //String getid=todo.getId();
        count=count+1;
        String getid=String.valueOf(count);
        todo.setId(getid);
        taskService.createtask(todo);
        return "redirect:/index";
    }

   

    @GetMapping(value="/update/{id}")
    public String postMethodName(Model model,@PathVariable String id) {
        Task task=taskRepo.findById(id).orElseThrow(()->new IllegalArgumentException("todo"));
        model.addAttribute("todo1",task);
        return "updatetodo";
    }
    @PostMapping(value="/update1/{id}")
    public String postMethodName1(@ModelAttribute Task todo2,Model model,@PathVariable String id) {
        System.out.println("hello da");
        //String getid=String.valueOf(count);
        todo2.setId(id);
        taskService.createtask(todo2);
        return "redirect:/index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id,Model model){
        this.taskRepo.deleteById(id);
        return "redirect:/index";
    }
    
    

   
}
