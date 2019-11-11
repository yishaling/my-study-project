package validation.flaginfo_validation;

public class MainClass {
    public static void main(String[] args) {
        new MainClass().setValue("s");
    }

    public void setValue(@Vilidata String a) {
        try {
            ValidateService.valid(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
