/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifs_devices.model;

/**
 *
 * @author sanmlk
 */
public class Request {

    private String Device_name;
    private String Type;
    private String Platform;
    private String OS;
    private int Priority;
    private int Size;
    private String Resolution;
    private String Location;
    private String SPA;
    private String Project;
    private String URL;
    private String UserName;
    private String Comment;

    public String getDevice_name() {
        return Device_name;
    }

    public void setDevice_name(String Device_name) {
        this.Device_name = Device_name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getPlatform() {
        return Platform;
    }

    public void setPlatform(String Platform) {
        this.Platform = Platform;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public int getPriority() {
        return Priority;
    }

    public void setPriority(int Priority) {
        this.Priority = Priority;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int Size) {
        this.Size = Size;
    }

    public String getResolution() {
        return Resolution;
    }

    public void setResolution(String Resolution) {
        this.Resolution = Resolution;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getSPA() {
        return SPA;
    }

    public void setSPA(String SPA) {
        this.SPA = SPA;
    }

    public String getProject() {
        return Project;
    }

    public void setProject(String Project) {
        this.Project = Project;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }
}
