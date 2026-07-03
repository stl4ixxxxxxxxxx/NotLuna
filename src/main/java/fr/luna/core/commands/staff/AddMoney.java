package fr.luna.core.commands.staff;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import fr.luna.core.Main;
import fr.luna.core.Utils;

public class AddMoney extends Command
{
    public AddMoney()
    {
        super("addmoney", Utils.DOUBLE_FLECHE_STAFF + "Permet d'ajouter de l'argent à un joueur.", "/addmoney");
        this.setPermission("cmd.staff.addmoney");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args)
    {
        if (sender.hasPermission("cmd.staff.addmoney")){

            if (args.length < 2){
                sender.sendMessage("§cUsage: /addmoney <§4pseudo§c> <§4quantité§c>");
                return false;
            }

            //Args 0
            Player player = Server.getInstance().getPlayerExact(args[0]);
            if (player == null){
                sender.sendMessage("§cCe joueur n'est pas connecté.");
                return false;
            }

            //Args 1
            float quantity;
            try {
                quantity = Float.parseFloat(args[1]);
                if (quantity < 0){
                    sender.sendMessage("§cLa quantité doit être plus élevé que 0.");
                    return false;
                }
            } catch (NumberFormatException e) {
                sender.sendMessage("§cVeuillez entrer un nombre valide ! ");
                return false;
            }

            sender.sendMessage(Utils.DOUBLE_FLECHE_STAFF + "Tu as ajouté§c " + quantity + " §fà§c " + player.getName());
            player.sendMessage(Utils.DOUBLE_FLECHE_VIOLETTE + "Tu as reçu§5 " + quantity + " §fde la part d'un membre du staff.");
            Main.getMoneyAPI().addMoney(player.getUniqueId(), quantity);

        }else{
            sender.sendMessage(Utils.NOT_PERMISSION);
        }

        return true;
    }
}
