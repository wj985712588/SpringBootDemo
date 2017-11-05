package cc.mhonor.entity;

import cc.mhonor.enums.GenderCodeEnum;
import org.springframework.stereotype.Component;

@Component
public class UserEntity {

    private Integer id;

    private String userName;

    private String passWord;

    private Integer age;

    private GenderCodeEnum gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getpassWord() {
        return passWord;
    }

    public void setpassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public GenderCodeEnum getGender() {
        return gender;
    }

    public void setGender(GenderCodeEnum gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
