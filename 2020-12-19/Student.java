import java.util.List;

public class Student {
    //属性：身高，体重，学号，姓名，专业，年龄，性别，电话
    //行为：选课，退课，查看课程，评教，
    float studentHeight;
    float studentWeight;
    int studentID;
    String studentName;
    String studentMajor;
    byte studentAge;
    String studentSex;
    String studentPhone;
    /*
    在学生类中有多个课程
    List<Course>selectedCourses;
     */
    /*
    只能选一节课
    Course course
     */
    List<Course> selectedCourses;
}
