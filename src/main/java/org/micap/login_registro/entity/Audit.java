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
public class Audit {
    private Date dateCreate;
    private Date dateModify;
    private Object UserModify;
    private Object UserCreated;

    public Audit setDateCreate(final Date dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    public Audit setDateModify(final Date dateModify) {
        this.dateModify = dateModify;
        return this;
    }

    public Audit setUserModify(final Object userModify) {
        UserModify = userModify;
        return this;
    }

    public Audit setUserCreated(final Object userCreated) {
        UserCreated = userCreated;
        return this;
    }
}
