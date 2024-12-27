package com.demo.user.model.api;

import lombok.Data;

@Data
public class ErrorBody {
  private String mensaje;

  public ErrorBody(String mensaje) {
    this.mensaje = mensaje;
  }

  public String getMensaje() {
    return mensaje;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }
}
