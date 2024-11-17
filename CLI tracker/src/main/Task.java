package main;

import java.time.LocalDateTime;

public class Task {
	private int id;
	private String description;
	private String status;
	private LocalDateTime dateCreate;
	private LocalDateTime dateUpdate;
	public Task() {
		description="created";
		status="ToDO";
		dateCreate=LocalDateTime.now();
		dateUpdate=LocalDateTime.now();
	}
	public Task(int id,String Description) {
		this.description=Description;
		this.id=id;
		dateCreate=LocalDateTime.now();
		dateUpdate=LocalDateTime.now();
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
		dateUpdate=LocalDateTime.now();
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
		dateUpdate=LocalDateTime.now();
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
		dateUpdate=LocalDateTime.now();
	}
	public LocalDateTime getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(LocalDateTime dateCreate) {
		this.dateCreate = dateCreate;
	}
	public LocalDateTime getDataUpdate() {
		return dateUpdate;
	}
	public void setDataUpdate(LocalDateTime dataUpdate) {
		this.dateUpdate = dataUpdate;
	}
	@Override
	public String toString() {
        return "ID: " + id + ", Description: " + description + ", Status: " + status +
               ", CreatedAt: " + dateCreate + ", UpdatedAt: " + dateUpdate;
    }

}
