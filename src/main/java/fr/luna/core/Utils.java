package fr.luna.core;

import cn.nukkit.Server;
import fr.luna.core.commands.Discord;
import fr.luna.core.commands.Seemoney;
import fr.luna.core.commands.Spawn;
import fr.luna.core.commands.staff.AddMoney;
import fr.luna.core.commands.staff.RemoveMoney;
import fr.luna.core.events.PlayerJoin;
import fr.luna.core.events.PlayerQuit;

import java.util.List;

public class Utils
{
    public static String DOUBLE_FLECHE_VIOLETTE = "§5»§f ";
    public static String DOUBLE_FLECHE_STAFF = "§c»§f ";
    public static String NOT_PERMISSION = "§cTu n'as pas la permission d'utiliser cette commande !";
    public static String NOT_PLAYER = "§cTu n'est pas un joueur. Connecte toi en jeu pour pouvoir faire cette action.";

    public static void registerCommands()
    {
        Server.getInstance().getCommandMap().registerAll("", List.of(
                //Joueur
                new Discord(),
                new Spawn(),
                new Seemoney(),

                //Staff
                new AddMoney(),
                new RemoveMoney()
        ));
    }

    public static void registerEvents(Main main)
    {
        Server.getInstance().getPluginManager().registerEvents(new PlayerJoin(), main);
        Server.getInstance().getPluginManager().registerEvents(new PlayerQuit(), main);
    }
}
