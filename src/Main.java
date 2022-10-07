import exceptions.InvalidOption;
import exceptions.UserException;
import libs.ACMEHospital;

public class Main {
    public static void main(String[] args) throws InvalidOption, UserException {
        ACMEHospital hospital = new ACMEHospital();
        hospital.inicializa();
        hospital.executa();
    }

}
