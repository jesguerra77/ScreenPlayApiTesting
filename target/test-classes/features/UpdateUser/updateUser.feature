
Feature: Como administrador del sistema de la compañía
  deseo actualizar el registro de un usuario
  para tener los datos actualizados del usuario

  Background: como administrador deseo poder actualizar usuarios en el sistema
    Given como administrador quiero validar los permisos en el sistema

    Scenario Outline: actualizar usuario
      When "el administrador" realiza la solicitud de atualización del usuario con <name> y <cargo>
      Then el usuario es actualizado
      Examples:
        |name  |cargo|
        |name  |cargo|
        |name  |cargo|