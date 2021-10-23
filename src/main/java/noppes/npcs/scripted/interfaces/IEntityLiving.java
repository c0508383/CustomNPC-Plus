package noppes.npcs.scripted.interfaces;

import net.minecraft.entity.EntityLiving;

public interface IEntityLiving<T extends EntityLiving> extends IEntityLivingBase<T> {
    boolean isNavigating();

    void clearNavigation();

    void navigateTo(double var1, double var3, double var5, double var7);

    T getMCEntity();
}
