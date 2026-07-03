package fr.luna.core.commands;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import fr.luna.core.Utils;
import jdk.jshell.execution.Util;

public class Discord extends Command
{
    public Discord()
    {
        super("discord", Utils.DOUBLE_FLECHE_VIOLETTE + "Permet d'avoir le lien du serveur discord.", "/discord");
        this.setPermission("cmd.joueur.discord");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args)
    {
        if (sender.hasPermission("cmd.joueur.discord")){
            sender.sendMessage(Utils.DOUBLE_FLECHE_VIOLETTE + "Voici le discord du serveur : §f.gg/xxxx");
        }else{
            sender.sendMessage(Utils.NOT_PERMISSION);
        }
        return true;
    }
}
