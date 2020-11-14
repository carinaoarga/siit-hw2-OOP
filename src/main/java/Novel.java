public class Novel extends Book{
    private String type;

    protected Novel(String title, int pages, String type) {
        super(title, pages);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Novel: " +
                "title='" + this.getTitle() + '\'' +
                ", pages=" + this.getPages() +
                ", type='" + type + '\'' +
                ';';
    }
}
