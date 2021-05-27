@backend @queryUser
Feature: como administrador del sistema
  quiero poder consultar los usuarios registrados en el sistema
  para conocer el estado actual de los usuarios registrados

  Background: como administrador del sistema deseo poder consultar los usuarios
  creados en el sistema
    Given como administrador quiero validar los permisos en el sistema

  Scenario: Consultar usuarios
    When "administrador" consulta los usuarios en el sistema
    Then los usuarios creados en el sistema son listados

  Scenario Outline: Consultar un usuario en particular
    When "administrador" consulta usuario con el <id>
    Then el usuario con el <id> es listado en el sistema
    Examples:
      | id |
      | 1  |
      | 2  |
