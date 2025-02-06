class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        String answer = "";
        int p = toSecond(pos);
        int s = toSecond(op_start);
        int e = toSecond(op_end);
        int v = toSecond(video_len);

        if (p >= s && p <= e) {
            p = e;
        }

        for (String command: commands) {
            if (command.equals("prev")) {
                p = Math.max(p - 10, 0);
            } else {
                p = Math.min(p + 10, v);
            }
            if (p >= s && p <= e) {
                p = e;
            }
        }

        return toStringTime(p);
    }

    public int toSecond(String time) {
        String[] tmp = time.split(":");
        int m = Integer.parseInt(tmp[0]) * 60;
        int s = Integer.parseInt(tmp[1]);
        return m + s;
    }

    public String toStringTime(int p) {
        String m = String.format("%02d", (int) Math.floor((double) p / 60));
        String s = String.format("%02d", p % 60);
        return m + ":" + s;
    }

}