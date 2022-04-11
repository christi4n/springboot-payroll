package net.mydevfactory.payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(EmployeeRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Employee("John Smith", "Chief Officer", "Engineering")));
      log.info("Preloading " + repository.save(new Employee("Deborah Parker", "Head Director", "Marketing")));
      log.info("Preloading " + repository.save(new Employee("Sam Beckett", "Director", "Construction")));
    };
  }
}