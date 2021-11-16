package br.fag.cmei.config;

import br.fag.cmei.service.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private  UsuarioServiceImpl usuarioDetailsService;



    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("administrador@cmei.com").password("{noop}administrador").roles(UserRoles.DIRETOR.name());
         auth.authenticationProvider(authProvider());

    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
        .authorizeRequests().antMatchers("/login/**", "/js/**", "/css/**", "/imagens/**", "/cadastro/**", "/h2/**").permitAll()
                .antMatchers("/consultar_coordenacao", "/consultar_secretaria", "/consultar_professores").hasRole(UserRoles.DIRETOR.name())
                .antMatchers("/consultar_coordenacao", "/consultar_secretaria", "/consultar_professores").hasRole(UserRoles.COORDENADOR.name())
                .antMatchers("/consultar_secretaria", "/consultar_professores").hasRole(UserRoles.SECRETARIO.name())
                .antMatchers("/consultar_professores").hasRole(UserRoles.PROFESSOR.name())
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/perfil", true);

    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(usuarioDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }
}



