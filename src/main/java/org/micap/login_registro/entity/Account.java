package org.micap.login_registro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Warren Stehen Aroni Soto.
 * User: warrenxxx
 * Date: 27/02/2018
 * Time: 13:32
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Account {
    private Object _id;
    private String email;
    private String password;
    private String userName;
    private String []roles;

    private Audit audit;
    private User user;
}
