package controller;

import java.util.List;

import model.Type;
import model.User;
import service.DataService;
import view.StudentView;

public class Controller {
    private final DataService dataService = new DataService();

    //метод создания студента
    public void createStudent(String firstName, String secondName, String lastName){
        dataService.create(firstName, secondName, lastName, Type.STUDENT);
    }
    //метод вывода студентов на экран
    public void getAllStudent(){
        List<User> userList = dataService.getAllStudent();
        for (User user : userList) {
            StudentView.printOmConsole(user);
        }
    }
}
