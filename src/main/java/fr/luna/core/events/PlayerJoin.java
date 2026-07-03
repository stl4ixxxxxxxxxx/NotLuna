package fr.luna.core.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import fr.luna.core.Main;

import java.util.UUID;

public class PlayerJoin implements Listener
{

    @EventHandler
    public void onJoin(PlayerJoinEvent ev)
    {
        Player player = ev.getPlayer();
        String pseudo = player.getName();

        if (!player.hasPlayedBefore()){
            ev.setJoinMessage("§5 " + pseudo + " §fvient de rejoindre le serveur pour la 1ère fois. Souhaitez lui la bienvenue !");
        }else{
            ev.setJoinMessage("[§2+§f] " + pseudo);
        }

        UUID uuid = player.getUniqueId();
        String grade = "Joueur";
        float moneyQuantity = 500;
        int pb = 0;
        Main.getMoneyAPI().loadPlayer(uuid, pseudo, grade, moneyQuantity, pb);
    }
}
