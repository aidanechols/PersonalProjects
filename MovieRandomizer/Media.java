import javax.swing.ImageIcon;

public class Media {
	
	private ImageIcon poster;
	private String title;
	private int releaseYear;
	private int duration;
	private String genre1;
	private String genre2;
	private String genre3;
	private double scoreIMDB;
	private String summary;
	private int metaScore;
	private String director;
	private String star1;
	private String star2;
	private String star3;
	private String star4;
	private int votes;
	private int earnings;
	
	
	public Media(Media duplicate) {
		 setPoster(duplicate.getPoster());
		 setTitle(duplicate.getTitle());
		 setRelease(duplicate.getRelease());
		 setDuration(duplicate.getDuration());
		 setGenre1(duplicate.getGenre1());
		 setGenre2(duplicate.getGenre2());
		 setGenre3(duplicate.getGenre3());
		 setIMDB(duplicate.getIMDB());
		 setSummary(duplicate.getSummary());
		 setMetaScore(duplicate.getmetaScore());
		 setDirector(duplicate.getDirector());
		 setStar1(duplicate.getStar1());
		 setStar2(duplicate.getStar2());
		 setStar3(duplicate.getStar3());
		 setStar4(duplicate.getStar4());
		 setVotes(duplicate.getVotes());
		 setEarnings(duplicate.getEarnings());
	}

	public Media(String poster,
				 String title,	 
				 int releaseYear,
				 int duration,
				 String genre1,
				 String genre2,
				 String genre3,
				 float scoreIMDB,
				 String summary,
				 int metaScore,
				 String director,
				 String star1,
				 String star2,
				 String star3,
				 String star4,
				 int votes,
				 int earnings) {
		 setPoster(poster);
		 setTitle(title);
		 setRelease(releaseYear);
		 setDuration(duration);
		 setGenre1(genre1);
		 setGenre2(genre2);
		 setGenre3(genre3);
		 setIMDB(scoreIMDB);
		 setSummary(summary);
		 setMetaScore(metaScore);
		 setDirector(director);
		 setStar1(star1);
		 setStar2(star2);
		 setStar3(star3);
		 setStar4(star4);
		 setVotes(votes);
		 setEarnings(earnings);
	}
	
	public ImageIcon getPoster() {
		return poster;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getRelease() {
		return releaseYear;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public String getDirector() {
		return director;
	}

	public String getGenre1() {
		return genre1;
	}
	
	public String getGenre2() {
		return genre2;
	}
	
	public String getGenre3() {
		return genre3;
	}
	
	public String[] getGenres() {
		String[] r = {genre1, genre2, genre3};
		return r;
	}

	public double getIMDB() {
		return scoreIMDB;
	}

	public String getSummary() {
		return summary;
	}
	
	public int getmetaScore(){
		return metaScore;
	}
	
	public String getStar1() {
		return star1;
	}
	
	public String getStar2() {
		return star2;
	}
	
	public String getStar3() {
		return star3;
	}
	
	public String getStar4() {
		return star4;
	}
	
	public String[] getCast() {
		String[] r = {star1, star2, star3, star4};
		return r;
	}
	
	public int getVotes(){
		return votes;
	}
	
	public int getEarnings(){
		return earnings;
	}
	
	
	
	public void setPoster(String poster) {
		this.poster = new ImageIcon(poster);
	}
	
	private void setPoster(ImageIcon poster) {
		this.poster = poster;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setRelease(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}

	public void setGenre1(String genre1) {
		this.genre1 = genre1;
	}
	
	public void setGenre2(String genre2) {
		this.genre2 = genre2;
	}
	
	public void setGenre3(String genre3) {
		this.genre3 = genre3;
	}

	public void setIMDB(double scoreIMDB) {
		this.scoreIMDB = scoreIMDB;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public void setMetaScore(int metaScore){
		this.metaScore = metaScore;
	}
	
	public void setStar1(String star1) {
		this.star1 = star1;
	}
	
	public void setStar2(String star2) {
		this.star2 = star2;
	}
	
	public void setStar3(String star3) {
		this.star3 = star3;
	}
	
	public void setStar4(String star4) {
		this.star4 = star4;
	}
	
	public void setVotes(int votes){
		this.votes = votes;
	}
	
	public void setEarnings(int earnings){
		this.earnings= earnings ;
	}

}

