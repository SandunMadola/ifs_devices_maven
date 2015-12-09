
package ifs_devices.model;

/**
 *
 * @author sanmlk
 */
public class Employee {

    private int id;
    private String name;
    private int age;

    private String username;
    private String pid;
    private String subpid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getSubpid() {
        return subpid;
    }

    public void setSubpid(String subpid) {
        this.subpid = subpid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
