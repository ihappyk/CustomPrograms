import java.util.*;

public class Top10Videos
{
    static class Video {
        String name;
        int watchRate;

        public Video (String name, int watchRate)
        {
            this.name = name;
            this.watchRate = watchRate;
        }

        @Override
        public String toString ()
        {
            return "Video{" + "name='" + name + '\'' + ", watchRate=" + watchRate + '}';
        }
    }

    public static void getTop10Video (List<Video> videoList)
    {
        Map<String, Integer> videoMap = new HashMap<String,Integer>();
        videoList.stream().forEach(video -> {
            int rate = video.watchRate;
            if(videoMap.containsKey(video.name)){
                rate += videoMap.get(video.name);
            }
            videoMap.put(video.name, rate);
        });

        List<Map.Entry<String, Integer>> list = new ArrayList<>(videoMap.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue()-o1.getValue());


        //get top 10 items
        int count = 10;
        System.out.println("Top videos: ");
        for (int i = 0; i <list.size() && count>0 ; i++) {
            Map.Entry<String, Integer> temp = list.get(i);
            System.out.print("["+ temp.getKey() + " : " + temp.getValue() + "] ");
            count--;
        }
    }

    public static void main(String[] args) {
        List<Video> videos = new ArrayList<>();
        videos.add(new Video("abc", 10));
        videos.add(new Video("def", 20));
        videos.add(new Video("abc", 15));
        videos.add(new Video("ghi", 50));
        videos.add(new Video("xyz", 100));
        videos.add(new Video("abc", 25));
        videos.add(new Video("jkl", 10));
        videos.add(new Video("mno", 15));
        videos.add(new Video("pqr", 25));
        videos.add(new Video("stu", 35));
        videos.add(new Video("lko", 19));
        videos.add(new Video("aaa", 5));
        videos.add(new Video("bbb", 10));
        videos.add(new Video("ccc", 35));
        videos.add(new Video("abc", 25));
        videos.add(new Video("eee", 20));
        getTop10Video(videos);
    }
}
