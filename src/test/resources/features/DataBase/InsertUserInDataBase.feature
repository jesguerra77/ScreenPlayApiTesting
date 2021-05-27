@dataBaseTest
Feature: como administrador del sistema
  quiero poder insertar un usuario en la base de datos
  para poder administrar la base de datos de la compañia

  @tester3
  Scenario Outline: insertar usuario en la base de datos
    Given como "administrador" quiero conectarme a la base de datos
    When "el administrador" inserta un usuario en la base datos con los datos <idEmpleado> <nombre> <meses> <salario>
    Examples:
      | idEmpleado | nombre    | meses | salario |
      | 12258      | Simon     | 3     | 6000000 |
      | 13545      | Tomas     | 5     | 5400000 |
      | 45687      | Bartolome | 9     | 7200000 |
      | 21546      | Juan      | 24    | 4300000 |
      | 46875      | Andres    | 65    | 3500000 |
      | 654543     | Pedro     | 54    | 3800000 |
      | 56156      | Santiago  | 12    | 6600000 |
      | 99865      | Felipe    | 13    | 1800000 |
      | 33461      | Mateo     | 1     | 3514132 |
      | 788756     | Judas     | 4     | 2355000 |

  Scenario Outline: Consultar usuarios
    Given como "administrador" quiero conectarme a la base de datos
    When "el administrador" quiere consultar los usuarios que tengan un salario mayor a <salario> y tengan menos de <meses> en la compañia
    Examples:
      | salario | meses |
      | 5000000 | 6     |

