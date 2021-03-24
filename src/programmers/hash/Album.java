package programmers.hash;

import java.util.*;

public class Album {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Genre> genreMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            Genre genre = genreMap.getOrDefault(genres[i], genreMap.getOrDefault(genres[i], new Genre(0)));
            genre.playCount += plays[i];
            genre.songs.add(new Song(i, plays[i]));

            genreMap.put(genres[i], genre);
        }

        ArrayList<Genre> genreArr = new ArrayList<>(genreMap.values());
        Collections.sort(genreArr);

        ArrayList<Integer> displayArr = new ArrayList<>();
        for (Genre genre : genreArr) {
            Collections.sort(genre.songs);
            displayArr.add(genre.songs.get(0).id);
            if (genre.songs.size() > 1) {
                displayArr.add(genre.songs.get(1).id);
            }
        }

        int[] res = new int[displayArr.size()];
        for (int i = 0; i < displayArr.size(); i++) {
            res[i] = displayArr.get(i);
        }
        return res;
    }

    class Genre implements Comparable<Genre> {
        int playCount;
        ArrayList<Song> songs;

        Genre(int playCount) {
            this.playCount = playCount;
            this.songs = new ArrayList<>();
        }

        @Override
        public int compareTo(Genre other) {
            if (this.playCount < other.playCount) {
                return 1;
            }
            return -1;
        }
    }

    class Song implements Comparable<Song> {
        int id;
        int playCount;

        Song(int id, int playCount) {
            this.id = id;
            this.playCount = playCount;
        }

        @Override
        public int compareTo(Song other) {
            if (this.playCount < other.playCount) {
                return 1;
            } else if (this.playCount == other.playCount) {
                return (this.id > other.id) ? 1 : -1;
            } else {
                return -1;
            }
        }
    }
}
