//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package noppes.npcs.scripted.interfaces;

import net.minecraft.entity.Entity;
import noppes.npcs.scripted.ScriptItemStack;
import noppes.npcs.scripted.entity.ScriptEntity;

public interface IEntity<T extends Entity> {
    /**
     * @param directory The particle's directory. Use only forward slashes when writing a directory. Example: "customnpcs:textures/particle/tail.png"
     * @param HEXcolor The particle's color as a HEX integer
     * @param amount The amount of particles to spawn
     * @param maxAge The particle's maximum age in MC ticks

     * @param x The particle's x position
     * @param y The particle's y position
     * @param z The particle's z position

     * @param motionX The particle's speed in the x axis
     * @param motionY The particle's speed in the y axis
     * @param motionZ The particle's speed in the z axis
     * @param gravity The particle's gravity

     * @param scale1 The particle's starting scale
     * @param scale2 The particle's ending scale
     * @param scaleRate Multiplier for the particle's scale growth rate
     * @param scaleRateStart The time at which the particle begins growing/shrinking

     * @param alpha1 The particle's starting transparency
     * @param alpha2 The particle's ending transparency
     * @param scaleRate Multiplier for the particle's transparency growth rate
     * @param alphaRateStart The time at which the particle begins appearing/fading
     */
    void spawnParticle(String directory, int HEXcolor, int amount, int maxAge,
                       double x, double y, double z,
                       double motionX, double motionY, double motionZ, float gravity,
                       float scale1, float scale2, float scaleRate, int scaleRateStart,
                       float alpha1, float alpha2, float alphaRate, int alphaRateStart
    );

    double getYOffset();

    /**
     * @return The entities width
     */
    double getWidth();

    /**
     * @return The entities height
     */
    double getHeight();

    /**
     * @return The entities x position
     */
    double getX();

    /**
     * @param x The entities x position
     */
    void setX(double x);

    /**
     * @return The entities y position
     */
    double getY();

    /**
     * @param y The entities y position
     */
    void setY(double y);

    /**
     * @return The entities x position
     */
    double getZ();

    /**
     * @param z The entities x position
     */
    void setZ(double z);

    /**
     * @return The block x position
     */
    int getBlockX();

    /**
     * @return The block y position
     */
    int getBlockY();

    /**
     * @return The block z position
     */
    int getBlockZ();

    /**
     * @param x The x position
     * @param y The y position
     * @param z The z position
     */
    void setPosition(double x, double y, double z);


    /**
     * @param range The search range for entities around this entity
     * @return Array of entities within range
     */
    ScriptEntity[] getSurroundingEntities(int range);

    /**
     * @param range The search range for entities around this entity
     * @param type The EntityType you want to find
     * @return Array of entities within range
     */
    ScriptEntity[] getSurroundingEntities(int range, int type);

    /**
     * @return Whether the entity is alive or not
     */
    boolean isAlive();

    /**
     * @param key Get temp data for this key
     * @return Returns the stored temp data
     */
    Object getTempData(String key);

    /**
     * Tempdata gets cleared when the entity gets unloaded or the world restarts
     * @param key The key for the data stored
     * @param value The data stored
     */
    void setTempData(String key, Object value);

    /**
     * @param key The key thats going to be tested against the temp data
     * @return Whether or not temp data containes the key
     */
    boolean hasTempData(String key);

    /**
     * @param key The key for the temp data to be removed
     */
    void removeTempData(String key);

    /**
     * Remove all tempdata
     */
    void clearTempData();

    /**
     * @param key The key of the data to be returned
     * @return Returns the stored data
     */
    Object getStoredData(String key);

    /**
     * Stored data persists through world restart. Unlike tempdata only Strings and Numbers can be saved
     * @param key The key for the data stored
     * @param value The data stored. This data can be either a Number or a String. Other data is not stored
     */
    void setStoredData(String key, Object value);

    /**
     * @param key The key of the data to be checked
     * @return Returns whether or not the stored data contains the key
     */
    boolean hasStoredData(String key);

    /**
     * @param key The key of the data to be removed
     */
    void removeStoredData(String key);

    /**
     * Remove all stored data
     */
    void clearStoredData();

    /**
     * @return The age of this entity in ticks
     */
    long getAge();

    /**
     * Despawns this entity. Removes it permanently
     */
    void despawn();

    /**
     * @return Return whether or not this entity is standing in water
     */
    boolean inWater();

    /**
     * @return Return whether or not this entity is standing in lava
     */
    boolean inLava();

    /**
     * @return Return whether or not this entity is standing in fire
     */
    boolean inFire();

    /**
     * @return Return whether or not this entity is on fire
     */
    boolean isBurning();

    /**
     * @param ticks Amount of world ticks this entity will burn. 20 ticks equals 1 second
     */
    void setBurning(int ticks);

    /**
     * Removes fire from this entity
     */
    void extinguish();

    /**
     * @return Name as which it's registered in minecraft
     */
    String getTypeName();

    /**
     * @param item Item to be dropped
     */
    void dropItem(ScriptItemStack item);

    /**
     * @return Return the rider
     */
    ScriptEntity getRider();

    /**
     * @param entity The entity to ride this entity
     */
    void setRider(ScriptEntity entity);

    /**
     * @return Return the entity, this entity is riding
     */
    ScriptEntity getMount();

    /**
     * @param entity The entity this entity will mount
     */
    void setMount(ScriptEntity entity);

    /**
     * @see noppes.npcs.scripted.constants.EntityType
     * @return Returns the EntityType of this entity
     */
    int getType();

    /**
     * @since 1.7.10c
     * @param type @EntityType to check
     * @return Returns whether the entity is type of the given @EntityType
     */
    boolean typeOf(int type);

    /**
     * @param rotation The rotation to be set (0-360)
     */
    void setRotation(float rotation);

    /**
     * @return Current rotation of the npc
     */
    float getRotation();

    /**
     * @param power How strong the knockback is
     * @param direction The direction in which he flies back (0-360). Usually based on getRotation()
     */
    void knockback(int power, float direction);

    /**
     * @since 1.7.10c
     * @return Returns whether or not this entity is sneaking
     */
    boolean isSneaking();

    /**
     * @since 1.7.10c
     * @return Returns whether or not this entity is sprinting
     */
    boolean isSprinting();

    /**
     * @since 1.7.10c
     * Expert users only
     * @return Returns minecrafts entity
     */
    T getMCEntity();

    void storeAsClone(int tab, String name);
}
