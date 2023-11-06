package p0071;

import java.util.ArrayList;
import java.util.List;

public class BO {

    List<Task> taskList = new ArrayList<>();
    Task task = new Task();

    private Task findByID(int id) {
        for(Task check : taskList){
            if(check.getId() == id){
                return check;
            }
        }
        return null;
    }

    public boolean taskIsEmpty() {
        return taskList.isEmpty();
    }

   
    private boolean checkDuplicate(Task task) {
        for (Task check : taskList) {
            if (check.getRequirementName().equalsIgnoreCase(task.getRequirementName())
                    && check.getTaskTypeID().equalsIgnoreCase(task.getTaskTypeID())
                    && check.getDate().equalsIgnoreCase(task.getDate())
                    && check.getPlanFrom() == task.getPlanFrom()
                    && check.getPlanTo() == task.getPlanTo()
                    && check.getAssignee().equalsIgnoreCase(task.getAssignee())
                    && check.getReviewer().equalsIgnoreCase(task.getReviewer())) {
                return true;
            }
        }
        return false;
    }

    private int increaseLastID() {
        return taskList.get(taskList.size() - 1).getId() + 1;
    }

    public int addTask(String taskTypeID, String requirementName, String date, double planFrom, double planTo,
            String assignee, String reviewer) throws Exception {
        int id;
        if (taskIsEmpty()) {
            id = 1;
        } else {
            id = increaseLastID();
        }
        Task task = new Task(id, taskTypeID, requirementName, date, planFrom, planTo, assignee, reviewer);
        if (checkDuplicate(task) == true) {
            id = - 1;
        } else {
            taskList.add(task);
        }
        return id;
    }

    public void deleteTask(String id) throws Exception {
        int input = Integer.parseInt(id);
        Task task = findByID(input);
        if (task == null) {
            throw new Exception("Not found");
        }
        if (task != null) {
            taskList.remove(task);
        }
    }

    public List<Task> getDataTasks() {
        return taskList;
    }
}
