public record Moneda(String base_code,
                     String target_code,
                     double conversion_rate,
                     double conversion_result) {

    @Override
    public String toString() {
        return "Moneda{" +
                "moneda base = '" + base_code + '\'' +
                ", moneda a cambiar = '" + target_code + '\'' +
                ", cuánto vale 1 unidad de una moneda en otra = " + conversion_rate +
                ", conversión = " + conversion_result +
                '}';
    }
}
