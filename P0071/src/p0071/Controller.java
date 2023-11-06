package p0071;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    int choice;
    Validation Vad = new Validation();
    BO bo = new BO();
    
    public void Menu() throws Exception {
        while (true) {
            System.out.println("=======Task program=======");
            System.out.println("1, Add task");
            System.out.println("2, Delete task");
            System.out.println("3, Display task");
            System.out.println("4, Exit");
            choice = Vad.getInt("Enter your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    delTask();
                    break;
                case 3:
                    showTask();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.out.println("Exit successfully!");
                    System.exit(0);
            }
        }
    }

    public void addTask() throws Exception {
        int id;

        System.out.println("----------------Add task---------------");
        String requirementName = Vad.inputString("Requirement name: ", "[A-Za-z\\s]+");
        String taskTypeID = Vad.inputTaskTypeId("Task type: ");
        String date = Vad.inputDate("Date: ");

        double planFrom = Vad.getDouble("Plan from: ", 8, 17);
        double planTo = Vad.getDouble("To: ", 8.5, 17.5);

        while (Vad.checkTime(planFrom, planTo) == false) {
            System.out.println("planFrom must less than planTo!");
            planFrom = Vad.getDouble("From: ", 8, 17);
            planTo = Vad.getDouble("To: ", 8.5, 17.5);
        }
        String assignee = Vad.inputString("Assignee: ", "[A-Za-z\\s]+");
        String reviewer = Vad.inputString("Reviewer: ", "[A-Za-z\\s]+");

        while (Vad.checkReviewer(assignee, reviewer) == true) {
            System.err.println("Assignee not same reviewer");
            assignee = Vad.inputString("Assignee: ", "[A-Za-z\\s]+");
            reviewer = Vad.inputString("Reviewer: ", "[A-Za-z\\s]+");
        }
        id = bo.addTask(taskTypeID, requirementName, date, planFrom, planTo, assignee, reviewer);
        if (id == -1) {
            throw new Exception("Duplicate Task");
        } else {
            System.out.println("Add Successfully");
            System.out.println("ID: " + id);
        }
    }

    public void delTask() {
        try {
            if (bo.taskIsEmpty()) {
                System.out.println("List task is empty");
                return;
            }
            System.out.println("---------------Delete Task-----------------");
            String idFind = Vad.inputString("input id: ", "^(?=.*[0-9])[0-9]+$");
            bo.deleteTask(idFind);
            System.out.println("DELETE SUCCESFULLY");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void showTask() {
        if (bo.taskIsEmpty()) {
            System.out.println("List task is empty");
            return;
        }
        List<Task> listTasks = bo.getDataTasks();
        System.out.println("----------------------------------------------- Task -----------------------------------------------");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (Task checkTask : listTasks) {
            double time = checkTask.getPlanTo() - checkTask.getPlanFrom();
            System.out.printf("%-15d%-15s%-15s%-15s%-15.1f%-15s%-15s\n", checkTask.getId(), checkTask.getRequirementName(),
                    checkTask.getTaskTypeID(), checkTask.getDate(), time, checkTask.getAssignee(), checkTask.getReviewer());
        }
    }
}
