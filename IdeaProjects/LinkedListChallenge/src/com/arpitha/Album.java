package com.arpitha;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private  String artist;
    private String name;
    private ArrayList<Song> songs;

    public Album(String artist, String name) {    // constructor
        this.artist = artist;
        this.name = name;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title,double duration ) {
        if(findSong(title) == null ){  //findSong is null
            this.songs.add(new Song(title,duration)); //add new song with title and duration
            return true;
        }
        return false;
    }

    private Song findSong(String title){
        for(Song checkedSong:this.songs){   //if checkedSong matches to current song
            if(checkedSong.getTitle().equals(title)){ //get the title that matches
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        int index = trackNumber -1; //start of the trackNumber
        if((index>0) && (index <= this.songs.size())) {
            playList.add(this.songs.get(index));  // return current song along with index
            return true;
        }
            System.out.println("this album doesn't have a track" + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList){
        Song checkedSong = findSong(title);
        if(checkedSong != null){    //check playlist is not empty
            playList.add(checkedSong);  //add the song to the playlist
            return true;
        }
        System.out.println(" the song" + title + "is not found in the album"); 
        return false;
    }
}