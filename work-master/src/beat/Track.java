package beat;

public class Track {
	
	private String titleImage;
	private String startMusic;
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
	public String getStartMusic() {
		return startMusic;
	}
	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}
	public Track(String titleImage, String startMusic) {
		super();
		this.titleImage = titleImage;
		this.startMusic = startMusic;
	}
	

}
