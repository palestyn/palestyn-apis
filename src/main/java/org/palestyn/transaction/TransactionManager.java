package org.palestyn.transaction;

import java.util.function.Consumer;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

public interface TransactionManager {
	public void doWithEntityManager(Transactional.TxType scope, Consumer<EntityManager> callback);
	public <R> R doWithEntityManager(Transactional.TxType scope, Function<EntityManager, R> callback);
}
