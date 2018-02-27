package org.micap.login_registro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Account dto class
 * Create by Warren Stephen Aroni soto
 * Creation Date 24/02/2018
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Account {
    private ObjectId _id;
    private String email;
    private String password;
    private String userName;
    private User user;
    private String[]phones;
}
