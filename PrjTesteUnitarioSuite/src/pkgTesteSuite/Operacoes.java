package pkgTesteSuite;
public class Operacoes {
    private double resultado = 0;
    // Maior valor
    public double maiorValor(double v1, double v2) {
        if (v1 > v2) {
            return v1;
        } else {
            return v2;
        }
    }
    // Menor valor
    public double menorValor(double v1, double v2) {
        if (v1 < v2) {
            return v1;
        } else {
            return v2;
        }
    }
    // Raiz quadrada
    public double raizQuadrada(double v1) {
        if (v1 >= 0) {
            resultado = Math.sqrt(v1);
        } else {
            throw new IllegalArgumentException(
                    "O Valor não pode ser negativo");
        }
        return resultado;
    }
    // Divisão
    public double divide(double v1, double v2) {
        try {
            resultado = v1 / v2;
            return resultado;
        } catch (Exception e) {
            System.out.println(
                    "Um erro ocorreu" + e.getMessage());
        }
        System.out.println(
                "O(s) valor(es) não pode(m) se nulos (Zeros!)");
        throw new IllegalArgumentException(
                "O(s) Valor(es) não pode(m)"
                + "ser nulo(s)");
    }
    // Produto - multiplicacao
    public double produto(double v1, double v2) {
        resultado = v1 * v2;
        return resultado;
    }
    // Soma
    public double soma(double v1, double v2) {
        resultado = v1 + v2;
        return resultado;
    }
}
