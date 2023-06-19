
package com.real.estate.service;

import com.real.estate.entity.Preference;
import com.real.estate.entity.User;
import com.real.estate.exception.ResourceNotFoundException;
import com.real.estate.repository.PreferenceRepository;
import com.real.estate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenceServiceImpl implements PreferenceService {

    @Autowired
    private PreferenceRepository preferenceRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Preference addPreference(Long userId, Preference preference) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        preference.setUser(user);
        return preferenceRepository.save(preference);
    }

    @Override
    public Preference updatePreference(Long userId, Long preferenceId, Preference preference) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        Preference existingPreference = preferenceRepository.findById(preferenceId)
                .orElseThrow(() -> new ResourceNotFoundException("Preference", "id", preferenceId));

        if (!existingPreference.getUser().equals(user)) {
            throw new ResourceNotFoundException("Preference", "id", preferenceId);
        }

        existingPreference.setName(preference.getName());
        existingPreference.setValue(preference.getValue());

        return preferenceRepository.save(existingPreference);
    }

    @Override
    public void deletePreference(Long userId, Long preferenceId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        Preference preference = preferenceRepository.findById(preferenceId)
                .orElseThrow(() -> new ResourceNotFoundException("Preference", "id", preferenceId));

        if (!preference.getUser().equals(user)) {
            throw new ResourceNotFoundException("Preference", "id", preferenceId);
        }

        preferenceRepository.delete(preference);
    }

    @Override
    public List<Preference> getPreferencesByUserId(Long userId) {
        return preferenceRepository.findByUserId(userId);
    }
}
