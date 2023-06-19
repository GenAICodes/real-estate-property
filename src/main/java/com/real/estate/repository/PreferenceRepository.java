
package com.real.estate.repository;

import com.real.estate.entity.Preference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreferenceRepository extends JpaRepository<Preference, Long> {
    List<Preference> findByUserId(Long userId);
}
