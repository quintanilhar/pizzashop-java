package me.quintanilha.pizzashop;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import me.quintanilha.pizzashop.health.PizzaHealthCheck;
import me.quintanilha.pizzashop.resources.PizzaResource;

public class PizzaShopApplication extends Application<PizzaShopConfiguration> {

    public static void main(final String[] args) throws Exception {
        new PizzaShopApplication().run(args);
    }

    @Override
    public String getName() {
        return "pizzashop";
    }

    @Override
    public void initialize(final Bootstrap<PizzaShopConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<PizzaShopConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(PizzaShopConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    @Override
    public void run(final PizzaShopConfiguration configuration, final Environment environment) {
        final PizzaResource resource = new PizzaResource();
        environment.jersey().register(resource);

        final PizzaHealthCheck healthCheck = new PizzaHealthCheck();
        environment.healthChecks().register("pizza", healthCheck);
    }

}
