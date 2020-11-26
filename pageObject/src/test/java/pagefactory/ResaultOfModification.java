package pagefactory;

public class ResaultOfModification {
    private  String before;
    private  String after;

    public ResaultOfModification(String first, String second) {
        this.before = first;
        this.after = second;
    }

    public String getBefore() {
        return before;
    }

    public String getAfter() {
        return after;
    }
}
