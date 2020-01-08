/*
 * Given a map Map<String, List<String>> userMap, where the key is a username and the value is a list of user's songs.
 * Also given a map Map<String, List<String>> genreMap, where the key is a genre and the value is a list of songs
 * belonging to this genre. The task is to return a map Map<String, List<String>>, where the key is a username and
 * the value is a list of the user's favorite genres. Favorite genre is a genre with the most song.
 * Example 1:
 * Input:
 * userMap = {
 *   "David": ["song1", "song2", "song3", "song4", "song8"],
 *   "Emma":  ["song5", "song6", "song7"]
 * },
 * genreMap = {
 *   "Rock":    ["song1", "song3"],
 *   "Dubstep": ["song7"],
 *   "Techno":  ["song2", "song4"],
 *   "Pop":     ["song5", "song6"],
 *   "Jazz":    ["song8", "song9"]
 * }
 * Output:
 * {
 *   "David": ["Rock", "Techno"],
 *   "Emma":  ["Pop"]
 * }
 * Explanation:
 * David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.
 * Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.
 *
 * Example 2:
 * Input:
 * userSongs = {
 *   "David": ["song1", "song2"],
 *   "Emma":  ["song3", "song4"]
 * },
 * songGenres = {}
 * Output: {
 *   "David": [],
 *   "Emma":  []
 * }
 *
 */

import java.util.*;

public class FavoriteGenres {

    public HashMap<String, List<String>> link(HashMap<String, List<String>> userSongs, HashMap<String, List<String>> songGenres) {

        HashMap<String, List<String>> favorites = new HashMap<String, List<String>>();

        /* for every user */
        for (String user : userSongs.keySet()) {
            List<String> userSongList = userSongs.get(user);
            //System.out.println(user + " " + userSongList);

            HashMap<String, Integer> count = new HashMap<String, Integer>();
            for (String g : songGenres.keySet()) {
                count.put(g, 0);
            }

            /* for every genre */
            for (String genre : songGenres.keySet()) {
                List<String> genreSongList = songGenres.get(genre);
                //System.out.println(genre + " " + genreSongList);
                /* for every user song */
                for (String userSong : userSongList) {
                    /* for every genre song */
                    for (String genreSong : genreSongList) {
                        if(userSong == genreSong) {
                            Integer a = count.get(genre);
                            count.put(genre, a + 1);
                            //System.out.println(user + " -------------- " + genre);
                        }
                    }
                }
            }

            //System.out.println(count);
            int max = Collections.max(count.values());
            List<String> favList = new ArrayList<String>();
            for (String gen : count.keySet()) {
                if(count.get(gen) == max) {
                    favList.add(gen);
                }
            }
            favorites.put(user, favList);
        }

        return favorites;
    }

    public static void main(String[] args) {
        /* Hashmap Practice */
        //------------------------------------------------------
        HashMap<String, Integer> map = new HashMap<>();
        //System.out.println(map);
        map.put("vishal", 10);
        map.put("sachin", 30);
        map.put("vaibhav", 20);
        //System.out.println(map);

        //System.out.println("Size of map is: " + map.size());

        //System.out.println(map);
        if (map.containsKey("vishal")) {
            Integer a = map.get("vishal");
            //System.out.println("value for key" + " \"vishal\" is: " + a);
        }

        map.clear();
        //System.out.println(map);
        //------------------------------------------------------

        HashMap<String, List<String>> userSongs = new HashMap<String, List<String>>();
        List<String> list = new ArrayList<String>();
        list.add("song1");
        list.add("song2");
        list.add("song3");
        list.add("song4");
        list.add("song8");
        userSongs.put("David", list);

        List<String> list2 = new ArrayList<String>();
        list2.add("song5");
        list2.add("song6");
        list2.add("song7");
        userSongs.put("Emma", list2);

        //System.out.println(userSongs);

        HashMap<String, List<String>> songGenres = new HashMap<String, List<String>>();
        List<String> rock = new ArrayList<String>();
        rock.add("song1");
        rock.add("song3");
        List<String> dubstep = new ArrayList<String>();
        dubstep.add("song7");
        List<String> techno = new ArrayList<String>();
        techno.add("song2");
        techno.add("song4");
        List<String> pop = new ArrayList<String>();
        pop.add("song5");
        pop.add("song6");
        List<String> jazz = new ArrayList<String>();
        jazz.add("song8");
        jazz.add("song9");

        songGenres.put("Rock", rock);
        songGenres.put("Dubstep", dubstep);
        songGenres.put("Techno", techno);
        songGenres.put("Pop", pop);
        songGenres.put("Jazz", jazz);

        FavoriteGenres fg = new FavoriteGenres();
        System.out.println(fg.link(userSongs, songGenres));
    }
}