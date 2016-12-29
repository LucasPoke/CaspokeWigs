package br.com.caspoke.dao.jpa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.caspoke.dao.IPersistentLoginDao;
import br.com.caspoke.model.PersistentLogin;
 
@Repository
@Transactional
public class JpaPersistentLoginDao implements IPersistentLoginDao {
 
	@PersistenceContext
	EntityManager manager;
	
    static final Logger logger = LoggerFactory.getLogger(JpaPersistentLoginDao.class);
 
    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        logger.info("Creating Token for user : {}", token.getUsername());
        PersistentLogin persistentLogin = new PersistentLogin();
        persistentLogin.setUsername(token.getUsername());
        persistentLogin.setSeries(token.getSeries());
        persistentLogin.setToken(token.getTokenValue());
        persistentLogin.setLast_used(token.getDate());
        manager.persist(persistentLogin);
 
    }
 
    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        logger.info("Fetch Token if any for seriesId : {}", seriesId);
        try {
            PersistentLogin persistentLogin = manager.find(PersistentLogin.class, seriesId);
 
            return new PersistentRememberMeToken(persistentLogin.getUsername(), persistentLogin.getSeries(),
                    persistentLogin.getToken(), persistentLogin.getLast_used());
        } catch (Exception e) {
            logger.info("Token not found...");
            return null;
        }
    }
 
    @Override
    public void removeUserTokens(String username) {
    	
        logger.info("Removing Token if any for user : {}", username);
        Query q = manager.createQuery("Select p from PersistentLogin as p where p.username = :username");
        q.setParameter("username", username);
        PersistentLogin persistentLogin = (PersistentLogin)q.getSingleResult();
        
        if (persistentLogin != null) {
            logger.info("rememberMe was selected");
            manager.remove(persistentLogin);
        }
 
    }
 
    @Override
    public void updateToken(String seriesId, String tokenValue, Date lastUsed) {
        logger.info("Updating Token for seriesId : {}", seriesId);
        PersistentLogin persistentLogin = manager.find(PersistentLogin.class, seriesId);
        persistentLogin.setToken(tokenValue);
        persistentLogin.setLast_used(lastUsed);
        manager.merge(persistentLogin);
    }
    
    public boolean existeSSO(String sso) {
    	Query q = manager.createQuery("Select p from PersistentLogin as p where p.username = :username");
        q.setParameter("username", sso);
        return q.getResultList().size()>0;
    }
 
}