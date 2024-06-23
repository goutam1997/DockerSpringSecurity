package gk_inventory.repository;

import gk_inventory.model.GkUserInfo;
import inventory.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GkUserInfoRepository extends JpaRepository<GkUserInfo, Integer> {

    Optional<GkUserInfo> findByName(String userName);
}
