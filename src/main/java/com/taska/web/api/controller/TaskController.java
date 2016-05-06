package com.taska.web.api.controller;

import com.taska.web.api.transport.ResponseTransport;
import com.taska.web.api.transport.TaskTransport;
import com.taska.bean.Task;
import com.taska.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList
        ;
import java.util.List;

@RestController
//@RequestMapping(value = "/api/service/v1/tasks")
public class TaskController {
    Logger logger= LoggerFactory.getLogger(TaskController.class);
    @Autowired
    TaskService service;
/*
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createTask(@RequestBody @Valid TaskTransport taskTransport,
                                     HttpServletResponse response) {

        Task task=new Task();
        task.setSubject(taskTransport.getSubject());
        task.setContent(taskTransport.getContent());
        task.setStatus(taskTransport.getStatus());
        service.addTask(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getTaskList() {

        List<TaskTransport> taskTransportList =new ArrayList<>();
        List<Task> taskList = service.getAllTask();

        for(Task t: taskList){
            TaskTransport taskTransport =new TaskTransport();
            taskTransport.setId(t.getId());
            taskTransport.setSubject(t.getSubject());
            taskTransport.setContent(t.getContent());
            taskTransport.setStatus(t.getStatus());
            taskTransportList.add(taskTransport);
            logger.info(t.toString());
        }
        ResponseTransport<TaskTransport> responseTransport =
                new ResponseTransport<>(taskTransportList.size(), 5, taskTransportList);
        return new ResponseEntity<>(responseTransport,HttpStatus.OK);
    }
    */
    @RequestMapping(value="/",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getTaskList() {

        return "Heyyy";
    }

}
