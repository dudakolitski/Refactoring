public class HtmlStatement extends Statement {

    @Override
    protected String createHeader(Customer aCustomer) {
        return "<H1>Rentals for <EM>" + aCustomer.getName() + "</EM></H1><P>\n";
    }

    @Override
    protected String createBody(Customer aCustomer) {
        StringBuilder body = new StringBuilder();
        for (Rental each : aCustomer.getRentals()) {
            body.append(each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n");
        }
        return body.toString();
    }

    @Override
    protected String createFooter(Customer aCustomer) {
        return "<P>You owe <EM>" + String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n" +
               "On this rental you earned <EM>" + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) + "</EM> frequent renter points<P>";
    }
}
