package com.shraddhaorg.library.LibraryManagement.repository;

import com.shraddhaorg.library.LibraryManagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
