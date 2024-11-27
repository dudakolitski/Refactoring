public class teste {
    public static class Main {  // Torne a classe Main estática
        public static void main(String[] args) {
            Movie movie1 = new Movie("The Matrix", Movie.REGULAR);
            Movie movie2 = new Movie("The Lion King", Movie.CHILDRENS);
            
            Rental rental1 = new Rental(movie1, 3);
            Rental rental2 = new Rental(movie2, 4);
    
            Customer customer = new Customer("John Doe");
            customer.addRental(rental1);
            customer.addRental(rental2);
    
            // Exibindo o relatório em HTML
            System.out.println(customer.htmlStatement());
        }
    }
}
