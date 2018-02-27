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
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String gender;

    public User setFirstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }


    public User setLastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User setBirthDate(final Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public User setGender(final String gender) {
        this.gender = gender;
        return this;
    }
}
