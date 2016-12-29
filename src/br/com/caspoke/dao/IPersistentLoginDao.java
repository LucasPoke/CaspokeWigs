package br.com.caspoke.dao;

import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import br.com.caspoke.model.PersistentLogin;

public interface IPersistentLoginDao extends PersistentTokenRepository{
	public boolean existeSSO(String sso);
}
