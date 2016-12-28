package br.com.caspoke.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.caspoke.dao.IClienteProfileDao;
import br.com.caspoke.model.ClienteProfile;
 
 
@Service("clienteProfileService")
@Transactional
public class ClienteProfileService {
     
    @Autowired
    @Qualifier("jpaClienteProfileDao")
    IClienteProfileDao dao;
     
    public ClienteProfile buscaPorId(int id) {
        return dao.buscaPorId(id);
    }
 
    public ClienteProfile buscaPorTipo(String type){
        return dao.buscaPorTipo(type);
    }
 
    public List<ClienteProfile> lista() {
        return dao.lista();
    }
}