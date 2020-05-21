package test;

/**
 * @author xiechao
 * @version 1.0.0
 * @date 2020/5/21 9:25
 * @description
 */
public class Teacher {
    private Integer age;

    private String name;

    private String address;

    public Teacher(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
