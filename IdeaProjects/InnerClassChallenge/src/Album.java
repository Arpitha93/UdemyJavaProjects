import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private  String artist;
    private String name;
    private SongList songs;

    public Album(String artist, String name) {    // constructor
        this.artist = artist;
        this.name = name;
        this.songs = new SongList();
    }

    public boolean addSong(String title,double duration ) {
        return this.songs.add(new Song(title,duration)); //adding new song which is called in .add
    }


    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        Song checkedSong = this.songs.findSong(trackNumber); //call inner class method to find valid or not
        if(checkedSong != null){
            playList.add(checkedSong);
            return true;
        }

        System.out.println("this album doesn't have a track" + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList){
        Song checkedSong = songs.findSong(title);
        if(checkedSong != null){    //check playlist is not empty
            playList.add(checkedSong);  //add the song to the playlist
            return true;
        }
        System.out.println(" the song" + title + "is not found in the album");
        return false;
    }

    private class SongList{
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<Song>();
        }

        public boolean add(Song song){
            if(songs.contains(song)){ //contains song from add() return false
                return false;
            }
            this.songs.add(song);
            return true;
        }

        private Song findSong(String title){
            for(Song checkedSong:this.songs){   //if checkedSong matches to current song
                if(checkedSong.getTitle().equals(title)){ //get the title that matches
                    return checkedSong;
                }
            }
            return null;
        }

        public Song findSong(int trackNumber){
            int index = trackNumber-1;
            if((index>0) && (index<songs.size())){
                return songs.get(index);
            }
            return null;
        }


    }
}