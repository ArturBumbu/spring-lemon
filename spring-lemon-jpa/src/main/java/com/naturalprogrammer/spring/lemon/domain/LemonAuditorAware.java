package com.naturalprogrammer.spring.lemon.domain;

import java.io.Serializable;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.AuditorAware;

import com.naturalprogrammer.spring.lemon.security.UserDto;
import com.naturalprogrammer.spring.lemon.util.LemonUtils;

/**
 * Needed for auto-filling of the
 * AbstractAuditable columns of AbstractUser
 *  
 * @author Sanjay Patel
 */
public class LemonAuditorAware
	<U extends AbstractUser<U,ID>,
	 ID extends Serializable>
implements AuditorAware<U> {
	
    private static final Log log = LogFactory.getLog(LemonAuditorAware.class);
    
    private AbstractUserRepository<U,ID> userRepository;
    
	public LemonAuditorAware(AbstractUserRepository<U,ID> userRepository) {
		
		this.userRepository = userRepository;
		log.info("Created");
	}

	@Override
	public Optional<U> getCurrentAuditor() {
		
		UserDto<ID> currentUser = LemonUtils.currentUser();
		
		if (currentUser == null)
			return Optional.empty();
		
		return userRepository.findById(currentUser.getId());
	}	
}
