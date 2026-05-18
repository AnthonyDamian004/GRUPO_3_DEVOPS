package com.cat.user.service.repository;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.cat.user.service.domain.User;

@Entity
@Table(name = "users")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

	@Id
	@Column(columnDefinition = "uuid")
	private UUID id;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private String apellido;

	@Column
	private String direccion;

	@Column
	private String telefono;

	@Column(nullable = false, unique = true)
	private String correo;

	public User toDomain() {
		return User.builder()
				.id(id)
				.nombre(nombre)
				.apellido(apellido)
				.direccion(direccion)
				.telefono(telefono)
				.correo(correo)
				.build();
	}

	public static UserEntity fromDomain(User user) {
		return UserEntity.builder()
				.id(user.getId())
				.nombre(user.getNombre())
				.apellido(user.getApellido())
				.direccion(user.getDireccion())
				.telefono(user.getTelefono())
				.correo(user.getCorreo())
				.build();
	}
}
