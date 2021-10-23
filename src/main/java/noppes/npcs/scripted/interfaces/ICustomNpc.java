package noppes.npcs.scripted.interfaces;

import net.minecraft.entity.EntityCreature;
import noppes.npcs.scripted.ScriptFaction;
import noppes.npcs.scripted.ScriptItemStack;
import noppes.npcs.scripted.entity.ScriptLivingBase;
import noppes.npcs.scripted.entity.ScriptPlayer;
import noppes.npcs.scripted.roles.ScriptJobInterface;
import noppes.npcs.scripted.roles.ScriptRoleInterface;

public interface ICustomNpc<T extends EntityCreature> extends IEntityLiving<T> {
    /**
     * @return Returns the current npcs size 1-30
     */
    int getSize();

    /**
     * @param size The size of the npc (1-30) default is 5
     */
    void setSize(int size);

    /**
     * @return Returns the current npcs modelType of the NPC
     */
    int getModelType();

    /**
     * @param modelType The modelType of the NPC. 0: Steve, 1: Steve64, 2: Alex
     */
    void setModelType(int modelType);

    /**
     * @return The npcs name
     */
    String getName();

    void setRotation(float rotation);
    /**
     * @param name The name of the npc
     */
    void setName(String name);

    /**
     * @since 1.7.10
     * @return The npcs title
     */
    String getTitle();

    /**
     * @since 1.7.10
     * @param title The title of the npc
     */
    void setTitle(String title);

    /**
     * @return The npcs texture
     */
    String getTexture();

    /**
     * @param texture The texture of the npc
     */
    void setTexture(String texture);

    /**
     * @return Home position x
     */
    int getHomeX();

    /**
     * @param x The home x position
     */
    void setHomeX(int x);

    /**
     * @return Home position x
     */
    int getHomeY();

    /**
     * @param y The home y position
     */
    void setHomeY(int y);

    /**
     * @return Home position x
     */
    int getHomeZ();

    /**
     * @param z The home x position
     */
    void setHomeZ(int z);

    /**
     * @param x The home x position
     * @param y The home y position
     * @param z The home z position
     */
    void setHome(int x, int y, int z);
    /**
     * @param health New max health
     */
    void setMaxHealth(int health);

    /**
     * @param bo Whether or not the npc will try to return to his home position
     */
    void setReturnToHome(boolean bo);

    /**
     * @return Whether or not the npc returns home
     */
    boolean getReturnToHome();

    /**
     * @return The faction of the npc
     */
    ScriptFaction getFaction();

    /**
     * @param id The id of the new faction
     */
    void setFaction(int id);

    int getType();

    boolean typeOf(int type);

    /**
     * @param target The targeted npc
     * @param item The item you want to shoot
     * @param accuracy Accuracy of the shot (0-100)
     */
    void shootItem(ScriptLivingBase target, ScriptItemStack item, int accuracy);

    /**
     * @param message The message the npc will say
     */
    void say(String message);

    /**
     * @param message The message the npc will say
     */
    void say(ScriptPlayer player, String message);

    /**
     * Kill the npc, doesnt't despawn it
     */
    void kill();

    /**
     * Basically completely resets the npc. This will also call the Init script
     */
    void reset();

    /**
     * @return Returns the npcs current role
     */
    ScriptRoleInterface getRole();

    /**
     * @return Returns the npcs current job
     */
    ScriptJobInterface getJob();

    /**
     * @return The item held in the right hand
     */
    ScriptItemStack getRightItem();

    /**
     * @param item Item to be held in the right hand
     */
    void setRightItem(ScriptItemStack item);

    /**
     * @return The item held in the left hand
     */
    ScriptItemStack getLefttItem();

    /**
     * @param item Item to be held in the left hand
     */
    void setLeftItem(ScriptItemStack item);

    /**
     * @return Returns the projectile the npc uses
     */
    ScriptItemStack getProjectileItem();

    /**
     * @param item Item to be used as projectile
     */
    void setProjectileItem(ScriptItemStack item);

    /**
     * @param slot The armor slot to return. 0:head, 1:body, 2:legs, 3:boots
     * @return Returns the worn armor in slot
     */
    ScriptItemStack getArmor(int slot);

    /**
     * @param slot The armor slot to set. 0:head, 1:body, 2:legs, 3:boots
     * @param item Item to be set as armor
     */
    void setArmor(int slot, ScriptItemStack item);

    /**
     * @param type The AnimationType
     */
    void setAnimation(int type);

    /**
     * @param type The visibility type of the npc, 0:visible, 1:invisible, 2:semi-visible
     */
    void setVisibleType(int type);

    /**
     * @return The visibility type of the npc, 0:visible, 1:invisible, 2:semi-visible
     */
    int getVisibleType();

    /**
     * @param type The visibility type of the name, 0:visible, 1:invisible, 2:when-attacking
     */
    void setShowName(int type);

    /**
     * @return Returns the visibility type of the name, 0:visible, 1:invisible, 2:when-attacking
     */
    int getShowName();

    /**
     * @return Returns the visiblity of the boss bar, 0:invisible, 1:visible, 2:when-attacking
     */
    int getShowBossBar();

    /**
     * @param type The visibility type of the boss bar, 0:invisible, 1:visible, 2:when-attacking
     */
    void setShowBossBar(int type);

    /**
     * @return The melee strength
     */
    int getMeleeStrength();

    /**
     * @param strength The melee strength
     */
    void setMeleeStrength(int strength);

    /**
     * @return The melee speed
     */
    int getMeleeSpeed();

    /**
     * @param speed The melee speed
     */
    void setMeleeSpeed(int speed);

    /**
     * @return The ranged strength
     */
    int getRangedStrength();

    /**
     * @param strength The ranged strength
     */
    void setRangedStrength(int strength);

    /**
     * @return The ranged speed
     */
    int getRangedSpeed();

    /**
     * @param speed The ranged speed
     */
    void setRangedSpeed(int speed);

    /**
     * @return The ranged burst count
     */
    int getRangedBurst();

    /**
     * @param count The ranged burst count
     */
    void setRangedBurst(int count);

    /**
     * @param player The player to give the item to
     * @param item The item given to the player
     */
    void giveItem(ScriptPlayer player, ScriptItemStack item);


    /**
     * On servers the enable-command-block option in the server.properties needs to be set to true
     * @param command The command to be executed
     */
    void executeCommand(String command);

    void setHeadScale(float x, float y, float z);

    void setBodyScale(float x, float y, float z);

    void setArmsScale(float x, float y, float z);

    void setLegsScale(float x, float y, float z);

    /**
     * @since 1.7.10c
     * @param resistance Explosion resistance (0-2) default is 1
     */
    void setExplosionResistance(float resistance);

    /**
     * @since 1.7.10c
     * @return Returns Explosion Resistance
     */
    float getExplosionResistance();

    /**
     * @param resistance Melee resistance (0-2) default is 1
     */
    void setMeleeResistance(float resistance);

    /**
     * @return Returns Melee Resistance
     */
    float getMeleeResistance();

    /**
     * @param resistance Arrow resistance (0-2) default is 1
     */
    void setArrowResistance(float resistance);

    /**
     * @return Returns Arrow Resistance
     */
    float getArrowResistance();

    /**
     * @param resistance Knockback resistance (0-2) default is 1
     */
    void setKnockbackResistance(float resistance);

    /**
     * @return Returns Knockback Resistance
     */
    float getKnockbackResistance();

    /**
     * @param type Retaliation type. 0:normal, 1:panic, 2:retreat, 3:nothing
     */
    void setRetaliateType(int type);

    /**
     * @return Returns the combat health regen per second
     */
    int getCombatRegen();

    /**
     * @param regen The combat health regen per second
     */
    void setCombatRegen(int regen);

    /**
     * @return Returns the health regen per second when not in combat
     */
    int getHealthRegen();

    /**
     * @param regen The health regen per second when not in combat
     */
    void setHealthRegen(int regen);

    long getAge();
}
