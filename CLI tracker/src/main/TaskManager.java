package main;
import java.io.*;
import java.util.*;
import org.json.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TaskManager {
	private List<Task> Tasks =new ArrayList<>();
	private final String filePath="data.json";
	
	public TaskManager() {
		loadTasks();	
	}
	
	public List<Task> getAllTasks(){
		return this.Tasks;
	}
	public void AddTask(String description) {
		this.Tasks.add(new Task(Tasks.size()+1,description));
		saveTasks();
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
	public void ListTasks(String filter) {
		for(Task task:Tasks) {
			if(filter==null || task.getStatus()==filter) {
				System.out.println(task);
			}
			
		}
	}
	public  Task getTaskById(int id) {
		return(Tasks.stream().filter(t -> t.getId()==id).findFirst().orElse(null));
	}
	private void loadTasks() {
		File file=new File(filePath);
		if(!file.exists()) {
			return ;
		}
		try(BufferedReader reader=new BufferedReader(new FileReader(file))){
			StringBuilder json =new StringBuilder();
			String line;
			while((line=reader.readLine())!=null) {
				json.append(line);
			}
			JSONArray array =new JSONArray(json.toString());
			for(int i=0;i<array.length();i++) {
				JSONObject obj = array.getJSONObject(i);
				Task task =new Task(obj.getInt("id"),obj.getString("Description"));
				Tasks.add(task);
			}
		}
		catch(Exception e) {
			System.out.println("there is an error check out");
		}
		
	}
	private void saveTasks() {
		JSONArray json =new JSONArray();
		for(Task task : Tasks) {
			JSONObject obj=new JSONObject();
			obj.put("id", task.getId());
			obj.put("description", task.getDescription());
			obj.put("status", task.getStatus());
			obj.put("createAt", task.getDateCreate().toString());
			obj.put("UpdateAt", task.getDataUpdate().toString());
			json.put(obj);
		}
		try (BufferedWriter writer =new BufferedWriter(new FileWriter(filePath))){
			writer.write(json.toString());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	

}
