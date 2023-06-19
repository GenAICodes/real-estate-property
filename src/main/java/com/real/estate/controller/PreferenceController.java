
package com.real.estate.controller;

import com.real.estate.entity.Preference;
import com.real.estate.service.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/preferences")
public class PreferenceController {

    @Autowired
    private PreferenceService preferenceService;

    @PostMapping
    public ResponseEntity<Preference> addPreference(@PathVariable Long userId, @RequestBody Preference preference) {
        Preference addedPreference = preferenceService.addPreference(userId, preference);
        return new ResponseEntity<>(addedPreference, HttpStatus.CREATED);
    }

    @PutMapping("/{preferenceId}")
    public ResponseEntity<Preference> updatePreference(@PathVariable Long userId, @PathVariable Long preferenceId, @RequestBody Preference preference) {
        Preference updatedPreference = preferenceService.updatePreference(userId, preferenceId, preference);
        return new ResponseEntity<>(updatedPreference, HttpStatus.OK);
    }

    @DeleteMapping("/{preferenceId}")
    public ResponseEntity<Void> deletePreference(@PathVariable Long userId, @PathVariable Long preferenceId) {
        preferenceService.deletePreference(userId, preferenceId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Preference>> getPreferencesByUserId(@PathVariable Long userId) {
        List<Preference> preferences = preferenceService.getPreferencesByUserId(userId);
        return new ResponseEntity<>(preferences, HttpStatus.OK);
    }
}
