package com.viniciussaraiva.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.viniciussaraiva.workshopmongo.domain.User;
import com.viniciussaraiva.workshopmongo.dto.UserDTO;
import com.viniciussaraiva.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<UserDTO>> Get() {
		List<User> users = userService.findAll();
		List<UserDTO> usersDTO = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok(usersDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> GetById(@PathVariable String id) {
		User user = userService.findById(id);
		return ResponseEntity.ok(new UserDTO(user));
	}
	
	@PostMapping()
	public ResponseEntity<Void> Post(@RequestBody UserDTO userDTO) {
		User user = new User(userDTO.getId(),userDTO.getEmail(),userDTO.getName());
		userService.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
