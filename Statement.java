public abstract class Statement {

    public String value(Customer aCustomer) {
        StringBuilder result = new StringBuilder();
        
        result.append(createHeader(aCustomer));
        
        // Criar o corpo do relatório (iteração sobre os aluguéis)
        for (Rental each : aCustomer.getRentals()) {
            result.append(createBody(aCustomer, each));
        }

        result.append(createFooter(aCustomer));
        
        return result.toString();
    }

    protected abstract String createHeader(Customer aCustomer);
    protected abstract String createBody(Customer aCustomer, Rental each);
    protected abstract String createFooter(Customer aCustomer);
}
