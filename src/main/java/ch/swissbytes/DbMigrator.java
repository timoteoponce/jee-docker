package ch.swissbytes;

import org.flywaydb.core.*;

import javax.annotation.*;
import javax.ejb.*;
import javax.ejb.Singleton;
import javax.inject.*;
import javax.sql.*;

@Startup
@Singleton
@TransactionManagement(TransactionManagementType.BEAN)
public class DbMigrator {

    @Resource(lookup = "java:/dbDs")
    private DataSource dataSource;

    @PostConstruct
    private void onStartup() {
        if (dataSource == null)
            throw new IllegalStateException("No datasource defined for startup migrations");
        Flyway flyway = new Flyway();
        flyway.setBaselineOnMigrate(true);
        flyway.setDataSource(dataSource);
        flyway.migrate();
    }
}