package bigbubuclass;

import java.util.*;

public class SongPlaylistMerge {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 7, 3);
        List<Integer> list2 = List.of(2, 1, 6, 7, 9);
        List<Integer> list3 = List.of(3, 9, 5);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        System.out.println(mergePlaylist(lists));

    }

    public static List<Integer> mergePlaylist(List<List<Integer>> playlists) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, List<Integer>> afterSongMap = new HashMap<>();

        for (List<Integer> playlist : playlists) {
            for (int i = 0; i < playlist.size() - 1; i++) {
                afterSongMap.computeIfAbsent(playlist.get(i), k -> new ArrayList<>()).add(playlist.get(i + 1));
            }
            afterSongMap.put(playlist.getLast(), new ArrayList<>());
        }


        afterSongMap.entrySet().forEach(entry -> {
            countMap.put(entry.getKey(), 0);
            afterSongMap.values().forEach(val -> {
                if (val.contains(entry.getKey())) {
                    countMap.put(entry.getKey(), countMap.get(entry.getKey()) + 1);
                }
            });
        });


        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        countMap.entrySet().forEach(entry -> {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
                visited.add(entry.getKey());
            }
        });
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);
            List<Integer> integers = afterSongMap.get(curr);

            for (int nextSong : integers) {
                countMap.put(nextSong, countMap.get(nextSong) - 1);
                if (countMap.get(nextSong) == 0 && !visited.contains(nextSong)) {
                    queue.add(nextSong);
                    visited.add(nextSong);
                }
            }
        }
        return result;
    }
}
