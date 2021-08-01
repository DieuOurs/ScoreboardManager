
public class ScoreboardManager {
    public static void set(ProxiedPlayer p){
        //HEADER + FOOTER
        String title = "Your Server";
        String footer = "Your Server IP";
        ScoreboardObjective objective = new ScoreboardObjective("main_scoreboard", title, ScoreboardObjective.HealthDisplay.INTEGER, (byte) 0);
        p.unsafe().sendPacket(objective);
        ScoreboardScore score = new ScoreboardScore(footer, (byte) 0, "main_scoreboard", 0);
        p.unsafe().sendPacket(score);
        //

        //LINE
        List<String> str = new ArrayList<>();
        str.add("§cBonjour"); //LINE 4
        str.add("§aHello"); //LINE 3
        str.add("§bHallo"); //LINE 2
        str.add("§5Hola"); //LINE 1
        int n = str.size();
        for(String line : str){
            score = new ScoreboardScore(line, (byte) 0, "main_scoreboard", n);
            p.unsafe().sendPacket(score);
            n -= 1;
        }
        //

        //DISPLAY
        ScoreboardDisplay display = new ScoreboardDisplay((byte) 1, "main_scoreboard");
        p.unsafe().sendPacket(display);
        //
    }
    public static void refreshAll(){
        for(ProxiedPlayer p : pl.getProxy().getPlayers()){
            set(p);
        }
    }
    public static void deleteAll(){
        for(ProxiedPlayer p : pl.getProxy().getPlayers()){
            ScoreboardDisplay display = new ScoreboardDisplay((byte) 0, "main_scoreboard");
            p.unsafe().sendPacket(display);
        }
    }
}
