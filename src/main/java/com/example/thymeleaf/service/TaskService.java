package com.example.thymeleaf.service;

import java.util.ArrayList;
import java.util.List;
import com.example.thymeleaf.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.thymeleaf.repo.TaskRepo;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepo taskRepo;


    public List<Task> getservice(){
        ArrayList<Task> tasks= new ArrayList<>();
        taskRepo.findAll().forEach(task->tasks.add(task));
        return tasks;

    }

    public void createtask(@RequestBody Task tasks){
        System.out.println(tasks.getTask());
        this.taskRepo.save(tasks);
    }

}
