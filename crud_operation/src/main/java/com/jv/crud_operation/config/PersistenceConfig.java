package com.jv.crud_operation.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class PersistenceConfig {

	private static class AuditorAwareimp implements AuditorAware<String>{
		@Override
		public Optional<String> getCurrentAuditor() {
			return Optional.of("anonymous User");
		}
		
	}
	
	@Bean
	public AuditorAware<String> auditorAware(){
		return new AuditorAwareimp();
	}
}
