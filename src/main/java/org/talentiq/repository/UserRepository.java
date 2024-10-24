package org.talentiq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.talentiq.model.entity.PortalUser;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<PortalUser, String> {
    Optional<PortalUser> findByUserName(String userName);
}
