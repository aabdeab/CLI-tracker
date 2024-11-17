package main;

import java.time.LocalDateTime;

public class Task {
	private int id;
	
	private String description;
	private String status;
	private LocalDateTime dateCreate;
	private LocalDateTime dataUpdate;
	public Task() {
		description="created";
		status="ToDO";
		dateCreate=LocalDateTime.now();
		dataUpdate=LocalDateTime.now();
	}
	public Task(int id,String Description) {
		this.description=Description;
		this.id=id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(LocalDateTime dateCreate) {
		this.dateCreate = dateCreate;
	}
	public LocalDateTime getDataUpdate() {
		return dataUpdate;
	}
	public void setDataUpdate(LocalDateTime dataUpdate) {
		this.dataUpdate = dataUpdate;
	}
	@Override
	public String toString() {
		return this.getDescription()+"["+this.getStatus()+"]";
	}

}
