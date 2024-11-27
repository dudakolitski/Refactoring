public abstract class Statement {

    public String value(Customer aCustomer) {
        String result = createHeader(aCustomer);
        result += createBody(aCustomer);
        result += createFooter(aCustomer);
        return result;
    }

    protected abstract String createHeader(Customer aCustomer);
    protected abstract String createBody(Customer aCustomer);
    protected abstract String createFooter(Customer aCustomer);
}
