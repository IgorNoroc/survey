package com.igornoroc.survey.service;

import com.igornoroc.survey.entity.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface UserService extends UserDetailsService {

    /**
     * Конвертируем роли юзера в SimpleGrandAuthority необходимых для SecurityContext при авторизации.
     * @param roles оригинальный список ролей юзера.
     * @return преобразованный список.
     */
    default List<SimpleGrantedAuthority> mapToSimpleGrantedAuthority(Set<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
    }
}
