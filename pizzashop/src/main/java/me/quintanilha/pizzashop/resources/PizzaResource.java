package me.quintanilha.pizzashop.resources;

import com.codahale.metrics.annotation.Timed;
import me.quintanilha.pizzashop.api.Pizza;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/pizzas")
@Produces(MediaType.APPLICATION_JSON)
public class PizzaResource {

    @GET
    @Timed
    public List<Pizza> list() {
        return Arrays.asList(
            new Pizza(101010, "Margherita"),
            new Pizza(202020, "Pepperoni")
        );
    }
}
