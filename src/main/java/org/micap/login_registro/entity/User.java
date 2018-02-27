package org.micap.login_registro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * User dto class
 * Create by Warren Stephen Aroni soto
 * Creation Date 24/02/2018
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
}
