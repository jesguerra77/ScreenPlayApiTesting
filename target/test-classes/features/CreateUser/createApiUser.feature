@backend @createUser
Feature: Creación de usuario

  Background: el administrador desea crear usuarios en el sistema
    Given el administrador quiere crear un usuario nuevo en la compañia
  @tester
  Scenario Outline: Crear nuevo usuario de la compañía
    When "el administrador" realiza el registro con <nombre> y <cargo>
    Then el empleado es creado de forma correcta
    Examples:
      | nombre    | cargo  |
      | johnathan | leader |
      | juan      | Analyst|

  Scenario Outline: Crear nuevo usuario con datos incorrectos
    When realiza el registro con <nombre> y <cargo>
    Then el empleado no es creado correctamente
    Examples:
      | nombre | cargo |
      | null   | leader|
      | juan   | null  |

