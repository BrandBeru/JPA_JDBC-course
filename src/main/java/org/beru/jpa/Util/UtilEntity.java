package org.beru.jpa.Util;

import jakarta.persistence.*;

public class UtilEntity {
    private static final EntityManagerFactory MANAGER_FACTORY = buildEntityManagerFactory();
    private static EntityManagerFactory buildEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("myPersistenceUnit");
    }
    public static EntityManager getEntityManager(){
        return MANAGER_FACTORY.createEntityManager();
    }
}
