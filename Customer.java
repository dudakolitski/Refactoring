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
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        
        // Iterando sobre os aluguéis e exibindo as informações
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            // Exibe os detalhes de cada locação
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        // Adiciona as linhas de rodapé
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n"; // Substitui totalAmount
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points"; // Substitui frequentRenterPoints
        return result;
    }

    // Método que calcula o total da cobrança
    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    // Método que calcula o total de pontos do locatário
    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
