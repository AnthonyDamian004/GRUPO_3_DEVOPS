package com.cat.user.service.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.cat.user.service.domain.User;
import com.cat.user.service.exceptions.DuplicateUserException;

import lombok.RequiredArgsConstructor;

@Repository
@Primary
@RequiredArgsConstructor
public class PostgresUserRepository implements UserRepository {

	private final UserJpaRepository jpaRepository;

	@Override
	public User save(User user) {
		String correoNormalizado = user.getCorreo().trim();
		if (jpaRepository.existsByCorreoIgnoreCase(correoNormalizado)) {
			throw new DuplicateUserException(user.getCorreo());
		}
		return jpaRepository.save(UserEntity.fromDomain(user)).toDomain();
	}

	@Override
	public Optional<User> findById(UUID id) {
		return jpaRepository.findById(id).map(UserEntity::toDomain);
	}
}
