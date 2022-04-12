package net.mydevfactory.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// fire up a servlet container 
// and serve up our service
@SpringBootApplication
public class PayrollApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PayrollApplication.class, args);
	}

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PayrollApplication.class);
    }

}
