package br.com.caspoke.springmvc.security;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.caspoke.dao.IClienteDao;
import br.com.caspoke.model.Cliente;
import br.com.caspoke.model.ClienteProfile;
 
 
@Service("clienteDetailsService")
public class ClienteDetailsService implements UserDetailsService{
 
    static final Logger logger = LoggerFactory.getLogger(ClienteDetailsService.class);
     
    @Autowired
    @Qualifier("jpaClienteDao")
    private IClienteDao dao;
     
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
        Cliente user = dao.buscaPorSSO(ssoId);
        logger.info("User : {}", user);
        if(user==null){
            logger.info("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getSsoId(), user.getSenha(), true, true, true, true, getGrantedAuthorities(user));
    }
 
     
    private List<GrantedAuthority> getGrantedAuthorities(Cliente user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
        for(ClienteProfile userProfile : user.getProfiles()){
            logger.info("UserProfile : {}", userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getTipo()));
        }
        logger.info("authorities : {}", authorities);
        return authorities;
    }
     
}