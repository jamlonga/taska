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
import javax.validation.Valid;
import java.util.ArrayList
        ;
import java.util.List;

@RestController
@RequestMapping(value = "/api/service/v1/tasks")
public class TaskController {
    Logger logger= LoggerFactory.getLogger(TaskController.class);
    @Autowired
    TaskService service;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createTask(@RequestBody @Valid TaskTransport taskTransport) {

        Task task=new Task();
        task.setSubject(taskTransport.getSubject());
        task.setContent(taskTransport.getContent());
        task.setStatus(taskTransport.getStatus());
        service.addTask(task);
        logger.info("Task {} saved", taskTransport.getSubject());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateTask(@RequestBody @Valid TaskTransport taskTransport,@PathVariable Integer id) {

        Task task=new Task();
        task.setId(taskTransport.getId());
        task.setSubject(taskTransport.getSubject());
        task.setContent(taskTransport.getContent());
        task.setStatus(taskTransport.getStatus());
        if(!id.equals(task.getId())){
            logger.error("Could not update task to task id {} ,task object id {} doesn't match", id,task.getId());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        service.updateTask(task);
        logger.info("Task id {}, subject {} saved", task.getId(),task.getSubject());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTask(@PathVariable Integer id) {
        service.deleteTask(id);
        logger.info("Task id {} deleted", id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
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
        logger.info("Get list of task with total {} task",taskList.size());
        ResponseTransport<TaskTransport> responseTransport =
                new ResponseTransport<>(taskTransportList.size(), taskTransportList);
        return new ResponseEntity<>(responseTransport,HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTaskById(@PathVariable Integer id) {

        TaskTransport taskTransport=new TaskTransport();
        Task task=service.getTask(id);
        taskTransport.setId(task.getId());
        taskTransport.setSubject(task.getSubject());
        taskTransport.setContent(task.getContent());
        taskTransport.setStatus(task.getStatus());
        logger.info("Get task {} ", task.toString());
        return new ResponseEntity<>(taskTransport, HttpStatus.OK);
    }

}
