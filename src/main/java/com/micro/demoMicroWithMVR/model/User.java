package com.micro.demoMicroWithMVR.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class User
{
    private Long userid;
    private String name;
    private String dob;
    private String ht;
    private String wt;
    private String gender;
    private String eye;
    private int postal_code;

    List<UserInfo> userInfoList=new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", ht='" + ht + '\'' +
                ", wt='" + wt + '\'' +
                ", gender='" + gender + '\'' +
                ", eye='" + eye + '\'' +
                ", postal_code=" + postal_code +
                '}';
    }

   public User(Long userid, String name, String dob, String ht, String wt, String gender, String eye, int postal_code) {
        this.userid = userid;
        this.name = name;
        this.dob = dob;
        this.ht = ht;
        this.wt = wt;
        this.gender = gender;
        this.eye = eye;
        this.postal_code = postal_code;
    }
}
