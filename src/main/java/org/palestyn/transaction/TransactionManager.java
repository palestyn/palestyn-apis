package org.palestyn.transaction;

import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

public interface TransactionManager {
	public void doWithEntityManager(Transactional.TxType scope, Consumer<EntityManager> callback);
}
