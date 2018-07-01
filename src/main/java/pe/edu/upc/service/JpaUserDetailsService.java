package pe.edu.upc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.dao.UsuarioDAO;
import pe.edu.upc.entity.Permisos;
import pe.edu.upc.entity.Usuario;

@Service
public class JpaUserDetailsService implements UserDetailsService{
	@Autowired
	private UsuarioDAO usuarioRepositorio;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = usuarioRepositorio.findByUsername(username);

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (Permisos role : usuario.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getPermiso()));
		}

		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true,
				authorities);
	}

}
