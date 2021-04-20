package book;

import cn.hutool.core.util.ObjectUtil;
import lombok.Data;

/**
 * 环路检测
 */
public class Solution02_08 {
    public static void main(String[] args) {
        Student student = new Student("name", 1);
        Student clone = ObjectUtil.clone(student);
        System.out.println(clone);
    }
}
@Data
class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
