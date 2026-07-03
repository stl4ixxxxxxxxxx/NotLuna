package fr.luna.core.commands;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import fr.luna.core.Utils;

public class Spawn extends Command
{
    public Spawn()
    {
        super("spawn", Utils.DOUBLE_FLECHE_VIOLETTE + "Permet de se téléporter au spawn", "/spawn");
        this.setPermission("cmd.joueur.spawn");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args)
    {
        if (sender instanceof Player player){
            if (player.hasPermission("cmd.joueur.spawn")){
                player.sendMessage(Utils.DOUBLE_FLECHE_VIOLETTE + "Téléportation dans 5 secondes.");

                int beforeX = player.getPosition().getFloorX();
                int beforeY = player.getPosition().getFloorY();
                int beforeZ = player.getPosition().getFloorZ();
                player.getServer().getScheduler().scheduleDelayedTask(new Runnable() {
                    @Override
                    public void run() {
                        if (player.isOnline()){
                            int afterX = player.getPosition().getFloorX();
                            int afterY = player.getPosition().getFloorY();
                            int afterZ = player.getPosition().getFloorZ();

                            if (beforeX == afterX && beforeY == afterY && beforeZ == afterZ){
                                player.teleport(Server.getInstance().getDefaultLevel().getSpawnLocation());
                                player.sendMessage(Utils.DOUBLE_FLECHE_VIOLETTE + "Tu as été téléporté au spawn.");
                            }else{
                                player.sendMessage("§cTu as bougé.");
                            }
                        }
                    }
                }, 100);
            }else {
                player.sendMessage(Utils.NOT_PERMISSION);
            }
        }else {
            sender.sendMessage(Utils.NOT_PLAYER);
        }
        return true;
    }
}
