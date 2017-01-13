package me.lishuo.entity;

/**
 * Created by lis on 17/1/10.
 */
public class Person {

    public Person(String name, String addr,  int sex) {
        this.addr = addr;
        this.name = name;
        this.sex = sex;
    }

    private String name;
    private int sex;
    private String addr;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "addr='" + addr + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
