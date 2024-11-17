package main;
import java.io.*;
import java.util.*;
import org.json.*;
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
	
	public void markTaskStatus(int id, String status) {
        Task task = getTaskById(id);
        if (task != null) {
            task.setStatus(status);
            saveTasks();
            System.out.println("Task marked as " + status + ".");
        } else {
            System.out.println("Task not found.");
        }
    }
	public void updateTask(int id, String description) {
        Task task = getTaskById(id);
        if (task != null) {
            task.setDescription(description);
            saveTasks();
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Task not found.");
        }
        return;
    }
	public void deleteTask(int id) {
        Task task = getTaskById(id);
        if (task != null) {
            Tasks.remove(task);
            saveTasks();
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found.");
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
