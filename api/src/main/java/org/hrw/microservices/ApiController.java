package org.hrw.microservices;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
public class ApiController {

  @RequestMapping(path = "/ping", method = RequestMethod.POST)
  public String ping() {
    return "pong";
  }
}
