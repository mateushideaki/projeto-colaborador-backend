package br.net.mirante.colaborador;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.net.mirante.colaborador.model.Cargo;
import br.net.mirante.colaborador.model.Role;
import br.net.mirante.colaborador.model.Time;
import br.net.mirante.colaborador.model.Usuario;
import br.net.mirante.colaborador.repository.CargoRepository;
import br.net.mirante.colaborador.repository.RoleRepository;
import br.net.mirante.colaborador.repository.TimeRepository;
import br.net.mirante.colaborador.repository.UsuarioRepository;

@SpringBootApplication
public class ProjetoColaboradorBackendApplication {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private TimeRepository timeRepository;
	@Autowired
	private CargoRepository cargoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoColaboradorBackendApplication.class, args);

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("colaborador#2020"));
	}

	@Bean
	public void preloadData() {
		List<Role> roles = roleRepository.findAll();
		if (roles == null || roles.isEmpty()) {
			Role admin = new Role("ROLE_ADMIN");
			Role user = new Role("ROLE_USER");
			admin = roleRepository.save(admin);
			user = roleRepository.save(user);

			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			Usuario usuario = new Usuario();
			usuario.setLogin("admin");
			usuario.setSenha(encoder.encode("admin"));
			usuario.setRoles(Collections.singletonList(admin));
			usuarioRepository.save(usuario);

			List<String> cargos = Arrays.asList(new String[] { "Desenvolvedor Java Junior", "Desenvolvedor Java Pleno",
					"Desenvolvedor Java Senior", "Desenvolvedor React Junior", "Desenvolvedor React Pleno",
					"Desenvolvedor React Senior", "Recrutador Junior", "Recrutador Pleno", "Recrutador Senior",
					"Designer UX/UI Junior", "Designer UX/UI Pleno", "Designer UX/UI Senior" });
			for (String strCargo : cargos) {
				cargoRepository.save(new Cargo(strCargo));
			}

			List<String> times = Arrays.asList(
					new String[] { "Squad Inovação", "Squad Recrutamento", "Squad Desenvolvimento", "Squad Design" });
			for (String strTime : times) {
				timeRepository.save(new Time(strTime));
			}

		}

	}
}
