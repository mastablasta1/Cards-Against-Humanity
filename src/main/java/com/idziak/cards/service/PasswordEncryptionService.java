package com.idziak.cards.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface PasswordEncryptionService {
    int SALT_LENGTH = 8;

    boolean authenticate(String attemptedPassword, byte[] encryptedPassword, byte[] salt);

    byte[] getEncryptedPassword(String password, byte[] salt);

    byte[] generateSalt();
}
