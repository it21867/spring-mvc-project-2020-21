package gr.hua.dit.ds.project.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(passwordEncoder())
		.usersByUsernameQuery("select username,password, enabled from user where username=?")
		.authoritiesByUsernameQuery("select username, authority from authorities where username=?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.cors().and()
		.authorizeRequests() 
		.antMatchers("/").permitAll()
		.antMatchers("/api/student/").permitAll()
		.antMatchers("/students/list").hasAnyRole("ADMIN","TEACHER","SECRETARY")
        .antMatchers("/students/student").hasAnyRole("ADMIN","TEACHER","SECRETARY")
        .antMatchers("/students/student/saveStudent").hasRole("ADMIN")
        .antMatchers("/students/updateStudent").hasAnyRole("ADMIN","SECRETARY")
        .antMatchers("/students/deleteStudent").hasRole("ADMIN")
        .antMatchers("/teachers/list").hasAnyRole("ADMIN","TEACHER")
        .antMatchers("/teachers/teacher").hasAnyRole("ADMIN","TEACHER")
        .antMatchers("/teachers/saveTeacher").hasRole("ADMIN")
        .antMatchers("/teachers/updateTeacher").hasRole("ADMIN")
        .antMatchers("/teachers/deleteTeacher").hasRole("ADMIN")
		.anyRequest().authenticated() 
		.and()
		.formLogin().permitAll() 
		.defaultSuccessUrl("/", true) 
		.and()
		.logout().permitAll(); 
	}
	
	
	
	@Bean
	   public PasswordEncoder passwordEncoder() {
	           PasswordEncoder encoder = new BCryptPasswordEncoder();
	           return encoder;
	}

}
