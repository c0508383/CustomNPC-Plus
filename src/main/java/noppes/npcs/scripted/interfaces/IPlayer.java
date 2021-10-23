package noppes.npcs.scripted.interfaces;

import net.minecraft.entity.player.EntityPlayerMP;
import noppes.npcs.scripted.ScriptItemStack;
import noppes.npcs.scripted.ScriptPixelmonPlayerData;

public interface IPlayer<T extends EntityPlayerMP> extends IEntityLivingBase<T> {
    /**
     * @return Returns the displayed name of the player
     */
    String getDisplayName();

    /**
     * @return Returns the players name
     */
    String getName();

    void setPosition(double x, double y, double z);

    boolean hasFinishedQuest(int id);

    boolean hasActiveQuest(int id);

    boolean hasReadDialog(int id);

    /**
     * Add the quest from active quest list
     * @param id The Quest ID
     */
    void startQuest(int id);

    /**
     * Add the quest from finished quest list
     * @param id The Quest ID
     */
    void finishQuest(int id);
    /**
     * Removes the quest from active quest list
     * @param id The Quest ID
     */
    void stopQuest(int id);

    /**
     * Removes the quest from active and finished quest list
     * @param id The Quest ID
     */
    void removeQuest(int id);

    int getType();

    boolean typeOf(int type);
    /**
     * @param faction The faction id
     * @param points The points to increase. Use negative values to decrease
     */
    void addFactionPoints(int faction, int points);

    /**
     * @param faction The faction id
     * @return  points
     */
    int getFactionPoints(int faction);

    /**
     * @param message The message you want to send
     */
    void sendMessage(String message);

    /**
     * @return Return gamemode. 0: Survival, 1: Creative, 2: Adventure
     */
    int getMode();

    /**
     * @param type The gamemode type. 0:SURVIVAL, 1:CREATIVE, 2:ADVENTURE
     */
    void setMode(int type);

    /**
     * @param item The item to be checked
     * @return How many of this item the player has
     */
    int inventoryItemCount(ScriptItemStack item);

    /**
     * @since 1.7.10d
     * @return Returns a IItemStack array size 36
     */
    ScriptItemStack[] getInventory();

    /**
     * @param item The Item type to be removed
     * @param amount How many will be removed
     * @return Returns true if the items were removed succesfully. Returns false incase a bigger amount than what the player has was given
     */
    boolean removeItem(ScriptItemStack item, int amount);

    /**
     * @since 1.7.10c
     * @param id The items name
     * @param damage The damage value
     * @param amount How many will be removed
     * @return Returns true if the items were removed succesfully. Returns false incase a bigger amount than what the player has was given or item doesnt exist
     */
    boolean removeItem(String id, int damage, int amount);

    /**
     * @since 1.7.10c
     * @param item Item to be added
     * @param amount The amount of the item to be added
     * @return Returns whether or not it gave the item succesfully
     */
    boolean giveItem(ScriptItemStack item, int amount);

    /**
     * @since 1.7.10c
     * @param id The items name
     * @param damage The damage value
     * @param amount The amount of the item to be added
     * @return Returns whether or not it gave the item succesfully
     */
    boolean giveItem(String id, int damage, int amount);

    /**
     * Same as the /spawnpoint command
     * @param x The x position
     * @param y The y position
     * @param z The z position
     */
    void setSpawnpoint(int x, int y, int z);

    void resetSpawnpoint();

    /**
     * @param item The item to be removed from the players inventory
     */
    void removeAllItems(ScriptItemStack item);


    /**
     * @param achievement The achievement id. For a complete list see http://minecraft.gamepedia.com/Achievements
     * @return Returns whether or not the player has this achievement
     */
    boolean hasAchievement(String achievement);

    /**
     * @param permission Bukkit/Cauldron permission
     * @return Returns whether or not the player has the permission
     */
    boolean hasBukkitPermission(String permission);

    /**
     * @since 1.7.10c
     * @return Returns the exp level
     */
    int getExpLevel();

    /**
     * @since 1.7.10c
     * @param level The new exp level you want to set
     */
    void setExpLevel(int level);

    /**
     * Requires pixelmon to be installed
     * @since 1.7.10d
     */
    ScriptPixelmonPlayerData getPixelmonData();

    ITimers getTimers();
}
