package main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TaskManager {
	private List<Task> Tasks =new ArrayList<>();
	private final String filePath="data.json";
	
	public TaskManager() {
		loadTasks();	
	}
	private void loadTasks() {
		File file=new File(filePath);
		if(!file.exists()) {
			return ;
		}
		try(BufferedReader reader=new BufferedReader(new FileReader(file))){
			ObjectMapper obj =new ObjectMapper();
			JsonNode node = obj.readTree(new FileReader(filePath));
			for(int i=0;i<node.size();i++) {
				Tasks.add(new Task());
			}
		}
		catch(Exception e) {
			System.out.println("there is an error check out");
		}
		
	}
	public List<Task> getAllTasks(){
		return this.Tasks;
	}
	public void AddTask(Task task) {
		this.Tasks.add(task);
		saveTasks();
	}
	private void saveTasks() {
		// TODO Auto-generated method stub
		
	}
	public void UpdateTask(int index,TaskStatus status) {
		if(index>=0 && index<Tasks.size()) {
			Tasks.get(index).setStatus(status.name());
		}
		else {
			System.out.println("invalid task index");
		}
	}
	public void DeleteTask(int index) {
		if(index>=0) {
			Tasks.remove(index);
		}
		else {
			System.out.println("invalid task index");
		}
	}
	public void ListTasks() {
		for(int i=0;i<Tasks.size();i++) {
			System.out.println("Task"+i+":"+Tasks.get(i).toString());
		}
	}
	
	
	
	

}
