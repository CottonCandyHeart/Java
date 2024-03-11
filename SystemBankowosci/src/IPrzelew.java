public interface IPrzelew {
    String rodzaj = "NULL";
    String tytul = "NULL";
    String kontoNadawcy = "NULL";
    String kontoAdresata = "NULL";
    String daneAdresata = "NULL";
    double kwota = 0.0;
    double oplatyDodatkowe = 0.0;

    /**
     *
     * @return
     */
    String toString();
}
