package com.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Krzysztof Januś on 2015-02-05.
 */
abstract public class AbstractRepository {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private DefaultTransactionDefinition transactionDefinition;

    @Autowired
    private PlatformTransactionManager transactionManager;

    protected EntityManager em() {
        return em;
    }

    protected TransactionStatus begin() {
        return transactionManager.getTransaction(transactionDefinition);
    }

    protected void commit(TransactionStatus transaction) {
        transactionManager.commit(transaction);
    }

    protected void rollBack(TransactionStatus transaction) {
        transactionManager.rollback(transaction);
    }
}
