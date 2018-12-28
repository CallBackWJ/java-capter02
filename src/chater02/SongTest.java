package chater02;

public class SongTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Song song =new Song();
		song.setTitle("좋은날");
		song.setAlbum("real");
		song.setArtist("아이유");
		song.setComposer("이민수");
		
		song.setTrack(3);
		song.setYear(2010);
		
		song.show();
		
		Song song1=new Song("Love Shot", "EXO", null, null, 0, 0);
		
		song1.show();
		
	}

}
