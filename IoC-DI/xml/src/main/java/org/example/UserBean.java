package org.example;

public class UserBean {
    private String name;
    private int age;
    private boolean male;

    // 기본 생성자는 반드시 가지고 있어야 한다.
    public UserBean() {
    }

    public UserBean(String name, int age, boolean male) {
        this.name = name;
        this.age = age;
        this.male = male;
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

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }
}
