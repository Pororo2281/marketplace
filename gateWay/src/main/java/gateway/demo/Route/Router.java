package gateway.demo.Route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.uri;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.cloud.gateway.server.mvc.predicate.GatewayRequestPredicates.before;
import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration
public class Router {

    @Bean
    public RouterFunction<ServerResponse> userServiceAuthRoute() {
        return route()
                .POST("/api/auth/**", http())
                .GET("/api/auth/**", http())
                .PUT("/api/auth/**", http())
                .before(uri("http://localhost:8081"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> userServiceSeller() {
        return route()
                .POST("/api/sellers/**", http())
                .GET("/api/sellers/**", http())
                .PUT("/api/sellers/**", http())
                .before(uri("http://localhost:8081"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> userServiceUser() {
        return route()
                .POST("/api/users/**", http())
                .GET("/api/users/**", http())
                .PUT("/api/users/**", http())
                .before(uri("http://localhost:8081"))
                .build();
    }


}

