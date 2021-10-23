package noppes.npcs.scripted.interfaces;

import net.minecraft.util.DamageSource;

public interface IDamageSource {
    String getType();

    boolean isProjectile();

    IEntity getTrueSource();

    IEntity getImmediateSource();

    DamageSource getMCDamageSource();
}
