public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
       _movie = movie;
       _daysRented = daysRented;
    }

    public int getDaysRented() {
       return _daysRented;
    }

    public Movie getMovie() {
       return _movie;
    }

    // Método para calcular os pontos de locação
    public int getFrequentRenterPoints() {
        int points = 1;  // Default points for every rental
        
        // Adiciona bônus para filmes novos lançamentos
        if (_movie.getPriceCode() == Movie.NEW_RELEASE && _daysRented > 1) {
            points++;  // Bônus de 1 ponto extra para locações de novos lançamentos com mais de 1 dia
        }

        return points;
    }

    // Método renomeado para getCharge() e movido para a classe Rental
    public double getCharge() {
       double thisAmount = 0;

       // Código extraído do switch-case
       switch (_movie.getPriceCode()) {
          case Movie.REGULAR:
             thisAmount += 2;
             if (_daysRented > 2)
                thisAmount += (_daysRented - 2) * 1.5;
             break;
          case Movie.NEW_RELEASE:
             thisAmount += _daysRented * 3;
             break;
          case Movie.CHILDRENS:
             thisAmount += 1.5;
             if (_daysRented > 3)
                thisAmount += (_daysRented - 3) * 1.5;
             break;
       }

       return thisAmount;
    }
}
