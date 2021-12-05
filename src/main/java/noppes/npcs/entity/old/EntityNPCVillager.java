package noppes.npcs.entity.old;

import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import noppes.npcs.ModelData;
import noppes.npcs.entity.EntityCustomNpc;
import noppes.npcs.entity.EntityNPCInterface;



public class EntityNPCVillager extends EntityNPCInterface
{

    public EntityNPCVillager(World world)
    {
        super(world);
        display.texture = "textures/entity/villager/villager.png";
    }
    public void onUpdate()
    {
    	isDead = true;

    	if(!worldObj.isRemote){
	    	NBTTagCompound compound = new NBTTagCompound();
	    	
	    	writeToNBT(compound);
	    	EntityCustomNpc npc = new EntityCustomNpc(worldObj);
	    	npc.readFromNBT(compound);
	    	ModelData data = npc.modelData;
			data.setEntityClass(EntityVillager.class);
	    	
	    	
	    	worldObj.spawnEntityInWorld(npc);
    	}
        super.onUpdate();
    }

}
