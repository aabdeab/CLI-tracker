package main;
public class CLImain {

	public static void main(String[] args) {
		TaskManager Task =new TaskManager();
		if(args.length==0) {
			System.out.println("Usage :<command>[arguments]");
			return;
		}
		String command=args[0];
		try {
			switch(command) {
			case "add" :
				Task.AddTask(args[1]);
				break;
			case "update" :
				Task.updateTask(Integer.parseInt(args[1]), args[2]);
				break;
			case "delete":
				Task.deleteTask(Integer.parseInt(args[1]));
				break;
			case "mark-in-progress":
				Task.markTaskStatus(Integer.parseInt(args[1]), "IN_PROGRESS");
				break;
			case "mark-done":
				Task.markTaskStatus(Integer.parseInt(args[1]), "DONE");
				break;
			case "list":
				String filter = args.length>1 ? args[1] : null;
				Task.ListTasks(filter);
				break;
			default:
				System.out.println("Unknow command,Try again");
			}
			
	}
		catch(Exception e) {
		     System.out.println("Error:"+e.getMessage());
		}

}
}
