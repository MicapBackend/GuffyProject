package org.micap.login_registro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

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
    private String role;

    private Audit audit;
    private User user;

    public Account set_id(final Object _id) {
        this._id = _id;
        return this;
    }

    public Account setEmail(final String email) {
        this.email = email;
        return this;
    }

    public Account setPassword(final String password) {
        this.password = password;
        return this;
    }

    public Account setUserName(final String userName) {
        this.userName = userName;
        return this;
    }

    public Account setRoles(final String role) {
        this.role = roles;
        return this;
    }

    public Account setAudit(final Audit audit) {
        this.audit = audit;
        return this;
    }

    public Account setUser(final User user) {
        this.user = user;
        return this;
    }

    public Account setIdToString(){
        return set_id(get_id().toString());
    }
    public Account createNewAudit(){
        return setAudit(new Audit(new Date(),new Date(),get_id(),get_id()));
    }
}
