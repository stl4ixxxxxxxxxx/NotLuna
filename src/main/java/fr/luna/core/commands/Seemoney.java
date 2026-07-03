package fr.luna.core.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import fr.luna.core.Main;
import fr.luna.core.Utils;

public class Seemoney extends Command
{
    public Seemoney()
    {
        super("seemoney", Utils.DOUBLE_FLECHE_VIOLETTE + "Permet de voir sa quantité d'argent", "/seemoney");
        this.setPermission("cmd.joueur.seemoney");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args)
    {
        if (sender instanceof Player player){
            if (sender.hasPermission("cmd.joueur.seemoney")){
                float quantiteMoney = Main.getMoneyAPI().getMoney(player.getUniqueId());
                player.sendMessage(Utils.DOUBLE_FLECHE_VIOLETTE + "Tu as §5" + quantiteMoney);
            }else {
                player.sendMessage(Utils.NOT_PERMISSION);
            }
        }else{
            sender.sendMessage(Utils.NOT_PLAYER);
        }
        return true;
    }
}
