package com.taska.bean;
public class Task {
    private Integer id;
    private String subject;
    private String content;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(this.getId())
                .append(", ")
                .append(this.getSubject())
                .append(", ")
                .append(this.getContent())
                .append(", ")
                .append(this.getStatus());

        return builder.toString();
    }

}
