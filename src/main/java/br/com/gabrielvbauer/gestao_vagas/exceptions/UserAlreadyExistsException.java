package br.com.gabrielvbauer.gestao_vagas.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
  public UserAlreadyExistsException() {
    super("Usuário já existe");
  }
}
