package br.com.marrone.mongoDbAtlasExample.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Permission {

    @Id
    private String id;
    private String permission;
    private String system;

    public Permission() {
    }

    public Permission(String permission, String system) {
        this.permission = permission;
        this.system = system;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id='" + id + '\'' +
                ", permission='" + permission + '\'' +
                ", system='" + system + '\'' +
                '}';
    }
}
