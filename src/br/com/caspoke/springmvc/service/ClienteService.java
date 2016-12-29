package br.com.caspoke.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.caspoke.dao.IClienteDao;
import br.com.caspoke.model.Cliente;

@Service("clienteService")
@Transactional
public class ClienteService {

	@Autowired
	@Qualifier("jpaClienteDao")
	IClienteDao dao;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
     
    public Cliente buscaPorId(int id) {
        return dao.buscaPorId(id);
    }
 
    public Cliente buscaPorSSO(String sso) {
        Cliente c = dao.buscaPorSSO(sso);
        return c;
    }
 
    public void insere(Cliente c) {
        c.setSenha(passwordEncoder.encode(c.getSenha()));
        dao.insere(c);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void atualiza(Cliente c) {
        Cliente entity = dao.buscaPorId(c.getId());
        if(entity!=null){
            entity.setSsoId(c.getSsoId());
            if(!c.getSenha().equals(entity.getSenha())){
                entity.setSenha(passwordEncoder.encode(c.getSenha()));
            }
            entity.setNome(c.getNome());
            entity.setEmail(c.getEmail());
            entity.setData(c.getData());
            entity.setOrcamentos(c.getOrcamentos());
            entity.setProfiles(c.getProfiles());
        }
    }
 
     
    public void removePorSSO(String sso) {
        dao.removePorSSO(sso);
    }
 
    public List<Cliente> lista() {
        return dao.lista();
    }
 
    public boolean isUserSSOUnique(Integer id, String sso) {
        Cliente user = buscaPorSSO(sso);
        return ( user == null || ((id != null) && (user.getId() == id)));
    }
}
