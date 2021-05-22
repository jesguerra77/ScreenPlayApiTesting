@backend @createUser
Feature: Creación de usuario

  Background: el administrador desea crear usuarios en el sistema
    Given como administrador quiero validar los permisos en el sistema
  @tester
  Scenario Outline: Crear nuevo usuario de la compañía
    When "el administrador" realiza el registro correcto con <nombre> y <cargo>
    Then el empleado con <nombre> y <cargo> es creado de forma correcta
    Examples:
      | nombre    | cargo  |
      | johnathan | leader |
      | juan      | Analyst|

  Scenario Outline: Crear nuevo usuario con datos incorrectos
    When "el administrador" realiza el registro incorrecto con <nombre> y <cargo>
    Then el empleado no pudo ser creado correctamente
    Examples:
      | nombre | cargo |
      | NULL   | leader|
      | juan   | NULL  |

