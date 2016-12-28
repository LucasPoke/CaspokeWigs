package br.com.caspoke.springmvc.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.caspoke.model.ClienteProfile;
import br.com.caspoke.springmvc.service.ClienteProfileService;

@Component
public class RoleToClienteProfileConverter implements Converter<Object, ClienteProfile>{
 
    static final Logger logger = LoggerFactory.getLogger(RoleToClienteProfileConverter.class);
     
    @Autowired
    ClienteProfileService clienteProfileService;
 
    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public ClienteProfile convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        ClienteProfile profile= clienteProfileService.buscaPorId(id);
        logger.info("Profile : {}",profile);
        return profile;
    }
}