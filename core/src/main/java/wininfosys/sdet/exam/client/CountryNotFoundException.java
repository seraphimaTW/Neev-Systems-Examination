package wininfosys.sdet.exam.client;

public class CountryNotFoundException extends RuntimeException {

    public CountryNotFoundException() {
    }

    public CountryNotFoundException(String errorMsg) {
        super(errorMsg);
    }

    public CountryNotFoundException(String msg, Exception e) {
        super(msg, e);
    }
}
