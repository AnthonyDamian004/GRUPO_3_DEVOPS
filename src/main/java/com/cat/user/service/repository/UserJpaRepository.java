package com.cat.user.service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {

	boolean existsByCorreoIgnoreCase(String correo);
}
