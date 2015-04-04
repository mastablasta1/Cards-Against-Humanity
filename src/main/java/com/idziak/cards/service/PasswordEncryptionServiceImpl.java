package com.idziak.cards.service;

import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

@Service
public class PasswordEncryptionServiceImpl implements PasswordEncryptionService {
    private static final String ALGORITHM = "PBKDF2WithHmacSHA1";
    private static final String RANDOM_ALGORITHM = "SHA1PRNG";
    private static final int KEY_LENGTH = 160;
    private static final int ITERATIONS = 1252;

    @Override
    public boolean authenticate(String attemptedPassword, byte[] encryptedPassword, byte[] salt) {
        byte[] encryptedAttemptedPassword = getEncryptedPassword(attemptedPassword, salt);
        return Arrays.equals(encryptedPassword, encryptedAttemptedPassword);
    }

    @Override
    public byte[] getEncryptedPassword(String password, byte[] salt) {
        try {
            KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
            SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
            return factory.generateSecret(keySpec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new IllegalStateException("Encryption error", e);
        }
    }

    @Override
    public byte[] generateSalt() {
        try {
            SecureRandom random = SecureRandom.getInstance(RANDOM_ALGORITHM);
            byte[] salt = new byte[SALT_LENGTH];
            random.nextBytes(salt);
            return salt;
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Random generation algorithm error", e);
        }
    }
}
