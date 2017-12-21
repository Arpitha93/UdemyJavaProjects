import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        // create a program that implements a playlist for songs
        // create a Song class that have a title and duration of song, also Album class conatining list of song.
        // the ablums will be stored in arreaylist.
        // songs from different albums can be added to the playlist and will appear in the list order they are added.
        //once the song have been added create a menu option to:
        //Quit, Skip, Forward to the next song, Skip backward to previous song, Replay the current song.
        //List the song in the playlist, a song must exsit in the album before it can be added to the playlist

        //Modify the playlist challenge so that Album class uses the inner class.
        //Instead of ArrayList to hold its tracks, it will use an inner class called SongList
        //The inner SongList will use an ArrayList and will provide a method to add song
        //It also provides the findSong() method which will be used by the containing Album class to add songs to playlist




        Album album = new Album("Ramachandrachar", "Ninna Olumeinda");
        album.addSong("ninna olumeinda", 5.65);
        album.addSong("yaru olidarenu", 4.43);
        album.addSong("udaya astamanavembo", 3.20);
        album.addSong("poppu hogona", 5.28);
        album.addSong("Anyarindali sukavaitu", 6.71);
        album.addSong("barayya bakutara priya", 4.84);
        albums.add(album);

        album = new Album("Vidyabhushan", "nammama sharade");
        album.addSong("pillangoviya", 7.85);
        album.addSong("nammama sharade", 4.12);
        album.addSong("gubbiyalo", 6.58);
        album.addSong("laali govinda laali", 8.25);
        album.addSong("mudukara vrutti", 4.56);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("ninna olumeinda", playList);
        albums.get(0).addToPlayList("hange madalayya krishna", playList);
        albums.get(0).addToPlayList(5, playList);
        albums.get(0).addToPlayList(2, playList);
        albums.get(1).addToPlayList(1, playList);
        albums.get(1).addToPlayList(4, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(7, playList); //does not exsit

        play(playList);
    }

    public static void play(LinkedList<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0){
            System.out.println("no song in the playlist");
        } else {
            System.out.println("now playing" + listIterator.next().toString());
            printMenu();
        }

        while (! quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playlist complete");
                    quit=true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){  //go to next song until end of playlist
                            listIterator.next();
                        }
                        forward=true; // if there's a new song found
                    }
                    if (listIterator.hasNext()){
                        System.out.println("now playing" + listIterator.next().toString());
                    } else {
                        System.out.println("we have end of the playlist");
                        forward = false;
                    }
                    break;
                case 2: if(forward){  // go to previous of playlist
                    if(listIterator.hasPrevious()){
                        listIterator.previous();
                    }
                    forward=false; // if reached at the beginning of playlist
                }
                    if (listIterator.hasPrevious()){
                        System.out.println("now playing" + listIterator.previous().toString());
                    } else {
                        System.out.println("we are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward) {  // to keep track of previous song, otherwise the program starts from the current song
                        if (listIterator.hasPrevious()) {
                            System.out.println("now playing" + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("we are at the start of list");
                        }
                    } else {
                        if (listIterator.hasNext()){
                            System.out.println("now playing" + listIterator.next().toString());
                            forward= true;
                        } else {
                            System.out.println("we have end of the list");
                        }
                    }

                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println(" now playing" + listIterator.next());
                        } else {
                            System.out.println(" now playing" + listIterator.previous());
                        }
                    } break;

            }
        }
    }


    private static void printMenu(){
        System.out.println("Available options:");
        System.out.println("0 - to quit\n" +
                "1- to play next song\n" +
                "2- to play previous song\n" +
                "3 - to replay the song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available options\n" +
                "6- delete the current song from playlist");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("========================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("===========================");


    }

}



