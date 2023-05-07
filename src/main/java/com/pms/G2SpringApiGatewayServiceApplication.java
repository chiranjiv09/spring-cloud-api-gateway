package com.pms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins={"http://localhost:4200","https://d2sp5bzn9zomrp.cloudfront.net/"})
public class G2SpringApiGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(G2SpringApiGatewayServiceApplication.class, args);
	}
	
	
	
	@Bean
	public RouteLocator serviceRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
						.route(p -> p
								.path("/allergy-service/**")
								.filters(f -> f.rewritePath("/allergy-service/(?<segment>.*)", "/api/v1/${segment}"))
								.uri("http://allergy-svc:9002"))
						
						.route(p -> p
								.path("/appointment-service/**")
								.filters(f -> f.rewritePath("/appointment-service/(?<segment>.*)", "/api/v1/${segment}"))
								.uri("http://appointment-svc:9003"))
						
						
						.route(p -> p
								.path("/authentication-service/**")
								.filters(f -> f.rewritePath("/authentication-service/(?<segment>.*)", "/api/v1/${segment}"))
								.uri("http://localhost:9004"))
					
								
						.route( p -> p
								.path("/patient-info-service/**")
								.filters(f -> f.rewritePath("/patient-info-service/(?<segment>.*)", "/api/v1/${segment}"))
								.uri("http://patient-info-svc:9005"))

							
						.route(p -> p
								.path("/patient-health-service/**")
								.filters(f -> f.rewritePath("/patient-health-service/(?<segment>.*)", "/api/v1/visit/${segment}"))
								.uri("http://patient-health-svc:9006"))
						
						
						.route( p -> p
								.path("/physician-availability-service/**")
								.filters(f -> f.rewritePath("/physician-availability-service/(?<segment>.*)", "/api/v1/${segment}"))
								.uri("http://physician-availability-svc:9007"))
						
						.route( p -> p
								.path("/notification-service/**")
								.filters(f -> f.rewritePath("/notification-service/(?<segment>.*)", "/api/v1/${segment}"))
								.uri("http://notification-svc:9008"))
						
						.route( p -> p
								.path("/auth0-service/**")
								.filters(f -> f.rewritePath("/auth0-service/(?<segment>.*)", "/api/v1/${segment}"))
								.uri("http://auth0-svc:9009"))

				.build();
	}

}
