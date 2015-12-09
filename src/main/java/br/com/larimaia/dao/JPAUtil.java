package br.com.larimaia.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Evandro on 11/11/2015.
 */
public class JPAUtil {

        private static final EntityManagerFactory emf;
        private static final EntityManager em;

        static {
            emf = Persistence.createEntityManagerFactory("lm_bemcasadoPU");
            em = emf.createEntityManager();
        }

        public static EntityManager abreConexao() {
            return em;
        }
}
