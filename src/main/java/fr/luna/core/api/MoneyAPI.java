package fr.luna.core.api;

import cn.nukkit.utils.Config;
import fr.luna.core.Main;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public class MoneyAPI
{
    private final HashMap<UUID, Float> moneyCache = new HashMap<>();
    private final HashMap<UUID, Integer> pbCache = new HashMap<>();

    public MoneyAPI()
    {

    }

    public void loadPlayer(UUID uuid, String pseudo, String grade, float moneyQuantity, int pbQuantity)
    {
        File playerFile = new File(Main.getInstance().getDataFolder() + "/donneeJoueur/" + pseudo + ".json");
        Config config = new Config(playerFile, Config.JSON);

        if (!config.exists("uuid")) config.set("uuid", uuid.toString());
        if (!config.exists("pseudo")) config.set("pseudo", pseudo);
        if (!config.exists("grade")) config.set("grade", grade);
        if (!config.exists("argent")) config.set("argent", moneyQuantity);
        if (!config.exists("pointBoutique")) config.set("pointBoutique", pbQuantity);
        config.save();

        moneyCache.put(uuid, (float) config.getDouble("argent"));
        pbCache.put(uuid, config.getInt("pointBoutique"));
    }

    public void savePlayer(UUID uuid, String pseudo)
    {
        File playerFile = new File(Main.getInstance().getDataFolder() + "/donneeJoueur/" + pseudo + ".json");
        Config config = new Config(playerFile, Config.JSON);

        if (moneyCache.containsKey(uuid)) {
            config.set("argent", moneyCache.get(uuid));
        }
        if (pbCache.containsKey(uuid)){
            config.set("pointBoutique", pbCache.get(uuid));
        }
        config.save();


        moneyCache.remove(uuid);
        pbCache.remove(uuid);
    }

    //Monnaie en $
    public float getMoney(UUID uuid)
    {
        return moneyCache.getOrDefault(uuid, 500.0f);
    }

    public void addMoney(UUID uuid, float quantity)
    {
        float pMoney = getMoney(uuid);
        moneyCache.put(uuid, pMoney + quantity);
    }

    public boolean removeMoney(UUID uuid, float quantity)
    {
        float pMoney = this.getMoney(uuid);
        if (pMoney >= quantity){
            moneyCache.put(uuid, pMoney - quantity);
            return true;
        }
        return false;
    }

    //Monnaie en PB (achtable en euros)
    public int getPb(UUID uuid)
    {
        return pbCache.getOrDefault(uuid, 0);
    }

    public void addPb(UUID uuid, int quantity)
    {
        int PPb = getPb(uuid);
        pbCache.put(uuid, PPb + quantity);
    }

    public boolean removePb(UUID uuid, int quantity)
    {
        int pPb = getPb(uuid);
        if (pPb >= quantity){
            pbCache.put(uuid, pPb - quantity);
            return true;
        }
        return false;
    }
}
