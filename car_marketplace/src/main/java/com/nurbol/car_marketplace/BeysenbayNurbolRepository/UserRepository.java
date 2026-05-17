package com.nurbol.car_marketplace.BeysenbayNurbolRepository;

import com.nurbol.car_marketplace.BeysenbayNurbolEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}