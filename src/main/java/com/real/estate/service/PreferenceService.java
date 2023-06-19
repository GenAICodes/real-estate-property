
package com.real.estate.service;

import com.real.estate.entity.Preference;

import java.util.List;

public interface PreferenceService {
    Preference addPreference(Long userId, Preference preference);
    Preference updatePreference(Long userId, Long preferenceId, Preference preference);
    void deletePreference(Long userId, Long preferenceId);
    List<Preference> getPreferencesByUserId(Long userId);
}
