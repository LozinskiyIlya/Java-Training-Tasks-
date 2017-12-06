package org.masa.ayanoter.Services;

public interface IAuthorizationService {

    boolean isValid(String username, String password);

    int getSecret(String username, String password);

    boolean checkSecret(int secret);
}
