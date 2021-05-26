#lenguage: es
@backend @deleteUser

Feature: Eliminar usuarios de la compañia

  Background: el administrador desea crear usuarios en el sistema
    Given como administrador quiero validar los permisos en el sistema

  Scenario Outline: Eliminar usuarios que ya no pertenecen a la compañia
    And "administrador" consulta usuario con el <id>
    When el administrador elimina el usuario con los datos correctos <id>
    Then el usuario con el <id> sea eliminado de la compañia
    Examples:
      | id    |
      | 1     |
      | 2     |

  @Delete
  Scenario Outline: Intentar eliminar usuarios que no existen en la compañia
    When "administrador" intenta eliminar un usuario con <idIncorrecto>
    Then el usuario no puede ser eliminado de la compañía
    Examples:
      | idIncorrecto |
      | %            |




