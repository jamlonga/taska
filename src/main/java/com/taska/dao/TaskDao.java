package com.taska.dao;

import com.taska.bean.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class TaskDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addTask(Task task){
        String sql = "INSERT INTO task(subject, content, status) VALUES(?,?,?)";
        return jdbcTemplate.update(sql, task.getSubject(),
                task.getContent(), task.getStatus());
    }
    public int updateTask(Task task){
        String sql = "UPDATE task SET id=?, subject=?, content=?, status=? WHERE id=?";
        return jdbcTemplate.update(sql, task.getId(),
                task.getSubject(), task.getContent(),task.getStatus(),task.getId());
    }

    public int deleteTask(Integer id){
        String sql = "DELETE FROM task WHERE id=?";
        return jdbcTemplate.update(sql,id);
    }
    public List<Task> getAllTask(){
        return jdbcTemplate.query("SELECT * FROM task", new RowMapper<Task>() {

            public Task mapRow(ResultSet rs, int arg1) throws SQLException {
                Task p = new Task();
                p.setId(rs.getInt("id"));
                p.setSubject(rs.getString("subject"));
                p.setContent(rs.getString("content"));
                p.setStatus(rs.getString("status"));
                return p;
            }

        });
    }

    public Task getTask(Integer id){
        return jdbcTemplate.queryForObject("SELECT * FROM task WHERE id=?", new Object[]{id}, new RowMapper<Task>() {

            public Task mapRow(ResultSet rs, int arg1) throws SQLException {
                Task p = new Task();
                p.setId(rs.getInt("id"));
                p.setSubject(rs.getString("subject"));
                p.setContent(rs.getString("content"));
                p.setStatus(rs.getString("status"));
                return p;
            }

        });
    }
}
