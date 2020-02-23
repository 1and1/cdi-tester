package com.oneandone.iocunitjpatra.example1;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by aschoerk on 28.06.17.
 */
@ApplicationScoped
@Transactional
public class Service implements ServiceIntf {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public int returnFive() {
        return 5;
    }

    @Override
    public long newEntity1(int intValue, String stringValue) {
        ExampleEntity1 entity1 = new ExampleEntity1(intValue, stringValue);
        entityManager.persist(entity1);
        return entity1.getId().longValue();
    }

    @Override
    public String getStringValueFor(long id) {
        return entityManager.createQuery("select e.stringValue from ExampleEntity1 e where e.id = :id", String.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
