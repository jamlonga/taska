package com.taska.service;

import java.util.List;
import com.taska.bean.Task;
import com.taska.dao.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskDao dao;

    public void addTask(Task task){
        dao.addTask(task);
    }
    public void updateTask(Task task){
        dao.updateTask(task);
    }
    public void deleteTask(Integer id){
        dao.deleteTask(id);
    }
    public List<Task> getAllTask() {
        return dao.getAllTask();
    }
    public Task getTask(Integer id){
        return dao.getTask(id);
    }
}
