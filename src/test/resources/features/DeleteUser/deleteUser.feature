#lenguage: es
@backend @deleteUser

Feature: Eliminar usuarios de la compañia

  Background: el administrador desea crear usuarios en el sistema
    Given el adminstrador desea eliminar usuarios de la compañia

  Scenario Outline: Eliminar usuarios que ya no pertenecen a la compañia
    And consulta el usuario con el <id> a eliminar exista en el sistema
    When el administrador elimina el usuario con los datos correctos <email>
    Then el usuario es eliminado de la compañia
    Examples:
      | email |
      | email |


  Scenario Outline: Intentar eliminar usuarios que no existen en la compañia
    When intenta eliminar un usuario con <idIncorrecto>
    Then el usuario no puede ser eliminado de la compañía
    Examples:
      | idIncorrecto |
      | 00000        |
      | xxxxx        |
      | 0101010      |

  Scenario Outline: Intentar eliminar usuarios con emial inválido
    When intenta eliminar un usuario con <emailIncorrecto>
    Then el usuario no puede ser eliminado de la compañía
    Examples:
      | emailIncorrecto  |
      | test@            |
      | tester.gmail.com |




