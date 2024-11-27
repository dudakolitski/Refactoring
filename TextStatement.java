public class TextStatement extends Statement {

    @Override
    protected String createHeader(Customer aCustomer) {
        return "Rental Record for " + aCustomer.getName() + "\n";
    }

    @Override
    protected String createBody(Customer aCustomer) {
        StringBuilder body = new StringBuilder();
        for (Rental each : aCustomer.getRentals()) {
            body.append("\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n");
        }
        return body.toString();
    }

    @Override
    protected String createFooter(Customer aCustomer) {
        return "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n" +
               "You earned " + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) + " frequent renter points";
    }
}
