package br.net.mirante.colaborador.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.net.mirante.colaborador.model.Usuario;
import br.net.mirante.colaborador.repository.UsuarioRepository;

@Repository
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		Optional<Usuario> user = usuarioRepository.findByLogin(login);

		if (!user.isPresent()) {
			throw new UsernameNotFoundException("Usuário não encontrado.");
		}

		return user.get();
	}

}
