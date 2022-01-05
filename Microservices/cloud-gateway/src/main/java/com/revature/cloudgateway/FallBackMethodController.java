package com.revature.cloudgateway;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CircuitBreaker()
public class FallBackMethodController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod(){
        return "User Service is taking longer than expected."+
                "Please try again later !!";
    }

    @GetMapping("/bookServiceFallBack")
    public String bookServiceFallBackMethod(){
        return "Book Service is taking longer than expected."+
                "Please try again later !!";
    }

    @GetMapping("/cartServiceFallBack")
    public String cartServiceFallBackMethod(){
        return "Cart Service is taking longer than expected."+
                "Please try again later !!";
    }
}
