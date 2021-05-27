package ApiRestAutomation.Database.Querys;

public enum Querys {
    INSERT(("INSERT INTO EMPLEADOS (IDEMPLEADO,NOMBRE,MESES,SALARIO)" + "VALUES ({idEmpleado}, '{nombre}', {meses}, '{salario}');")),
    WHERE("SELECT idEmpleado,name" + "FROM empleados"+ "WHERE salario >'{salario}' AND meses < '{meses}';");
    private final String query;


    Querys(String s) {
        this.query = s;
    }

    @Override
    public String toString() {
        return this.query;
    }
}