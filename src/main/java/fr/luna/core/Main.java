package fr.luna.core;

import cn.nukkit.plugin.PluginBase;
import fr.luna.core.api.MoneyAPI;

public class Main extends PluginBase
{
    private static Main instance;
    private static MoneyAPI moneyAPI;

    @Override
    public void onEnable()
    {
        this.getLogger().info("[LUNAVIA] Le core vient de charger.");
        instance = this;
        moneyAPI = new MoneyAPI();

        //Enregistrement des commandes et des events.
        Utils.registerCommands();
        Utils.registerEvents(this);
    }

    @Override
    public void onDisable()
    {

    }

    public static Main getInstance()
    {
        return instance;
    }

    public static MoneyAPI getMoneyAPI()
    {
        return moneyAPI;
    }
}
