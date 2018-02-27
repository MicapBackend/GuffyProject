package org.micap.login_registro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by Warren Stehen Aroni Soto.
 * User: warrenxxx
 * Date: 27/02/2018
 * Time: 11:23
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class User {

    //Account Dates
    private ObjectId _id;
    private String email;
    private String password;
    private String userName;
    private String []roles;


    private Date dateCreate;
    private Date dateModify;
    private ObjectId UserModify;
    private ObjectId UserCreated;

    //User Dates
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String gender;
}
