package org.kintro.prepared;

/*
 * A pre-defined class for inter-op.
 */

public class JPerson {
    private String name;
    private int age;
    private boolean isFemale;

    public JPerson(String name, int age, boolean isFemale) {
        this.name = name;
        this.age = age;
        this.isFemale = isFemale;
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

    public boolean isFemale() {
        return isFemale;
    }

    public void setFemale(boolean female) {
        isFemale = female;
    }

    @Override
    public String toString() {
        return "Person(" +
                "name=" + name +
                ", age=" + age +
                ')';
    }
}
