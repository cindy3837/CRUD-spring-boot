package com.example.service.app.entity;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;

public class ManualInsertGenerator extends IdentityGenerator {

        @Override
        public Serializable generate(SharedSessionContractImplementor s, Object obj) throws HibernateException {
            Serializable id = s.getEntityPersister(null, obj).getClassMetadata().getIdentifier(obj, s);

            if (id != null && Long.valueOf(id.toString()) > 0) {
                return id;
            } else {
                return super.generate(s, obj);
            }
        }
    }
