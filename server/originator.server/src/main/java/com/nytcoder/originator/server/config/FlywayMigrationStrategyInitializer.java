/**
 *
 */
package com.nytcoder.originator.server.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class FlywayMigrationStrategyInitializer implements FlywayMigrationStrategy {

	@DependsOn("springUtility")
	@Override
	public void migrate(Flyway flyway) {
		flyway.repair();
		flyway.migrate();
		flyway.setBaselineOnMigrate(true);
		flyway.setClassLoader(Thread.currentThread().getContextClassLoader() );
	}

}
