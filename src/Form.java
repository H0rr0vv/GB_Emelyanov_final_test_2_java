public enum Form {
    Simple("простая форма", 1),
    Average("обычная форма", 2),
    Complex("сложная форма", 5);

    private String form;
    private Integer complexity;

    Form(String form, Integer complexity) {
        this.form = form;
        this.complexity = complexity;
    }

    public String getForm() {
        return form;
    }

    public Integer getComplexity() {
        return complexity;
    }
}
