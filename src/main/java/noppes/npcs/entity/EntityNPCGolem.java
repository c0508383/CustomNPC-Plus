package noppes.npcs.entity;

import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import noppes.npcs.ModelData;
import noppes.npcs.constants.EnumAnimation;



public class EntityNPCGolem extends EntityNPCInterface
{

    public EntityNPCGolem(World world)
    {
        super(world);
        display.texture = "customnpcs:textures/entity/golem/Iron Golem.png";

		width = 1.4f;
		height = 2.5f;
    }
    
    public void updateHitbox() {
		currentAnimation = EnumAnimation.values()[dataWatcher.getWatchableObjectInt(14)];
		if(currentAnimation == EnumAnimation.LYING){
			width = height = 0.5f;
		}
		else if (currentAnimation == EnumAnimation.SITTING){
			width = 1.4f;
			height = 2f;
		}
		else{
			width = 1.4f;
			height = 2.5f;
		}
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
			data.setEntityClass(EntityNPCGolem.class);
	    	
	    	
	    	worldObj.spawnEntityInWorld(npc);
    	}
        super.onUpdate();
    }
}