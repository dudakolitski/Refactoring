public class Customer {
    private String _name;
    @SuppressWarnings("rawtypes")
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    @SuppressWarnings("unchecked")
    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    @SuppressWarnings("rawtypes")
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        
        // Iterando sobre os aluguéis do cliente
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            // Add frequent renter points
            frequentRenterPoints++;

            // Add bonus for a two-day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            // Show figures for this rental (removendo the 'thisAmount' temporário)
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge(); // Usando diretamente o método getCharge() em vez de 'thisAmount'
        }

        // Add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}
