package com.example.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
  
@Entity
@Table
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private LocalDate dueDate;
    private String subject;
    private String description;
    private String email;
    private int phno;
    private boolean days7;
    private boolean days5;
    private boolean days3;
    private boolean days2;
    
   
        
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhno() {
		return phno;
	}
	public void setPhno(int phno) {
		this.phno = phno;
	}
	public boolean isDays7() {
		return days7;
	}
	public void setDays7(boolean days7) {
		this.days7 = days7;
	}
	public boolean isDays5() {
		return days5;
	}
	public void setDays5(boolean days5) {
		this.days5 = days5;
	}
	public boolean isDays3() {
		return days3;
	}
	public void setDays3(boolean days3) {
		this.days3 = days3;
	}
	public boolean isDays2() {
		return days2;
	}
	public void setDays2(boolean days2) {
		this.days2 = days2;
	}
    


}
