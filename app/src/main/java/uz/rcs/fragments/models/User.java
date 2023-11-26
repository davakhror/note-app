package uz.rcs.fragments.models;

import java.io.Serializable;

public class User implements Serializable {

    String name;
    int age;

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

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public User(String name, int age, String familyName) {
        this.name = name;
        this.age = age;
        this.familyName = familyName;
    }

    String familyName;

}
