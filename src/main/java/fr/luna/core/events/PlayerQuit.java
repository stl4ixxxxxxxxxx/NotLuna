package fr.luna.core.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerQuitEvent;
import fr.luna.core.Main;

public class PlayerQuit implements Listener
{
    @EventHandler
    public void onQuit(PlayerQuitEvent ev)
    {
        Player player = ev.getPlayer();
        Main.getMoneyAPI().savePlayer(player.getUniqueId(), player.getName());
    }
}
