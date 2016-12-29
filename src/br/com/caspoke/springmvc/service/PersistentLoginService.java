package br.com.caspoke.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.caspoke.dao.IPersistentLoginDao;
import br.com.caspoke.model.PersistentLogin;

@Service("persistentLoginService")
@Transactional
public class PersistentLoginService {

	@Autowired
	@Qualifier("jpaPersistentLoginDao")
	IPersistentLoginDao dao;
	
	public boolean existeSSO(String sso) {
		return dao.existeSSO(sso);
	}
}
