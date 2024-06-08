package service;

import java.util.ArrayList;
import java.util.List;

import model.Student;
import model.Teacher;
import model.Type;
import model.User;

public class DataService {
    private List<User> userList  = new ArrayList<>();
    
    
    


    public void create(String firstName, String secondName, String lastName, Type type){
        int id = getFreeId(type);//тут получили id студента или учителя
        if (type == Type.STUDENT) {//если хотим создать студента
            userList.add(new Student(firstName, secondName, lastName, id));
        }
        if (type == Type.TEACHER) {//если хотим создать студента
            userList.add(new Teacher(firstName, secondName, lastName, id));
        }
    }
    private int getFreeId(Type type){
        boolean itsStudent = Type.STUDENT == type;//true если студент, false если учитель
        int lastId = 1; //переменная для последнего id//если нашли учителя то нашли новый lastId, если список пуст был изначально то вернется 1
        for (User user : userList) {
            if (user instanceof Teacher && (!itsStudent)) {
                lastId = ((Teacher)user).getTeacherId()+1;
            }
            if (user instanceof Student && itsStudent) {
                lastId = ((Student)user).getStudentId()+1;
            }
            
        }
        return lastId;
        
    }
    //метод чтобы получить список студентов
    public List<User> getAllStudent(){
        List<User> result = new ArrayList<>();
        for (User user : userList) {
            if (user instanceof Student) {
                result.add(user);
            }
        
        }
        return result;
    }
}
