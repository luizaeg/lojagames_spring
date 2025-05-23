package com.generation.lojagames.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.lojagames.model.Usuario;
import com.generation.lojagames.model.UsuarioLogin;
import com.generation.lojagames.repository.UsuarioRepository;
import com.generation.lojagames.security.JwtService;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public Optional<Usuario> cadastrarUsuario(Usuario usuario) {
		
		if(usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário (e-mail) já existe!", null);
		}

		
		if (!isMaiorDeIdade(usuario.getDataNascimento())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário deve ser maior de 18 anos!", null);
		}
		
		usuario.setSenha(criptografarSenha(usuario.getSenha()));
		
		return Optional.ofNullable(usuarioRepository.save(usuario));
	}
	
	public Optional<Usuario> atualizarUsuario(Usuario usuario) {
		
		
		if(usuario.getId() == null || !usuarioRepository.existsById(usuario.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!", null);
        }

		
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(usuario.getId());

		
		if (!isMaiorDeIdade(usuario.getDataNascimento())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário deve ser maior de 18 anos!", null);
		}

		
		Optional<Usuario> buscaUsuarioPorEmail = usuarioRepository.findByUsuario(usuario.getUsuario());

	
		if (buscaUsuarioPorEmail.isPresent() && !buscaUsuarioPorEmail.get().getId().equals(usuario.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário (e-mail) já está em uso por outra conta!", null);
        }

		
		usuario.setSenha(criptografarSenha(usuario.getSenha()));
		
		
		return Optional.ofNullable(usuarioRepository.save(usuario));
		
	}
	
	public Optional<UsuarioLogin> autenticarUsuario(Optional<UsuarioLogin> usuarioLogin) {
		
		var credenciais = new UsernamePasswordAuthenticationToken(usuarioLogin.get().getUsuario(), usuarioLogin.get().getSenha());
		
		Authentication authentication = authenticationManager.authenticate(credenciais);
		
		if(authentication.isAuthenticated()) {
			Optional<Usuario> usuario = usuarioRepository.findByUsuario(usuarioLogin.get().getUsuario());
			
			if(usuario.isPresent()) {
				usuarioLogin.get().setId(usuario.get().getId());
				usuarioLogin.get().setNome(usuario.get().getNome());
				usuarioLogin.get().setDataNascimento(usuario.get().getDataNascimento()); // Adiciona a data de nascimento ao login
				usuarioLogin.get().setSenha("");
				usuarioLogin.get().setToken(gerarToken(usuarioLogin.get().getUsuario()));
				
				return usuarioLogin;
			}
		}
		
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuário ou senha inválidos!", null);
	} 
	
	private String gerarToken(String usuario) {
		return "Bearer " + jwtService.generateToken(usuario);
	}
	
	private String criptografarSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(senha);
	}

	// Verificar maior idade
	
	private boolean isMaiorDeIdade(LocalDate dataNascimento) {
		if (dataNascimento == null) {
			return false; // Data de nascimento é obrigatória
		}
		
		return !dataNascimento.isAfter(LocalDate.now().minusYears(18));
	}
}