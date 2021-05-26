@backend @createUser
Feature: Creación de usuario

  Background: el administrador desea crear usuarios en el sistema
    Given como administrador quiero validar los permisos en el sistema
  @tester
  Scenario Outline: Crear nuevo usuario de la compañía
    When "el administrador" realiza el registro correcto con <nombre> <salario> y <edad>
    Then el empleado con <nombre> <salario> y <edad> es creado de forma correcta
    Examples:
      | nombre    | salario  | edad  |
      | johnathan | 123      | 23    |
      | juan      | 456      | 24    |

  Scenario Outline: Crear nuevo usuario con datos incorrectos
    When "el administrador" realiza el registro incorrecto con <nombre> y <salario> y <edad>
    Then el empleado no pudo ser creado correctamente
    Examples:
      | nombre | salario | edad  |
      | NULL   | leader  | 23    |
      | juan   | NULL    | 34    |

