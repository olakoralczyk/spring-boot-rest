package pl.dmcs.rkotas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@SpringBootApplication
@RestController
public class RkotasApplication  {

	public static void main(String[] args) {
		SpringApplication.run(RkotasApplication.class, args);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping("/home")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping("/about")
	public Map<String, Object> unsecureHome() {
		Map<String, Object> model = new HashMap<>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}

	@EnableWebSecurity
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/about").permitAll()
					.anyRequest()
					.authenticated()
					.and()
					.httpBasic()
					.and()
					.cors();
		}
	}
}
/*
var http = require('http');
  var auth = require('basic-auth');
  var server = http.createServer(function(req,res)){
    var credentials = auth(req)
  if (!credentials || credentials.name != 'john' || credentials.pass !== 'secret') {
      res.statusCode = 401
      res. setHeader ('WWW-Authenticate','Basic realm="example"')
      res.end('Access denied')
} else {
      res.end('Access granted')
    }
})

server.listen(4200)
 */
