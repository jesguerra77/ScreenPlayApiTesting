@backend @updateUser
Feature: Como administrador del sistema de la compañía
  deseo actualizar el registro de un usuario
  para tener los datos actualizados del usuario

  Background: como administrador deseo poder actualizar usuarios en el sistema
    Given como administrador quiero validar los permisos en el sistema

  Scenario Outline: actualizar usuario
    When "el administrador" realiza la solicitud de actualización del usuario con <id> <nombre> <salario> y <edad>
    Then el usuario es actualizado con los siguientes datos <nombre> <salario> <edad>
    Examples:
      | id | nombre    | salario | edad |
      | 1  | johnathan | 123     | 12   |
      | 2  | Alexander | 123     | 43   |