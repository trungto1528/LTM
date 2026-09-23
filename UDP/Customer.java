package UDP;

import java.io.Serializable;

public class Customer implements Serializable {
    private String id;
    private String code;
    private String name;
    private String dayOfBirth;
    private String userName;
    private static final long serialVersionUID = 20151107;

    public Customer(String id, String code, String name, String dayOfBirth, String username) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.userName = username;
    };

    public String getId() {
        return this.id;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public String getDayOfBirth() {
        return this.dayOfBirth;
    }

    public String getUsername() {
        return this.userName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDayOfBirth(String dob) {
        this.dayOfBirth = dob;
    }

    public void SetUsername(String username) {
        this.userName = username;
    }
}
