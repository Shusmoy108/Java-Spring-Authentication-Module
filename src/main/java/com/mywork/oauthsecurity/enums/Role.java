package com.mywork.oauthsecurity.enums;

import static com.mywork.oauthsecurity.enums.Permission.ADMIN_CREATE;
import static com.mywork.oauthsecurity.enums.Permission.ADMIN_DELETE;
import static com.mywork.oauthsecurity.enums.Permission.ADMIN_UPDATE;
import static com.mywork.oauthsecurity.enums.Permission.MANAGER_CREATE;
import static com.mywork.oauthsecurity.enums.Permission.MANAGER_DELETE;
import static com.mywork.oauthsecurity.enums.Permission.MANAGER_READ;
import static com.mywork.oauthsecurity.enums.Permission.MANAGER_UPDATE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public enum Role {
USER(Collections.emptySet()),
ADMIN(Set.of(
		//ADMIN_READ,
		ADMIN_CREATE,
		ADMIN_DELETE,
		ADMIN_UPDATE,
		MANAGER_READ,
		MANAGER_CREATE,
		MANAGER_DELETE,
		MANAGER_UPDATE)),
MANAGER(Set.of(
		MANAGER_READ,
		MANAGER_CREATE,
		MANAGER_DELETE,
		MANAGER_UPDATE
		))
;
	@Getter
	private final Set<Permission> permissions;
	
	public List<SimpleGrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities= new ArrayList<SimpleGrantedAuthority>();
//		    var authorities = getPermissions()
//		            .stream()
//		            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
//		            .collect(Collectors.toList());
		    authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
		    return authorities;
		  }
}
