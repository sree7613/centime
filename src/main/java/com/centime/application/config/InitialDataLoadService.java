package com.centime.application.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.centime.application.annotation.LogMethodParam;
import com.centime.application.model.AppUser;
import com.centime.application.repository.AppUserRepository;

@Configuration
public class InitialDataLoadService {

	private static final Logger logger = LoggerFactory.getLogger(InitialDataLoadService.class);

	@Bean
	@LogMethodParam
	CommandLineRunner initDatabase(AppUserRepository repository) {
		return args -> {
			logger.info(" {}", repository.save(new AppUser(0, "Warrior", "red")));
			logger.info(" {}", repository.save(new AppUser(0, "Wizard", "green")));
			logger.info(" {}", repository.save(new AppUser(0, "Priest", "white")));
			logger.info(" {}", repository.save(new AppUser(0, "Rogue", "yellow")));
			logger.info(" {}", repository.save(new AppUser(1, "Fighter", "blue")));
			logger.info(" {}", repository.save(new AppUser(1, "Paladin", "lighblue")));
			logger.info(" {}", repository.save(new AppUser(1, "Ranger", "lighgreen")));
			logger.info(" {}", repository.save(new AppUser(2, "Mage", "grey")));
			logger.info(" {}", repository.save(new AppUser(2, "Specialist wizard", "lightgrey")));
			logger.info(" {}", repository.save(new AppUser(3, "Cleric", "red")));
			logger.info(" {}", repository.save(new AppUser(3, "Druid", "green")));
			logger.info(" {}", repository.save(new AppUser(3, "Priest of specific mythos", "white")));
			logger.info(" {}", repository.save(new AppUser(4, "Thief", "yellow")));
			logger.info(" {}", repository.save(new AppUser(13, "Assassin", "lighblue")));
			logger.info(" {}", repository.save(new AppUser(4, "Bard", "blue")));

		};
	}
}
