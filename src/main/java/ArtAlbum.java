public class ArtAlbum extends Book{
    private String paperQuality;

    protected ArtAlbum(String title, int pages, String paperQuality) {
        super(title, pages);
        this.paperQuality = paperQuality;
    }

    public String getPaperQuality() {
        return paperQuality;
    }

    @Override
    public String toString() {
        return "ArtAlbum: " +
                "title='" + this.getTitle() + '\'' +
                ", pages=" + this.getPages() +
                ", paperQuality='" + paperQuality + '\'' +
                ';';
    }
}
