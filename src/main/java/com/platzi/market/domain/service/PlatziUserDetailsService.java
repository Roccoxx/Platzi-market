package com.platzi.market.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlatziUserDetailsService implements UserDetailsService {
    /* PARA PEDIR DATOS DE UNA DB (GG)
    @Autowired
    private AccesoRepo accesoRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Access access = accesoRepo.auth(username);
        return new User(access.getUser(), ("{noop}" + access.getPass()), new ArrayList<>());
    }*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // noop para que no sea codificada
        return new User("platzi", "{noop}platzi123", new ArrayList<>());
    }
}
