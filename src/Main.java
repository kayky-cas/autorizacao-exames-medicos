import exceptions.InvalidOption;
import libs.ACMEHospital;

public class Main {
    public static void main(String[] args) throws InvalidOption {
        ACMEHospital hospital = new ACMEHospital();
        hospital.inicializa();
        hospital.executa();
    }

}
