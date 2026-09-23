package TCP;

import java.io.Serializable;

public class Customer implements Serializable {
    private int id;
    private String code;
    private String name;
    private String dayOfBirth;
    private String userName;
    private static final long serialVersionUID = 20170711L;

    public Customer(int id, String code, String name, String dayOfBirth, String username) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.userName = username;
    };

    public int getId() {
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

    public void setId(int id) {
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
    public void SetUsername(String username){
        this.userName=username;
    }
}
